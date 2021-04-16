package by.antonov.xmlparser.parser;

import by.antonov.xmlparser.entity.PublicationTypes;
import by.antonov.xmlparser.exception.PublicationException;
import by.antonov.xmlparser.parser.entitybuilder.PublicationWriter;
import by.antonov.xmlparser.parser.entitybuilder.PublicationFactory;
import by.antonov.xmlparser.util.CustomResourceLoader;
import by.antonov.xmlparser.validator.PublicationEnumValidator;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PublicationStAXParser extends PublicationParser {
    private final XMLInputFactory inputFactory;
    private final PublicationFactory builderFactory;
    private XMLStreamReader reader;
    private PublicationWriter publicationWriter;
    private String currentRootElement;

    public PublicationStAXParser() {
        super();

        inputFactory = XMLInputFactory.newInstance();
        builderFactory = new PublicationFactory();
    }

    @Override
    public void buildPublicationSet(String xmlFilepath) throws PublicationException {
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(CustomResourceLoader.getResourceFile(xmlFilepath));
            reader = inputFactory.createXMLStreamReader(inputStream);
            readXML();
        } catch (FileNotFoundException | XMLStreamException e) {
            throw new PublicationException("StAX Parser configuration error", e);
        }
    }

    public void readXML() throws PublicationException {
        String elementName;

        try {
            while (reader.hasNext()) {
                reader.next();
                if (reader.isStartElement()) {
                    elementName = reader.getLocalName();
                    if (PublicationEnumValidator.publicationTypeContainValue(elementName)) {
                        PublicationTypes currentType = PublicationTypes.valueOf(elementName.toUpperCase());
                        switch (currentType) {
                            case BOOKLET -> {
                                currentRootElement = elementName;
                                publicationWriter = builderFactory.newPublicationBuilder(PublicationTypes.BOOKLET);
                            }
                            case MAGAZINE -> {
                                currentRootElement = elementName;
                                publicationWriter = builderFactory.newPublicationBuilder(PublicationTypes.MAGAZINE);
                            }
                            case NEWSPAPER -> {
                                currentRootElement = elementName;
                                publicationWriter = builderFactory.newPublicationBuilder(PublicationTypes.NEWSPAPER);
                            }
                        }

                        for (int i = 0; i < reader.getAttributeCount(); i++) {
                            publicationWriter.setAttribute(reader.getAttributeLocalName(i), reader.getAttributeValue(i));
                        }
                    }

                    if (PublicationEnumValidator.publicationElementContainValue(elementName)) {
                        publicationWriter.setElement(elementName, getXMLText(reader));
                    }
                }

                if (reader.isEndElement()) {
                    if (currentRootElement != null && currentRootElement.equals(reader.getLocalName())) {
                        publicationSet.add(publicationWriter.buildPublication());
                    }
                }
            }
        } catch (XMLStreamException e) {
            throw new PublicationException("StAX reading error", e);
        }
    }

    public String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}

package by.antonov.xmlparser.parser;

import by.antonov.xmlparser.entity.*;
import by.antonov.xmlparser.exception.PublicationException;
import by.antonov.xmlparser.parser.entitybuilder.PublicationBuilder;
import by.antonov.xmlparser.parser.entitybuilder.PublicationFactory;
import by.antonov.xmlparser.util.CustomResourceLoader;
import by.antonov.xmlparser.util.PublicationEnumConverter;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Set;

public class PublicationDOMParser extends PublicationParser {
    private DocumentBuilder documentBuilder;
    private PublicationFactory publicationFactory;
    private PublicationBuilder publicationBuilder;

    public PublicationDOMParser() throws PublicationException {
        super();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            publicationFactory = new PublicationFactory();
        } catch (ParserConfigurationException e) {
            throw new PublicationException("Can't create new DocumentBuilder", e);
        }
    }

    public PublicationDOMParser(Set<Publication> publicationSet) {
        super(publicationSet);
    }

    @Override
    public void buildPublicationSet(String xmlFilepath) throws PublicationException {
        Document document;
        try {
            document = documentBuilder.parse(CustomResourceLoader.getResourceFile(xmlFilepath));
            document.getDocumentElement().normalize();
            Element root = document.getDocumentElement();
            NodeList publicationList = root.getChildNodes();

            for(int i = 0; i < publicationList.getLength(); i++) {
                if (publicationList.item(i).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                Node elementNode = publicationList.item(i);
                switch (PublicationTypes.valueOf(elementNode.getNodeName().toUpperCase())) {
                    case NEWSPAPER -> {
                        publicationBuilder = publicationFactory.newPublicationBuilder(PublicationTypes.NEWSPAPER);
                    }
                    case MAGAZINE -> {
                        publicationBuilder = publicationFactory.newPublicationBuilder(PublicationTypes.MAGAZINE);
                    }
                    case BOOKLET -> {
                        publicationBuilder = publicationFactory.newPublicationBuilder(PublicationTypes.BOOKLET);
                    }
                }
                parsePublicationElement((Element) elementNode);
                publicationSet.add(publicationBuilder.buildPublication());
            }
        } catch (SAXException | IOException  e) {
            throw new PublicationException("Parser error", e);
        } catch (IllegalArgumentException e) {
            throw new PublicationException("Filepath is null", e);
        }
    }

    private void parsePublicationElement(Element publicationElement) {
        // attributes
        NamedNodeMap attributeMap = publicationElement.getAttributes();
        for (int i = 0; i < attributeMap.getLength(); i++) {
            Node attribute = attributeMap.item(i);
            publicationBuilder.setAttribute(attribute.getNodeName(), attribute.getTextContent());
        }

        // element fields
        NodeList childElements = publicationElement.getChildNodes();
        for (int i = 0; i < childElements.getLength(); i++) {
            if (childElements.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            Node currentElement = childElements.item(i);
            publicationBuilder.setElement(currentElement.getNodeName(), currentElement.getTextContent());
        }
    }
}

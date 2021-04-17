package by.antonov.xmlparser.parser;

import by.antonov.xmlparser.entity.*;
import by.antonov.xmlparser.exception.PublicationException;
import by.antonov.xmlparser.parser.entitybuilder.PublicationWriter;
import by.antonov.xmlparser.parser.entitybuilder.PublicationFactory;
import by.antonov.xmlparser.util.CustomResourceLoader;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class PublicationDOMParser extends PublicationParser {
    private final DocumentBuilder documentBuilder;
    private final PublicationFactory publicationFactory;
    private PublicationWriter publicationWriter;

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
                    case NEWSPAPER -> publicationWriter = publicationFactory.newPublicationBuilder(PublicationTypes.NEWSPAPER);
                    case MAGAZINE -> publicationWriter = publicationFactory.newPublicationBuilder(PublicationTypes.MAGAZINE);
                    case BOOKLET -> publicationWriter = publicationFactory.newPublicationBuilder(PublicationTypes.BOOKLET);
                }
                parsePublicationElement((Element) elementNode);
                publicationSet.add(publicationWriter.buildPublication());
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
            publicationWriter.setAttribute(attribute.getNodeName(), attribute.getTextContent());
        }

        // element fields
        NodeList childElements = publicationElement.getChildNodes();
        for (int i = 0; i < childElements.getLength(); i++) {
            if (childElements.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            Node currentElement = childElements.item(i);
            publicationWriter.setElement(currentElement.getNodeName(), currentElement.getTextContent());
        }
    }
}

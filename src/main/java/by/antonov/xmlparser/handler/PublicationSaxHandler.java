package by.antonov.xmlparser.handler;

import by.antonov.xmlparser.entity.Publication;
import by.antonov.xmlparser.exception.PublicationException;
import by.antonov.xmlparser.parser.entitybuilder.PublicationBuilder;
import by.antonov.xmlparser.parser.entitybuilder.PublicationFactory;
import by.antonov.xmlparser.validator.PublicationEnumValidator;
import by.antonov.xmlparser.entity.PublicationTypes;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;
import java.util.Set;

public class PublicationSaxHandler extends DefaultHandler {
    protected Set<Publication> publicationSet;
    private PublicationFactory publicationFactory;
    private PublicationBuilder publicationBuilder;
    private String currentRootElement;
    private String currentElementContent;

    public Set<Publication> getPublicationSet() {
        return this.publicationSet;
    }

    @Override
    public void startDocument() throws SAXException {
        this.publicationSet = new HashSet<Publication>();
        this.publicationFactory = new PublicationFactory();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (PublicationEnumValidator.publicationTypeContainValue(qName)) {
            PublicationTypes currentType = PublicationTypes.valueOf(qName.toUpperCase());
            switch (currentType) {
                case BOOKLET -> {
                    currentRootElement = qName;
                    publicationBuilder = publicationFactory.newPublicationBuilder(PublicationTypes.BOOKLET);
                }
                case MAGAZINE -> {
                    currentRootElement = qName;
                    publicationBuilder = publicationFactory.newPublicationBuilder(PublicationTypes.MAGAZINE);
                }
                case NEWSPAPER -> {
                    currentRootElement = qName;
                    publicationBuilder = publicationFactory.newPublicationBuilder(PublicationTypes.NEWSPAPER);
                }
            }
        }

        if (publicationBuilder != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                publicationBuilder.setAttribute(attributes.getQName(i), attributes.getValue(i));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (publicationBuilder != null) {
            publicationBuilder.setElement(qName, currentElementContent);
        }

        if (currentRootElement != null && currentRootElement.equals(qName)) {
            publicationSet.add(publicationBuilder.buildPublication());

            publicationBuilder = null;
            currentRootElement = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentElementContent = new String(ch, start, length);
    }
}

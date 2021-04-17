package by.antonov.xmlparser.handler;

import by.antonov.xmlparser.entity.Publication;
import by.antonov.xmlparser.parser.entitybuilder.PublicationWriter;
import by.antonov.xmlparser.parser.entitybuilder.PublicationFactory;
import by.antonov.xmlparser.validator.PublicationEnumValidator;
import by.antonov.xmlparser.entity.PublicationTypes;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;
import java.util.Set;

public class PublicationSaxHandler extends DefaultHandler {
    protected Set<Publication> publicationSet;
    private PublicationFactory publicationFactory;
    private PublicationWriter publicationWriter;
    private String currentRootElement;
    private String currentElementContent;

    public Set<Publication> getPublicationSet() {
        return this.publicationSet;
    }

    @Override
    public void startDocument() {
        this.publicationSet = new HashSet<>();
        this.publicationFactory = new PublicationFactory();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (PublicationEnumValidator.publicationTypeContainValue(qName)) {
            PublicationTypes currentType = PublicationTypes.valueOf(qName.toUpperCase());
            switch (currentType) {
                case BOOKLET -> {
                    currentRootElement = qName;
                    publicationWriter = publicationFactory.newPublicationBuilder(PublicationTypes.BOOKLET);
                }
                case MAGAZINE -> {
                    currentRootElement = qName;
                    publicationWriter = publicationFactory.newPublicationBuilder(PublicationTypes.MAGAZINE);
                }
                case NEWSPAPER -> {
                    currentRootElement = qName;
                    publicationWriter = publicationFactory.newPublicationBuilder(PublicationTypes.NEWSPAPER);
                }
            }
        }

        if (publicationWriter != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                publicationWriter.setAttribute(attributes.getQName(i), attributes.getValue(i));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (publicationWriter != null) {
            publicationWriter.setElement(qName, currentElementContent);
        }

        if (currentRootElement != null && currentRootElement.equals(qName)) {
            publicationSet.add(publicationWriter.buildPublication());

            publicationWriter = null;
            currentRootElement = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        currentElementContent = new String(ch, start, length);
    }
}

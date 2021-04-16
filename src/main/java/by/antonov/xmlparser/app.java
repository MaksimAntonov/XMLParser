package by.antonov.xmlparser;

import by.antonov.xmlparser.parser.PublicationParser;
import by.antonov.xmlparser.parser.PublicationBuilderFactory;
import by.antonov.xmlparser.exception.PublicationException;
import by.antonov.xmlparser.validator.XmlValidator;

public class app {
    public static void main(String[] args) {
        XmlValidator.xmlFileValidation("data/papers.xml", "data/papers.xsd");

        PublicationParser builder = null;
        try {
            builder = PublicationBuilderFactory.createPublicationBuilder("stax");
            builder.buildPublicationSet("data/papers.xml");

            System.out.println(builder.getPublicationList().toString());
        } catch (PublicationException e) {
            e.printStackTrace();
        }
    }
}
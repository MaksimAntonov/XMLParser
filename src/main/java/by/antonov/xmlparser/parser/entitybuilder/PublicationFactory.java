package by.antonov.xmlparser.parser.entitybuilder;

import by.antonov.xmlparser.entity.PublicationTypes;

public class PublicationFactory {
    public PublicationBuilder newPublicationBuilder(PublicationTypes type) {
        return switch (type) {
            case BOOKLET -> new BookletBuilder();
            case MAGAZINE -> new MagazineBuilder();
            case NEWSPAPER -> new NewspaperBuilder();
        };
    }
}

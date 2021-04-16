package by.antonov.xmlparser.parser.entitybuilder;

import by.antonov.xmlparser.entity.PublicationTypes;

public class PublicationFactory {
    public PublicationWriter newPublicationBuilder(PublicationTypes type) {
        return switch (type) {
            case BOOKLET -> new BookletWriter();
            case MAGAZINE -> new MagazineWriter();
            case NEWSPAPER -> new NewspaperWriter();
        };
    }
}

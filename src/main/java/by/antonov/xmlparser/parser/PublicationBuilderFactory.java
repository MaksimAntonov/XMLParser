package by.antonov.xmlparser.parser;

import by.antonov.xmlparser.exception.PublicationException;

public class PublicationBuilderFactory {
    private enum ParserType {
        DOM, SAX, STAX
    }

    private PublicationBuilderFactory() {}

    public static PublicationParser createPublicationBuilder(String parserType) throws PublicationException {
        ParserType type = ParserType.valueOf(parserType.toUpperCase());
        switch (type) {
            case DOM -> { return new PublicationDOMParser(); }
            case SAX -> { return new PublicationSAXParser(); }
            case STAX -> { return new PublicationStAXParser(); }
            default -> throw new PublicationException("Incorrect parser type. " + parserType + " instead of DOM, SAX or STAX");
        }
    };

}

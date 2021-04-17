package by.antonov.xmlparser.parser;

import by.antonov.xmlparser.exception.PublicationException;

public class PublicationParserFactory {
    private enum ParserType {
        DOM, SAX, STAX
    }

    private PublicationParserFactory() {}

    public static PublicationParser createPublicationParser(String parserType) throws PublicationException {
        ParserType type;
        try {
            type = ParserType.valueOf(parserType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new PublicationException("Incorrect parser type: " + parserType + " instead of DOM, SAX or STAX");
        }
        switch (type) {
            case DOM -> { return new PublicationDOMParser(); }
            case SAX -> { return new PublicationSAXParser(); }
            case STAX -> { return new PublicationStAXParser(); }
            default -> throw new PublicationException("Can't find parser for " + parserType);
        }
    }
}

package by.antonov.xmlparser.util;

import by.antonov.xmlparser.entity.PublicationAttributes;
import by.antonov.xmlparser.entity.PublicationElements;

public class PublicationEnumConverter {
    private PublicationEnumConverter() {}

    public static PublicationElements convertStringToElement(String elementString) {
        return PublicationElements.valueOf(elementString.toUpperCase().replace("-", "_"));
    }

    public static PublicationAttributes convertStringToAttribute(String attributeString) {
        return PublicationAttributes.valueOf(attributeString.toUpperCase().replace("-", "_"));
    }
}

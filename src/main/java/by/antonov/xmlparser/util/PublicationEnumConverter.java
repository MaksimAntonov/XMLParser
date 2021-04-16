package by.antonov.xmlparser.util;

import by.antonov.xmlparser.entity.PublicationAttributes;
import by.antonov.xmlparser.entity.PublicationElements;
import by.antonov.xmlparser.entity.PublicationTypes;

public class PublicationEnumConverter {
    private PublicationEnumConverter() {}

    public static String convertTypeToString(PublicationTypes publicationType) {
        return publicationType.toString().toLowerCase();
    }

    public static PublicationTypes convertStingToType(String publicationType) {
        return PublicationTypes.valueOf(publicationType.toUpperCase());
    }

    public static String convertElementToString(PublicationElements publicationElement) {
        return publicationElement.toString().toLowerCase().replace("_", "-");
    }

    public static PublicationElements convertStringToElement(String elementString) {
        return PublicationElements.valueOf(elementString.toUpperCase().replace("-", "_"));
    }

    public static String convertAttributeToString(PublicationAttributes publicationAttribute) {
        return publicationAttribute.toString().toLowerCase().replace("_", "-");
    }

    public static PublicationAttributes convertStringToAttribute(String attributeString) {
        return PublicationAttributes.valueOf(attributeString.toUpperCase().replace("-", "_"));
    }
}

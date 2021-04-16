package by.antonov.xmlparser.validator;

import by.antonov.xmlparser.entity.PublicationAttributes;
import by.antonov.xmlparser.entity.PublicationElements;
import by.antonov.xmlparser.entity.PublicationTypes;

public class PublicationEnumValidator {
    private PublicationEnumValidator() {}

    public static boolean publicationTypeContainValue(String testValue) {
        boolean result = false;
        for (PublicationTypes value : PublicationTypes.values()) {
            if (value.name().equalsIgnoreCase(testValue)) {
                result = true;
            }
        }

        return result;
    }

    public static boolean publicationElementContainValue(String testValue) {
        boolean result = false;
        for (PublicationElements value : PublicationElements.values()) {
            if (value.name().equalsIgnoreCase(testValue.replace("-", "_"))) {
                result = true;
            }
        }
        return result;
    }

    public static boolean publicationAttributeContainValue(String testValue) {
        boolean result = false;
        for (PublicationAttributes value : PublicationAttributes.values()) {
            if (value.name().equalsIgnoreCase(testValue.replace("-", "_"))) {
                result = true;
            }
        }
        return result;
    }
}

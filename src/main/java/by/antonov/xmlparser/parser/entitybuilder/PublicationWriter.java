package by.antonov.xmlparser.parser.entitybuilder;

import by.antonov.xmlparser.entity.Publication;
import by.antonov.xmlparser.entity.PublicationAttributes;
import by.antonov.xmlparser.entity.PublicationElements;
import by.antonov.xmlparser.util.PublicationEnumConverter;
import by.antonov.xmlparser.validator.PublicationEnumValidator;

import java.util.HashMap;
import java.util.Map;

public abstract class PublicationWriter {
    protected Map<PublicationElements, String> elementsMap = new HashMap<>();
    protected Map<PublicationAttributes, String> attributeMap = new HashMap<>();

    public void setElement(String elementType, String elementValue) {
        if (PublicationEnumValidator.publicationElementContainValue(elementType)) {
            elementsMap.put(PublicationEnumConverter.convertStringToElement(elementType), elementValue);
        }
    }

    public void setAttribute(String attributeType, String attributeValue) {
        if (PublicationEnumValidator.publicationAttributeContainValue(attributeType)) {
            attributeMap.put(PublicationEnumConverter.convertStringToAttribute(attributeType), attributeValue);
        }
    }

    public abstract Publication buildPublication();
}

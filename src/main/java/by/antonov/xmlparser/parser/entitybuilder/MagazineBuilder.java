package by.antonov.xmlparser.parser.entitybuilder;

import by.antonov.xmlparser.entity.Magazine;
import by.antonov.xmlparser.entity.Publication;
import by.antonov.xmlparser.entity.PublicationAttributes;
import by.antonov.xmlparser.entity.PublicationElements;

import java.time.LocalDate;

class MagazineBuilder extends PublicationBuilder {
    @Override
    public Publication buildPublication() {
        return ((attributeMap.containsKey(PublicationAttributes.PUBLICATION_WEBSITE))
                ? new Magazine(
                    attributeMap.get(PublicationAttributes.PAPER_ID),
                attributeMap.get(PublicationAttributes.PUBLICATION_WEBSITE),
                    elementsMap.get(PublicationElements.TITLE),
                    LocalDate.parse(elementsMap.get(PublicationElements.SUBSCRIBE_DATE)),
                    elementsMap.get(PublicationElements.MONTHLY),
                    elementsMap.get(PublicationElements.COLORED),
                    Integer.parseInt(elementsMap.get(PublicationElements.PAGES)),
                    elementsMap.get(PublicationElements.SUBSCRIBE_INDEX),
                    elementsMap.get(PublicationElements.PAGES_TYPE)
                )
                : new Magazine(
                    attributeMap.get(PublicationAttributes.PAPER_ID),
                    elementsMap.get(PublicationElements.TITLE),
                    LocalDate.parse(elementsMap.get(PublicationElements.SUBSCRIBE_DATE)),
                    elementsMap.get(PublicationElements.MONTHLY),
                    elementsMap.get(PublicationElements.COLORED),
                    Integer.parseInt(elementsMap.get(PublicationElements.PAGES)),
                    elementsMap.get(PublicationElements.SUBSCRIBE_INDEX),
                    elementsMap.get(PublicationElements.PAGES_TYPE)
                )
        );
    }
}

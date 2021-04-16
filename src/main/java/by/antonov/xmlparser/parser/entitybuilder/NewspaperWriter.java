package by.antonov.xmlparser.parser.entitybuilder;

import by.antonov.xmlparser.entity.Newspaper;
import by.antonov.xmlparser.entity.Publication;
import by.antonov.xmlparser.entity.PublicationAttributes;
import by.antonov.xmlparser.entity.PublicationElements;

import java.time.LocalDate;

class NewspaperWriter extends PublicationWriter {
    @Override
    public Publication buildPublication() {
        Newspaper.Builder builder = new Newspaper.Builder();
        builder.setId(attributeMap.get(PublicationAttributes.PAPER_ID))
                .setTitle(elementsMap.get(PublicationElements.TITLE))
                .setSubscribeDate(LocalDate.parse(elementsMap.get(PublicationElements.SUBSCRIBE_DATE)))
                .setMonthly(elementsMap.get(PublicationElements.MONTHLY))
                .setColored(elementsMap.get(PublicationElements.COLORED))
                .setPages(Integer.parseInt(elementsMap.get(PublicationElements.PAGES)))
                .setSubscribeIndex(elementsMap.get(PublicationElements.SUBSCRIBE_INDEX));

        if (attributeMap.containsKey(PublicationAttributes.PUBLICATION_WEBSITE)) {
            builder.setWebsite(attributeMap.get(PublicationAttributes.PUBLICATION_WEBSITE));
        }

        return builder.build();
    }
}

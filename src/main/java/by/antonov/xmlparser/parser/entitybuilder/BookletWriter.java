package by.antonov.xmlparser.parser.entitybuilder;

import by.antonov.xmlparser.entity.Booklet;
import by.antonov.xmlparser.entity.Publication;
import by.antonov.xmlparser.entity.PublicationAttributes;
import by.antonov.xmlparser.entity.PublicationElements;

import java.time.LocalDate;

class BookletWriter extends PublicationWriter {
    @Override
    public Publication buildPublication() {
        Booklet.Builder builder = new Booklet.Builder();
        builder.setId(attributeMap.get(PublicationAttributes.PAPER_ID))
                .setTitle(elementsMap.get(PublicationElements.TITLE))
                .setSubscribeDate(LocalDate.parse(elementsMap.get(PublicationElements.SUBSCRIBE_DATE)))
                .setMonthly(elementsMap.get(PublicationElements.MONTHLY))
                .setColored(elementsMap.get(PublicationElements.COLORED))
                .setPages(Integer.parseInt(elementsMap.get(PublicationElements.PAGES)))
                .setPageType(elementsMap.get(PublicationElements.PAGES_TYPE));

        if (attributeMap.containsKey(PublicationAttributes.PUBLICATION_WEBSITE)) {
            builder.setWebsite(attributeMap.get(PublicationAttributes.PUBLICATION_WEBSITE));
        }

        return builder.build();
    }
}

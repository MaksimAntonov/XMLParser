package by.antonov.xmlparser.parser.entitybuilder;

import static by.antonov.xmlparser.entity.PublicationAttributes.*;
import static by.antonov.xmlparser.entity.PublicationElements.*;

import by.antonov.xmlparser.entity.Booklet;
import by.antonov.xmlparser.entity.Publication;

import java.time.LocalDate;

class BookletWriter extends PublicationWriter {
    @Override
    public Publication buildPublication() {
        Booklet.Builder builder = new Booklet.Builder();
        builder.setId(attributeMap.get(PAPER_ID))
                .setTitle(elementsMap.get(TITLE))
                .setSubscribeDate(LocalDate.parse(elementsMap.get(SUBSCRIBE_DATE)))
                .setMonthly(elementsMap.get(MONTHLY))
                .setColored(elementsMap.get(COLORED))
                .setPages(Integer.parseInt(elementsMap.get(PAGES)))
                .setPageType(elementsMap.get(PAGES_TYPE));

        if (attributeMap.containsKey(PUBLICATION_WEBSITE)) {
            builder.setWebsite(attributeMap.get(PUBLICATION_WEBSITE));
        }

        return builder.build();
    }
}

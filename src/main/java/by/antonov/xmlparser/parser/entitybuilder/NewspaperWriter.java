package by.antonov.xmlparser.parser.entitybuilder;

import static by.antonov.xmlparser.entity.PublicationAttributes.*;
import static by.antonov.xmlparser.entity.PublicationElements.*;

import by.antonov.xmlparser.entity.Newspaper;
import by.antonov.xmlparser.entity.Publication;

import java.time.LocalDate;

class NewspaperWriter extends PublicationWriter {
    @Override
    public Publication buildPublication() {
        Newspaper.Builder builder = new Newspaper.Builder();
        builder.setId(attributeMap.get(PAPER_ID))
                .setTitle(elementsMap.get(TITLE))
                .setSubscribeDate(LocalDate.parse(elementsMap.get(SUBSCRIBE_DATE)))
                .setMonthly(elementsMap.get(MONTHLY))
                .setColored(elementsMap.get(COLORED))
                .setPages(Integer.parseInt(elementsMap.get(PAGES)))
                .setSubscribeIndex(elementsMap.get(SUBSCRIBE_INDEX));

        if (attributeMap.containsKey(PUBLICATION_WEBSITE)) {
            builder.setWebsite(attributeMap.get(PUBLICATION_WEBSITE));
        }

        return builder.build();
    }
}

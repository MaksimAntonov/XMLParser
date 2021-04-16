package by.antonov.xmlparser.parser;

import by.antonov.xmlparser.entity.Publication;
import by.antonov.xmlparser.exception.PublicationException;

import java.util.HashSet;
import java.util.Set;

public abstract class PublicationParser {
    protected Set<Publication> publicationSet;

    protected PublicationParser() {
        this.publicationSet = new HashSet<Publication>();
    }

    protected PublicationParser(Set<Publication> publicationList) {
        this.publicationSet = publicationList;
    }

    public Set<Publication> getPublicationList() {
        return new HashSet<Publication>(this.publicationSet);
    }

    public abstract void buildPublicationSet(String xmlFilepath) throws PublicationException;
}

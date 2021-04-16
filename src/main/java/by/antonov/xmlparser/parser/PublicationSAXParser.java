package by.antonov.xmlparser.parser;

import by.antonov.xmlparser.entity.Publication;
import by.antonov.xmlparser.exception.PublicationException;
import by.antonov.xmlparser.handler.PublicationSaxHandler;
import by.antonov.xmlparser.util.CustomResourceLoader;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.Set;

public class PublicationSAXParser extends PublicationParser {
    private PublicationSaxHandler publicationHandler = new PublicationSaxHandler();
    private XMLReader reader;

    public PublicationSAXParser() throws PublicationException {
        super();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            reader = parser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            throw new PublicationException("SAX Parser configuration error", e);
        }
        reader.setContentHandler(publicationHandler);

    }

    public PublicationSAXParser(Set<Publication> publicationList) {
        super(publicationList);
    }

    @Override
    public void buildPublicationSet(String xmlFilepath) throws PublicationException {
        try {
            InputStream stream = new FileInputStream(CustomResourceLoader.getResourceFile(xmlFilepath));
            InputSource source = new InputSource(new InputStreamReader(stream));
            reader.parse(source);

            publicationSet = publicationHandler.getPublicationSet();
        } catch (SAXException | IOException e) {
            throw new PublicationException("Parsing error", e);
        }
    }
}

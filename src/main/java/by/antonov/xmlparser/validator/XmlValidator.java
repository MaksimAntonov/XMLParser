package by.antonov.xmlparser.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

import by.antonov.xmlparser.handler.PaperErrorHandler;

public class XmlValidator {
    private static Logger Logger = LogManager.getLogger();
    public static void xmlFileValidation(String xmlFilename, String schemaFilename) {
        Logger.info("XmlFileValidation for XML: " + xmlFilename + ", schema: " + schemaFilename);
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(new File(schemaFilename));
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlFilename);
            validator.setErrorHandler(new PaperErrorHandler());
            validator.validate(source);
            Logger.info("XmlFileValidation was finished.");
        } catch (SAXException e) {
            Logger.error("Can't parse file " + xmlFilename + ", error: " + e.getMessage());
        } catch (IOException e) {
            Logger.error("Can't open file " + xmlFilename + ", error: " + e.getMessage());
        }
    }
}

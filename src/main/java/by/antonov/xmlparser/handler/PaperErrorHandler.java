package by.antonov.xmlparser.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class PaperErrorHandler implements ErrorHandler {
    private static Logger Logger = LogManager.getLogger();

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        Logger.warn(getLineColumnNumber(exception) + " - " + exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        Logger.error(getLineColumnNumber(exception) + " - " + exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        Logger.fatal(getLineColumnNumber(exception) + " - " + exception.getMessage());
    }

    private String getLineColumnNumber(SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}

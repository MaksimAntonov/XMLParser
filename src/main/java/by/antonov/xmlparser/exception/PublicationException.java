package by.antonov.xmlparser.exception;

public class PublicationException extends Exception {
    public PublicationException() {
        super();
    }

    public PublicationException(String message) {
        super(message);
    }

    public PublicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public PublicationException(Throwable cause) {
        super(cause);
    }

    protected PublicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

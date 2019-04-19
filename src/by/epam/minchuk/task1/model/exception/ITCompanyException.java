package by.epam.minchuk.task1.model.exception;

public class ITCompanyException extends Exception {

    public ITCompanyException() {
    }

    public ITCompanyException(String message) {
        super(message);
    }

    public ITCompanyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ITCompanyException(Throwable cause) {
        super(cause);
    }

    public ITCompanyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

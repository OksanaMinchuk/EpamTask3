package by.epam.minchuk.task1.model.exception.technicalexeption;

public class FinderNullPointerException extends ITCompanyTechnicalException {

    public FinderNullPointerException() {
    }

    public FinderNullPointerException(String message) {
        super(message);
    }

    public FinderNullPointerException(String message, Throwable cause) {
        super(message, cause);
    }

    public FinderNullPointerException(Throwable cause) {
        super(cause);
    }

}

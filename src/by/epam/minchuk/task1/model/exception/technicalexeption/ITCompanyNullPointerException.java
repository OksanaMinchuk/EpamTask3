package by.epam.minchuk.task1.model.exception.technicalexeption;

public class ITCompanyNullPointerException extends ITCompanyTechnicalException {

    public ITCompanyNullPointerException() {
    }

    public ITCompanyNullPointerException(String message) {
        super(message);
    }

    public ITCompanyNullPointerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ITCompanyNullPointerException(Throwable cause) {
        super(cause);
    }

}

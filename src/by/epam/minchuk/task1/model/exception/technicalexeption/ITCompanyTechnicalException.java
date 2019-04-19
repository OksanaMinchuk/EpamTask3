package by.epam.minchuk.task1.model.exception.technicalexeption;

import by.epam.minchuk.task1.model.exception.ITCompanyException;

public class ITCompanyTechnicalException extends ITCompanyException {

    public ITCompanyTechnicalException() {
    }

    public ITCompanyTechnicalException(String message) {
        super(message);
    }

    public ITCompanyTechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public ITCompanyTechnicalException(Throwable cause) {
        super(cause);
    }

}

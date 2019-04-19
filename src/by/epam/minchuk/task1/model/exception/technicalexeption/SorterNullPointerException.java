package by.epam.minchuk.task1.model.exception.technicalexeption;

import by.epam.minchuk.task1.model.exception.technicalexeption.ITCompanyTechnicalException;

public class SorterNullPointerException extends ITCompanyTechnicalException {

    public SorterNullPointerException() {
    }

    public SorterNullPointerException(String message) {
        super(message);
    }

    public SorterNullPointerException(String message, Throwable cause) {
        super(message, cause);
    }

    public SorterNullPointerException(Throwable cause) {
        super(cause);
    }

}

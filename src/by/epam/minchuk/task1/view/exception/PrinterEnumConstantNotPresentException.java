package by.epam.minchuk.task1.view.exception;

import by.epam.minchuk.task1.model.exception.technicalexeption.ITCompanyTechnicalException;

public class PrinterEnumConstantNotPresentException extends ITCompanyTechnicalException {

    public PrinterEnumConstantNotPresentException() {
    }

    public PrinterEnumConstantNotPresentException(String message) {
        super(message);
    }

    public PrinterEnumConstantNotPresentException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrinterEnumConstantNotPresentException(Throwable cause) {
        super(cause);
    }

}

package by.epam.minchuk.task1.model.exception.technicalexeption;

public class CompanyCreatorNullPointerException extends ITCompanyTechnicalException {

    public CompanyCreatorNullPointerException() {
    }

    public CompanyCreatorNullPointerException(String message) {
        super(message);
    }

    public CompanyCreatorNullPointerException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompanyCreatorNullPointerException(Throwable cause) {
        super(cause);
    }

}

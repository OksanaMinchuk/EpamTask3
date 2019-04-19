package by.epam.minchuk.task1.model.exception.technicalexeption;

public class TeamCreatorNullPointerException extends ITCompanyTechnicalException {
    public TeamCreatorNullPointerException() {
    }

    public TeamCreatorNullPointerException(String message) {
        super(message);
    }

    public TeamCreatorNullPointerException(String message, Throwable cause) {
        super(message, cause);
    }

    public TeamCreatorNullPointerException(Throwable cause) {
        super(cause);
    }
}

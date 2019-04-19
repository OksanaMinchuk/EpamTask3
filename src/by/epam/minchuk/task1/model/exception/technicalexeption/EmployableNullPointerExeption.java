package by.epam.minchuk.task1.model.exception.technicalexeption;

public class EmployableNullPointerExeption extends ITCompanyTechnicalException {
    public EmployableNullPointerExeption() {
    }

    public EmployableNullPointerExeption(String message) {
        super(message);
    }

    public EmployableNullPointerExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployableNullPointerExeption(Throwable cause) {
        super(cause);
    }
}

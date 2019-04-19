package by.epam.minchuk.task1.model.exception.logicexception;

public class FinderEmployeeNotFoundException extends ITCompanyLogicalException {

    public FinderEmployeeNotFoundException() {
    }

    public FinderEmployeeNotFoundException(String message) {
        super(message);
    }
}

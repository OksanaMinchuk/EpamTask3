package by.epam.minchuk.task1.model.exception.logicexception;

import by.epam.minchuk.task1.model.exception.logicexception.ITCompanyLogicalException;

public class ProjectManagerDataWrongException extends ITCompanyLogicalException {

    public ProjectManagerDataWrongException() {
        super();
    }

    public ProjectManagerDataWrongException(String message) {
        super(message);
    }

}

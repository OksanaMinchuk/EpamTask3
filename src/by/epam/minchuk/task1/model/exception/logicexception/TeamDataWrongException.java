package by.epam.minchuk.task1.model.exception.logicexception;

import by.epam.minchuk.task1.model.exception.logicexception.ITCompanyLogicalException;

public class TeamDataWrongException extends ITCompanyLogicalException {

    public TeamDataWrongException() {
    }

    public TeamDataWrongException(String message) {
        super(message);
    }

}

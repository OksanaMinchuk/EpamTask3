package by.epam.minchuk.task1.model.exception.logicexception;

import by.epam.minchuk.task1.model.exception.logicexception.ITCompanyLogicalException;

public class TesterDataWrongException extends ITCompanyLogicalException {

    public TesterDataWrongException() {
        super();
    }

    public TesterDataWrongException(String message) {
        super(message);
    }

}

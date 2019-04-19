package by.epam.minchuk.task1.util.creator;

import by.epam.minchuk.task1.model.entity.Employee;
import by.epam.minchuk.task1.model.entity.Tester;

public class TesterCreator implements AbstractCreator {

    @Override
    public Employee create() {
        return new Tester();
    }
}

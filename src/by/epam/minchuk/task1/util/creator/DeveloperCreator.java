package by.epam.minchuk.task1.util.creator;

import by.epam.minchuk.task1.model.entity.Developer;
import by.epam.minchuk.task1.model.entity.Employee;

public class DeveloperCreator implements AbstractCreator {

    @Override
    public Employee create() {
        return new Developer();
    }
}

package by.epam.minchuk.task1.util.creator;

import by.epam.minchuk.task1.model.entity.Employee;
import by.epam.minchuk.task1.model.entity.ProjectManager;

public class ProjectManagerCreator implements AbstractCreator {

    @Override
    public Employee create() {
        return new ProjectManager();
    }
}

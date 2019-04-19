package by.epam.minchuk.task1.model.entity;

import by.epam.minchuk.task1.model.exception.logicexception.ProjectManagerDataWrongException;

/**
 * Class {@code ProjectManager} is a subclass of Employee
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.02.2019
 */

public class ProjectManager extends Employee {

    private String project;

    public ProjectManager() {
    }

    public ProjectManager(String name, String surname, int salaryPerHour, String project) {
        super(name, surname, salaryPerHour);
        if (project != "") {
            this.project = project;
        }
    }

    public ProjectManager(ProjectManager projectManager) {
        super(projectManager);
        this.project = projectManager.project;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) throws ProjectManagerDataWrongException {
        if (project != null && project != "") {
            this.project = project;
        } else {
            throw new ProjectManagerDataWrongException("Wrong ProjectManager project value");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ProjectManager that = (ProjectManager) o;
        return project.equals(that.project);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + project.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ProjectManager {" + super.toString() +
                "project='" + project + '\'' + "}";
    }
}

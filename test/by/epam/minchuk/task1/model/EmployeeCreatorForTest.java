package by.epam.minchuk.task1.model;

import by.epam.minchuk.task1.model.entity.*;
import by.epam.minchuk.task1.model.exception.technicalexeption.EmployableNullPointerExeption;

public class EmployeeCreatorForTest {
    public static Employee[] initEmployee() {
        ITCompany itCompany = new ITCompany();
        try {
            itCompany.addWorker(new Developer("John", "Conor", 50, Engineer.EngineerLevelType.MIDDLE,
                    Developer.DeveloperType.BACK_END, "Java"));
            itCompany.addWorker(new Developer("Donald", "Conor", 46, Engineer.EngineerLevelType.MIDDLE,
                    Developer.DeveloperType.BACK_END, "C++"));
            itCompany.addWorker(new Tester("Tom", "Gibbs", 25,
                    Tester.EngineerLevelType.JUNIOR, Tester.TesterType.MANUAL));
            itCompany.addWorker(new ProjectManager("Scott", "Johnson", 60, "Online-Store"));
        } catch (EmployableNullPointerExeption employableNullPointerExeption1) {
            employableNullPointerExeption1.printStackTrace();
        }
        return itCompany.getEmployeesArray();
    }
}

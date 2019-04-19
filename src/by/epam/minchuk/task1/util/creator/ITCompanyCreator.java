package by.epam.minchuk.task1.util.creator;

import by.epam.minchuk.task1.model.entity.*;
import by.epam.minchuk.task1.model.exception.technicalexeption.EmployableNullPointerExeption;

/**
 * Class {@code ITCompanyCreator} creating ITCompany and adding Employees and Teams to the ITCompany
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.02.2019
 */

public class ITCompanyCreator {

    private Developer developer1 = new Developer("John", "Conor", 50, Engineer.EngineerLevelType.MIDDLE,
            Developer.DeveloperType.BACK_END, "Java");
    private Developer developer2 = new Developer("Donald", "Freeman", 46, Engineer.EngineerLevelType.MIDDLE,
            Developer.DeveloperType.BACK_END, "C++");
    private Developer developer3 = new Developer("Cris", "Norman", 42, Engineer.EngineerLevelType.MIDDLE,
            Developer.DeveloperType.BACK_END, "Python");
    private Developer developer4 = new Developer("Jack", "Gilbert", 52, Engineer.EngineerLevelType.SENIOR,
            Developer.DeveloperType.FRONT_END, "HTML");
    private Developer developer5 = new Developer("Jack", "Harrison", 32, Engineer.EngineerLevelType.JUNIOR,
            Developer.DeveloperType.FRONT_END, "CSS");
    private Developer developer6 = new Developer("Carroll", "Anderson", 48, Engineer.EngineerLevelType.SENIOR,
            Developer.DeveloperType.FRONT_END, "JavaScript");

    private Tester tester1 = new Tester("Alex", "Miller", 30,
            Tester.EngineerLevelType.MIDDLE, Tester.TesterType.MANUAL);
    private Tester tester2 = new Tester("Tom", "Gibbs", 25,
            Tester.EngineerLevelType.JUNIOR, Tester.TesterType.MANUAL);
    private Tester tester3 = new Tester("Hailey", "Conor", 34,
            Tester.EngineerLevelType.SENIOR, Tester.TesterType.AUTOMATION);
    private Tester tester4 = new Tester("Oliver", "Watson", 31,
            Tester.EngineerLevelType.MIDDLE, Tester.TesterType.AUTOMATION);

    private ProjectManager projectManager1 = new ProjectManager("Scott", "Johnson", 60, "Online-Store");
    private ProjectManager projectManager2 = new ProjectManager("Martin", "Thompson", 51, "Game");
    private ProjectManager projectManager3 = new ProjectManager("Genry", "Blake", 55, "WebApp");

    public Employee[] createCompany() {
        ITCompany itCompany = new ITCompany();
        try {
            itCompany.addWorker(developer1);
            itCompany.addWorker(developer2);
            itCompany.addWorker(developer3);
            itCompany.addWorker(developer4);
            itCompany.addWorker(developer5);
            itCompany.addWorker(developer6);
            itCompany.addWorker(tester1);
            itCompany.addWorker(tester2);
            itCompany.addWorker(tester3);
            itCompany.addWorker(tester4);
            itCompany.addWorker(projectManager1);
            itCompany.addWorker(projectManager2);
            itCompany.addWorker(projectManager3);
            itCompany.removeWorker(projectManager3);
        } catch (EmployableNullPointerExeption employableNullPointerExeption) {
            employableNullPointerExeption.printStackTrace();
        }
        return itCompany.getEmployeesArray();
    }

}

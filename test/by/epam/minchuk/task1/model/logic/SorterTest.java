package by.epam.minchuk.task1.model.logic;

import by.epam.minchuk.task1.model.EmployeeCreatorForTest;
import by.epam.minchuk.task1.model.entity.*;
import by.epam.minchuk.task1.model.exception.technicalexeption.ITCompanyNullPointerException;
import by.epam.minchuk.task1.model.exception.technicalexeption.ITCompanyTechnicalException;
import by.epam.minchuk.task1.model.exception.technicalexeption.SorterNullPointerException;
import org.junit.*;

public class SorterTest {

    private Employee[] actualEmployees;
    private ITCompany itCompany;

    @Before
    public void init() {
       itCompany = new ITCompany();
    }

    @Test
    public void testPositiveSortBySalary() throws SorterNullPointerException, ITCompanyNullPointerException {
        Employee[] expectedEmployees = {
                new Tester("Tom", "Gibbs", 25,
                        Tester.EngineerLevelType.JUNIOR, Tester.TesterType.MANUAL),
                new Developer("Donald", "Conor", 46, Engineer.EngineerLevelType.MIDDLE,
                        Developer.DeveloperType.BACK_END, "C++"),
                new Developer("John", "Conor", 50, Engineer.EngineerLevelType.MIDDLE,
                        Developer.DeveloperType.BACK_END, "Java"),
                new ProjectManager("Scott", "Johnson", 60, "Online-Store")
        };
        itCompany.setEmployeesArray(EmployeeCreatorForTest.initEmployee());
        Sorter.sortBySalary(itCompany);
        actualEmployees = itCompany.getEmployeesArray();
        Assert.assertArrayEquals(expectedEmployees, actualEmployees);
    }

    @Test(expected = ITCompanyTechnicalException.class)
    public void testExceptionSortBySalary() throws SorterNullPointerException, ITCompanyNullPointerException {
        actualEmployees = null;
        itCompany.setEmployeesArray(actualEmployees);
        Sorter.sortBySalary(itCompany);
    }

    @Test
    public void testPositiveSortBySurnameAndSalary() throws SorterNullPointerException, ITCompanyNullPointerException {
        Employee[] expectedEmployees = {
                new Developer("Donald", "Conor", 46, Engineer.EngineerLevelType.MIDDLE,
                        Developer.DeveloperType.BACK_END, "C++"),
                new Developer("John", "Conor", 50, Engineer.EngineerLevelType.MIDDLE,
                        Developer.DeveloperType.BACK_END, "Java"),
                new Tester("Tom", "Gibbs", 25,
                        Tester.EngineerLevelType.JUNIOR, Tester.TesterType.MANUAL),
                new ProjectManager("Scott", "Johnson", 60, "Online-Store")
        };
        itCompany.setEmployeesArray(EmployeeCreatorForTest.initEmployee());
        Sorter.sortBySurnameAndSalary(itCompany);
        actualEmployees = itCompany.getEmployeesArray();
        Assert.assertArrayEquals(expectedEmployees, actualEmployees);
    }

    @Test(expected = ITCompanyTechnicalException.class)
    public void testExceptionSortBySurnameAndSalary() throws SorterNullPointerException, ITCompanyNullPointerException {
        actualEmployees = null;
        itCompany.setEmployeesArray(actualEmployees);
        Sorter.sortBySurnameAndSalary(itCompany);
    }

}

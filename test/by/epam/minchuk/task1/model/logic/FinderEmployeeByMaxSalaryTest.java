package by.epam.minchuk.task1.model.logic;

import by.epam.minchuk.task1.model.EmployeeCreatorForTest;
import by.epam.minchuk.task1.model.entity.Employee;
import by.epam.minchuk.task1.model.entity.ITCompany;
import by.epam.minchuk.task1.model.entity.ProjectManager;
import by.epam.minchuk.task1.model.exception.technicalexeption.FinderNullPointerException;
import by.epam.minchuk.task1.model.exception.technicalexeption.ITCompanyNullPointerException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FinderEmployeeByMaxSalaryTest {

    private ITCompany itCompany;

    @Before
    public void init() throws ITCompanyNullPointerException {
        itCompany = new ITCompany();
        itCompany.setEmployeesArray(EmployeeCreatorForTest.initEmployee());
    }

    @Test
    public void testPositiveFindEmployeeByMaxSalary() throws FinderNullPointerException, ITCompanyNullPointerException {
        itCompany.setEmployeesArray(EmployeeCreatorForTest.initEmployee());
        double maxSalary = FinderMaxSalary.findMaxSalary(itCompany);
        Employee actualEmployee = FinderEmployeeByMaxSalary.findEmployeeByMaxSalary(itCompany, maxSalary);
        Employee expectedEmployee = new ProjectManager("Scott", "Johnson", 60, "Online-Store");
        Assert.assertEquals(expectedEmployee, actualEmployee);
    }

    @Test(expected = FinderNullPointerException.class)
    public void testExceptionFindEmployeeByMaxSalaryWrongEmployee() throws FinderNullPointerException {
        double maxSalary = FinderMaxSalary.findMaxSalary(itCompany);
        itCompany = null;
        FinderEmployeeByMaxSalary.findEmployeeByMaxSalary(itCompany, maxSalary);
    }

    @Test(expected = FinderNullPointerException.class)
    public void testExceptionFindEmployeeByMaxSalaryWrongSalary() throws FinderNullPointerException {
        FinderEmployeeByMaxSalary.findEmployeeByMaxSalary(itCompany, -5);
    }
}

package by.epam.minchuk.task1.model.logic;

import by.epam.minchuk.task1.model.EmployeeCreatorForTest;
import by.epam.minchuk.task1.model.entity.Developer;
import by.epam.minchuk.task1.model.entity.Employee;
import by.epam.minchuk.task1.model.entity.Engineer;
import by.epam.minchuk.task1.model.entity.ITCompany;
import by.epam.minchuk.task1.model.exception.technicalexeption.FinderNullPointerException;
import by.epam.minchuk.task1.model.exception.technicalexeption.ITCompanyNullPointerException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FinderEmployeeByTypeTest {

    private ITCompany itCompany;

    @Test
    public void testFindEmployeeByType() throws FinderNullPointerException, ITCompanyNullPointerException {
        List<Employee> expectedEmployees = new ArrayList<>();
        expectedEmployees.add(new Developer("John", "Conor", 50, Engineer.EngineerLevelType.MIDDLE,
                Developer.DeveloperType.BACK_END, "Java"));
        expectedEmployees.add(new Developer("Donald", "Conor", 46, Engineer.EngineerLevelType.MIDDLE,
                Developer.DeveloperType.BACK_END, "C++"));
        itCompany = new ITCompany();
        itCompany.setEmployeesArray(EmployeeCreatorForTest.initEmployee());
        List<Employee> actualEmployees = FinderEmployeeByType.findEmployeeByType(itCompany, Employee.EmployeeType.DEVELOPER);
        Assert.assertEquals(expectedEmployees.get(0).getClass().getSimpleName(), actualEmployees.get(0).getClass().getSimpleName());
        Assert.assertEquals(expectedEmployees.get(1).getClass().getSimpleName(), actualEmployees.get(1).getClass().getSimpleName());
    }

    @Test(expected = FinderNullPointerException.class)
    public void testExceptionFindEmployeeByType() throws FinderNullPointerException {
        FinderEmployeeByType.findEmployeeByType(itCompany, Employee.EmployeeType.DEVELOPER);
    }
}

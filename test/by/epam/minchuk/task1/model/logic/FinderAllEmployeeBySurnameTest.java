package by.epam.minchuk.task1.model.logic;

import by.epam.minchuk.task1.model.EmployeeCreatorForTest;
import by.epam.minchuk.task1.model.entity.Developer;
import by.epam.minchuk.task1.model.entity.Employee;
import by.epam.minchuk.task1.model.entity.Engineer;
import by.epam.minchuk.task1.model.entity.ITCompany;
import by.epam.minchuk.task1.model.exception.ITCompanyException;
import by.epam.minchuk.task1.model.exception.logicexception.FinderEmployeeNotFoundException;
import by.epam.minchuk.task1.model.exception.technicalexeption.FinderNullPointerException;
import by.epam.minchuk.task1.model.exception.technicalexeption.ITCompanyNullPointerException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FinderAllEmployeeBySurnameTest {

    private ITCompany itCompany;

    @Test
    public void testFindAllEmployeeBySurname() throws ITCompanyNullPointerException, FinderEmployeeNotFoundException, FinderNullPointerException {
        List<Employee> expectedEmployees = new ArrayList<>();
        expectedEmployees.add(new Developer("John", "Conor", 50, Engineer.EngineerLevelType.MIDDLE,
                Developer.DeveloperType.BACK_END, "Java"));
        expectedEmployees.add(new Developer("Donald", "Conor", 46, Engineer.EngineerLevelType.MIDDLE,
                Developer.DeveloperType.BACK_END, "C++"));
        itCompany = new ITCompany();
        itCompany.setEmployeesArray(EmployeeCreatorForTest.initEmployee());
        Assert.assertEquals(expectedEmployees.get(0), FinderAllEmployeeBySurname.findAllEmployeeBySurname(itCompany, "Conor").get(0));
        Assert.assertEquals(expectedEmployees.get(1), FinderAllEmployeeBySurname.findAllEmployeeBySurname(itCompany, "Conor").get(1));
    }

    @Test(expected = ITCompanyException.class)
    public void testExceptionFindAllEmployeeBySurname() throws FinderEmployeeNotFoundException, FinderNullPointerException {
        itCompany = null;
        FinderAllEmployeeBySurname.findAllEmployeeBySurname(itCompany, "Conor");
    }
}

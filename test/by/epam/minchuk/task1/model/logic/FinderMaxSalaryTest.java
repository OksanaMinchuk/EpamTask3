package by.epam.minchuk.task1.model.logic;

import by.epam.minchuk.task1.model.EmployeeCreatorForTest;
import by.epam.minchuk.task1.model.entity.ITCompany;
import by.epam.minchuk.task1.model.exception.technicalexeption.FinderNullPointerException;
import by.epam.minchuk.task1.model.exception.technicalexeption.ITCompanyNullPointerException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FinderMaxSalaryTest {

    private ITCompany itCompany;

    @Before
    public void init() throws ITCompanyNullPointerException {
        itCompany = new ITCompany();
        itCompany.setEmployeesArray(EmployeeCreatorForTest.initEmployee());
    }

    @Test
    public void testPositiveFindMaxSalary() throws FinderNullPointerException {
        double actualMaxSalary = FinderMaxSalary.findMaxSalary(itCompany);
        double excpectedMaxSalary = 60;
        double delta = 0.01;
        Assert.assertEquals(excpectedMaxSalary, actualMaxSalary, delta);
    }

    @Test(expected = FinderNullPointerException.class)
    public void testExceptionFindMaxSalary() throws FinderNullPointerException {
        itCompany = null;
        FinderMaxSalary.findMaxSalary(itCompany);
    }
}

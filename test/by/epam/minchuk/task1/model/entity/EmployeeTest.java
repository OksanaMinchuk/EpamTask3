package by.epam.minchuk.task1.model.entity;

import by.epam.minchuk.task1.model.exception.logicexception.EmployeeDataWrongException;
import org.junit.*;

public class EmployeeTest {

    private Employee employee;

    @Before
    public void initEmployee() {
        employee = new Employee();
    }

    @After
    public void clearEmployee() {
        employee = null;
    }

    @Test
    public void testPositiveSetName () throws EmployeeDataWrongException {
        String expected = "Jack";
        employee.setName("Jack");
        String actual = employee.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNegativeSetName () throws EmployeeDataWrongException {
        String expected = "Jack";
        employee.setName("John");
        String actual = employee.getName();
        Assert.assertNotEquals(expected, actual);
    }

    @Test(expected = EmployeeDataWrongException.class)
    public void testExceptionSetName () throws EmployeeDataWrongException {
        employee.setName("");
    }

    @Test(expected = EmployeeDataWrongException.class)
    public void testExceptionNullSetName () throws EmployeeDataWrongException {
        employee.setName(null);
    }

    @Test
    public void testPositiveSetSalaryPerHour () throws EmployeeDataWrongException {
        double expected = 25;
        employee.setSalaryPerHour(25);
        double actual = employee.getSalaryPerHour();
        double delta = 0.01;
        Assert.assertEquals(expected, actual, delta);
    }

    @Test
    public void testNegativeSetSalaryPerHour () throws EmployeeDataWrongException {
        double expected = 10;
        employee.setSalaryPerHour(25);
        double actual = employee.getSalaryPerHour();
        Assert.assertNotEquals(expected, actual);
    }

    @Test(expected = EmployeeDataWrongException.class)
    public void testExceptionSetSalaryPerHour () throws EmployeeDataWrongException {
        employee.setSalaryPerHour(-25);
    }

    @Test
    public void testPositiveConstructor() {
        this.employee = new Employee("Jack", "Conor", 27);
        String expectedName = "Jack";
        String actualName = this.employee.getName();
        String expectedSurname = "Conor";
        String actualSurname = this.employee.getSurname();
        double expectedSalary = 27;
        double actualSalary = this.employee.getSalaryPerHour();
        double delta = 0.01;
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedSurname, actualSurname);
        Assert.assertEquals(expectedSalary, actualSalary, delta);
    }

    @Test
    public void testEqualsForDifferentEmployee() {
        Employee firstEmployee = new Employee("Den", "Conor", 16);
        Employee secondEmployee = new Employee("Jack", "Conor", 27);
        boolean result = firstEmployee.equals(secondEmployee);
        Assert.assertFalse(result);
    }

    @Test
    public void testEqualsForEqualsEmployee() {
        Employee firstEmployee = new Employee("Jack", "Conor", 27);
        Employee secondEmployee = new Employee("Jack", "Conor", 27);
        boolean result = firstEmployee.equals(secondEmployee);
        Assert.assertTrue(result);
    }

    @Test
    public void testEqualsForNullEmployee() {
        Employee firstEmployee = new Employee("Den", "Conor", 16);
        Employee secondEmployee = null;
        boolean result = firstEmployee.equals(secondEmployee);
        Assert.assertFalse(result);
    }
}

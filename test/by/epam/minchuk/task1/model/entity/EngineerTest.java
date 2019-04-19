package by.epam.minchuk.task1.model.entity;

import by.epam.minchuk.task1.model.exception.logicexception.EmployeeDataWrongException;
import by.epam.minchuk.task1.model.exception.logicexception.EngineerDataWrongException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EngineerTest {

    private Engineer engineer;

    @Before
    public void initEngineer() {
        engineer = new Engineer();
    }

    @After
    public void clearEngineer() {
        engineer = null;
    }

    @Test
    public void testPositiveSetLevel () throws EngineerDataWrongException {
        String expected = Engineer.EngineerLevelType.JUNIOR.toString();
        engineer.setLevel(Engineer.EngineerLevelType.JUNIOR);
        String actual = engineer.getLevel().toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNegativeSetLevel () throws EngineerDataWrongException {
        String expected = Engineer.EngineerLevelType.JUNIOR.toString();
        engineer.setLevel(Engineer.EngineerLevelType.MIDDLE);
        String actual = engineer.getLevel().toString();
        Assert.assertNotEquals(expected, actual);
    }

    @Test(expected = EngineerDataWrongException.class)
    public void testExceptionSetLevel () throws EngineerDataWrongException {
        engineer.setLevel(null);
    }

}

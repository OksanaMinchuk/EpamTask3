package by.epam.minchuk.task1.model.entity;

import by.epam.minchuk.task1.model.exception.logicexception.ProjectManagerDataWrongException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProjectManagerTest {

    private ProjectManager projectManager;

    @Before
    public void initProjectManager() {
        projectManager = new ProjectManager();
    }

    @After
    public void clearProjectManager() {
        projectManager = null;
    }

    @Test
    public void testPositiveSetProject () throws ProjectManagerDataWrongException {
        String expected = "Game";
        projectManager.setProject("Game");
        String actual = projectManager.getProject();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNegativeSetProject () throws ProjectManagerDataWrongException {
        String expected = "Game";
        projectManager.setProject("Store");
        String actual = projectManager.getProject();
        Assert.assertNotEquals(expected, actual);
    }

    @Test(expected = ProjectManagerDataWrongException.class)
    public void testExceptionSetProject () throws ProjectManagerDataWrongException {
        projectManager.setProject("");
    }
}

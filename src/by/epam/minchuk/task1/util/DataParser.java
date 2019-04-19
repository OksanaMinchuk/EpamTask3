package by.epam.minchuk.task1.util;

import by.epam.minchuk.task1.model.entity.*;
import by.epam.minchuk.task1.model.exception.logicexception.*;
import by.epam.minchuk.task1.util.creator.AbstractCreator;
import by.epam.minchuk.task1.util.creator.DeveloperCreator;
import by.epam.minchuk.task1.util.creator.ProjectManagerCreator;
import by.epam.minchuk.task1.util.creator.TesterCreator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DataParser {

    private static final String STRING_SEPARATOR = "\\s";
    private static AbstractCreator creator;

    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    public static Employee[] createEmployee(List<String> listString) {

        int size = listString.size();
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < size; i++) {

            String[] splitString = listString.get(i).split(STRING_SEPARATOR);

            try {
                if (splitString[0].equalsIgnoreCase("Developer")) {
                    creator = new DeveloperCreator();
                    Developer developer = (Developer) creator.create();
                    developer.setName(splitString[1]);
                    developer.setSurname(splitString[2]);
                    developer.setSalaryPerHour(Double.parseDouble(splitString[3]));
                    developer.setLevel(Engineer.EngineerLevelType.valueOf(splitString[4]));
                    developer.setDeveloperType(Developer.DeveloperType.valueOf(splitString[5]));
                    developer.setSkill(splitString[6]);
                    employees.add(developer);

                } else if (splitString[0].equalsIgnoreCase("Tester")) {
                    creator = new TesterCreator();
                    Tester tester = (Tester) creator.create();
                    tester.setName(splitString[1]);
                    tester.setSurname(splitString[2]);
                    tester.setSalaryPerHour(Double.parseDouble(splitString[3]));
                    tester.setLevel(Engineer.EngineerLevelType.valueOf(splitString[4]));
                    tester.setTesterType(Tester.TesterType.valueOf(splitString[5]));
                    employees.add(tester);

                } else if (splitString[0].equalsIgnoreCase("ProjectManager")) {
                    creator = new ProjectManagerCreator();
                    ProjectManager projectManager = (ProjectManager) creator.create();
                    projectManager.setName(splitString[1]);
                    projectManager.setSurname(splitString[2]);
                    projectManager.setSalaryPerHour(Double.parseDouble(splitString[3]));
                    projectManager.setProject(splitString[4]);
                    employees.add(projectManager);
                }

                LOGGER.trace("Parsing text...");

            } catch (EmployeeDataWrongException e) {
                e.printStackTrace();
            } catch (ProjectManagerDataWrongException e) {
                e.printStackTrace();
            } catch (TesterDataWrongException e) {
                e.printStackTrace();
            } catch (EngineerDataWrongException e) {
                e.printStackTrace();
            } catch (DeveloperDataWrongException e) {
                e.printStackTrace();
            }
        }
        return employees.toArray(new Employee[employees.size()]);
    }

}

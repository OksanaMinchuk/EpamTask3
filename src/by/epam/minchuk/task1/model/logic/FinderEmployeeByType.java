package by.epam.minchuk.task1.model.logic;


import by.epam.minchuk.task1.model.entity.Employee;
import by.epam.minchuk.task1.model.entity.ITCompany;
import by.epam.minchuk.task1.model.exception.logicexception.FinderEmployeeNotFoundException;
import by.epam.minchuk.task1.model.exception.technicalexeption.FinderNullPointerException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Class {@code FinderEmployeeByType}
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.03.2019
 */

public class FinderEmployeeByType {

    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    /**
     * Returns an Arraylist containing all of the employees by typeEmployee
     *
     * @param itCompany ITCompany object
     * @param employeeType the specific condition
     * @return List<Employee> object satisfying the specific condition
     * @throws FinderNullPointerException
     */
    public static List<Employee> findEmployeeByType(ITCompany itCompany, Employee.EmployeeType employeeType) throws FinderNullPointerException {
        if (itCompany != null && employeeType != null) {
            Employee[] employees = itCompany.getEmployeesArray();
            List<Employee> findEmployees = new ArrayList<>();
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getClass().getSimpleName().equalsIgnoreCase(employeeType.toString())) {
                    findEmployees.add(employees[i]);
                }
            }
            LOGGER.info("method findEmployeeByType is successful");
            return findEmployees;
        } else {
            throw new FinderNullPointerException("Invoking a method \"findEmployeeByType\" for a null object");
        }
    }

}

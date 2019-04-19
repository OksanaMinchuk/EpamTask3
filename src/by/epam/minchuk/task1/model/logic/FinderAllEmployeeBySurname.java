package by.epam.minchuk.task1.model.logic;

import by.epam.minchuk.task1.model.entity.Employee;
import by.epam.minchuk.task1.model.entity.ITCompany;
import by.epam.minchuk.task1.model.exception.logicexception.FinderEmployeeNotFoundException;
import by.epam.minchuk.task1.model.exception.technicalexeption.FinderNullPointerException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Class {@code FinderAllEmployeeBySurname}
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.03.2019
 */

public class FinderAllEmployeeBySurname {

    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    /**
     * Returns an Arraylist containing all of the elements in existing array by surname
     *
     * @param itCompany ITCompany object
     * @param surnameValue the specific condition
     * @return List<Employee> object satisfying the specific condition
     * @throws FinderNullPointerException,FinderEmployeeNotFoundException
     */
    public static List<Employee> findAllEmployeeBySurname(ITCompany itCompany, String surnameValue) throws FinderNullPointerException, FinderEmployeeNotFoundException {
        if (itCompany != null && surnameValue != null) {
            Employee[] employees = itCompany.getEmployeesArray();
            List<Employee> findEmployees = new ArrayList<>();

            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getSurname().equals(surnameValue)) {
                    findEmployees.add(employees[i]);
                }
            }

            LOGGER.info("method findAllEmployeeBySurname is successful");

            if (findEmployees.isEmpty()) {
                throw new FinderEmployeeNotFoundException("Employee by surname " + surnameValue + " not found");
            }
            return findEmployees;
        } else {
            throw new FinderNullPointerException("Invoking a method \"findAllEmployeeBySurname\" for a null object");
        }
    }
}

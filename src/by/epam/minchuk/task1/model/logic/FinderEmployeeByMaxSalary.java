package by.epam.minchuk.task1.model.logic;

import by.epam.minchuk.task1.model.entity.Employee;
import by.epam.minchuk.task1.model.entity.ITCompany;
import by.epam.minchuk.task1.model.exception.logicexception.FinderEmployeeNotFoundException;
import by.epam.minchuk.task1.model.exception.technicalexeption.FinderNullPointerException;
import org.apache.log4j.Logger;

/**
 * Class {@code FinderEmployeeByMaxSalary}
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.03.2019
 */

public class FinderEmployeeByMaxSalary {

    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    /**
     * Returns employee with max salary
     *
     * @param itCompany ITCompany object
     * @param maxSalary the specific condition
     * @return findEmployee Employee object satisfying the specific condition
     * @throws FinderNullPointerException
     */
    public static Employee findEmployeeByMaxSalary(ITCompany itCompany, double maxSalary) throws FinderNullPointerException {
        if (itCompany != null && maxSalary > 0) {
            Employee[] employees = itCompany.getEmployeesArray();
            Employee findEmployee = null;
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getSalaryPerHour() == maxSalary) {
                    findEmployee = employees[i];
                }
            }
            LOGGER.info("method findEmployeeByMaxSalary is successful");
            return findEmployee;
        } else {
            throw new FinderNullPointerException("Invoking a method \"findEmployeeByMaxSalary\" for a null object or wrong maxSalary value");
        }
    }
}

package by.epam.minchuk.task1.model.logic;

import by.epam.minchuk.task1.model.entity.Employee;
import by.epam.minchuk.task1.model.entity.ITCompany;
import by.epam.minchuk.task1.model.exception.technicalexeption.FinderNullPointerException;
import org.apache.log4j.Logger;

/**
 * Class {@code FinderMaxSalary}
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.03.2019
 */

public class FinderMaxSalary {

    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    /**
     * Returns max salary value
     *
     * @param itCompany ITCompany object
     * @return maxSalary
     * @throws FinderNullPointerException
     */
    public static double findMaxSalary(ITCompany itCompany) throws FinderNullPointerException {
        if (itCompany != null) {
            Employee[] employees = itCompany.getEmployeesArray();
            double maxSalary = 0;
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getSalaryPerHour() > maxSalary) {
                    maxSalary = employees[i].getSalaryPerHour();
                }
            }
            LOGGER.info("method findMaxSalary is successful");
            return maxSalary;
        } else {
            throw new FinderNullPointerException("Invoking a method \"findMaxSalary\" for a null object");
        }
    }
}

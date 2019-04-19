package by.epam.minchuk.task1.model.logic;

import by.epam.minchuk.task1.model.entity.ITCompany;
import by.epam.minchuk.task1.model.exception.technicalexeption.SorterNullPointerException;
import by.epam.minchuk.task1.model.logic.comparator.ComparatorSalary;
import by.epam.minchuk.task1.model.logic.comparator.ComparatorSurname;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Class {@code Sorter}  allows to sort Employee by different conditions
 *
 * @autor Oksana Minchuk
 * @version 1.0 16.03.2019
 */

public class Sorter {

    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    private static Comparator comparator;

    public static void sortBySalary(ITCompany itCompany) throws SorterNullPointerException {
        if (itCompany.getEmployeesArray() != null) {
            comparator = new ComparatorSalary();
            Arrays.sort(itCompany.getEmployeesArray(), comparator);
            LOGGER.info("sorting by salary is successful");
        } else {
            LOGGER.error("method throws exception");
            throw new SorterNullPointerException("Invoking a method \"sortBySalary\" for a null object");
        }
    }

    public static void sortBySurnameAndSalary(ITCompany itCompany) throws SorterNullPointerException {
        if (itCompany.getEmployeesArray() != null) {
            comparator = new ComparatorSurname();
            Arrays.sort(itCompany.getEmployeesArray(), comparator.thenComparing(new ComparatorSalary()));
            LOGGER.info("sorting by surname and salary is successful");
        } else {
            LOGGER.error("method throws exception");
            throw new SorterNullPointerException("Invoking a method \"sortBySurnameAndSalary\" for a null object");
        }
    }
}

package by.epam.minchuk.task1.util.creator;

import by.epam.minchuk.task1.model.entity.*;
import by.epam.minchuk.task1.model.exception.logicexception.ITCompanyDataWrongException;
import by.epam.minchuk.task1.model.exception.technicalexeption.CompanyCreatorNullPointerException;
import by.epam.minchuk.task1.model.exception.technicalexeption.EmployableNullPointerExeption;
import by.epam.minchuk.task1.model.exception.technicalexeption.TeamNullPointerException;

/**
 * Class {@code TeamCreator} creating Teams
 *
 * @autor Oksana Minchuk
 * @version 1.0 15.03.2019
 */

public class TeamCreator {

    public static Team createTeamOne (ITCompany itCompany) throws CompanyCreatorNullPointerException {
        if (itCompany != null) {
            Team team = new Team();
            try {
                team.setManager((ProjectManager) itCompany.getEmployee(10));
                team.addWorker(itCompany.getEmployee(0));
                team.addWorker(itCompany.getEmployee(3));
                team.addWorker(itCompany.getEmployee(6));
                team.addWorker(itCompany.getEmployee(8));
            } catch (ITCompanyDataWrongException e) {
                e.printStackTrace();
            } catch (EmployableNullPointerExeption employableNullPointerExeption) {
                employableNullPointerExeption.printStackTrace();
            } catch (TeamNullPointerException e) {
                e.printStackTrace();
            }
            return team;
        } else {
            throw new CompanyCreatorNullPointerException("Invoking a method for a null object");
        }
    }
    public static Team createTeamTwo (ITCompany itCompany) throws CompanyCreatorNullPointerException {
        if (itCompany != null) {
            Team team = new Team();
            try {
                team.setManager((ProjectManager) itCompany.getEmployee(11));
                team.addWorker(itCompany.getEmployee(1));
                team.addWorker(itCompany.getEmployee(4));
                team.addWorker(itCompany.getEmployee(7));
            } catch (ITCompanyDataWrongException e) {
                e.printStackTrace();
            } catch (EmployableNullPointerExeption employableNullPointerExeption) {
                employableNullPointerExeption.printStackTrace();
            } catch (TeamNullPointerException e) {
                e.printStackTrace();
            }
            return team;
        } else {
            throw new CompanyCreatorNullPointerException("Invoking a method for a null object");
        }
    }
}

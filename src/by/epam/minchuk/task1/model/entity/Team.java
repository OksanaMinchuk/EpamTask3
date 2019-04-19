package by.epam.minchuk.task1.model.entity;

import by.epam.minchuk.task1.model.exception.logicexception.TeamDataWrongException;
import by.epam.minchuk.task1.model.exception.technicalexeption.EmployableNullPointerExeption;
import by.epam.minchuk.task1.model.exception.technicalexeption.TeamNullPointerException;

import java.io.Serializable;

/**
 * Class {@code Team}
 *
 * @autor Oksana Minchuk
 * @version 1.0 16.03.2019
 */

public class Team implements Employable, Serializable {

    private static final int DEFAULT_LENGHT = 0;
    private int lenght;
    private ProjectManager manager;
    private Engineer[] engineers;

    public Team() {
        lenght = DEFAULT_LENGHT;
        engineers = new Engineer[DEFAULT_LENGHT];
    }

    public Team(ProjectManager manager, Engineer[] engineers) {
        this.manager = manager;
        this.engineers = engineers;
    }

    public Team(Team team) {
        this.manager = team.manager;
        engineers = new Engineer[DEFAULT_LENGHT];
        for (int i = 0; i < engineers.length; i++) {
            this.engineers[i] = team.engineers[i];
        }
    }

    public ProjectManager getManager() {
        return manager;
    }

    public void setManager(ProjectManager manager) throws TeamNullPointerException {
        if (manager != null) {
            this.manager = manager;
        } else {
            throw new TeamNullPointerException();
        }
    }

    public Engineer[] getEngineers() {
        return engineers;
    }

    public void setEngineers(Engineer[] engineers) throws TeamNullPointerException{
        if (engineers != null) {
            this.engineers = engineers;
        } else {
            throw new TeamNullPointerException();
        }
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) throws TeamDataWrongException {
        if (lenght >= 0) {
        this.lenght = lenght;
        } else {
            throw new TeamDataWrongException("Wrong array lenght");
        }
    }

    public Engineer getEngineerByIndex(int index) throws TeamDataWrongException {
        if (index >= 0|| index < lenght) {
            return engineers[index];
        } else {
            throw new TeamDataWrongException("Wrong array index");
        }
    }

    public double getTeamPrice(){
        double price = this.manager.getSalaryPerHour();
        for (Engineer engineer : this.engineers) {
            price += engineer.getSalaryPerHour();
        }
        return price;
    }

    @Override
    public void addWorker(Employee employee) throws EmployableNullPointerExeption {
        Engineer engineer = (Engineer)employee;
        if (engineer != null) {
            Engineer[] newEngineers = new Engineer[engineers.length + 1];
            for (int i = 0; i < engineers.length; i++) {
                newEngineers[i] = engineers[i];
            }
            newEngineers[engineers.length] = engineer;
            engineers = newEngineers;
        } else {
            throw new EmployableNullPointerExeption ("Invoking a method for a null object, employee cannot be null");
        }
    }

    @Override
    public void removeWorker(Employee employee) throws EmployableNullPointerExeption{
        Engineer engineer = (Engineer)employee;
        if (engineer != null) {
            Engineer newEngineers[] = new Engineer[engineers.length-1];
            for (int i = 0, j = 0; i < engineers.length; i++, j++) {
                if (!engineer.equals(engineers[i])) {
                    newEngineers[j] = engineers[i];
                } else {
                    j--;
                }
            }
            engineers = newEngineers;
        } else {
            throw new EmployableNullPointerExeption ("Invoking a method for a null object, employee cannot be null");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Engineer engineer : engineers) {
            builder.append(engineer).append("\n");
        }
        return "\tTeam on project \"" + manager.getProject() + "\""
                + "\nmanager = " + manager
                + ",\nengineers = \n" + builder.toString();
    }
}

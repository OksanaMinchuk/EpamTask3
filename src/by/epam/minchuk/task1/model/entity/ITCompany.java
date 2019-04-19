package by.epam.minchuk.task1.model.entity;

import by.epam.minchuk.task1.model.exception.logicexception.ITCompanyDataWrongException;
import by.epam.minchuk.task1.model.exception.technicalexeption.EmployableNullPointerExeption;
import by.epam.minchuk.task1.model.exception.technicalexeption.ITCompanyNullPointerException;
import by.epam.minchuk.task1.util.collection.collectionImpl.MyArrayList;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Class {@code ITCompany}
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.02.2019
 */

public class ITCompany implements Employable, Serializable {

    private static final int DEFAULT_LENGHT = 0;
    private int lenght;
    private Employee[] employeesArray;
    private MyArrayList<Team> teams;

    public ITCompany() {
        lenght = DEFAULT_LENGHT;
        employeesArray = new Employee[lenght];
        teams = new MyArrayList<>();
    }

    public ITCompany(Employee[] employeesArray, MyArrayList<Team> teams) {
        this.employeesArray = employeesArray;
        this.teams = teams;
    }

    public ITCompany(ITCompany itCompany) {
        employeesArray = new Employee[lenght];
        teams = new MyArrayList<>();
        for (int i = 0; i < employeesArray.length; i++) {
            this.employeesArray[i] = itCompany.employeesArray[i];
        }
        for (int i = 0; i < teams.size(); i++ ) {
            this.teams.add(itCompany.teams.get(i));
        }
    }

    public int getLenght() {
        return lenght;
    }

    public void setEmployeesArray(Employee[] employeesArray) throws ITCompanyNullPointerException {
        if (employeesArray != null) {
            this.employeesArray = employeesArray;
        } else {
            throw new ITCompanyNullPointerException("employee array cannot be null");
        }
    }

    public void setLenght(int lenght) throws ITCompanyDataWrongException {
        if (lenght >= 0) {
            this.lenght = lenght;
        } else {
            throw new ITCompanyDataWrongException("Wrong array lenght");
        }
    }

    public Employee[] getEmployeesArray() {
        return employeesArray;
    }

    public Employee getEmployee(int index) throws ITCompanyDataWrongException {
        if (index >= 0 || index < lenght) {
            return employeesArray[index];
        } else {
            throw new ITCompanyDataWrongException("Wrong array index");
        }
    }

    public void setEmployee(int index, Employee newEmployee) throws ITCompanyDataWrongException {
        if (newEmployee != null && index >=0 && index < lenght) {
            this.employeesArray[index] = newEmployee;
        } else {
            throw new ITCompanyDataWrongException("Wrong array index or newEmployee value is null");
        }
    }

    public void addTeam(Team team) throws ITCompanyNullPointerException {
        if (team != null) {
            teams.add(team);
        } else {
            throw new ITCompanyNullPointerException("Invoking a method for a null object, employee can not be null");
        }
    }

    public void removeTeam(Team team) throws ITCompanyNullPointerException {
        if (team != null) {
            teams.remove(team);
        } else {
            throw new ITCompanyNullPointerException("Invoking a method for a null object, employee can not be null");
        }
    }

    public Team getTeamByIndex(int index) throws ITCompanyNullPointerException {
        if (index >= 0 && index < teams.size()) {
            return teams.get(index);
        } else {
            throw new ITCompanyNullPointerException("Invoking a method for a null object, employee can not be null");
        }
    }

    @Override
    public void addWorker(Employee employee) throws EmployableNullPointerExeption {
        if (employee != null) {
            Employee newEmployees[] = new Employee[employeesArray.length + 1];
            for (int i = 0; i < employeesArray.length; i++) {
                newEmployees[i] = employeesArray[i];
            }
            newEmployees[employeesArray.length] = employee;
            employeesArray = newEmployees;
        } else {
            throw new EmployableNullPointerExeption ("Invoking a method \"addEmployeeToCompany\" for a null object, employee cannot be null");
        }
    }

    @Override
    public void removeWorker(Employee employee) throws EmployableNullPointerExeption {
        if (employee != null) {
            Employee newEmployees[] = new Employee[employeesArray.length-1];
            for (int i = 0, j = 0; i < employeesArray.length; i++, j++) {
                if (!employee.equals(employeesArray[i])) {
                    newEmployees[j] = employeesArray[i];
                } else {
                    j--;
                }
            }
            employeesArray = newEmployees;
        } else {
            throw new EmployableNullPointerExeption ("Invoking a method \"removeEmployeeFromCompany\" for a null object, employee cannot be null");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ITCompany itCompany = (ITCompany) o;

        if (lenght != itCompany.lenght) return false;
        return Arrays.equals(employeesArray, itCompany.employeesArray);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(employeesArray);
        result = 31 * result + lenght;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("\tITCompany\n");
        for (Employee employee : employeesArray) {
            builder.append(employee).append("\n");
        }
        for (int i = 0; i < teams.size(); i++) {
            builder.append(teams.get(i));
        }
        return builder.toString();
    }
}

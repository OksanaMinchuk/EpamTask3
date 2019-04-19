package by.epam.minchuk.task1.model.entity;

import by.epam.minchuk.task1.model.exception.logicexception.EmployeeDataWrongException;
import by.epam.minchuk.task1.util.localizationConst.Constant;

import java.io.Serializable;

/**
 * Class {@code Employee} is a superclass for all emloyees of IT-Company
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.02.2019
*/


public class Employee implements Serializable {

    public enum EmployeeType {
        DEVELOPER, TESTER, PROJECTMANAGER
    }

    private String name;
    private String surname;
    private double salaryPerHour;

    public Employee() {
    }

    public Employee(String name, String surname, int salaryPerHour) {
        if (name != ""  && surname != "" && salaryPerHour > 0) {
            this.name = name;
            this.surname = surname;
            this.salaryPerHour = salaryPerHour;
        }
    }

    public Employee(Employee employee) {
        this.name = employee.name;
        this.surname = employee.surname;
        this.salaryPerHour = employee.salaryPerHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws EmployeeDataWrongException {
        if (name != null && name != "") {
            this.name = name;
        } else {
            throw new EmployeeDataWrongException("Wrong employee name value");
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws EmployeeDataWrongException {
        if (surname != null && surname != "") {
            this.surname = surname;
        } else {
            throw new EmployeeDataWrongException("Wrong employee surname value");
        }
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) throws EmployeeDataWrongException {
        if (salaryPerHour > 0) {
            this.salaryPerHour = salaryPerHour;
        } else {
            throw new EmployeeDataWrongException ("Wrong employee salaryPerHour value");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (salaryPerHour != employee.salaryPerHour) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        return surname != null ? surname.equals(employee.surname) : employee.surname == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + surname.hashCode();
        temp = Double.doubleToLongBits(salaryPerHour);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return Constant.NAME + " '" + name + " \', "
                + Constant.SURNAME + " '" + surname + " \', "
                + Constant.SALARY_PER_HOUR + " " + salaryPerHour + ", ";
    }
}

package by.epam.minchuk.task1.model.entity;

import by.epam.minchuk.task1.model.exception.technicalexeption.EmployableNullPointerExeption;

public interface Employable {

    public void addWorker (Employee employee) throws EmployableNullPointerExeption;
    public void removeWorker(Employee employee) throws EmployableNullPointerExeption;

}

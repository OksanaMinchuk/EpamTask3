package by.epam.minchuk.task1.model.entity;

import by.epam.minchuk.task1.model.exception.logicexception.EngineerDataWrongException;
import by.epam.minchuk.task1.util.localizationConst.Constant;

/**
 * Class {@code Engineer} is a subclass of Employee and a superclass for Developer and Tester
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.02.2019
 */

public class Engineer extends Employee {

    public enum EngineerLevelType {
        JUNIOR, MIDDLE, SENIOR
    }

    private EngineerLevelType level;

    public Engineer() {
    }

    public Engineer(String name, String surname, int salaryPerHour, EngineerLevelType level) {
        super(name, surname, salaryPerHour);
        this.level = level;
    }

    public Engineer(Engineer engineer) {
        super(engineer);
        this.level = engineer.level;
    }

    public EngineerLevelType getLevel() {
        return level;
    }

    public void setLevel(EngineerLevelType level) throws EngineerDataWrongException {
        if (level != null) {
            this.level = level;
        } else {
            throw new EngineerDataWrongException("Wrong engineer level type value");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Engineer engineer = (Engineer) o;
        return level == engineer.level;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + level.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + Constant.LEVEL + " = " + level;
    }
}

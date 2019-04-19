package by.epam.minchuk.task1.model.entity;

import by.epam.minchuk.task1.model.exception.logicexception.DeveloperDataWrongException;
import by.epam.minchuk.task1.util.localizationConst.Constant;

/**
 * Class {@code Developer} is a subclass of Engineer
 *
 * @autor Oksana Minchuk
 * @version 1.0 17.02.2019
 */

public class Developer extends Engineer {

    public enum DeveloperType {
        FRONT_END, BACK_END
    }

    private DeveloperType developerType;
    private String skill;

    public Developer() {
    }

    public Developer(DeveloperType developerType, String skill) {
            this.developerType = developerType;
        if (skill != "") {
            this.skill = skill;
        }
    }

    public Developer(String name, String surname, int salaryPerHour, EngineerLevelType levelType, DeveloperType developerType, String skill) {
        super(name, surname, salaryPerHour, levelType);
        if (developerType != null && skill != "") {
            this.developerType = developerType;
            this.skill = skill;
        }
    }

    public Developer(Developer developer) {
        super(developer);
        this.developerType = developer.developerType;
        this.skill = developer.skill;
    }


    public DeveloperType getDeveloperType() {
        return developerType;
    }

    public void setDeveloperType(DeveloperType developerType) throws DeveloperDataWrongException {
        if (developerType != null) {
            this.developerType = developerType;
        } else {
            throw new DeveloperDataWrongException("Wrong developer type value");
        }
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) throws DeveloperDataWrongException {
        if (skill != "" && skill != null) {
            this.skill = skill;
        } else {
            throw new DeveloperDataWrongException("Wrong developer skill value");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Developer developer = (Developer) o;

        if (developerType != developer.developerType) return false;
        return skill.equals(developer.skill);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + developerType.hashCode();
        result = 31 * result + skill.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return Constant.DEVELOPER + " {" + super.toString()
                + ", " + Constant.DEVELOPER_TYPE + " = " + developerType
                + ", " + Constant.SKILL +  " ='" + skill + '\'' + "}";
    }
}

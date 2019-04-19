package by.epam.minchuk.task1.util;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DataValidator {

    private static final String DATA_PATTERN =
            "(Developer|Tester|ProjectManager)(\\s+([A-Za-z])+){2}\\s(\\d+\\.\\d+)(\\s([A-Za-z\\_\\+\\-])+){1,3}";

    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    public static List<String> createValidStringList(String text) {
        LOGGER.trace("Validating text...");

        System.out.println(text);
        List<String> listString = null;

        if (text != null) {
            String[] strings = text.split(";");
            listString = new ArrayList<>();

            for (String str : strings) {

                if (str.matches(DATA_PATTERN)) {
                    listString.add(str);
                }
            }
        }
        return  listString;
    }
}

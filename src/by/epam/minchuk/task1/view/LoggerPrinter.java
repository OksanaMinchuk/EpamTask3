package by.epam.minchuk.task1.view;

import org.apache.log4j.Logger;

public class LoggerPrinter implements Printable {

    private static final Logger LOGGER = Logger.getRootLogger();

    @Override
    public void print(Object ob) {
        LOGGER.info(ob);
    }
}

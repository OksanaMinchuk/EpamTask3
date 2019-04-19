package by.epam.minchuk.task1.view.printercreator;

import by.epam.minchuk.task1.view.*;
import by.epam.minchuk.task1.view.exception.PrinterEnumConstantNotPresentException;

public class PrinterCreator {

    public enum PrinterType {
        CONSOLE, FILE, LOGGER, SOME
    }

    private PrinterCreator() {

    }

    public static Printable getPrinter(PrinterType printerType) throws PrinterEnumConstantNotPresentException {
        Printable printer = new ConsolePrinter();

                switch (printerType) {
                    case FILE:
                        printer = new FilePrinter();
                        break;
                    case LOGGER:
                        printer = new LoggerPrinter();
                        break;
                }

        return printer;
    }
}

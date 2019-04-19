package by.epam.minchuk.task1.util;

import by.epam.minchuk.task1.model.entity.ITCompany;
import org.apache.log4j.Logger;

import java.io.*;

public class MySerializator {

    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    public static void write(String filePath, ITCompany itCompany) {

        try (ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filePath)))) {

            objectOutputStream.writeObject(itCompany);

        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

    public static ITCompany read(String filePath) {

        ITCompany itCompany = null;

        try (ObjectInputStream objectInputStream =
                new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePath)))) {

            itCompany = (ITCompany) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return itCompany;
    }
}

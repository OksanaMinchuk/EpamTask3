package by.epam.minchuk.task1.util;

import org.apache.log4j.Logger;

import java.io.*;

public class DataReader {

    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    public DataReader() {
    }

    public static String readFile(String filePath) {

        LOGGER.trace("Reading text rom file... " + filePath);

        StringBuilder stringBuilder = new StringBuilder();

        try {
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader ist = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(ist);
            String read;

            while ((read = br.readLine()) != null) {
                stringBuilder.append(read);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}


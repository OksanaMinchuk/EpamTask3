package by.epam.minchuk.task1.view;

import java.io.*;

public class FilePrinter implements Printable {

    private File fbyte = new File("outputDataByte.bin");
    private File fsymb = new File("outputDataSymbol.txt");

    //private FileOutputStream fileOutputStream = null;
    //private FileWriter fileWriter = null;

    @Override
    public void print(Object ob) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fbyte, true);
             FileWriter fileWriter = new FileWriter(fsymb, true)) {
            fileOutputStream.write(ob.toString().getBytes());
            fileWriter.write(ob.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

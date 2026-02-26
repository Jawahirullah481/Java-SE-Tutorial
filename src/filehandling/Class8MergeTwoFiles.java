package filehandling;

import filehandling.handler.FileHandler;

import java.io.*;

public class Class8MergeTwoFiles extends FileHandler {

    @Override
    public void execute() {

        try(
                BufferedInputStream reader1 = new BufferedInputStream(new FileInputStream("resources/file-handling/file6.txt"));
                BufferedInputStream reader2 = new BufferedInputStream(new FileInputStream("resources/file-handling/file7.txt"));
                BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream("resources/file-handling/file8.txt"))
        ) {

            int ch;
            while((ch = reader1.read()) != -1) {
                writer.write(ch);
            }

            while((ch = reader2.read()) != -1) {
                writer.write(ch);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

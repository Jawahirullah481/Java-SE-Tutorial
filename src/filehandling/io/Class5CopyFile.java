package filehandling.io;

import filehandling.handler.FileHandler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Class5CopyFile extends FileHandler {

    @Override
    public void execute() {

        try(
                FileInputStream reader = new FileInputStream("resources/file-handling/file3.txt");
                FileOutputStream writer = new FileOutputStream("resources/file-handling/file5.txt")) {

            int ch;

            while((ch = reader.read()) != -1) {
                writer.write(ch);
            }

            System.out.println("File Copied Successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

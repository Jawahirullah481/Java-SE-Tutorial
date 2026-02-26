package filehandling;

import filehandling.handler.FileHandler;

import java.io.File;
import java.io.IOException;

public class Class1CreateFile extends FileHandler {

    /*
        File class DOES NOT read/write data.

        It only:
           1. Represents file path
           2. Manages files
     */

    @Override
    public void execute() {

        File file = new File("resources/file-handling/file1.txt");

        try {
            if (file.exists()) {
                System.out.println("File is Already available");
            } else {
                file.createNewFile();
                System.out.println("File Successfully Created");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package filehandling;

import filehandling.handler.FileHandler;

import java.io.File;
import java.util.Arrays;

public class Class10ListAllFiles extends FileHandler {

    @Override
    public void execute() {

        File directory = new File("resources/file-handling");
        File[] files = directory.listFiles();

        for(File file : files) {
            if(file.isFile())
                System.out.println(file.getName());
        }

    }
}

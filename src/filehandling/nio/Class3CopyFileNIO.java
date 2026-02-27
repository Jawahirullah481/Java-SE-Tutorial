package filehandling.nio;

import filehandling.handler.FileHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Class3CopyFileNIO extends FileHandler {

    @Override
    public void execute() {

        try {

            Path srcFile = Paths.get("resources/file-handling/file10.txt");
            Path destFile = Paths.get("resources/file-handling/file11.txt");

            Files.copy(srcFile, destFile, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Content Copied From " + srcFile + " to " + destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

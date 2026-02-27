package filehandling.nio;

import filehandling.handler.FileHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Class2WriteIntoFileNIO extends FileHandler {

    @Override
    public void execute() {

        try {
            Path path = Paths.get("resources/file-handling/file10.txt");
            String content = "Hi!. This is Line 1 \n" +
                    "This is Line 2 \n" +
                    "This is Line 3";

            Files.write(path, content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

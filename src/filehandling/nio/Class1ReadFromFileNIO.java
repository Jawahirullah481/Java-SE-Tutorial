package filehandling.nio;

import filehandling.handler.FileHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Class1ReadFromFileNIO extends FileHandler {

    @Override
    public void execute() {

        try {

            Path path = Paths.get("resources/file-handling/file3.txt");
            List<String> lines = Files.readAllLines(path);
            lines.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

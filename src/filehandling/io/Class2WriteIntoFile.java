package filehandling.io;

import filehandling.handler.FileHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Class2WriteIntoFile extends FileHandler {

    @Override
    public void execute() {

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("resources/file-handling/file2.txt"))) {

            writer.write("\n");
            writer.write("This Message is from Class2WriteIntoFile");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

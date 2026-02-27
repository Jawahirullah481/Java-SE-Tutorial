package filehandling.io;

import filehandling.handler.FileHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Class4AppendIntoFile extends FileHandler {

    @Override
    public void execute() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("resources/file-handling/file4.txt", true))) {

            writer.write("This Message is from Class4WriteIntoFile\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

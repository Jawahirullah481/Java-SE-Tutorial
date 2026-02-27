package filehandling.io;

import filehandling.handler.FileHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Class6ReadFileContents extends FileHandler {

    @Override
    public void execute() {

        try (BufferedReader reader = new BufferedReader(new FileReader("resources/file-handling/file6.txt"))) {

            int characters = 0, words = 0, lines = 0;
            String line;

            while((line = reader.readLine()) != null) {

                characters += line.length();
                words += line.split(" ").length;
                lines++;

            }

            System.out.printf("%-20s : %d%n", "No. Of. Characters", characters);
            System.out.printf("%-20s : %d%n", "No. Of. Words", words);
            System.out.printf("%-20s : %d%n", "No. Of. Lines", lines);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


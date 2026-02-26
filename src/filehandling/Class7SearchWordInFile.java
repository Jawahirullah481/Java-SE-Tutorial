package filehandling;

import filehandling.handler.FileHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Class7SearchWordInFile extends FileHandler {

    @Override
    public void execute() {

        try (BufferedReader reader = new BufferedReader(new FileReader("resources/file-handling/file7.txt"))) {

            String searchText = "Lion";
            boolean isFound = false;

            String line;

            while((line = reader.readLine()) != null) {
                if(line.contains(searchText)) {
                    isFound = true;
                }
            }

            if(isFound) {
                System.out.println(searchText + " Found");
            } else {
                System.out.println(searchText + " Not Found");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package filehandling;

import filehandling.handler.FileHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Class3ReadFromFile extends FileHandler {

    @Override
    public void execute() {

        method2();

    }

    private void method1() {

        try(FileReader reader = new FileReader("resources/filehandling/file3.txt")) {

            int ch;
            while((ch = reader.read()) != -1) {
                System.out.print((char)ch);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void method2() {

        try (BufferedReader reader = new BufferedReader(new FileReader("resources/file-handling/file3.txt"))) {

            String line = "";

            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

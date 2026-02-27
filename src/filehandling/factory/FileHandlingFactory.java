package filehandling.factory;

import filehandling.handler.FileHandler;
import filehandling.io.*;
import filehandling.nio.Class1ReadFromFileNIO;
import filehandling.nio.Class2WriteIntoFileNIO;
import filehandling.nio.Class3CopyFileNIO;

public class FileHandlingFactory {

    public static void execute() {

        String concept = "CopyFileNIO";

        FileHandler obj;

        switch (concept) {
            case "CreateFile" : obj = new Class1CreateFile(); break;
            case "WriteIntoFile" : obj = new Class2WriteIntoFile(); break;
            case "ReadFromFile" : obj = new Class3ReadFromFile(); break;
            case "AppendIntoFile" : obj = new Class4AppendIntoFile(); break;
            case "CopyFile" : obj = new Class5CopyFile(); break;
            case "ReadFileContents" : obj = new Class6ReadFileContents(); break;
            case "SearchWordInFile" : obj = new Class7SearchWordInFile(); break;
            case "MergeTwoFiles" : obj = new Class8MergeTwoFiles(); break;
            case "Serialization" : obj = new Class9Serialization(); break;
            case "ListAllFiles" : obj = new Class10ListAllFiles(); break;
            case "ReadFromFileNIO" : obj = new Class1ReadFromFileNIO(); break;
            case "WriteIntoFileNIO" : obj = new Class2WriteIntoFileNIO(); break;
            case "CopyFileNIO" : obj = new Class3CopyFileNIO(); break;
            default: obj = new Class1CreateFile(); break;
        }

        obj.execute();

    }

}

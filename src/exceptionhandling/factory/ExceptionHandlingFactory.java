package exceptionhandling.factory;

import exceptionhandling.*;
import exceptionhandling.handler.ExceptionHandler;

public class ExceptionHandlingFactory {

    public static void execute() {

        String concept = "MultiCatchBlock";

        ExceptionHandler obj;

        switch (concept) {
            case "ExceptionInfos" : obj = new Class1ExceptionInfos(); break;
            case "HandlineMultipleExceptions" : obj = new Class2HandlineMultipleExceptions(); break;
            case "ReturnVsFinally" : obj = new Class3ReturnVsFinally(); break;
            case "CustomException" : obj = new Class4CustomException(); break;
            case "TryWithResources" : obj = new Class5TryWithResources(); break;
            case "MultiCatchBlock" : obj = new Class6MultiCatchBlock(); break;
            default: obj = new Class1ExceptionInfos(); break;
        }

        obj.run();

    }

}

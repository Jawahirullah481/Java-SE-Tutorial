import exceptionhandling.*;

public class Main {
    public static void main(String[] args) {

        String concept = "CustomException";

        ExceptionHandler obj;

        switch (concept) {
            case "ExceptionInfos" : obj = new Class1ExceptionInfos(); break;
            case "HandlineMultipleExceptions" : obj = new Class2HandlineMultipleExceptions(); break;
            case "ReturnVsFinally" : obj = new Class3ReturnVsFinally(); break;
            case "CustomException" : obj = new Class4CustomException(); break;
            default: obj = new Class1ExceptionInfos(); break;
        }

        obj.run();

    }
}
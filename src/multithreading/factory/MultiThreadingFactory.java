package multithreading.factory;

import multithreading.Class1CreatingThreads;
import multithreading.handler.ThreadHandler;

public class MultiThreadingFactory {

    public static void execute() {

        String concept = "CreatingThreads";

        ThreadHandler obj;

        switch (concept) {
            case "CreatingThreads" : obj = new Class1CreatingThreads(); break;
            default: obj = new Class1CreatingThreads(); break;
        }

        obj.execute();

    }

}

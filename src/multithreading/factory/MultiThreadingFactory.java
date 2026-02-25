package multithreading.factory;

import multithreading.*;
import multithreading.handler.ThreadHandler;

public class MultiThreadingFactory {

    public static void execute() {

        String concept = "DaemonThreads";

        ThreadHandler obj;

        switch (concept) {
            case "CreatingThreads" : obj = new Class1CreatingThreads(); break;
            case "ThreadPriority" : obj = new Class2ThreadPriority(); break;
            case "YieldMethod" : obj = new Class3YieldMethod(); break;
            case "JoinMethod" : obj = new Class4JoinMethod(); break;
            case "InterruptMethod" : obj = new Class5InterruptMethod(); break;
            case "SynchorizedMethod" : obj = new Class6SynchronizedMethod(); break;
            case "SynchronizedBlock" : obj = new Class7SynchronizedBlock(); break;
            case "WaitNotify" : obj = new Class8WaitNotify(); break;
            case "DaemonThreads" : obj = new Class9DaemonThreads(); break;
            default: obj = new Class1CreatingThreads(); break;
        }

        obj.execute();

    }

}

package stream.factory;

import stream.Class1CreatingStreams;
import stream.Class2ProcessingStreams;
import stream.Class3TerminatingStreams;
import stream.Class4PracticePrograms;
import stream.handler.StreamHandler;

public class StreamFactory {
    public static void execute() {

        String concept = "PracticePrograms";

        StreamHandler obj;

        switch(concept) {
            case "CreatingStreams": obj = new Class1CreatingStreams(); break;
            case "ProcessingStreams": obj = new Class2ProcessingStreams(); break;
            case "TerminatingStreams": obj = new Class3TerminatingStreams(); break;
            case "PracticePrograms": obj = new Class4PracticePrograms(); break;
            default: obj = new Class1CreatingStreams(); break;
        }

        obj.execute();

    }
}

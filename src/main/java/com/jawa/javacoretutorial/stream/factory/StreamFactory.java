package com.jawa.javacoretutorial.stream.factory;

import com.jawa.javacoretutorial.stream.Class1CreatingStreams;
import com.jawa.javacoretutorial.stream.Class2ProcessingStreams;
import com.jawa.javacoretutorial.stream.Class3TerminatingStreams;
import com.jawa.javacoretutorial.stream.Class4PracticePrograms;
import com.jawa.javacoretutorial.stream.handler.StreamHandler;

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

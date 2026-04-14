package com.jawa.javacoretutorial.httprequests.factory;

import com.jawa.javacoretutorial.httprequests.Class1HttpClient;
import com.jawa.javacoretutorial.httprequests.Class2HttpClientWithJacksonParsing;
import com.jawa.javacoretutorial.httprequests.Class3HttpClientWithJsonObject;
import com.jawa.javacoretutorial.httprequests.handler.HttpHandler;

public class HttpFactory {

    public static void execute() {
        String concept = "Class3HttpClientWithJsonObject";

        HttpHandler obj;

        switch(concept) {
            case "HttpClient": obj = new Class1HttpClient(); break;
            case "HttpClientWithJacksonParsing": obj = new Class2HttpClientWithJacksonParsing(); break;
            case "Class3HttpClientWithJsonObject": obj = new Class3HttpClientWithJsonObject(); break;
            default: obj = new Class1HttpClient(); break;
        }

        obj.execute();
    }

}

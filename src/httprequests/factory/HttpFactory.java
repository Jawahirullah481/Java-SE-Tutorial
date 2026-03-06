package httprequests.factory;

import httprequests.Class1HttpClient;
import httprequests.Class2HttpClientWithJacksonParsing;
import httprequests.handler.HttpHandler;

public class HttpFactory {

    public static void execute() {
        String concept = "HttpClientWithJacksonParsing";

        HttpHandler obj;

        switch(concept) {
            case "HttpClient": obj = new Class1HttpClient(); break;
            case "HttpClientWithJacksonParsing": obj = new Class2HttpClientWithJacksonParsing(); break;
            default: obj = new Class1HttpClient(); break;
        }

        obj.execute();
    }

}

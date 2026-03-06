package httprequests;

import com.fasterxml.jackson.databind.ObjectMapper;
import httprequests.handler.HttpHandler;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Class1HttpClient extends HttpHandler {

    @Override
    public void execute() {

        try {
            // 1. Create Http Client
            HttpClient client = HttpClient.newHttpClient();

            // 2. Create Http Request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://jsonplaceholder.typicode.com/users/1"))
                    .GET()
                    .build();

            // 3. Send the Request
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 4. Print the response
            System.out.println(response.body());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}

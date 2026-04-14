package com.jawa.javacoretutorial.httprequests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jawa.javacoretutorial.httprequests.bean.User;
import com.jawa.javacoretutorial.httprequests.handler.HttpHandler;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Class2HttpClientWithJacksonParsing extends HttpHandler {

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

            // 3. Send Http Request
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 4. Getting Json Response String
            String responseBody = response.body();

            // 5. Parse as Object
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(responseBody, User.class);

            System.out.printf(
                    "ID : %d %nUser Name : %s %nEmail : %s %n",
                    user.getId(), user.getUsername(), user.getEmail()
            );



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

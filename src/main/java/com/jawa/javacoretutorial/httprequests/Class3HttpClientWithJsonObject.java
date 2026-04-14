package com.jawa.javacoretutorial.httprequests;

import com.jawa.javacoretutorial.httprequests.handler.HttpHandler;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Class3HttpClientWithJsonObject extends HttpHandler {

    /*
        Retrieve the averate temperature of the records which are having wind speed less than 10.
     */

    @Override
    public void execute() {

        try {

            HttpClient client = HttpClient.newHttpClient();

            String city = "Alwar";
            int page = 1;
            int totalPages = 1;

            int totalTemp = 0;
            int count = 0;

            while (page <= totalPages) {

                String url = "https://jsonmock.hackerrank.com/api/weather/search?name=" + city + "&page=" + page;

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .GET()
                        .build();

                HttpResponse<String> response = client.send(
                        request, HttpResponse.BodyHandlers.ofString());

                JSONObject obj = new JSONObject(response.body());

                // get total pages (only once is enough, but safe anyway)
                totalPages = obj.getInt("total_pages");

                JSONArray data = obj.getJSONArray("data");

                for (int i = 0; i < data.length(); i++) {

                    JSONObject record = data.getJSONObject(i);

                    // 🌡 Temperature from "weather"
                    String weatherStr = record.getString("weather"); // "15 degree"
                    int temperature = Integer.parseInt(weatherStr.split(" ")[0]);

                    // 💨 Wind from "status" array
                    JSONArray statusArr = record.getJSONArray("status");

                    int windSpeed = Integer.MAX_VALUE;

                    for (int j = 0; j < statusArr.length(); j++) {
                        String s = statusArr.getString(j);

                        if (s.startsWith("Wind:")) {
                            String value = s.split(":")[1].trim(); // "1Kmph"
                            windSpeed = Integer.parseInt(value.replaceAll("[^0-9]", ""));
                        }
                    }

                    // ✅ filter condition
                    if (windSpeed < 10) {
                        totalTemp += temperature;
                        count++;
                    }
                }

                page++;
            }

            int average = count == 0 ? 0 : totalTemp / count;
            System.out.println("Average : " + average);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

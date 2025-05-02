package com.example.Working_With_Api;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class WorkingWithApiApplication {

	public static String fetchNameHandler() {
		String url = "https://meowfacts.herokuapp.com/";
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.build();

		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			if (response.statusCode() != 200) {
				throw new RuntimeException("HTTP error code: " + response.statusCode());
			}

			JSONObject jsonResponse = new JSONObject(response.body());
			JSONArray facts = jsonResponse.getJSONArray("data");
			return facts.getString(0);
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			return null;
		}
	}

	public static void main(String[] args) {
		String fact = fetchNameHandler();
		if (fact != null) {
			System.out.println("CAT FACT:");
			System.out.println(fact);
		}
	}

}

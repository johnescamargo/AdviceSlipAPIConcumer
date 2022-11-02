package com.main.rest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;
import com.main.models.SlipClass;

public class RestApi {

	private static final String URL_BASE = "https://api.adviceslip.com/";

	//Get and display some random advice
	public void randomAdvice() {
		
		try {
			
			String advice = URL_BASE + "advice";
			URL url = new URL(advice);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			int responseCode = conn.getResponseCode();

			if (responseCode != 200) {
				throw new RuntimeException("HttpResponseCode" + responseCode);
			} else {

				StringBuilder informationString = new StringBuilder();
				Scanner scanner = new Scanner(url.openStream());

				while (scanner.hasNext()) {
					informationString.append(scanner.nextLine());
				}
				// Closing the scanner
				scanner.close();

				// Printing the data
				System.out.println(informationString);

				String resString = informationString.toString();

				Gson gson = new Gson();
				SlipClass slip = gson.fromJson(resString, SlipClass.class);//Using an object to display the data.

				System.out.println(slip);// printing the class

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}

package com.trade.markets.client.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class ProcessorThread {
	

	public static void process(String url) throws IOException, InterruptedException {

		Thread.sleep(2*1000);
		System.out.println("Executing:" + url.substring(52));
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);
//		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//		String line = "";
//		while ((line = rd.readLine()) != null) {
//			System.out.println(line);
//		}

	}
}

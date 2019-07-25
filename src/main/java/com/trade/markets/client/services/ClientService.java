package com.trade.markets.client.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class ClientService {

	String serverURL = "https://springboot-test-chocks.herokuapp.com/baseURL/findMarketSignals";

	@RequestMapping(value = "/start/Daily", method = RequestMethod.GET)
	public void findDailySignals() throws InterruptedException, IOException {

		List<String> urlList = new ArrayList<String>();

		try {
			File file = new File("src/main/java/com/trade/markets/client/services/symbols.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {

					String symbuy = serverURL + "/MACD/Daily/BUY/" + line.toString();
					String symsell = serverURL + "/MACD/Daily/SELL/" + line.toString();

					urlList.add(symbuy);
					urlList.add(symsell);

					line = br.readLine();
				}

			} finally {
				br.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		while (urlList.size() > 0) {
			for (int i = 0; i < urlList.size(); i++) {
				ProcessorThread.process(urlList.get(i));
			}

			Thread.sleep(30 * 1000);
		}
	}

	@RequestMapping(value = "/start/Weekly", method = RequestMethod.GET)
	public void findMACDWeeklySignals() throws InterruptedException, IOException {

		List<String> urlList = new ArrayList<String>();

		try {
			File file = new File("src/main/java/com/trade/markets/client/services/symbols.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {

					String symbuy = serverURL + "/MACD/Weekly/BUY/" + line.toString();
					String symsell = serverURL + "/MACD/Weekly/SELL/" + line.toString();

					urlList.add(symbuy);
					urlList.add(symsell);

					line = br.readLine();
				}

			} finally {
				br.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		while (urlList.size() > 0) {
			for (int i = 0; i < urlList.size(); i++) {
				ProcessorThread.process(urlList.get(i));
			}

			Thread.sleep(30 * 1000);
		}
	}

	@RequestMapping(value = "/start/Monthly", method = RequestMethod.GET)
	public void findMonthlyignals() throws InterruptedException, IOException {

		List<String> urlList = new ArrayList<String>();

		try {
			File file = new File("src/main/java/com/trade/markets/client/services/symbols.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {

					String symbuy = serverURL + "/MACD/Monthly/BUY/" + line.toString();
					String symsell = serverURL + "/MACD/Monthly/SELL/" + line.toString();

					urlList.add(symbuy);
					urlList.add(symsell);

					line = br.readLine();
				}

			} finally {
				br.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		while (urlList.size() > 0) {
			for (int i = 0; i < urlList.size(); i++) {
				ProcessorThread.process(urlList.get(i));
			}

			Thread.sleep(30 * 1000);
		}
	}

}
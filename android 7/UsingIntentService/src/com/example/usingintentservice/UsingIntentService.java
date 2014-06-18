package com.example.usingintentservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class UsingIntentService extends IntentService {

	public UsingIntentService() {
		super("Empty Constructor");
	}

	public UsingIntentService(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	// This method is executed in background when this service is started
	@Override
	protected void onHandleIntent(Intent intent) {
		String group = "";
		String url = "";

		url = Constants.SERVER_URL;

		try {
			// Retreiving file from the url
			group = downloadUrl(url);

			// Creating an intent for broadcastreceiver
			Intent broadcastIntent = new Intent(Constants.BROADCAST_ACTION);

			// Attaching data to the intent
			broadcastIntent.putExtra(Constants.EXTRA_FILE, group);

			// Sending the broadcast

			LocalBroadcastManager.getInstance(getApplicationContext())
					.sendBroadcast(broadcastIntent);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** A method to download data from url */
	private String downloadUrl(String strUrl) throws IOException {
		String data = "";
		InputStream iStream = null;
		HttpURLConnection urlConnection = null;
		try {
			URL url = new URL(strUrl);

			// Creating an http connection to communicate with url
			urlConnection = (HttpURLConnection) url.openConnection();

			// Connecting to url
			urlConnection.connect();

			// Reading data from url
			iStream = urlConnection.getInputStream();

			BufferedReader br = new BufferedReader(new InputStreamReader(
					iStream));

			StringBuffer sb = new StringBuffer();
			String line = "";
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

			data = sb.toString();

			br.close();

		} catch (Exception e) {
			Log.d("Exception while fetching data", e.toString());
		} finally {
			iStream.close();
			urlConnection.disconnect();
		}
		return data;
	}

}

package com.example.notificationbarapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationReceiver extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView tv = new TextView(this);
		tv.setText("You clicked the Show Notification Button and then selected the notfication");

		setContentView(tv);
	}
}

package com.example.notificationsmsapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationView extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification);

		TextView tv = (TextView) findViewById(R.id.tv_sms_sent);
		Bundle data = getIntent().getExtras();
		tv.setText(data.getString("number"));
	}
}

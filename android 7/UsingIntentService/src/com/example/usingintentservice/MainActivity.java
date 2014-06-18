package com.example.usingintentservice;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	Button button;
	Intent mServiceIntent;
	DogFileReceiver mReceiver;
	TextView mTvGroup;

	IntentFilter mFilter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.file_main);
		button = (Button) this.findViewById(R.id.btn_download);
		mTvGroup = (TextView) findViewById(R.id.tv_dog_group);

		button.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {

		mServiceIntent = new Intent(getApplicationContext(),
				UsingIntentService.class);

		// Starting the DogFileService to fetch the file
		startService(mServiceIntent);

		// Instantiating BroadcastReceiver
		mReceiver = new DogFileReceiver();

		// Creating an IntentFilter with action
		mFilter = new IntentFilter(Constants.BROADCAST_ACTION);

		// Registering BroadcastReceiver with this activity for the intent
		// filter

		LocalBroadcastManager.getInstance(getApplicationContext())
				.registerReceiver(mReceiver, mFilter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.file_main, menu);
		return true;
	}

	// Defining a BroadcastReceiver
	private class DogFileReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {

			String group = intent.getStringExtra(Constants.EXTRA_FILE);
			mTvGroup.setText("FILE CONTENTS: " + group);

		}
	}

}

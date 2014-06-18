package com.example.buttonresourceapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ButtonResourceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_button_resource);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.

		getMenuInflater().inflate(R.menu.button_resource, menu);

		Button button = (Button) findViewById(R.id.btn_start);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Toast.makeText(ButtonResourceActivity.this,
						"Start Button was Clicked", Toast.LENGTH_LONG).show();

			}

		});

		Button button1 = (Button) findViewById(R.id.btn_stop);

		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				Toast.makeText(ButtonResourceActivity.this,
						"Stop Button was Clicked", Toast.LENGTH_LONG).show();

			}

		});

		return true;

	}

}

/*
 * public class ButtonResourceActivity extends Activity {
 * 
 * @Override protected void onCreate(Bundle savedInstanceState) {
 * super.onCreate(savedInstanceState);
 * setContentView(R.layout.activity_button_resource);
 * 
 * 
 * public boolean onCreateOptionsMenu(Menu menu){ // Inflate the menu; this adds
 * items to the action bar if it is present.
 * getMenuInflater().inflate(R.menu.button_resource, menu);
 * 
 * 
 * Button button = (Button) findViewById(R.id.btn_start);
 * button.setOnClickListener(new OnClickListener() { public void OnClick(View
 * view) { Toast.makeText(ButtonResourceActivity.this,
 * "The start button was clicked", Toast.LENGTH_LONG) .show(); }
 * 
 * @Override public void onClick(View v) { // TODO Auto-generated method stub
 * 
 * } }); return true; }
 * 
 * } }
 */

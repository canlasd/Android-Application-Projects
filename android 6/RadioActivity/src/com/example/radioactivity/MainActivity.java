package com.example.radioactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dogs_view);

		findViewById(R.id.Sporting).setOnClickListener(mGlobal_OnClickListener);
		findViewById(R.id.Hound).setOnClickListener(mGlobal_OnClickListener);
		findViewById(R.id.NonSporting).setOnClickListener(
				mGlobal_OnClickListener);

		findViewById(R.id.Working).setOnClickListener(mGlobal_OnClickListener);
		findViewById(R.id.Toy).setOnClickListener(mGlobal_OnClickListener);
		findViewById(R.id.Herding).setOnClickListener(mGlobal_OnClickListener);
		findViewById(R.id.Terrier).setOnClickListener(mGlobal_OnClickListener);
		findViewById(R.id.Mutt).setOnClickListener(mGlobal_OnClickListener);

	}

	// Global On Click listener for all views

	final OnClickListener mGlobal_OnClickListener = new OnClickListener() {
		@Override
		public void onClick(final View v) {
			switch (v.getId()) {
			case R.id.Sporting:

				Toast toast = Toast.makeText(MainActivity.this,
						"You selected the Sporting Button", Toast.LENGTH_LONG);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();
				break;

			case R.id.Hound:

				Toast toast1 = Toast.makeText(MainActivity.this,
						"You selected the Hound Button", Toast.LENGTH_LONG);
				toast1.setGravity(Gravity.CENTER, 0, 0);
				toast1.show();
				break;

			case R.id.NonSporting:

				Toast toast2 = Toast.makeText(MainActivity.this,
						"You selected the Non-Sporting Button",
						Toast.LENGTH_LONG);
				toast2.setGravity(Gravity.CENTER, 0, 0);
				toast2.show();
				break;

			case R.id.Working:

				Toast toast3 = Toast.makeText(MainActivity.this,
						"You selected the Working Button", Toast.LENGTH_LONG);
				toast3.setGravity(Gravity.CENTER, 0, 0);
				toast3.show();
				break;

			case R.id.Toy:

				Toast toast4 = Toast.makeText(MainActivity.this,
						"You selected the Toy Button", Toast.LENGTH_LONG);
				toast4.setGravity(Gravity.CENTER, 0, 0);
				toast4.show();
				break;

			case R.id.Herding:

				Toast toast5 = Toast.makeText(MainActivity.this,
						"You selected the Herding Button", Toast.LENGTH_LONG);
				toast5.setGravity(Gravity.CENTER, 0, 0);
				toast5.show();
				break;

			case R.id.Terrier:

				Toast toast6 = Toast.makeText(MainActivity.this,
						"You selected the Terrier Button", Toast.LENGTH_LONG);
				toast6.setGravity(Gravity.CENTER, 0, 0);
				toast6.show();
				break;

			case R.id.Mutt:

				Toast toast7 = Toast.makeText(MainActivity.this,
						"You selected the Mutt Button", Toast.LENGTH_LONG);
				toast7.setGravity(Gravity.CENTER, 0, 0);
				toast7.show();
				break;
			}
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;

	}

}

package com.example.popupmenuapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TextView textv = (TextView) findViewById(R.id.lab_menu);
		textv.setOnClickListener(viewClickListener);
	}

	OnClickListener viewClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			showPopupMenu(v);
		}

	};

	private void showPopupMenu(View v) {
		PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
		popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());

		popupMenu
				.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem item) {

						Toast.makeText(MainActivity.this, item.toString(),
								Toast.LENGTH_LONG).show();
						return true;
					}
				});

		popupMenu.show();
	}
}

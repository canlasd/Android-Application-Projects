package com.example.popumenuimage;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnMenuItemClickListener,
		OnClickListener {

	private PopupMenu popupMenu;

	private final static int Dogs = 1;
	private final static int Cats = 2;
	private final static int Birds = 3;

	/** Called when the activity is first created. */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pop_up);
		popupMenu = new PopupMenu(MainActivity.this, findViewById(R.id.heart));
		popupMenu.getMenu().add(Menu.NONE, Dogs, Menu.NONE, R.string.dogs);
		popupMenu.getMenu().add(Menu.NONE, Cats, Menu.NONE, R.string.cats);
		popupMenu.getMenu().add(Menu.NONE, Birds, Menu.NONE, R.string.birds);
		popupMenu.setOnMenuItemClickListener(MainActivity.this);

		findViewById(R.id.heart).setOnClickListener(MainActivity.this);

	}

	@Override
	public void onClick(View v) {
		popupMenu.show();

	}

	@Override
	public boolean onMenuItemClick(MenuItem item) {
		TextView tv = (TextView) findViewById(R.id.selection);
		switch (item.getItemId()) {

		case Dogs:
			tv.setText(R.string.dog_love);
			break;

		case Cats:
			tv.setText(R.string.cat_love);
			break;

		case Birds:
			tv.setText(R.string.bird_love);
			break;

		}

		return false;

	}
}

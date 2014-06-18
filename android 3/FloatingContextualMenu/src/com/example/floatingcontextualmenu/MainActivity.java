package com.example.floatingcontextualmenu;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	String[] Dogs = new String[] { "Afinpincher", "Afghan Hound",
			"Basset Hound", "Bichon Friche", "Bull Dog", "Chow Chow",
			"American Cocker Spaniel", "German Shepard", "Great Dane",
			"Grey Hound", "Poodle", "Labrador Retriever", "Maltese",
			"Yorkshire Terrier" };

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, Dogs);
		getListView().setAdapter(adapter);

		/** Registering context menu for the listview */
		registerForContextMenu(getListView());

	}

	/** This will be invoked when an item in the listview is long pressed */
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		getMenuInflater().inflate(R.menu.actions, menu);
	}

	/** This will be invoked when a menu item is selected */
	@Override
	public boolean onContextItemSelected(MenuItem item) {

		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
				.getMenuInfo();

		switch (item.getItemId()) {
		case R.id.menu_want:
			Toast.makeText(this, "I want a : " + Dogs[info.position],
					Toast.LENGTH_LONG).show();
			break;
		case R.id.menu_delete:
			Toast.makeText(this, "Remove a : " + Dogs[info.position],
					Toast.LENGTH_LONG).show();
			break;
		case R.id.menu_maybe:
			Toast.makeText(this, "Not sure about : " + Dogs[info.position],
					Toast.LENGTH_LONG).show();
			break;

		}
		return true;
	}

}
package com.example.contextualmenuapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	String[] Dogs = new String[] { "Afinpincher", "Afghan Hound",
			"Basset Hound", "Bichon Friche", "Bull Dog", "Chow Chow",
			"American Cocker Spaniel", "German Shepard", "Great Dane",
			"Grey Hound", "Poodle", "Labrador Retriever", "Maltese",
			"Yorkshire Terrier" };

	MultiChoiceModeListener mMultiChoiceModeListener;

	@Override
	protected void onStart() {
		super.onStart();

		/**
		 * For contextual action mode, the choice mode should be
		 * CHOICE_MODE_MULTIPLE_MODAL
		 */
		getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

		/** Setting multichoicemode listener for the listview */
		getListView().setMultiChoiceModeListener(mMultiChoiceModeListener);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/** Defining a multichoicemodelistener for the listview. */
		mMultiChoiceModeListener = new MultiChoiceModeListener() {

			@Override
			public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
				return false;
			}

			@Override
			public void onDestroyActionMode(ActionMode mode) {

			}

			/**
			 * This will be invoked when action mode is created. In our case ,
			 * it is on long clicking a menu item
			 */
			@Override
			public boolean onCreateActionMode(ActionMode mode, Menu menu) {
				getMenuInflater().inflate(R.menu.context_menu, menu);
				return true;
			}

			/** Invoked when an action in the action mode is clicked */
			@Override
			public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
				Toast.makeText(
						getBaseContext(),
						"Applying " + item.getTitle() + " on "
								+ getListView().getCheckedItemCount()
								+ " Dogs \n" + getCheckedItems(),
						Toast.LENGTH_LONG).show();

				return false;
			}

			@Override
			public void onItemCheckedStateChanged(ActionMode mode,
					int position, long id, boolean checked) {
			}
		};

		/** Defining array adapter to host the list of items */
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_multiple_choice, Dogs);

		/** Setting array adapter for the listview */
		getListView().setAdapter(adapter);

	}

	/** Returning the selected items */
	public String getCheckedItems() {
		String selected_Dogs = "";
		SparseBooleanArray checkedItems = getListView()
				.getCheckedItemPositions();
		for (int i = 0, j = 0; i < Dogs.length; i++) {
			if (checkedItems.get(i)) {
				j++;
				selected_Dogs += "\n" + j + ". " + Dogs[i];
			}

		}
		return selected_Dogs;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}

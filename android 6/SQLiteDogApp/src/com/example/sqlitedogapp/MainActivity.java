package com.example.sqlitedogapp;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements
		LoaderCallbacks<Cursor> {

	SimpleCursorAdapter mAdapter;
	ListView mLstDogs;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/** Event handler for click event on Add button */
		OnClickListener addContactListener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				/**
				 * Creating a bundle object to pass some data to the fragment
				 */
				Bundle args = new Bundle();

				/** Adding current operation to the bundle object */
				args.putInt("dog_action", DogConstants.DOG_ADD);

				/** Getting fragment manager to open the contact fragment */
				/**
				 * Here Android's backward compatibility support library
				 * function getSupportFragmentManager() is used to support
				 * Android 1.6 and above
				 */
				FragmentManager fm = getSupportFragmentManager();
				/** Creating dogs dialog fragment */
				DogConstants dogcontact = new DogConstants();
				/** Setting the bundle object to this fragment */
				dogcontact.setArguments(args);

				/**
				 * Starting a fragment transaction to dyanmically add fragment
				 * to the application
				 */
				FragmentTransaction ft = fm.beginTransaction();

				/** Adding fragment to the fragment transaction */
				ft.add(dogcontact, "CONTACT");

				/**
				 * The dog dialog fragment is effectively added and opened
				 */
				ft.commit();

			}
		};
		/** Event handler for click event on Edit button */
		OnClickListener editContactListener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				int id = 0;

				/**
				 * Getting the position of the currently selected item in the
				 * listview
				 */
				int position = mLstDogs.getCheckedItemPosition();

				/**
				 * Getting the id of the currently selected contact in the
				 * listview
				 */
				if (mAdapter.getCursor().moveToPosition(position)) {
					id = Integer.parseInt(mAdapter.getCursor().getString(0));
				}

				/**
				 * If no item is selected, then corresponding message is shown
				 */
				if (id == 0) {
					Toast.makeText(getBaseContext(),
							"Please Select a dog to edit", Toast.LENGTH_SHORT)
							.show();
					return;
				}

				/** Creating a bundle object to pass some data to the fragment */
				Bundle args = new Bundle();

				/** Adding contact id to the bundle object */
				args.putInt("dog_id", id);

				/** Adding current operation to the bundle object */
				args.putInt("dog_action", DogConstants.DOG_EDIT);

				/** Getting fragment manager to open the contact fragment */
				/**
				 * Here Android's backward compatibility support library
				 * function getSupportFragmentManager() is used to support
				 * Android 1.6 and above
				 */
				FragmentManager fm = getSupportFragmentManager();

				/** Creating contact dialog fragment */
				DogConstants dogcontact = new DogConstants();

				/** Setting the bundle object to this fragment */

				dogcontact.setArguments(args);

				/**
				 * Starting a fragment transaction to dyanmically add fragment
				 * to the application
				 */
				FragmentTransaction ft = fm.beginTransaction();

				/** Adding fragment to the fragment transaction */

				ft.add(dogcontact, "CONTACT");

				/** The contact dialog fragment is effectively added and opened */

				ft.commit();

			}
		};

		/** Event handler for click event on Delete button */
		OnClickListener delContactListener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				int id = 0;
				/**
				 * Getting the position of the currently selected item in the
				 * listview
				 */
				int position = mLstDogs.getCheckedItemPosition();

				/**
				 * Getting the id of the currently selected contact in the
				 * listview
				 */
				if (mAdapter.getCursor().moveToPosition(position)) {
					id = Integer.parseInt(mAdapter.getCursor().getString(0));
				}

				/** If no item is selected, then corresponding message is shown */
				if (id == 0) {
					Toast.makeText(getBaseContext(),
							"Please Select an  Entry to delete",
							Toast.LENGTH_SHORT).show();
					return;
				}

				/** Creating a bundle object to pass some data to the fragment */
				Bundle args = new Bundle();
				/** Adding contact id to the bundle object */
				args.putInt("dog_id", id);

				/** Adding current operation to the bundle object */
				args.putInt("dog_action", DogConstants.DOG_DEL);

				/** Getting fragment manager to open the contact fragment */
				/**
				 * Here Android's backward compatibility support library
				 * function getSupportFragmentManager() is used to support
				 * Android 1.6 and above
				 */

				FragmentManager fm = getSupportFragmentManager();

				/** Creating contact dialog fragment */
				DogConstants dogcontact = new DogConstants();

				/** Setting the bundle object to this fragment */
				dogcontact.setArguments(args);

				/**
				 * Starting a fragment transaction to dyanmically add fragment
				 * to the application
				 */
				FragmentTransaction ft = fm.beginTransaction();

				/** Adding fragment to the fragment transaction */
				ft.add(dogcontact, "CONTACT");

				/** The contact dialog fragment is effectively added and opened */

				ft.commit();

			}
		};
		/** Getting a reference to Add Dog Button */
		Button addContact = (Button) findViewById(R.id.btn_add);
		addContact.setOnClickListener(addContactListener);

		/** Getting a reference to Edit Dog Button */
		Button editContact = (Button) findViewById(R.id.btn_edit);
		editContact.setOnClickListener(editContactListener);

		/** Getting a reference to Delete Dog Button */
		Button delContact = (Button) findViewById(R.id.btn_del);
		delContact.setOnClickListener(delContactListener);

		mLstDogs = (ListView) findViewById(R.id.lst_dogs);

		mAdapter = new SimpleCursorAdapter(getBaseContext(),
				android.R.layout.simple_list_item_single_choice, null,
				new String[] { DogBreedsDB.KEY_NAME, DogBreedsDB.KEY_GROUP },
				new int[] { android.R.id.text1, android.R.id.text2 }, 0);

		mLstDogs.setAdapter(mAdapter);
		mLstDogs.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

		/** Creating a loader for populating listview from sqlite database */
		getSupportLoaderManager().initLoader(0, null, this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/** A callback method invoked by the loader when initLoader() is called */
	@Override
	public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
		Uri uri = DogProvider.CONTENT_URI;
		return new CursorLoader(this, uri, null, null, null, null);
	}

	/**
	 * A callback method, invoked after the requested content provider returned
	 * all the data
	 */
	@Override
	public void onLoadFinished(Loader<Cursor> arg0, Cursor arg1) {
		mAdapter.swapCursor(arg1);
	}

	@Override
	public void onLoaderReset(Loader<Cursor> arg0) {
		mAdapter.swapCursor(null);
	}
}

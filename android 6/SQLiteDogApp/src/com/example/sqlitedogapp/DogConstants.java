package com.example.sqlitedogapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.EditText;

public class DogConstants extends DialogFragment implements
		LoaderCallbacks<Cursor> {

	/** A constant identifier for add operation */
	public static final int DOG_ADD = 1;

	/** A constant identifier for edit operation */
	public static final int DOG_EDIT = 2;

	/** A constant identifier for delete operation */
	public static final int DOG_DEL = 3;

	/** An adapter which holds dogs for the listview */
	SimpleCursorAdapter mAdapter;

	/** A reference for Dog Breed name */
	EditText mTxtName;

	/** A reference for Dog Group */
	EditText mTxtGroup;

	/** A variable to inflate the layout file contact.xml */
	View mDogView;

	/**
	 * A variable to hold Dog id, which is required for update and delete of an
	 * entry
	 */
	int mDogId = 0;

	/** Current operation done by this class, default is DOG_ADD */
	int mDogAction = DOG_ADD;

	/** A callback method */
	@Override
	public void onActivityCreated(Bundle arg0) {
		super.onActivityCreated(arg0);

		/** Getting a reference to Name */
		mTxtName = (EditText) mDogView.findViewById(R.id.txt_breed);

		/** Getting a reference to Group */
		mTxtGroup = (EditText) mDogView.findViewById(R.id.txt_group);

		/** Creating the loader, if it does not exists */
		getLoaderManager().initLoader(0, null, this);
	};

	/** A callbak method */
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		/**
		 * Initializes mDogAction and mDogID using the arguments passed to this
		 * fragment by the function setArguments()
		 */
		Bundle b = getArguments();
		if (b != null) {
			if (b.containsKey("dog_action")) {
				mDogAction = b.getInt("dog_action");
			}
			if (b.containsKey("dog_id")) {
				mDogId = b.getInt("dog_id");
			}
		}

		/** Creates a dialog window */
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(
				getActivity());

		/** Inflating the layout file for this dialog window */
		mDogView = getActivity().getLayoutInflater().inflate(R.layout.dogs,
				null);

		/** Click listener for the OK button of the dialog window */
		OnClickListener clickListener = new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				/** Setting up values to insert or delete a dog */
				ContentValues contentValues = new ContentValues();
				contentValues.put(DogBreedsDB.KEY_NAME, mTxtName.getText()
						.toString());
				contentValues.put(DogBreedsDB.KEY_GROUP, mTxtGroup.getText()
						.toString());

				switch (mDogAction) {
				case DOG_ADD:
					/** Invokes content provider's insert operation */

					getActivity().getContentResolver().insert(
							DogProvider.CONTENT_URI, contentValues);
					break;
				case DOG_EDIT:
					/** Invokes content provider's update operation */
					Uri uri = DogProvider.CONTENT_URI;
					String pathSegment = Integer.toString(mDogId);
					uri = Uri.withAppendedPath(uri, pathSegment);

					getActivity().getContentResolver().update(uri,
							contentValues, null, null);

					break;

				case DOG_DEL:
					/** Invokes content provider's delete operation */
					uri = DogProvider.CONTENT_URI;
					pathSegment = Integer.toString(mDogId);
					uri = Uri.withAppendedPath(uri, pathSegment);

					getActivity().getContentResolver().delete(uri, null, null);
				}

				/** Restarting the MainActivity's loader to refresh the listview */
				getActivity().getSupportLoaderManager().restartLoader(0, null,
						(LoaderCallbacks<Cursor>) getActivity());
			}
		};

		/** Changing the appearance of the dialog window based on the operation */
		switch (mDogAction) {
		case DOG_ADD:
			dialogBuilder.setView(mDogView);
			dialogBuilder.setTitle("Add Dog Information");
			break;
		case DOG_EDIT:
			dialogBuilder.setView(mDogView);
			dialogBuilder.setTitle("Edit Dog Information");
			break;
		case DOG_DEL:
			dialogBuilder.setTitle("Delete Dog Information");
			dialogBuilder.setMessage("Are you sure you want to delete?");
			break;

		}

		dialogBuilder.setNegativeButton("Cancel", null);

		/** Setting click event handler for the OK button */
		dialogBuilder.setPositiveButton("OK", clickListener);
		return dialogBuilder.create();
	}

	/** A callback method invoked by the loader when initLoader() is called */
	@Override
	public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
		Bundle b = getArguments();

		/** Requesting for the Dog Breed name and Dog Group to be edited */
		if (mDogAction == DOG_EDIT) {
			Uri uri = DogProvider.CONTENT_URI;
			String pathSegment = Integer.toString(mDogId);
			uri = Uri.withAppendedPath(uri, pathSegment);
			return new CursorLoader(getActivity(), uri, null, null, null, null);
		} else {
			return null;
		}
	}

	/**
	 * A callback method, invoked after the requested content provider returned
	 * all the data
	 */
	@Override
	public void onLoadFinished(Loader<Cursor> arg0, Cursor data) {
		/** populates Dog Breed Name and Dog Group on edit operation */
		if (data.moveToFirst()) {
			mTxtName.setText(data.getString(1));
			mTxtGroup.setText(data.getString(2));
		}

	}

	@Override
	public void onLoaderReset(Loader<Cursor> arg0) {
	}

}
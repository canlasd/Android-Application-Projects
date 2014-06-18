package com.example.sqlitedogapp;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;

/** A custom Content Provider to do the database operations */
public class DogProvider extends ContentProvider {

	public static final String PROVIDER_NAME = "AND001.sqlite.app.contacts";

	/**
	 * A uri to do operations on Dog Breeds table. A content provider is
	 * identified by its uri
	 */
	public static final Uri CONTENT_URI = Uri.parse("content://"
			+ PROVIDER_NAME + "/dogs");

	/** Constants to identify the requested operation */
	private static final int DOGS = 1;
	private static final int DOG_ID = 2;

	private static final UriMatcher uriMatcher;
	static {
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(PROVIDER_NAME, "dogs", DOGS);
		uriMatcher.addURI(PROVIDER_NAME, "dogs/#", DOG_ID);
	}

	/** This content provider does the database operations by this object */
	DogBreedsDB mDogssDB;

	/**
	 * A callback method which is invoked when the content provider is starting
	 * up
	 */
	@Override
	public boolean onCreate() {
		mDogssDB = new DogBreedsDB(getContext());
		return true;
	}

	/**
	 * A callback method which is invoked when delete operation is requested on
	 * this content provider
	 */
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		int cnt = 0;
		if (uriMatcher.match(uri) == DOG_ID) {
			String dogID = uri.getPathSegments().get(1);
			cnt = mDogssDB.del(dogID);
		}
		return cnt;
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	/**
	 * A callback method which is invoked when insert operation is requested on
	 * this content provider
	 */
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		long rowID = mDogssDB.insert(values);
		Uri _uri = null;
		if (rowID > 0) {
			_uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
		} else {
			try {
				throw new SQLException("Failed to insert : " + uri);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return _uri;
	}

	/** A callback method which is by the default content uri */
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {

		if (uriMatcher.match(uri) == DOGS) {
			return mDogssDB.getAllContacts();
		} else {
			String dogID = uri.getPathSegments().get(1);
			return mDogssDB.getDogByID(dogID);
		}
	}

	/**
	 * A callback method which is invoked when update operation is requested on
	 * this content provider
	 */
	@Override
	public int update(Uri uri, ContentValues contentValues, String selection,
			String[] selectionArgs) {
		int cnt = 0;
		if (uriMatcher.match(uri) == DOG_ID) {
			String dogID = uri.getPathSegments().get(1);
			cnt = mDogssDB.update(contentValues, dogID);
		}
		return cnt;
	}
}

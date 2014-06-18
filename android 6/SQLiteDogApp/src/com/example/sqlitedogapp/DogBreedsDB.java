package com.example.sqlitedogapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DogBreedsDB extends SQLiteOpenHelper {

	/** Database name */
	private static String DBNAME = "sqlitedogapp";

	/** Version number of the database */
	private static int VERSION = 1;

	/** Field 1 of the table contacts, which is the primary key */
	public static final String KEY_ROW_ID = "_id";

	/** Field 2 of the table contacts, stores the dog breed name */
	public static final String KEY_NAME = "name";

	/**
	 * Field 3 of the table contacts, stores the dog group for the dog breed
	 * entered
	 */
	public static final String KEY_GROUP = "phone";

	/** A constant, stores the the table name */
	private static final String DATABASE_TABLE = "dogtypes";

	/** An instance variable for SQLiteDatabase */
	private final SQLiteDatabase mDB;

	/** Constructor */
	public DogBreedsDB(Context context) {
		super(context, DBNAME, null, VERSION);
		this.mDB = getWritableDatabase();
	}

	/**
	 * This is a callback method, invoked when the method getReadableDatabase()
	 * / getWritableDatabase() is called provided the database does not exists
	 * */
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table dogtypes (_id integer primary key autoincrement , "

				+ " name text not null , phone text not null ) ";

		db.execSQL(sql);
	}

	/** Inserts a new contact to the table contacts */
	public long insert(ContentValues contentValues) {
		long rowID = mDB.insert(DATABASE_TABLE, null, contentValues);
		return rowID;

	}

	/** Updates a contact */
	public int update(ContentValues contentValues, String dogID) {
		int cnt = mDB.update(DATABASE_TABLE, contentValues, "_id=" + dogID,
				null);
		return cnt;
	}

	/** Deletes a contact from the table */
	public int del(String dogID) {
		int cnt = mDB.delete(DATABASE_TABLE, "_id=" + dogID, null);
		return cnt;
	}

	/** Returns all the contacts in the table */
	public Cursor getAllContacts() {
		return mDB.query(DATABASE_TABLE, new String[] { KEY_ROW_ID, KEY_NAME,
				KEY_GROUP }, null, null, null, null, KEY_NAME + " asc ");
	}

	/** Returns a contact by passing its id */
	public Cursor getDogByID(String dogID) {
		return mDB.query(DATABASE_TABLE, new String[] { KEY_ROW_ID, KEY_NAME,
				KEY_GROUP }, "_ID=" + dogID, null, null, null, KEY_NAME
				+ " asc ");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
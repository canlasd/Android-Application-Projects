package com.example.doglistsql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DogListDB extends SQLiteOpenHelper {

	/** Database name */
	private static String DBNAME = "doglistsqlite";

	/** Version number of the database */
	private static int VERSION = 1;

	/** Field 1 of the table cust_master, which is the primary key */
	public static final String KEY_ROW_ID = "_id";

	/** Field 2 of the table cust_master, stores the customer code */
	public static final String KEY_BREED = "cust_breed";

	/** Field 3 of the table cust_master, stores the customer name */
	public static final String KEY_TYPE = "cust_type";

	/**
	 * Field 4 of the table cust_master, stores the phone number of the customer
	 */
	public static final String KEY_RANK = "cust_rank";

	/** A constant, stores the the table name */
	private static final String DATABASE_TABLE = "cust_master";

	/** An instance variable for SQLiteDatabase */
	private final SQLiteDatabase mDB;

	/** Constructor */
	public DogListDB(Context context) {
		super(context, DBNAME, null, VERSION);
		this.mDB = getWritableDatabase();
	}

	/**
	 * This is a callback method, invoked when the method getReadableDatabase()
	 * / getWritableDatabase() is called provided the database does not exists
	 * */
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table " + DATABASE_TABLE + " ( " + KEY_ROW_ID
				+ " integer primary key autoincrement , " + KEY_BREED
				+ " text , " + KEY_TYPE + " text , " + KEY_RANK + " text ) ";

		db.execSQL(sql);

		sql = "insert into " + DATABASE_TABLE + " (" + KEY_BREED + ", "
				+ KEY_TYPE + "," + KEY_RANK + " ) "
				+ " values ('Labrador','Sporting Group','#1' )";
		db.execSQL(sql);

		sql = "insert into " + DATABASE_TABLE + " (" + KEY_BREED + ", "
				+ KEY_TYPE + ", " + KEY_RANK + " ) "
				+ " values ('Poodle','Non-Sporting','#8' )";
		db.execSQL(sql);

		sql = "insert into " + DATABASE_TABLE + " (" + KEY_BREED + ", "
				+ KEY_TYPE + "," + KEY_RANK + " ) "
				+ " values ('Labradoodle','Hybrid','#0' )";
		db.execSQL(sql);
		sql = "insert into " + DATABASE_TABLE + " (" + KEY_BREED + ", "
				+ KEY_TYPE + "," + KEY_RANK + " ) "
				+ " values ('CKC Spaniel','Toy Group','#2' )";
		db.execSQL(sql);

		sql = "insert into " + DATABASE_TABLE + " (" + KEY_BREED + ", "
				+ KEY_TYPE + "," + KEY_RANK + " ) "
				+ " values ('Maltese','Toy Group','#25' )";
		db.execSQL(sql);

		sql = "insert into " + DATABASE_TABLE + " (" + KEY_BREED + ", "
				+ KEY_TYPE + ", " + KEY_RANK + " ) "
				+ " values ('Maltipoo','Hybrid','#0' )";
		db.execSQL(sql);

		sql = "insert into " + DATABASE_TABLE + " (" + KEY_BREED + ", "
				+ KEY_TYPE + "," + KEY_RANK + " ) "
				+ " values ('Bichon Frise','Non-Sporting','#38' )";
		db.execSQL(sql);

		sql = "insert into " + DATABASE_TABLE + " (" + KEY_BREED + ", "
				+ KEY_TYPE + "," + KEY_RANK + " ) "
				+ " values ('Miniature Schnauzer','Terrier Group','#13'  )";
		db.execSQL(sql);
	}

	/** Returns all the customers in the table */
	public Cursor getAllDogs() {
		return mDB.query(DATABASE_TABLE, new String[] { KEY_ROW_ID, KEY_BREED,
				KEY_TYPE, KEY_RANK }, null, null, null, null, KEY_BREED
				+ " asc ");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
	}
}

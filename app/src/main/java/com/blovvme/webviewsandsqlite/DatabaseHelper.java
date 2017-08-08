package com.blovvme.webviewsandsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Blovvme on 8/7/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MyDatabase";

    public static final String TABLE_NAME = "Contacts";
    public static final String CONTACT_NAME = "Name";
    public static final String CONTACT_NUMBER = "Number";
    private static final String TAG = "MyDbTag";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //query
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
                "(" + CONTACT_NAME + " TEXT, " +
                CONTACT_NUMBER + " TEXT PRIMARY KEY" + ")";
        //create the table for user
        sqLiteDatabase.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


    //methods
    public void saveNewContact(String name, String number) {
        //instance of db
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CONTACT_NAME, name);
        contentValues.put(CONTACT_NUMBER, number);
        database.insert(TABLE_NAME, null, contentValues);
        Log.d(TAG, "saveNewContact: ");
    }

    public void getContacts() {

        SQLiteDatabase database = this.getWritableDatabase();
        String query = "Select * from " + TABLE_NAME;
        //String query = "Select * from "+ TABLE_NAME + "where ? = ?";
        //CURSOR
        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Log.d(TAG, "getContact: Name:" + cursor.getString(0)
                        + ", Phone: " + cursor.getString(1 ));

            } while (cursor.moveToNext());
        }
    }


}

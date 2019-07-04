package com.example.crudoperation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    protected static final String DATABASE_NAME = "AddressDatabase";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE address " +
                "( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "street TEXT, " +
                "city TEXT, "+
                "state TEXT, " +
                "postalCode TEXT, " +
                "country TEXT) ";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS address";
        db.execSQL(sql);

        onCreate(db);
    }

}

package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    protected static final String DATABASE_NAME = "BloodCampDatabase";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {



        String sql = "CREATE TABLE user " +
                "( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "mobile TEXT, " +
                "address TEXT, "+
                "bloodgroup TEXT, "+
                "username TEXT, " +
                "password TEXT, "+
                "active INTEGER) ";

        db.execSQL(sql);

        sql = "CREATE TABLE donor " +
                "( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "userid TEXT, " +
                "password TEXT, "+
                "active INTEGER) ";

        db.execSQL(sql);

    }

    public boolean validateLogin(String un, String pwd)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        boolean chklogin=false;
        Cursor c = db.rawQuery("SELECT username, password FROM user  WHERE username = ? AND password =?", new String[]{un,pwd});

        if(c==null)
        {
            //set boolean var to false
            chklogin=false;
            //message no such records
        }

        else
        {
            //set boolean var to true
            chklogin=true;
            c.moveToFirst();
        }

        return chklogin; //boolean var
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS address";
        db.execSQL(sql);

        onCreate(db);
    }

}

package com.example.sqldemo;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "contactsManager";
    private static final int DATABASE_VERSION = 1;


    private static final String TABLE_CONTACTS = "contacts";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";



    String CREATE_CONTACTS_TABLE =
            "CREATE TABLE " + TABLE_CONTACTS
                    + "("
                    + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                    + KEY_PH_NO + " TEXT"
                    + ")";


    String DROP_CONTACTS_TABLE="DROP TABLE IF EXISTS " + TABLE_CONTACTS;


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_CONTACTS_TABLE);
        onCreate(db);

    }



    public void addContact(String param1, String param2){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values  =new ContentValues();
        values.put(KEY_NAME,param1);
        values.put(KEY_PH_NO,param2);

        db.insert(TABLE_CONTACTS,null,values);
        db.close();

    }


    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<Contact>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhone_number(cursor.getString(2));
                //Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }


    public Contact getLastContact(){
        Contact contact = new Contact();
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToLast()) {
            contact.setId(Integer.parseInt(cursor.getString(0)));
            contact.setName(cursor.getString(1));
            contact.setPhone_number(cursor.getString(2));
        }
        return contact;
    }



    public void deleteTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(DROP_CONTACTS_TABLE);
        db.execSQL(CREATE_CONTACTS_TABLE);
        //onCreate(db);

    }



    public void deleteRow(String value1)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_CONTACTS+ " WHERE "+KEY_NAME+"='"+value1+"'");
        db.close();
    }

    public void deleteRow(String value1, String value2)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_CONTACTS+ " WHERE "+KEY_NAME+"='"+value1+"'"+ " and " +KEY_PH_NO+"='"+value2+"'");
        db.close();
    }

    public void deleteLastRow()
    {
        Contact contact = new Contact();
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToLast()) {
            contact.setId(Integer.parseInt(cursor.getString(0)));
            //contact.setName(cursor.getString(1));
            //contact.setPhone_number(cursor.getString(2));
        }
        db.execSQL("DELETE FROM " + TABLE_CONTACTS+ " WHERE "+KEY_ID+"='"+contact.getId()+"'");
        db.close();
    }

    //https://stackoverflow.com/questions/7510219/deleting-row-in-sqlite-in-android


}
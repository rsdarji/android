package com.example.crudoperation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TableControllerStudent extends DatabaseHandler {

    public TableControllerStudent(Context context) {
        super(context);
    }

    public int count() {

        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "SELECT * FROM address";
        int recordCount = db.rawQuery(sql, null).getCount();
        db.close();

        return recordCount;

    }

    public boolean create(ObjectAddress objectAddress) {

        ContentValues values = new ContentValues();

        values.put("street", objectAddress.street);
        values.put("city", objectAddress.city);
        values.put("state", objectAddress.state);
        values.put("postalCode", objectAddress.postalCode);
        values.put("country", objectAddress.country);


        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("address", null, values) > 0;
        db.close();

        return createSuccessful;
    }

    public boolean delete(String id) {

        ContentValues values = new ContentValues();

        SQLiteDatabase db = this.getWritableDatabase();
        int deleteSuccessful = db.delete("address","id=?", new String[]{Integer.toString(Integer.parseInt(id))});
        Log.d("delete successfull",String.valueOf(deleteSuccessful));
        /*values.put("street", objectAddress.street);
        values.put("city", objectAddress.city);
        values.put("state", objectAddress.state);
        values.put("postalCode", objectAddress.postalCode);
        values.put("country", objectAddress.country);*/




        //boolean createSuccessful = db.insert("address", null, values) > 0;
        db.close();

        return deleteSuccessful>0;
    }

    public List<ObjectAddress> read() {

        List<ObjectAddress> recordsList = new ArrayList<>();

        String sql = "SELECT * FROM address ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                String street = cursor.getString(cursor.getColumnIndex("street"));
                String city = cursor.getString(cursor.getColumnIndex("city"));
                String state = cursor.getString(cursor.getColumnIndex("state"));
                String postalCode = cursor.getString(cursor.getColumnIndex("postalCode"));
                String country = cursor.getString(cursor.getColumnIndex("country"));

                ObjectAddress objectAddress = new ObjectAddress();
                objectAddress.id = id;
                objectAddress.street = street;
                objectAddress.city = city;
                objectAddress.state = state;
                objectAddress.postalCode = postalCode;
                objectAddress.country = country;

                recordsList.add(objectAddress);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return recordsList;
    }

}
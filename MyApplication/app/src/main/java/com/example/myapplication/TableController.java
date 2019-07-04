package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TableController extends DatabaseHandler {


    public TableController(Context context) {
        super(context);
    }

    public int usercount() {

        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "SELECT * FROM user";
        int recordCount = db.rawQuery(sql, null).getCount();
        db.close();

        return recordCount;

    }

    public boolean createUser(RegisterPOJO registerObject) {

        ContentValues values = new ContentValues();

        values.put("name", registerObject.getName());
        values.put("mobile", registerObject.getMobile());
        values.put("address", registerObject.getAddress());
        values.put("bloodgroup", registerObject.getBloodGroup());
        values.put("username", registerObject.getUserName());
        values.put("password", registerObject.getPassword());
        values.put("active", 1);


        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("user", null, values) > 0;
        db.close();

        return createSuccessful;
    }

    public boolean deleteUser(String id) {

        ContentValues values = new ContentValues();

        SQLiteDatabase db = this.getWritableDatabase();
        int deleteSuccessful = db.delete("user","id=?", new String[]{Integer.toString(Integer.parseInt(id))});
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



    public List<RegisterPOJO> read() {

        List<RegisterPOJO> recordsList = new ArrayList<>();

        String sql = "SELECT * FROM user ORDER BY id DESC";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String mobile = cursor.getString(cursor.getColumnIndex("mobile"));
                String address = cursor.getString(cursor.getColumnIndex("address"));
                String bloodgroup = cursor.getString(cursor.getColumnIndex("bloodgroup"));
                String username = cursor.getString(cursor.getColumnIndex("username"));
                String password = cursor.getString(cursor.getColumnIndex("password"));
                int active = Integer.parseInt(cursor.getString(cursor.getColumnIndex("active")));

                RegisterPOJO registerPOJOObject = new RegisterPOJO();
                registerPOJOObject.setId(id);
                registerPOJOObject.setName(name);
                registerPOJOObject.setMobile(mobile);
                registerPOJOObject.setAddress(address);
                registerPOJOObject.setBloodGroup(bloodgroup);
                registerPOJOObject.setUserName(username);
                registerPOJOObject.setPassword(password);
                registerPOJOObject.setActive(active);


                recordsList.add(registerPOJOObject);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return recordsList;
    }

}
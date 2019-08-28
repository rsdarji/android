package com.example.sqlitedemo1;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView txt1;
    DatabaseHandler mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1=findViewById(R.id.text1);
        txt1.setText("");
        txt1.setMovementMethod(new ScrollingMovementMethod());

        mydb = new DatabaseHandler(this);
        mydb.getReadableDatabase();
        displayingALL();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.adding) {

            addingOneContact();
            //displayingLastContact();
            update();

            return true;
        }

        if (id == R.id.addingmany) {
            addingManyContact();
            update();
            return true;
        }

        if (id == R.id.deletingall) {
            mydb.deleteTable();
            update();
            return true;
        }

        if (id == R.id.deletingoneparam) {
            mydb.deleteRow("arash");
            update();
            return true;
        }

        if (id == R.id.deletingtwoparams) {
            mydb.deleteRow("arash");
            update();
            return true;
        }

        if (id == R.id.deletinglastrow) {
            mydb.deleteLastRow();
            update();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }



    private void addingOneContact() {
        mydb.addContact("Pooja","12345554565");

    }


    private void addingManyContact() {
        mydb.addContact("arash","12345554565");
        mydb.addContact("arash","12345554565");
        mydb.addContact("arash","12345554565");
        mydb.addContact("arash","12345554565");
        mydb.addContact("arash","12345554565");
        mydb.addContact("arash","12345554565");
        mydb.addContact("arash","12345554565");
        mydb.addContact("arash","12345554565");
        mydb.addContact("arash","12345554565");
        mydb.addContact("arash","12345554565");
        mydb.addContact("arash","12345554565");
        mydb.addContact("arash","12345554565");
        mydb.addContact("arash","12345554565");
        mydb.addContact("arash","12345554565");
        mydb.addContact("arash","12345554565");
        mydb.addContact("arash","12345554565");
        mydb.addContact("arash","12345554565");
        mydb.addContact("arash","12345554565");
        mydb.addContact("arash","12345554565");
        mydb.addContact("arash","123");
        mydb.addContact("arash","123");
    }

    private void displayingALL() {

        // Reading all contacts
        List<Contact> contacts = mydb.getAllContacts();
        if (contacts.size()==0) txt1.setText("No records in the Database");

        for (Contact cn : contacts) {
            String log = "Id: "+cn.getId()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhone_number();
            txt1.append(log+ "\n");
        }

    }


    public void displayingLastContact(){
        Contact cn=mydb.getLastContact();
        String log = "Id: "+cn.getId()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhone_number();
        txt1.append(log+ "\n");
    }

    public void update(){
        txt1.setText("");
        displayingALL();

    }






}

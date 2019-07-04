package com.example.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Login extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    public void goToRegister(View view) {
        button = (Button)findViewById(R.id.register_button);
        EditText usernameET = findViewById(R.id.username);
        EditText passwordET = findViewById(R.id.password);
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Login.this, Home.class);
                startActivity(intent);
            }
        });
    }

    public void doLogin(View view) {
        button = (Button)findViewById(R.id.login_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usernameET = findViewById(R.id.username);
                EditText passwordET = findViewById(R.id.password);
                String username = usernameET.getText().toString();
                String password = passwordET.getText().toString();

                DatabaseHandler databaseHandler = new DatabaseHandler(getApplicationContext());
                Intent intent = new Intent(Login.this, Register.class);
                if(databaseHandler.validateLogin(username,password)){
                    intent = new Intent(Login.this, Home.class);
                }

                startActivity(intent);
            }
        });
    }

    public void deleteUser(View view) {
        button = (Button)findViewById(R.id.delete_user_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context = v.getRootView().getContext();
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View formElementsView = inflater.inflate(R.layout.delete_form, null, false);
                final EditText idET = (EditText) findViewById(R.id.id);


                new AlertDialog.Builder(context)
                        .setView(formElementsView)
                        .setPositiveButton("Delete",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        String idvalue = idET.getText().toString();




                                        boolean deleteSuccessful = new TableController(context).deleteUser(idvalue);
                                        Log.d("deleteSuccessful : ",String.valueOf(deleteSuccessful));
                                        if(deleteSuccessful){
                                            Toast.makeText(context, "Address information was deleted.", Toast.LENGTH_SHORT).show();
                                        }else{
                                            Toast.makeText(context, "Unable to delete address information.", Toast.LENGTH_SHORT).show();
                                        }
                                        readRecords();
                                        dialog.cancel();
                                    }

                                }).show();


            }
        });
    }



    public void readRecords() {

        LinearLayout linearLayoutRecords = (LinearLayout) findViewById(R.id.linearLayoutRecords);
        linearLayoutRecords.removeAllViews();

        List<RegisterPOJO> users = new TableController(this).read();

        if (users.size() > 0) {

            for (RegisterPOJO obj : users) {

                int id = obj.id;
                String name = obj.name;
                String mobile = obj.mobile;
                String address = obj.address;
                String bloodGroup = obj.bloodGroup;
                String username = obj.userName;
                String password = obj.password;
                int active = obj.active;


                String textViewContents = "id: "+id + " \n" +name + " \n" + mobile+" \n"+address + " \n"+bloodGroup + " \n"+username+" \n"+password+" \n="+active+"\n======================" ;

                TextView textViewUserItem= new TextView(this);
                textViewUserItem.setPadding(0, 10, 0, 10);
                textViewUserItem.setText(textViewContents);
                textViewUserItem.setTag(Integer.toString(id));

                linearLayoutRecords.addView(textViewUserItem);
            }

        }

        else {

            TextView locationItem = new TextView(this);
            locationItem.setPadding(8, 8, 8, 8);
            locationItem.setText("No records yet.");

            linearLayoutRecords.addView(locationItem);
        }

    }
}

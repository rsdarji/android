package com.example.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context = v.getRootView().getContext();
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View formElementsView = inflater.inflate(R.layout.activity_register, null, false);
                final EditText nameET = (EditText) findViewById(R.id.name);
                final EditText mobileET = (EditText) findViewById(R.id.mobile);
                final EditText addressET = (EditText) findViewById(R.id.address);
                final EditText bloodGroupET = (EditText) findViewById(R.id.bloodgroup);
                final EditText usernameET = (EditText) findViewById(R.id.username);
                final EditText passwordET = (EditText) findViewById(R.id.password);


                String name = nameET.getText().toString();
                String mobile = mobileET.getText().toString();
                String address = addressET.getText().toString();
                String bloodGroup = bloodGroupET.getText().toString();
                String userName = usernameET.getText().toString();
                String password = passwordET.getText().toString();
                RegisterPOJO registerPOJOObject = new RegisterPOJO();
                registerPOJOObject.setName(name);
                registerPOJOObject.setMobile(mobile);
                registerPOJOObject.setAddress(address);
                registerPOJOObject.setBloodGroup(bloodGroup);
                registerPOJOObject.setUserName(userName);
                registerPOJOObject.setPassword(password);

                boolean createSuccessful = new TableController(context).createUser(registerPOJOObject);
                if(createSuccessful){
                    Toast.makeText(context, "User information was saved.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Unable to save User information.", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}

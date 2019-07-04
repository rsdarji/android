package com.example.crudoperation;

import android.content.Context;
import android.content.DialogInterface;
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

public class MainActivity extends AppCompatActivity {


    public void countRecords() {
        int recordCount = new TableControllerStudent(this).count();
        TextView textViewRecordCount = (TextView) findViewById(R.id.textViewRecordCount);
        textViewRecordCount.setText(recordCount + " records found.");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countRecords();
        readRecords();
        Button buttonCreateStudent = (Button) findViewById(R.id.addAddress);
        buttonCreateStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context = v.getRootView().getContext();
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View formElementsView = inflater.inflate(R.layout.address_form, null, false);
                final EditText streetET = (EditText) formElementsView.findViewById(R.id.street);
                final EditText cityET = (EditText) formElementsView.findViewById(R.id.city);
                final EditText stateET = (EditText) formElementsView.findViewById(R.id.state);
                final EditText postalcodeET = (EditText) formElementsView.findViewById(R.id.postalcode);
                final EditText countryET = (EditText) formElementsView.findViewById(R.id.country);

                new AlertDialog.Builder(context)
                        .setView(formElementsView)
                        .setPositiveButton("Add",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        String street = streetET.getText().toString();
                                        String city = cityET.getText().toString();
                                        String state = stateET.getText().toString();
                                        String postalCode = postalcodeET.getText().toString();
                                        String country = countryET.getText().toString();
                                        ObjectAddress objectAddress = new ObjectAddress();
                                        objectAddress.street= street;
                                        objectAddress.city= city;
                                        objectAddress.state= state;
                                        objectAddress.postalCode= postalCode;
                                        objectAddress.country= country;


                                        boolean createSuccessful = new TableControllerStudent(context).create(objectAddress);
                                        if(createSuccessful){
                                            Toast.makeText(context, "Address information was saved.", Toast.LENGTH_SHORT).show();
                                        }else{
                                            Toast.makeText(context, "Unable to save address information.", Toast.LENGTH_SHORT).show();
                                        }
                                        readRecords();
                                        dialog.cancel();
                                    }

                                }).show();


            }
        });

        Button buttonDeleteStudent = (Button) findViewById(R.id.deleteAddress);
        buttonDeleteStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context = v.getRootView().getContext();
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View formElementsView = inflater.inflate(R.layout.delete_form, null, false);
                final EditText idET = (EditText) formElementsView.findViewById(R.id.id);


                new AlertDialog.Builder(context)
                        .setView(formElementsView)
                        .setPositiveButton("Delete",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        String idvalue = idET.getText().toString();




                                        boolean deleteSuccessful = new TableControllerStudent(context).delete(idvalue);
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

        List<ObjectAddress> students = new TableControllerStudent(this).read();

        if (students.size() > 0) {

            for (ObjectAddress obj : students) {

                int id = obj.id;
                String street = obj.street;
                String city = obj.city;
                String state = obj.state;
                String postalCode = obj.postalCode;
                String country = obj.country;


                String textViewContents = "id: "+id + " \n" +street + " \n" + city+" \n"+state + " \n"+postalCode + " \n"+country+"\n=======================" ;

                TextView textViewStudentItem= new TextView(this);
                textViewStudentItem.setPadding(0, 10, 0, 10);
                textViewStudentItem.setText(textViewContents);
                textViewStudentItem.setTag(Integer.toString(id));

                linearLayoutRecords.addView(textViewStudentItem);
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

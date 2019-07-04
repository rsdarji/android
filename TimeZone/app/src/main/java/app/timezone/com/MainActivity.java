package app.timezone.com;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONObject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nextPage(View myView){


        EditText in1=(EditText) findViewById(R.id.editText1);
        EditText in2=(EditText) findViewById(R.id.editText2);

        Intent myIntent=new Intent(this,TimezoneDetails.class);
        myIntent.putExtra("LON",Double.parseDouble(in1.getText().toString()));
        myIntent.putExtra("LAT",Double.parseDouble(in2.getText().toString()));

        startActivity(myIntent);
    }


}


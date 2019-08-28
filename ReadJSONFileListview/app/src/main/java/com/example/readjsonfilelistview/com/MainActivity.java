package com.example.readjsonfilelistview.com;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog dialog;
    private ListView lv;
    private static String url = "https://api.myjson.com/bins/l4gag";

    ArrayList<HashMap<String,String>> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactList = new ArrayList<>();
        lv =
    }
}

package com.example.jsoncontactlist;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog dialog;
    private ListView lv;
    private static String url = "https://api.myjson.com/bins/1dfuo4";

    ArrayList<HashMap<String,String>> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.list_view);
        new GetContacts().execute();

    }

    private class GetContacts extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("Please wait...");
            dialog.setCancelable(true);
            dialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            HttpConnector connector = new HttpConnector();
            try {
                String res = connector.method(url);
                Log.d("Response",res);
                if(res!=null){
                    try{
                        JSONObject jsonObject = new JSONObject(res);
                        JSONArray jsonArray = jsonObject.getJSONArray("contacts");
                        for(int i = 0;i<jsonArray.length();i++){
                            JSONObject o = jsonArray.getJSONObject(i);
                            String id = o.getString("id");
                            String name = o.getString("name");
                            String address = o.getString("address");
                            String gender = o.getString("gender");
                            JSONObject phone = o.getJSONObject("phone");
                            String mobile = phone.getString("mobile");
                            String home = phone.getString("home");
                            String office = phone.getString("office");

                            HashMap<String, String> contact = new HashMap<>();

                            contact.put("id",id);
                            contact.put("name",name);
                            contact.put("address",address);
                            contact.put("gender",gender);
                            contact.put("mobile",mobile);
                            contact.put("home",home);
                            contact.put("office",office);

                            contactList.add(contact);


                        }
                    } catch(JSONException e){
                        e.printStackTrace();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"response is null",Toast.LENGTH_LONG);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (dialog.isShowing()){
                dialog.dismiss();
            }
            ListAdapter la = new SimpleAdapter(MainActivity.this,contactList,R.layout.list_item,
                    new String[]{"id","name","address","gender","mobile"},new int[]{R.id.id,R.id.name,R.id.address,R.id.gender,R.id.mobile});
            lv.setAdapter(la);

        }
    }
}

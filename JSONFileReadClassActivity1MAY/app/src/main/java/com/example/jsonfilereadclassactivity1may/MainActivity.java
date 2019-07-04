package com.example.jsonfilereadclassactivity1may;

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
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog dialog;
    private ListView lv;
    private static String url = "https://api.myjson.com/bins/10fg3c";

    ArrayList<HashMap<String,String>> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.list_view);
        new GetContacts().execute();

    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {

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
                        JSONArray jsonArray = new JSONArray(res);
                        for(int i=0; i<jsonArray.length();i++){
                            HashMap<String, String> contact = new HashMap<>();
                            JSONObject o = jsonArray.getJSONObject(i);
                            String id = o.getString("id");
                            String name = o.getString("name");
                            String type  = o.getString("type");
                            JSONObject battersObject = o.getJSONObject("batters");
                            JSONArray battersArray = battersObject.getJSONArray("batter");
                            for(int j =0 ; j<2;j++){
                                JSONObject batterArrayObject = battersArray.getJSONObject(j);
                                String batterId = batterArrayObject.getString("id1");
                                String batterType = batterArrayObject.getString("type1");
                                contact.put("batterId"+j,batterId);
                                contact.put("batterType"+j,batterType);
                            }
                            JSONArray toppingArray = o.getJSONArray("topping");
                            for(int k =0 ; k<2;k++){
                                JSONObject toppingArrayObject = toppingArray.getJSONObject(k);
                                String toppingId = toppingArrayObject.getString("id2");
                                String toppingType = toppingArrayObject.getString("type2");
                                contact.put("toppingId"+k,toppingId);
                                contact.put("toppingType"+k,toppingType);
                            }


                            contact.put("id",id);
                            contact.put("name",name);
                            contact.put("type",type);

                            contactList.add(contact);

                        }
                        Log.d("contactList",contactList.toString());

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
                    new String[]{"id","name","type",
                            "batterId0","batterType0",
                            "batterId1","batterType1",
                            "toppingId0","toppingType0",
                            "toppingId1","toppingType1"},
                    new int[]{R.id.id,R.id.name,R.id.type,
                            R.id.batter_id_tv1,R.id.batter_type_tv1,
                            R.id.batter_id_tv2,R.id.batter_type_tv2,
                            R.id.topping_id_tv1,R.id.topping_type_tv1,
                            R.id.topping_id_tv2,R.id.topping_type_tv2});
            lv.setAdapter(la);

        }
    }
}

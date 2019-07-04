package app.timezone.com;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TimezoneDetails extends AppCompatActivity {

    TextView out1, out2,out3,out4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timezone_details);


        out1 =(TextView) findViewById(R.id.textView1);
        out2 =(TextView) findViewById(R.id.textView2);
        out3 =(TextView) findViewById(R.id.textView3);
        out4 =(TextView) findViewById(R.id.textView4);


        new MyTask().execute();
    }

    private class MyTask extends AsyncTask<Void, Void, Void> {
        String o1,o2,o3,o4;
        @Override
        protected Void doInBackground(Void... params){


            URL url = null;

            Intent myNewIntent=getIntent();

            Double InfoReceivedLog=myNewIntent.getDoubleExtra("LON",99);

            Double InfoReceivedLat=myNewIntent.getDoubleExtra("LAT", 99);


            try {

                url = new URL("https://maps.googleapis.com/maps/api/timezone/json?location="+InfoReceivedLog+","+InfoReceivedLat+"&timestamp=1331161200&key=AIzaSyARiki0HBLlyR7xH0K3e4eifaSLzx8b-7E");

                HttpURLConnection client = null;

                client = (HttpURLConnection) url.openConnection();

                client.setRequestMethod("GET");

                int responseCode = client.getResponseCode();

                System.out.println("\n Sending 'GET' request to URL : " + url);

                System.out.println("Response Code : " + responseCode);

                InputStreamReader myInput= new InputStreamReader(client.getInputStream());

                BufferedReader in = new BufferedReader(myInput);
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                //print result
                System.out.println(response.toString());

                JSONObject obj =new JSONObject(response.toString());

                o1=""+obj.getInt("dstOffset");

                o2=""+obj.getInt("rawOffset");

                o3=obj.getString("timeZoneId");

                o4=obj.getString("timeZoneName");



            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }

            catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;

        }

        @Override
        protected void onPostExecute(Void result){

            out1.setText(o1);

            out2.setText(o2);

            out3.setText(o3);

            out4.setText(o4);

            super.onPostExecute(result);
        }

    }
}

package app.activity.com.activityapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private  static final String TAG = "Main activity";
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Oncreate...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Onstart...");
    }

    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Resume...");
    }

    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Pause...");
    }

    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Stop...");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Destroy...");
    }

    public void goToActivityTwo(View view) {
        button = findViewById(R.id.click_me);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
                startActivity(intent);
            }
        });
    }
}

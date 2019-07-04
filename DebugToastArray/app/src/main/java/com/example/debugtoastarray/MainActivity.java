package com.example.debugtoastarray;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    String array[] = {"Red","Green","Yellow"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickme(View view) {

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "Colors are ";
                for(int i =0 ; i<array.length;i++) {
                    str = str.concat(array[i]);
                    if(i!=array.length-1) {
                        str = str.concat(", ");
                    }
                }

                Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();

            }
        });
    }
}


package com.example.photogallary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.util.Iterator;


public class MainActivity extends AppCompatActivity {

    //Image img = (Image)findViewById(R.id.img1);
    ImageView imgclk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgclk = (ImageView)findViewById(R.id.img1);
        imgclk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,display_img.class);
                intent.putExtra("img","img1");
                startActivity(intent);

            }
        });
        imgclk = (ImageView)findViewById(R.id.img2);
        imgclk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,display_img.class);
                intent.putExtra("img","img2");
                startActivity(intent);

            }
        });

        imgclk = (ImageView)findViewById(R.id.img3);
        imgclk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,display_img.class);
                intent.putExtra("img","img3");
                startActivity(intent);

            }
        });

        imgclk = (ImageView)findViewById(R.id.img4);
        imgclk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,display_img.class);
                intent.putExtra("img","img4");
                startActivity(intent);

            }
        });

        imgclk = (ImageView)findViewById(R.id.img5);
        imgclk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,display_img.class);
                intent.putExtra("img","img5");
                startActivity(intent);

            }
        });

        imgclk = (ImageView)findViewById(R.id.img6);
        imgclk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,display_img.class);
                intent.putExtra("img","img6");
                startActivity(intent);

            }
        });

        imgclk = (ImageView)findViewById(R.id.img7);
        imgclk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,display_img.class);
                intent.putExtra("img","img7");
                startActivity(intent);

            }
        });

        imgclk = (ImageView)findViewById(R.id.img8);
        imgclk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,display_img.class);
                intent.putExtra("img","img8");
                startActivity(intent);

            }
        });
    }



   
}
package com.example.photogallary;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class display_img extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_img);
        Intent intent = getIntent();
        String img = intent.getStringExtra("img");
        ImageView image;
        if(img.equalsIgnoreCase("img1")){
            image  = (ImageView) findViewById(R.id.img1);
            Resources res = getResources(); /** from an Activity */
            image.setImageDrawable(res.getDrawable(R.drawable.birthday_poster));
        } else if(img.equalsIgnoreCase("img2")){
            image  = (ImageView) findViewById(R.id.img1);
            Resources res = getResources(); /** from an Activity */
            image.setImageDrawable(res.getDrawable(R.drawable.blood_donation_poster));
        } else if(img.equalsIgnoreCase("img3")){
            image  = (ImageView) findViewById(R.id.img1);
            Resources res = getResources(); /** from an Activity */
            image.setImageDrawable(res.getDrawable(R.drawable.poster_poster_design_compition));
        } else if(img.equalsIgnoreCase("img4")){
            image  = (ImageView) findViewById(R.id.img1);
            Resources res = getResources(); /** from an Activity */
            image.setImageDrawable(res.getDrawable(R.drawable.poster_summer_food_festival));
        } else if(img.equalsIgnoreCase("img5")){
            image  = (ImageView) findViewById(R.id.img1);
            Resources res = getResources(); /** from an Activity */
            image.setImageDrawable(res.getDrawable(R.drawable.poster_summer_nights));
        } else if(img.equalsIgnoreCase("img6")){
            image  = (ImageView) findViewById(R.id.img1);
            Resources res = getResources(); /** from an Activity */
            image.setImageDrawable(res.getDrawable(R.drawable.logo));
        } else if(img.equalsIgnoreCase("img7")){
            image  = (ImageView) findViewById(R.id.img1);
            Resources res = getResources(); /** from an Activity */
            image.setImageDrawable(res.getDrawable(R.drawable.blood_donation_logo));
        }else {
            image  = (ImageView) findViewById(R.id.img1);
            Resources res = getResources(); /** from an Activity */
            image.setImageDrawable(res.getDrawable(R.drawable.download));
        }

    }

    public void back(View view) {
        button = (Button)findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent back = new Intent(display_img.this,MainActivity.class);
                startActivity(back);
            }
        });
    }
}

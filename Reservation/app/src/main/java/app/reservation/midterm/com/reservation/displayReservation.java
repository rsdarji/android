package app.reservation.midterm.com.reservation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class displayReservation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_reservation);
        Intent intent = getIntent();
        String fullname = intent.getStringExtra("fullname");
        String phonenumber = intent.getStringExtra("phonenumber");
        String email = intent.getStringExtra("email");
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");
        String wedding = intent.getStringExtra("wedding");
        String content = intent.getStringExtra("content");

        TextView displayReservation = findViewById(R.id.display_reservation);
        displayReservation.setText("Thanks "+fullname+" for reserving our service for your wedding ceremony on "+date+" "+time
                +". Your phone number is "+phonenumber+" and your contact email is "+email);
    }
}

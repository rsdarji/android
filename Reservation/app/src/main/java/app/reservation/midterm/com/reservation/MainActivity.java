package app.reservation.midterm.com.reservation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void reservation(View view) {
        button = findViewById(R.id.submit);
        EditText fullname = findViewById(R.id.fullname);
        EditText phonenumber = findViewById(R.id.phonenumber);
        EditText email = findViewById(R.id.email);
        EditText date = findViewById(R.id.date);
        EditText time = findViewById(R.id.time);
        EditText wedding = findViewById(R.id.wedding);
        EditText content = findViewById(R.id.content);

        Intent displayReservation = new Intent(MainActivity.this,displayReservation.class);
        displayReservation.putExtra("fullname",fullname.getText().toString());
        displayReservation.putExtra("phonenumber",phonenumber.getText().toString());
        displayReservation.putExtra("email",email.getText().toString());
        displayReservation.putExtra("date",date.getText().toString());
        displayReservation.putExtra("time",time.getText().toString());
        displayReservation.putExtra("wedding",wedding.getText().toString());
        displayReservation.putExtra("content",content.getText().toString());

        startActivity(displayReservation);
    }
}

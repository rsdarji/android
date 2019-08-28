package app.finalexam.com.hotels;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void guestPlusCount(View view) {
        button = (Button) findViewById(R.id.guest_plus_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView count = findViewById(R.id.guest_count);
                int guestCount = Integer.parseInt(count.getText().toString());
                guestCount++;

                count.setText(String.valueOf(guestCount));
//                TextView price = findViewById(R.id.price);
//                price.setText(String.valueOf(coffeeCount*5));
            }
        });
    }

    public void guestMinusCount(View view) {
        button = (Button) findViewById(R.id.guest_minus_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView count = findViewById(R.id.guest_count);
                int guestCount = Integer.parseInt(count.getText().toString());
                if (guestCount > 0)
                    guestCount--;

                count.setText(String.valueOf(guestCount));
            }
        });
    }

    public void roomMinusCount(View view) {
        button = (Button) findViewById(R.id.room_minus_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView count = findViewById(R.id.room_count);
                int roomCount = Integer.parseInt(count.getText().toString());
                if (roomCount > 0)
                    roomCount--;

                count.setText(String.valueOf(roomCount));
            }
        });
    }
    public void roomPlusCount(View view) {
        button = (Button) findViewById(R.id.room_plus_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView count = findViewById(R.id.room_count);
                int roomCount = Integer.parseInt(count.getText().toString());
                roomCount++;

                count.setText(String.valueOf(roomCount));
            }
        });
    }

    public void book(View view) {
        button = (Button) findViewById(R.id.book_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView room_count = findViewById(R.id.room_count);
                TextView guest_count = findViewById(R.id.guest_count);
                Toast.makeText(MainActivity.this,
                        "Booked guest: "+guest_count.getText()+" and number of rooms are: "+room_count.getText(), Toast.LENGTH_LONG).show();

            }
        });
    }
}

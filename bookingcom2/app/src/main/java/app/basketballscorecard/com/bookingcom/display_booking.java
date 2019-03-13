package app.basketballscorecard.com.bookingcom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class display_booking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_display_booking);
        Intent intent = getIntent();
        String userSearch = intent.getStringExtra("userSearch");
        String fromDate = intent.getStringExtra("fromDate");
        String toDate = intent.getStringExtra("toDate");
        String room = intent.getStringExtra("room");
        String adult = intent.getStringExtra("adult");
        String children = intent.getStringExtra("children");
        String travellingFor = intent.getStringExtra("travellingFor");

        TextView textView = findViewById(R.id.textView);
        textView.setText("Thanks Sir for booking our service. The check-in date "+fromDate+
                " for "+travellingFor+" trip with "+room+" rooms and "+adult+
                " adults and "+children+" childrens are being processed.");

    }
}

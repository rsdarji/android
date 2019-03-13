package app.basketballscorecard.com.bookingcom;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    Button button;
    private RadioGroup travellingFor;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    public void search(View view) {
        travellingFor = (RadioGroup) findViewById(R.id.radiogroup);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userSearch = findViewById(R.id.editText);
                EditText fromDate = findViewById(R.id.editText2);
                EditText toDate = findViewById(R.id.editText3);
                EditText room = findViewById(R.id.editText4);
                EditText adult = findViewById(R.id.editText5);
                EditText children = findViewById(R.id.editText6);
                int selectedId = travellingFor.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);

                Intent displayOrder = new Intent(MainActivity.this,display_booking.class);
                displayOrder.putExtra("userSearch",userSearch.getText().toString());
                displayOrder.putExtra("fromDate",fromDate.getText().toString());
                displayOrder.putExtra("toDate",toDate.getText().toString());
                displayOrder.putExtra("room",room.getText().toString());
                displayOrder.putExtra("adult",adult.getText().toString());
                displayOrder.putExtra("children",children.getText().toString());
                displayOrder.putExtra("travellingFor",radioButton.getText().toString());

                startActivity(displayOrder);






            }
        });
    }
}

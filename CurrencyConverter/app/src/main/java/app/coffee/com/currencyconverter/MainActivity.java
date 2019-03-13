package app.coffee.com.currencyconverter;

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

    public void INRToCAD(View view) {
        button = (Button)findViewById(R.id.INRtoCAD);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inr = findViewById(R.id.INR);
                EditText cad = findViewById(R.id.CAD);

                Double cadValue = Double.parseDouble(inr.getText().toString())/53.13;
                cad.getText().clear();
                cad.setText(cadValue.toString());
            }
        });
    }

    public void CADtoINR(View view) {
        button = (Button)findViewById(R.id.CADtoINR);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inr = findViewById(R.id.INR);
                EditText cad = findViewById(R.id.CAD);

                Double inrValue = Double.parseDouble(cad.getText().toString())*53.13;
                inr.getText().clear();
                inr.setText(String.valueOf(inrValue));
            }
        });
    }

    public void reset(View view) {
        button = findViewById(R.id.reset);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inr = findViewById(R.id.INR);
                EditText cad = findViewById(R.id.CAD);
                inr.getText().clear();
                cad.getText().clear();

            }
        });
    }
}

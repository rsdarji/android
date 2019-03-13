package app.coffee.midterm.com.coffeeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void plusCount(View view) {
        button = (Button) findViewById(R.id.buttonplus);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView count = findViewById(R.id.count);
                int coffeeCount = Integer.parseInt(count.getText().toString());
                coffeeCount++;

                count.setText(String.valueOf(coffeeCount));
//                TextView price = findViewById(R.id.price);
//                price.setText(String.valueOf(coffeeCount*5));
            }
        });
    }

    public void minusCount(View view) {
        button = (Button) findViewById(R.id.buttonminus);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView count = findViewById(R.id.count);
                int coffeeCount = Integer.parseInt(count.getText().toString());
                if (coffeeCount > 0)
                    coffeeCount--;

                count.setText(String.valueOf(coffeeCount));
            }
        });
    }

    public void reset(View view) {
        button = findViewById(R.id.reset);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView count = findViewById(R.id.count);
                CheckBox whippedCream = (CheckBox) findViewById(R.id.checkBox);
                CheckBox chocolate = (CheckBox) findViewById(R.id.checkBox2);

                whippedCream.setChecked(false);
                chocolate.setChecked(false);
                count.setText("0");

            }
        });
    }

    public void order(View view) {
        TextView count = findViewById(R.id.count);
        int coffeeCount = Integer.parseInt(count.getText().toString());
        String toppings = "";
        CheckBox whippedCream = (CheckBox) findViewById(R.id.checkBox);
        CheckBox chocolate = (CheckBox) findViewById(R.id.checkBox2);

        if (whippedCream.isChecked()) {
            toppings = toppings.concat("Whipped cream");
        }

        if (chocolate.isChecked()) {
            if(!toppings.isEmpty()){
                toppings.concat(", ");
            }
            toppings = toppings.concat(" Chocolate");
        }

        int coffeePrice = coffeeCount*5;
        double tax_value = (Double.parseDouble(String.valueOf(coffeePrice))*15)/100;
        double orderPrice = coffeePrice+tax_value;
        Toast.makeText(MainActivity.this,
                "You ordered "+String.valueOf(coffeeCount)+" coffees with "+toppings
                        +" and total cost is "+String.valueOf(orderPrice)+" Dollars", Toast.LENGTH_LONG).show();
    }
}

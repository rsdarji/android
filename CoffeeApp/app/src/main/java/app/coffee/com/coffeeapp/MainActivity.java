package app.coffee.com.coffeeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    Button button;
    public static final String ORDERED_COFFEE_COUNT = "orderedCoffeeCount";
    public static final String ORDERED_PRICE = "orderPrice";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increaseCount(View view) {
        button = (Button)findViewById(R.id.plusCount);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView orderCount = findViewById(R.id.orderCount);
                int coffeeCount = Integer.parseInt(orderCount.getText().toString());
                coffeeCount++;

                orderCount.setText(String.valueOf(coffeeCount));
                TextView price = findViewById(R.id.price);
                price.setText(String.valueOf(coffeeCount*5));
            }
        });
    }

    public void decreaseCount(View view) {
        button = (Button)findViewById(R.id.minusCount);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView orderCount = findViewById(R.id.orderCount);
                int coffeeCount = Integer.parseInt(orderCount.getText().toString());
                if(coffeeCount>0)
                    coffeeCount--;

                orderCount.setText(String.valueOf(coffeeCount));
                TextView price = findViewById(R.id.price);
                price.setText(String.valueOf(coffeeCount*5));
            }
        });
    }

    public void submitOrder(View view) {
        button = (Button)findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView orderedCoffeeCount = findViewById(R.id.orderCount);
                TextView orderPrice = findViewById(R.id.price);
                Intent displayOrder = new Intent(MainActivity.this,DisplayOrder.class);
                displayOrder.putExtra("orderedCoffeeCount",orderedCoffeeCount.getText().toString());
                displayOrder.putExtra("orderPrice",orderPrice.getText().toString());
                startActivity(displayOrder);
            }
        });
    }
}

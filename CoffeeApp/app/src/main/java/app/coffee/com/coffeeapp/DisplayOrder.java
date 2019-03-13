package app.coffee.com.coffeeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_order);
        Intent intent = getIntent();
        String orderedCoffeeCount = intent.getStringExtra(MainActivity.ORDERED_COFFEE_COUNT);
        String orderedPrice = intent.getStringExtra(MainActivity.ORDERED_PRICE);


        TextView coffeeQuntity = findViewById(R.id.coffeeQuntity);
        coffeeQuntity.setText(orderedCoffeeCount);
        TextView price = findViewById(R.id.price);
        price.setText(orderedPrice);
        TextView tax = findViewById(R.id.taxValue);
        double tax_value = (Double.parseDouble(orderedPrice)*15)/100;
        tax.setText(String.valueOf(tax_value));
        TextView total = findViewById(R.id.total);
        Double totalValue = Double.parseDouble(orderedPrice)+tax_value;
        total.setText(totalValue.toString());
    }
}
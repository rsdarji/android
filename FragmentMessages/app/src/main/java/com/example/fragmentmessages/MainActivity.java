package com.example.fragmentmessages;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static int temp1 = 0;
    public static int temp2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        if(findViewById(R.id.fragment_one_container)!=null){
            if(savedInstanceState!=null){
                return;
            }
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            FragmentOne homeFragment = new FragmentOne();
            fragmentTransaction.add(R.id.fragment_one_container,homeFragment,null);
            fragmentTransaction.commit();
        }
        if(findViewById(R.id.fragment_two_container)!=null){
            if(savedInstanceState!=null){
                return;
            }
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            FragmentTwo homeFragment = new FragmentTwo();
            fragmentTransaction.add(R.id.fragment_two_container,homeFragment,null);
            fragmentTransaction.commit();
        }


    }

    public void buttonPlusF1Click(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentTwo fragmentTwo = new FragmentTwo();
        fragmentTransaction.add(R.id.fragment_two_container,fragmentTwo,null);

        TextView text = findViewById(R.id.textView2F2);
        text.setText("");
        temp1+=1;
        text.setText("Fragment 1 is incremented by "+temp1);

        fragmentTransaction.commit();

    }

    public void buttonMinusF1Click(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentTwo fragmentTwo = new FragmentTwo();
        fragmentTransaction.add(R.id.fragment_two_container,fragmentTwo,null);


        TextView text = findViewById(R.id.textView2F2);
        text.setText("");
        temp1-=1;
        text.setText("Fragment 1 is decremented by "+temp1);

        fragmentTransaction.commit();
    }

    public void buttonMinusF2Click(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentOne fragmentOne = new FragmentOne();
        fragmentTransaction.add(R.id.fragment_one_container,fragmentOne,null);


        TextView text = findViewById(R.id.textView2F1);
        text.setText("");
        temp2-=1;
        text.setText("Fragment 2 is decremented by "+temp2);

        fragmentTransaction.commit();
    }

    public void buttonPlusF2Click(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentOne fragmentOne = new FragmentOne();
        fragmentTransaction.add(R.id.fragment_one_container,fragmentOne,null);


        TextView text = findViewById(R.id.textView2F1);
        text.setText("");
        temp2+=1;
        text.setText("Fragment 2 is incremented by "+temp2);

        fragmentTransaction.commit();
    }
}

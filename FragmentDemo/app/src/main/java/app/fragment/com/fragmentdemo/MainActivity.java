package app.fragment.com.fragmentdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FragmentTwo fragmentTwo = new FragmentTwo();
        fragmentTransaction.add(R.id.framelayout, fragmentTwo);
        fragmentTransaction.commit();
        setContentView(R.layout.activity_main);
    }

    public void loadFragmentOne(View view) {
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                FragmentOne fragmentOne = new FragmentOne();
                fragmentTransaction.replace(R.id.framelayout, fragmentOne);
                fragmentTransaction.commit();

            }
        });
    }

    public void loadFragmentTwo(View view) {
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                FragmentTwo fragmentTwo = new FragmentTwo();
                fragmentTransaction.replace(R.id.framelayout, fragmentTwo);
                fragmentTransaction.commit();
            }
        });
    }

    public void loadFragmentThree(View view) {
        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                FragmentThree fragmentThree = new FragmentThree();
                fragmentTransaction.replace(R.id.framelayout, fragmentThree);
                fragmentTransaction.commit();
            }
        });
    }
}

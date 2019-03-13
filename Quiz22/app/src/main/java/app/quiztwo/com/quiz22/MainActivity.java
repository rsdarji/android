package app.quiztwo.com.quiz22;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        if(findViewById(R.id.fragment1_container)!=null){

            if(savedInstanceState!=null){
                return;
            }

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            FragmentOne fragmentOne = new FragmentOne();
            fragmentTransaction.add(R.id.fragment1_container,fragmentOne,null);
            fragmentTransaction.commit();

        }
        if(findViewById(R.id.fragment2_container)!=null){

            if(savedInstanceState!=null){
                return;
            }

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            FragmentTwo fragmentTwo = new FragmentTwo();
            fragmentTransaction.add(R.id.fragment2_container,fragmentTwo,null);
            fragmentTransaction.commit();

        }
        if(findViewById(R.id.fragment3_container)!=null){

            if(savedInstanceState!=null){
                return;
            }

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            FragmentThree fragmentThree = new FragmentThree();
            fragmentTransaction.add(R.id.fragment3_container,fragmentThree,null);
            fragmentTransaction.commit();

        }
        button = findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment1_container, new FragmentTwo(), null).commit();
            }
        });

        button = findViewById(R.id.b2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment2_container, new FragmentThree(), null).commit();
            }
        });
        button = findViewById(R.id.b3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment3_container, new FragmentOne(), null).commit();
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment1, container, false);
        button = view.findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment1_container, new FragmentTwo(), null).commit();
            }
        });

        return view;
    }
}

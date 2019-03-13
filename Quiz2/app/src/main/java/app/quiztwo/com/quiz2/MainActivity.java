package app.quiztwo.com.quiz2;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    private Button button;
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

    }


}

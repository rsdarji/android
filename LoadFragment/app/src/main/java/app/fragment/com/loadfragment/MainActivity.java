package app.fragment.com.loadfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setFragment(R.id.framelayout_one, new FragmentOne());
        setFragment(R.id.framelayout_two, new FragmentTwo());
        setContentView(R.layout.activity_main);
    }

    private void setFragment(int fragmentContainer, Fragment fragment){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(fragmentContainer, fragment);
        fragmentTransaction.commit();

    }
}

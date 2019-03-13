package app.fragment.com.fragmentcommunicationwithedittext;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentOne fragmentOne = new FragmentOne();
                fragmentTransaction.add(R.id.frameLayout,fragmentOne,null);
                TextView text = findViewById(R.id.fragment1_textview1);
                //text.setText("");
                EditText edit = (EditText)findViewById(R.id.editText);
                text.setText("edittext 1 value: "+edit.getText().toString());
                fragmentTransaction.commit();
            }
        });

        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentTwo fragmentTwo = new FragmentTwo();
                fragmentTransaction.add(R.id.frameLayout,fragmentTwo,null);
                TextView text = findViewById(R.id.fragment2_textview1);
                //text.setText("");
                EditText edit = (EditText)findViewById(R.id.editText2);
                text.setText("edittext 2 value: "+edit.getText().toString());
                fragmentTransaction.commit();
            }
        });
    }


    public void button(View view) {
    }
}

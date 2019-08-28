package app.finalexam.com.localmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void move(View view) {
        tv = (TextView) findViewById(R.id.textview1);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this, ScreenTwoo.class);
                startActivity(j);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.local:
                Intent i = new Intent(MainActivity.this, ScreenTwoo.class);
                startActivity(i);
                Toast.makeText(this," sub Item 1 Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.myplaces:
                Intent j = new Intent(MainActivity.this, ScreenTwoo.class);
                startActivity(j);
                Toast.makeText(this,"sub Item 2 Selected", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

}

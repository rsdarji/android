package fetchdetail.ravi.com.fetchdetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String LOGIN_VALUE = "loginValue";
    public static final String PASSWORD_VALUE = "passwordValue";
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDetails(View view) {
        button = findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent showDetails = new Intent(MainActivity.this,Details.class);
                EditText login = (EditText) findViewById(R.id.login);
                EditText password = (EditText) findViewById(R.id.password);


                showDetails.putExtra(LOGIN_VALUE, login.getText().toString());
                showDetails.putExtra(PASSWORD_VALUE, password.getText().toString());

                startActivity(showDetails);
            }
        });
    }

    public void showPhoto(View view) {
        button = findViewById(R.id.b2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showPhoto = new Intent(MainActivity.this, Photo.class);
                startActivity(showPhoto);
            }
        });
    }
}

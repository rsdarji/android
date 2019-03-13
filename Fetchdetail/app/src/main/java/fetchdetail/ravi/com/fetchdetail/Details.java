package fetchdetail.ravi.com.fetchdetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    public static final String LOGIN_VALUE = "loginValue";
    public static final String PASSWORD_VALUE = "passwordValue";
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        String loginValue = intent.getStringExtra(MainActivity.LOGIN_VALUE);
        String passwordValue = intent.getStringExtra(MainActivity.PASSWORD_VALUE);

        TextView loginText = findViewById(R.id.loginText);
        loginText.setText("Your login value is: "+loginValue);

        TextView passwordText = findViewById(R.id.passwordText);
        passwordText.setText("Your password value is: "+passwordValue);

    }

    public void goBack(View view) {
        button = findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(Details.this,MainActivity.class);
                startActivity(goBack);
            }
        });
    }
}

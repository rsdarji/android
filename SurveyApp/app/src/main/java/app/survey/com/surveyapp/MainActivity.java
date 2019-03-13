package app.survey.com.surveyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void yes(View view) {
        button = findViewById(R.id.button_yes);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementResult();
            }
        });
        button.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                incrementResult();
                return true;
            }
        });
    }
    void incrementResult(){
        TextView result = findViewById(R.id.result);
        count+=1;
        result.setText(String.valueOf(count));
    }

    public void no(View view) {
        button = findViewById(R.id.button_no);

    }
}

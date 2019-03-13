package app.basketballscorecard.com.basketballsocrecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button button;
    int teamAScoreCount = 0;
    int teamBScoreCount = 0;
    TextView teamAScore;
    TextView teamBScore;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void teamAScorePlus(View view) {
        button = findViewById(R.id.team_a_score_plus);
        teamAScore = findViewById(R.id.team_a_score);
        teamBScore = findViewById(R.id.team_b_score);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAScore.setText(String.valueOf(teamAScoreCount+=1));
            }
        });
    }

    public void teamAScoreMinus(View view) {
        button = findViewById(R.id.team_a_score_minus);
        teamAScore = findViewById(R.id.team_a_score);
        teamBScore = findViewById(R.id.team_b_score);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamAScore.setText(String.valueOf(teamAScoreCount-=1));
            }
        });

    }

    public void teamBScorePlus(View view) {
        button = findViewById(R.id.team_b_score_plus);
        teamAScore = findViewById(R.id.team_a_score);
        teamBScore = findViewById(R.id.team_b_score);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBScore.setText(String.valueOf(teamBScoreCount+=1));
            }
        });

    }

    public void teamBScoreMinus(View view) {
        button = findViewById(R.id.team_b_score_minus);
        teamAScore = findViewById(R.id.team_a_score);
        teamBScore = findViewById(R.id.team_b_score);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBScore.setText(String.valueOf(teamBScoreCount-=1));
            }
        });

    }

    public void result(View view) {
        button = findViewById(R.id.result_button);
        result = findViewById(R.id.result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(teamAScoreCount>teamBScoreCount){
                    result.setText("Team A won");
                } else if(teamAScoreCount<teamBScoreCount){
                    result.setText("Team B won");
                }else{
                    result.setText("Match Tie");
                }
            }
        });
    }

    public void reset(View view) {
        button = findViewById(R.id.reset);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamBScore.setText("");
                teamAScore.setText("");
                result.setText("");
            }
        });
    }
}

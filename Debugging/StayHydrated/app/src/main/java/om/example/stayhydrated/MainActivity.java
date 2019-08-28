package om.example.stayhydrated;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView historyListView;
    ArrayList<WaterQuantity> quantityHistoryList = new ArrayList<WaterQuantity>();
    HistoryListView historyListViewAdapter;
    ProgressBar progressBar;
    int progressbarCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        historyListViewAdapter = new HistoryListView(this, quantityHistoryList);

        // Set up history list adapter
        historyListView = findViewById(R.id.historyListView);
        historyListView.setAdapter(historyListViewAdapter);

        // Set up the progress bar and give it a default progress
        progressBar = findViewById(R.id.progressBar);

        // The three quantity buttons
        ImageView dropletImage = findViewById(R.id.dropletImage);
        ImageView glassImage = findViewById(R.id.glassImage);
        ImageView bottleImage = findViewById(R.id.bottleImage);

        // Example: adding quantity to history list
        //quantityHistoryList.add(WaterQuantity.getQty50());
        //quantityHistoryList.add(WaterQuantity.getQty200());
        //quantityHistoryList.add(WaterQuantity.getQty350());
        historyListViewAdapter.notifyDataSetChanged();

        //progressBar.setProgress(600);

        // On click listeners
        dropletImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantityHistoryList.add(WaterQuantity.getQty50());
                historyListViewAdapter.notifyDataSetChanged();
                progressbarCount += 50;
                progressBar.setProgress(progressbarCount);

            }
        });

        glassImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantityHistoryList.add(WaterQuantity.getQty200());
                historyListViewAdapter.notifyDataSetChanged();
                progressbarCount += 200;
                progressBar.setProgress(progressbarCount);
            }
        });

        bottleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantityHistoryList.add(WaterQuantity.getQty350());
                historyListViewAdapter.notifyDataSetChanged();
                progressbarCount += 300;
                progressBar.setProgress(progressbarCount);
            }
        });

    }
}

package om.example.stayhydrated;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.ParseException;
import java.util.ArrayList;

public class HistoryListView extends ArrayAdapter {
    private final Activity context;

    //to store the animal images
    private final ArrayList<WaterQuantity> quantityHistoryList;

    public HistoryListView(Activity context, ArrayList<WaterQuantity> quantityHistoryListParams){
        super(context, R.layout.data_view_row , quantityHistoryListParams);
        this.context = context;
        this.quantityHistoryList = quantityHistoryListParams;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.data_view_row, null,true);

        TextView historyDataText = rowView.findViewById(R.id.historyDataText);
        TextView historyDataTimestamp = rowView.findViewById(R.id.historyDataTimestamp);
        ImageView historyDataImage = rowView.findViewById(R.id.historyDataImage);


        historyDataText.setText(quantityHistoryList.get(position).toString());
        try {
            historyDataTimestamp.setText(quantityHistoryList.get(position).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        historyDataImage.setImageResource(quantityHistoryList.get(position).getImageId());

        return rowView;

    }
}

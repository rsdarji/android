package om.example.todolist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends Activity {
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItems = (ListView) findViewById(R.id.lvItems);
        items = new ArrayList<String>();
        readItems();
        itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);


        setupListViewListener();
    }

    // Attaches a long click listener to the listview
    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
            new AdapterView.OnItemLongClickListener() {


                @Override
                public boolean onItemLongClick(AdapterView<?> adapter,
                                               View item, int pos, long id) {
                    // Remove the item within array at position
                    items.remove(pos);
                    // Refresh the adapter
                    itemsAdapter.notifyDataSetChanged();
                    // Return true consumes the long click event (marks it handled)
                    writeItems();
                    return true;
                }
            });
    }

    public void onAddItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        if(!itemText.equalsIgnoreCase("")) {
            itemsAdapter.add(itemText);
            writeItems();
            etNewItem.setText("");
        }
    }

    private void readItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile, null));
        } catch (IOException e) {
            items = new ArrayList<String>();
            items.add("Welcome to Todo List!");
        }
    }

    private void writeItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
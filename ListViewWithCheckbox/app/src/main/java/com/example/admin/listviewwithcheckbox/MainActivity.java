package com.example.admin.listviewwithcheckbox;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // The context variable to use in whole activity in place of
    // "HomeActivity.this".
    private Context mContext;

    // The FruitList Adapter to bind the views and show in listview.
    private FruitListAdapter mFruitListAdapter;

    // The ArrayList of Fruits<FruitItem>.
    private ArrayList<FruitItem> mFruitList;

    // The ListView of fruit message list.
    private ListView mFruitListview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        initView();
        mFruitList = FruitDummyDataManager.getFruitItemList();
        populateFruitList(mFruitList);
    }

    private void initView() {
        mFruitListview = (ListView) findViewById(R.id.fruit_listview);

        // Setting item click listener
        mFruitListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adpView, View view,
                                    int position, long itemId) {
                Log.d("TEST", "onItemClick");
                if (mFruitListAdapter != null) {
                    FruitItem item = mFruitListAdapter.getItem(position);
                    AppUtils.showToast(mContext, getString(R.string.item_click)
                            + item.getFruitname());
                }
            }
        });

    }

    /**
     * The method to receive click events of views.
     *
     * @param view
     */
    /*public void viewClickListener(View view) {
        if (R.id.back_arrow_view == view.getId()) {
            finish();
        }
    }*/

    /**
     * The listener to get list item click events.
     */
    private FruitListAdapter.OnFruitItemClickListener listListener = new FruitListAdapter.OnFruitItemClickListener() {

        @Override
        public void onCheckboxClicked(int position, FruitItem item) {
            item.setCheckboxChecked(!item.isCheckboxChecked());
            mFruitListAdapter.notifyDataSetChanged();
            if (item.isCheckboxChecked()) {
                AppUtils.showToast(mContext, getString(R.string.fruit_name)
                        + item.getFruitname() + getString(R.string.is_checked));
            } else {
                AppUtils.showToast(mContext, getString(R.string.fruit_name)
                        + item.getFruitname()
                        + getString(R.string.is_unchecked));
            }

        }

    };

    /**
     * Populate the list.
     *
     * @param list
     */
    private void populateFruitList(ArrayList<FruitItem> list) {
        if (list != null && list.size() > 0) {
            if (mFruitListAdapter == null) {
                mFruitListAdapter = new FruitListAdapter(mContext, mFruitList);
                mFruitListAdapter.setOnFruitClickListener(listListener);
            }
            mFruitListview.setAdapter(mFruitListAdapter);
        } else {
            mFruitListAdapter.setItemlist(mFruitList);
            AppUtils.showToast(mContext,
                    getString(R.string.no_message_list_found));
        }
    }

    @Override
    protected void onDestroy() {
        if (mContext != null) {
            mFruitListAdapter = null;
            mFruitList = null;
            mFruitListview = null;
            mContext = null;
            super.onDestroy();
        }
    }
}

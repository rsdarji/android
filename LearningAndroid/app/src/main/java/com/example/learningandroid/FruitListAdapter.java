package com.example.learningandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FruitListAdapter extends BaseAdapter {

        // The ArrayList of Users<essageItem>
        private ArrayList<FruitItem> mItemsList;

        // The LayoutInflater to holds layout inflater to inflate list item.
        private LayoutInflater mLayoutInflater;

        // The OnMessageClickListener of listener.
        private OnFruitItemClickListener listener;

        /**
         * Constructor.
         *
         * @param context
         * @param list
         */
        public FruitListAdapter(Context context, ArrayList<FruitItem> list) {
            mItemsList = list;
            mLayoutInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        /**
         * Method to set item list and notify adapter to update its views.
         *
         * @param list
         */
        public void setItemlist(ArrayList<FruitItem> list) {
            mItemsList = list;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            if (mItemsList != null) {
                return mItemsList.size();
            } else {
                return 0;
            }
        }

        @Override
        public FruitItem getItem(int position) {
            FruitItem item = null;
            if (mItemsList != null && mItemsList.size() > 0) {
                item = mItemsList.get(position);
            }
            return item;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }



    /**
         * Method to set the listener class object.
         *
         * @param listener
         */
        public void setOnFruitClickListener(OnFruitItemClickListener listener) {
            this.listener = listener;
        }

        /**
         * Interface to provide click events to the required classes.
         *
         * @author Amruta.Doye
         *
         */
        public interface OnFruitItemClickListener {

            /**
             * The method declaration for user selected. This method will be fired
             * when user click on check/uncheck the checkbox on the list item.
             *
             * @param position
             * @param item
             */
            public void onCheckboxClicked(int position, FruitItem item);

        }

        /**
         *
         * @return update list from array list.
         */
        public ArrayList<FruitItem> getUpdatedList() {
            return mItemsList;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                ViewHolder viewHolder = new ViewHolder();
                view = mLayoutInflater.inflate(R.layout.fragment_one_, parent,
                        false);
                viewHolder.header_textview = (TextView) view
                        .findViewById(R.id.header_textview);
                viewHolder.sub_textview = (TextView) view
                        .findViewById(R.id.sub_textview);
                viewHolder.profile_imageview = (ImageView) view
                        .findViewById(R.id.profile_imageview);

                view.setTag(viewHolder);
            }

            ViewHolder viewHolder = (ViewHolder) view.getTag();
            final FruitItem item = getItem(position);
            if (item != null && viewHolder != null) {
                viewHolder.header_textview.setText(item.getFruitname());
                viewHolder.sub_textview.setText(item.getMessage());
                viewHolder.profile_imageview.setBackgroundResource(item
                        .getPictureResId());

                /*viewHolder.checkbox.setTag(position);
                viewHolder.checkbox.setChecked(item.isCheckboxChecked());
                viewHolder.checkbox.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        listener.onCheckboxClicked(position, item);
                    }
                });*/

            }
            return view;
        }

        /**
         * View holder class to hold the views to bind on list view.
         *
         * @author Amruta.Doye
         *
         */
        public static class ViewHolder {
            TextView header_textview;
            TextView sub_textview;
            ImageView profile_imageview;
            CheckBox checkbox;

        }

    }

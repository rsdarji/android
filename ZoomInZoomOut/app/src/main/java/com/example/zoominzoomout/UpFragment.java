package com.example.zoominzoomout;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;


public class UpFragment extends Fragment implements SeekBar.OnSeekBarChangeListener{

    // This variable is used to refer to the activity that use this fragment.
    private OnFragmentInteractionListener mListener;

    // The text seekbar.
    private SeekBar textSeekBar = null;

    // The image seekbar.
    private SeekBar imageSeekBar = null;

    public UpFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the fragment layout.
        View fragmentView = inflater.inflate(R.layout.seekbar, container, false);

        if(textSeekBar == null)
        {
            textSeekBar = (SeekBar)fragmentView.findViewById(R.id.text_seek_bar);
            textSeekBar.setOnSeekBarChangeListener(this);
        }

        if(imageSeekBar == null)
        {
            imageSeekBar = (SeekBar)fragmentView.findViewById(R.id.image_seek_bar);
            imageSeekBar.setOnSeekBarChangeListener(this);
        }

        return fragmentView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /* Assign the activity to the variable. Because activity implements OnFragmentInteractionListener
           so the activity is an instance of OnFragmentInteractionListener. */
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /* This method is invoked when the seekbar slide. Because UpFragment.java implement SeekBar.OnSeekBarChangeListener interface. */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        int seekBarId = seekBar.getId();

        if(seekBarId == R.id.text_seek_bar)
        {
            // If slide the text seekbar then invoke activity's onTextSeekBar method.
            mListener.onTextSeekBarChange(progress);
        }else if(seekBarId == R.id.image_seek_bar)
        {
            // If slide the image seekbar then invoke activity's onImageSeekBar mtehod.
            mListener.onImageSeekBarChange(progress);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    /**
     * The activity must implement below interface.
     * When seekbar slide, the mListener will invoke below methods that is implemented in the activity.
     * Activity will display related fragment in the override methods accordingly.
     */
    public interface OnFragmentInteractionListener {

        void onTextSeekBarChange(float seekbarValue);

        void onImageSeekBarChange(float seekbarValue);
    }



}

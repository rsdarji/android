package com.example.zoominzoomout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TextFragment extends Fragment {

    private TextView textView = null;

    /* Used to change textview text size. */
    public void changeTextSize(float textSize)
    {
        if(textView!=null)
        {
            textView.setTextSize(textSize);
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate TextFragment layout.
        View fragmentView = inflater.inflate(R.layout.text_fragment, container, false);

        // Get the textview object.
        textView = fragmentView.findViewById(R.id.text_view);

        return fragmentView;
    }
}

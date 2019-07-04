
package com.example.bloodcampnavgraph;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

public class navigation_second_fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_navigation_second_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toast.makeText(getActivity().getApplicationContext(), "Bundle args " + getArguments().getBoolean("test_boolean"), Toast.LENGTH_SHORT).show();
        //Toast.makeText(getActivity().getApplicationContext(), "Bundle args " + navigation_first_fragmentArgs.fromBundle(getArguments()).getTestString(), Toast.LENGTH_SHORT).show();

        Button button = view.findViewById(R.id.button_frag2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);
                navController.navigateUp();

                /*navController.addOnNavigatedListener(new NavController.OnNavigatedListener() {

                    public void onNavigated(@NonNull NavController controller, @NonNull NavDestination destination) {
                        Log.d("TAG", destination.getLabel() + " ");
                    }
                });*/
            }
        });
    }

}

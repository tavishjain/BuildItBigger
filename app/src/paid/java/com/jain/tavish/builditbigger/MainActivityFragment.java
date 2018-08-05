package com.jain.tavish.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivityFragment extends Fragment{

    String joke;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);

        root.findViewById(R.id.tellJokeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                root.findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
                new EndpointsAsyncTask(getContext(), root.findViewById(R.id.progressBar)).execute();
            }
        });

        return root;
    }
}

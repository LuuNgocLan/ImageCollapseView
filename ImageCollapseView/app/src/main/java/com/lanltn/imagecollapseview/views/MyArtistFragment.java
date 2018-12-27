package com.lanltn.imagecollapseview.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.swipe.util.Attributes;
import com.lanltn.imagecollapseview.R;
import com.lanltn.imagecollapseview.adapter.MyArtistAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyArtistFragment extends Fragment {


    private RecyclerView recyclerView;
    private MyArtistAdapter adapter;

    public MyArtistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_artist, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        adapter = new MyArtistAdapter(getContext());
        adapter.setMode(Attributes.Mode.Single);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        return view;
    }

}

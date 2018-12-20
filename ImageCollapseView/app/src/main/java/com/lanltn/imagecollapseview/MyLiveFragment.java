package com.lanltn.imagecollapseview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.swipe.util.Attributes;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyLiveFragment extends Fragment {


    private RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;

    public MyLiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_live, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        adapter = new RecyclerViewAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        adapter.setMode(Attributes.Mode.Single);
        recyclerView.setAdapter(adapter);
        return view;
    }

}

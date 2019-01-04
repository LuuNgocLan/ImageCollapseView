package com.lanltn.imagecollapseview.modules.myLive;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.swipe.util.Attributes;
import com.lanltn.imagecollapseview.R;
import com.lanltn.imagecollapseview.modules.myLive.MyLiveAdapter;
import com.lanltn.imagecollapseview.models.MyLive;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyLiveFragment extends Fragment {


    private MyLiveAdapter adapter;
    private RecyclerView recyclerView;
    private List<MyLive> myLiveList = new ArrayList<>();

    public MyLiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_live, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        adapter = new MyLiveAdapter(getContext(), myLiveList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        adapter.setMode(Attributes.Mode.Single);
        recyclerView.setAdapter(adapter);
        initData();
        return view;
    }

    private void initData() {
        myLiveList.add(new MyLive("2018.12.2", "Amazon Fashion Week TOKYO 2019SS」 with  SPACE SHOWER …"));
        myLiveList.add(new MyLive("2018.12.3", "Amazon Fashion Week TOKYO 2019SS」 with  SPACE SHOWER …"));
        myLiveList.add(new MyLive("2018.12.4", "Amazon Fashion Week TOKYO 2019SS」 with  SPACE SHOWER …"));
        myLiveList.add(new MyLive("2018.12.5", "Amazon Fashion Week TOKYO 2019SS」 with  SPACE SHOWER …"));
        myLiveList.add(new MyLive("2018.12.6", "Amazon Fashion Week TOKYO 2019SS」 with  SPACE SHOWER …"));
        myLiveList.add(new MyLive("2018.12.7", "Amazon Fashion Week TOKYO 2019SS」 with  SPACE SHOWER …"));
        myLiveList.add(new MyLive("2018.12.8", "Amazon Fashion Week TOKYO 2019SS」 with  SPACE SHOWER …"));
        myLiveList.add(new MyLive("2018.12.9", "Amazon Fashion Week TOKYO 2019SS」 with  SPACE SHOWER …"));
        myLiveList.add(new MyLive("2018.12.10", "Amazon Fashion Week TOKYO 2019SS」 with  SPACE SHOWER …"));
        adapter.notifyDataSetChanged();
    }

}

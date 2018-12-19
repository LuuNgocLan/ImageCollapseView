package com.lanltn.imagecollapseview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageCollapsingView imageCollapsingView;
    private RecyclerView recyclerView;
    private int[] idImageList = {R.drawable.artist_1, R.drawable.artist_1, R.drawable.artist_1, R.drawable.artist_2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        imageCollapsingView = findViewById(R.id.imageCollapsingView);
//
//        List<Integer> idList = new ArrayList<>();
//        for (int i : idImageList) {
//            idList.add(i);
//        }
//        imageCollapsingView.setImageIdList(idList);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new Adapter());


    }
}

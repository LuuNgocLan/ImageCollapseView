package com.lanltn.imagecollapseview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageCollapsingView imageCollapsingView;
    private int[] idImageList = {R.drawable.artist_1, R.drawable.artist_1, R.drawable.artist_1, R.drawable.artist_2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageCollapsingView = findViewById(R.id.imageCollapsingView);
        List<Integer> idList = new ArrayList<>();
        for (int i : idImageList) {
            idList.add(i);
        }
        imageCollapsingView.setImageIdList(idList);


    }
}

package com.lanltn.imagecollapseview.views;

import android.support.v17.leanback.widget.HorizontalGridView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.widget.Toast;

import com.lanltn.imagecollapseview.R;
import com.lanltn.imagecollapseview.adapter.GridAdapter;

public class GridImageActivity extends AppCompatActivity {
    private HorizontalGridView horizontalGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_image);
        horizontalGridView = findViewById(R.id.horizontalGridView);
        horizontalGridView.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
        horizontalGridView.setAdapter(
                new GridAdapter(
                        this,
                        new GridAdapter.OnItemSelectedListener() {
                            @Override
                            public void onClick() {
                                Toast.makeText(getBaseContext(), "ITEM CLICKED!", Toast.LENGTH_SHORT).show();
                            }
                        },
                        R.layout.item_grid_image));
    }
}

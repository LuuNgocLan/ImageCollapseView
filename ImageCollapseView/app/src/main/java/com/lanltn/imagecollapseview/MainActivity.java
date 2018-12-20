package com.lanltn.imagecollapseview;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;

import com.daimajia.swipe.util.Attributes;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int[] idImageList = {R.drawable.artist_1, R.drawable.fes2, R.drawable.artist_1, R.drawable.artist_2};
    private List<ImageData> imageData = new ArrayList<>();

    private Button btnNext;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private List<Fragment> fragmentList = new ArrayList<>();
    private String[] titles = {"My Live", "My Artist", "My LiveHouse"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNext = findViewById(R.id.btnNext);
        mViewPager = findViewById(R.id.view_pager);
        mTabLayout = findViewById(R.id.tabLayout);

        setEvenButton();

        initTabs();
    }

    public void initTabs() {
        fragmentList.add(new MyLiveFragment());
        fragmentList.add(new MyArtistFragment());
        fragmentList.add(new MyLiveHouseFragment());

        mViewPager.setAdapter(new BasePagerAdapter(getSupportFragmentManager(), fragmentList, titles));
        mViewPager.setOffscreenPageLimit(3);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }


    private void setEvenButton() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GridImageActivity.class));
            }
        });
    }

}

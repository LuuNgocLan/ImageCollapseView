package com.lanltn.imagecollapseview.views;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lanltn.imagecollapseview.R;
import com.lanltn.imagecollapseview.adapter.BasePagerAdapter;
import com.lanltn.imagecollapseview.models.ImageData;
import com.lanltn.imagecollapseview.ui.ButtonDrawableView;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int[] idImageList = {R.drawable.artist_1, R.drawable.fes2, R.drawable.artist_1, R.drawable.artist_2};
    private List<ImageData> imageData = new ArrayList<>();

    private ButtonDrawableView btnNext, btn_2;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private List<Fragment> fragmentList = new ArrayList<>();
    private String[] titles = {"My Live", "My Artist", "My LiveHouse"};
    private boolean isSelectedButton = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNext = findViewById(R.id.btnNext);
        btn_2 = findViewById(R.id.btn_2);
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
                isSelectedButton = !isSelectedButton;
                btnNext.setStatusButtonSelected(isSelectedButton);
//                startActivity(new Intent(MainActivity.this, GridImageActivity.class));
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelectedButton = !isSelectedButton;
                btn_2.setStatusButtonSelected(isSelectedButton);
            }
        });

        final ButtonDrawableView btn3 = findViewById(R.id.btn_3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelectedButton = !isSelectedButton;
                btn3.setStatusButtonSelected(isSelectedButton);
            }
        });
    }

}

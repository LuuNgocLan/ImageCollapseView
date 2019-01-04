package com.lanltn.imagecollapseview.modules.home;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lanltn.imagecollapseview.R;
import com.lanltn.imagecollapseview.adapter.MainPagerAdapter;
import com.lanltn.imagecollapseview.databinding.ActivityMainBinding;
import com.lanltn.imagecollapseview.ui.ButtonDrawableView;
import com.lanltn.imagecollapseview.views.GridImageActivity;

public class MainActivity extends AppCompatActivity {
    private boolean isSelectedButton = false;

    private MainActivityViewModel mViewModel;

    private ActivityMainBinding mBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModel = new MainActivityViewModel();
        mBinding.setViewModel(mViewModel);
        initTabs();
        setEvenButton();
    }

    public void initTabs() {
//        mViewPager = mBinding.viewPager;
//        mTabLayout = mBinding.tabLayout;
//
//        mViewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));

        mViewModel.setMainPagerAdapter(new MainPagerAdapter(getSupportFragmentManager()));
    }


    private void setEvenButton() {
        mBinding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelectedButton = !isSelectedButton;
                mBinding.btnNext.setStatusButtonSelected(isSelectedButton);
                startActivity(new Intent(MainActivity.this, GridImageActivity.class));
            }
        });

        mBinding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelectedButton = !isSelectedButton;
                mBinding.btn2.setStatusButtonSelected(isSelectedButton);
            }
        });

        final ButtonDrawableView btn3 = findViewById(R.id.btn_3);
        mBinding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelectedButton = !isSelectedButton;
                mBinding.btn3.setStatusButtonSelected(isSelectedButton);
            }
        });
    }

}

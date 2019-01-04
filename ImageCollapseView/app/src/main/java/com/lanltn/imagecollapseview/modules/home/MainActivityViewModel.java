package com.lanltn.imagecollapseview.modules.home;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.TableLayout;
import com.lanltn.imagecollapseview.BR;

import com.lanltn.imagecollapseview.adapter.MainPagerAdapter;
import com.lanltn.imagecollapseview.ui.NonSwipeableViewPager;

public class MainActivityViewModel extends BaseObservable {

    /*private MainPagerAdapter adapter;

    private Activity mContext;


    public MainActivityViewModel(Activity activity) {
        this.mContext = activity;
        this.adapter = new MainPagerAdapter(activity.getFragmentManager());
    }

    @Bindable
    public MainPagerAdapter getAdapter() {
        return this.adapter;
    }

    @BindingAdapter({"pagerAdapter"})
    public static void bindViewPagerAdapter(ViewPager viewPager) {
        viewPager.setAdapter(adapter);
    }*/


    private MainPagerAdapter mainPagerAdapter;

    public void MainActivityViewModel() {}

    @Bindable
    public MainPagerAdapter getMainPagerAdapter() {
        return mainPagerAdapter;
    }

    public void setMainPagerAdapter(MainPagerAdapter mainPagerAdapter) {
        this.mainPagerAdapter = mainPagerAdapter;
        notifyPropertyChanged(BR.mainPagerAdapter);
    }

    @BindingAdapter({"page_adapter"})
    public static void pageAdapter(NonSwipeableViewPager nonSwipeableViewPager, MainPagerAdapter mainPagerAdapter)
    {
        nonSwipeableViewPager.setAdapter(mainPagerAdapter);

    }

    @BindingAdapter({"viewPager"})
    public static void bindViewPager(TabLayout mTabLayout, NonSwipeableViewPager mViewPager){
        mViewPager.setOffscreenPageLimit(3);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }

}

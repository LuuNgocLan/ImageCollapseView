package com.lanltn.imagecollapseview.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lanltn.imagecollapseview.modules.myArtist.MyArtistFragment;
import com.lanltn.imagecollapseview.modules.myLive.MyLiveFragment;
import com.lanltn.imagecollapseview.views.MyLiveHouseFragment;

import java.util.List;

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private String[] mTitles = {"My Live","My Artist","My LiveHouse"};

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new MyLiveFragment();
            case 1:
                return new MyArtistFragment();
            case 2:
                return new MyLiveHouseFragment();
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public int getCount() {
        return 3;
    }
}


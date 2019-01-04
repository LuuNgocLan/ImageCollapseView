package com.lanltn.imagecollapseview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import com.lanltn.imagecollapseview.R;
import com.lanltn.imagecollapseview.models.ImageData;
import com.lanltn.imagecollapseview.models.MyLive;
import com.lanltn.imagecollapseview.ui.ImageCollapsingView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyLiveHouseAdapter extends RecyclerSwipeAdapter<MyLiveHouseAdapter.RecyclerViewHolder> {
    private Context mContext;
    private List<MyLive> myLiveList;

    public MyLiveHouseAdapter(Context context, List<MyLive> myLiveList) {
        this.mContext = context;
        this.myLiveList = myLiveList;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_my_live_house, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder viewHolder, final int position) {

        mItemManger.bindView(viewHolder.itemView, position);
        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);

        viewHolder.swipeLayout.setOnDoubleClickListener(new SwipeLayout.DoubleClickListener() {
            @Override
            public void onDoubleClick(SwipeLayout layout, boolean surface) {
                Toast.makeText(mContext, "DoubleClick", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        SwipeLayout swipeLayout;


        public RecyclerViewHolder(View itemView) {
            super(itemView);
            swipeLayout = itemView.findViewById(R.id.swipe);
        }
    }
}


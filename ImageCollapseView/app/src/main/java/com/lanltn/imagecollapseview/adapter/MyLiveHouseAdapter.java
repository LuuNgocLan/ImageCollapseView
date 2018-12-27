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

public class MyLiveHouseAdapter extends RecyclerSwipeAdapter<MyLiveHouseAdapter.RecyclerViewHolder> implements ImageCollapsingView.OnCollapsingImageListener {
    private int[] idImageList_4 = {R.drawable.artist_1, R.drawable.fes2, R.drawable.fes3, R.drawable.artist_2};
    private int[] idImageSource = ImageData.getIdImageList();
    private List<Integer> idList_4;
    private List<Integer> idList_1;
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
        MyLive myLive = myLiveList.get(position);
        viewHolder.date.setText(myLive.getDate());
        viewHolder.title.setText(myLive.getTitle());

        mItemManger.bindView(viewHolder.itemView, position);
        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);

        viewHolder.swipeLayout.setOnDoubleClickListener(new SwipeLayout.DoubleClickListener() {
            @Override
            public void onDoubleClick(SwipeLayout layout, boolean surface) {
                Toast.makeText(mContext, "DoubleClick", Toast.LENGTH_SHORT).show();
            }
        });

        idList_4 = new ArrayList<>();
        for (int i : idImageList_4) {
            idList_4.add(i);
        }
        idList_1 = new ArrayList<>();

        //set data
        Random rd = new Random();
        int num = rd.nextInt(2);
        if (num == 0) {
            int num_id = rd.nextInt(9);
            idList_1.add(idImageSource[num_id]);
            viewHolder.imageCollapsingView.setImageIdList(idList_1);
        } else {
            viewHolder.imageCollapsingView.setImageIdList(idList_4);
        }
        viewHolder.imageCollapsingView.setOnCollapsingImageListener(this);

    }

    @Override
    public int getItemCount() {
        return myLiveList.size();
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    @Override
    public void onClickPlayer() {
        Toast.makeText(mContext, "Playing...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickImageItem() {

    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        SwipeLayout swipeLayout;
        ImageCollapsingView imageCollapsingView;
        TextView date, title;


        public RecyclerViewHolder(View itemView) {
            super(itemView);
            imageCollapsingView = itemView.findViewById(R.id.imageCollapsingView);

            swipeLayout = itemView.findViewById(R.id.swipe);
            date = itemView.findViewById(R.id.date);
            title = itemView.findViewById(R.id.title);
            imageCollapsingView.setSizeButtonImage(48, 48);
        }
    }
}


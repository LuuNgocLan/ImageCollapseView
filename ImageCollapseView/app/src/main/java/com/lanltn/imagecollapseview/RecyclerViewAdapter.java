package com.lanltn.imagecollapseview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.swipe.SimpleSwipeListener;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerViewAdapter extends RecyclerSwipeAdapter<RecyclerViewAdapter.RecyclerViewHolder> implements ImageCollapsingView.OnCollapsingImageListener {
    private int[] idImageList_4 = {R.drawable.artist_1, R.drawable.fes2, R.drawable.fes3, R.drawable.artist_2};
    private List<Integer> idList_4;
    private List<Integer> idList_1;
    private Context mContext;

    public RecyclerViewAdapter(Context context) {
        this.mContext = context;
        idList_4 = new ArrayList<>();
        for (int i : idImageList_4) {
            idList_4.add(i);
        }
        idList_1 = new ArrayList<>();


    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_artist_recyclerview, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder viewHolder, final int position) {
        mItemManger.bindView(viewHolder.itemView, position);
        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
        viewHolder.swipeLayout.addSwipeListener(new SimpleSwipeListener() {
            @Override
            public void onOpen(SwipeLayout layout) {
//                YoYo.with(Techniques.Tada).duration(500).delay(100).playOn(layout.findViewById(R.id.trash));
            }
        });

        viewHolder.swipeLayout.setOnDoubleClickListener(new SwipeLayout.DoubleClickListener() {
            @Override
            public void onDoubleClick(SwipeLayout layout, boolean surface) {
                Toast.makeText(mContext, "DoubleClick", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.imvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mItemManger.removeShownLayouts(viewHolder.swipeLayout);
//                mDataset.remove(position);
                notifyItemRemoved(position);
//                notifyItemRangeChanged(position, mDataset.size());
                mItemManger.closeAllItems();
                Toast.makeText(view.getContext(), "Deleted!", Toast.LENGTH_SHORT).show();
            }
        });

        //set data
        Random rd = new Random();
        int num = rd.nextInt(2);
        if (num == 0) {
            int num_id = rd.nextInt(4);
            idList_1.add(idImageList_4[num_id]);
            viewHolder.imageCollapsingView.setImageIdList(idList_1);
        } else {
            viewHolder.imageCollapsingView.setImageIdList(idList_4);
        }
        viewHolder.imageCollapsingView.setOnCollapsingImageListener(this);

    }

    @Override
    public int getItemCount() {
        return 10;
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
        ImageView imvDelete;
        ImageCollapsingView imageCollapsingView;


        public RecyclerViewHolder(View itemView) {
            super(itemView);
            imageCollapsingView = itemView.findViewById(R.id.imageCollapsingView);
            swipeLayout = itemView.findViewById(R.id.swipe);
            imvDelete = itemView.findViewById(R.id.delete);
        }
    }
}


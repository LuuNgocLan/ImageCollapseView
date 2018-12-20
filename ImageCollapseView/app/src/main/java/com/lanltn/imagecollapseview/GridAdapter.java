package com.lanltn.imagecollapseview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.RecyclerViewHolder> {

    //datafo
    private int[] idImageList_4 = {R.drawable.artist_1, R.drawable.fes2, R.drawable.fes3, R.drawable.artist_2};
    private List<Integer> idList_1 = new ArrayList<>();
    private Context mContext;
    private OnItemSelectedListener onItemSelectedListener;

    public GridAdapter(Context context, OnItemSelectedListener onItemSelectedListener) {
        this.mContext = context;
        this.onItemSelectedListener = onItemSelectedListener;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_grid_image, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.imageCollapsingView.setStyleImageCollapsingView(1);
        Random rd = new Random();
        int num_id = rd.nextInt(4);
        idList_1.add(idImageList_4[0]);
        holder.imageCollapsingView.setImageIdList(idList_1);
        holder.imageCollapsingView.setOnCollapsingImageListener(new ImageCollapsingView.OnCollapsingImageListener() {
            @Override
            public void onClickPlayer() {
                Toast.makeText(mContext, "Playing...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClickImageItem() {

            }
        });

    }

    @Override
    public int getItemCount() {
        return 13;
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageCollapsingView imageCollapsingView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            imageCollapsingView = itemView.findViewById(R.id.imageCollapsingView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemSelectedListener.onClick();
        }
    }

    public interface OnItemSelectedListener {
        public void onClick();
    }
}


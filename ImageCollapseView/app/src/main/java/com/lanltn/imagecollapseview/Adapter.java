package com.lanltn.imagecollapseview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Adapter extends RecyclerView.Adapter<Adapter.RecyclerViewHolder> {
    private int[] idImageList_4 = {R.drawable.artist_1, R.drawable.artist_1, R.drawable.artist_1, R.drawable.artist_2};
    private List<Integer> idList_4;
    private List<Integer> idList_1;

    public Adapter() {
        idList_4 = new ArrayList<>();
        for (int i : idImageList_4) {
            idList_4.add(i);
        }
        idList_1 = new ArrayList<>();
        idList_1.add(idImageList_4[0]);


    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_artist, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Random rd = new Random();
        int num = rd.nextInt(2);
        if (num == 0) {
            holder.imageCollapsingView.setImageIdList(idList_1);
        } else {
            holder.imageCollapsingView.setImageIdList(idList_4);
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageCollapsingView imageCollapsingView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            imageCollapsingView = itemView.findViewById(R.id.imageCollapsingView);
        }
    }
}


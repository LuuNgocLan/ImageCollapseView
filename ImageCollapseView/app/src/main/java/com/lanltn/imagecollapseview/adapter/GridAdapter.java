package com.lanltn.imagecollapseview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lanltn.imagecollapseview.models.ImageData;
import com.lanltn.imagecollapseview.ui.ImageCollapsingView;
import com.lanltn.imagecollapseview.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.RecyclerViewHolder> {

    private int[] idImageList = ImageData.getIdImageList();
    private List<Integer> idList_1;

    private Context mContext;
    private OnItemSelectedListener onItemSelectedListener;
    private int idLayoutItem;

    public GridAdapter(Context context, OnItemSelectedListener onItemSelectedListener, int idLayoutItem) {
        this.mContext = context;
        this.onItemSelectedListener = onItemSelectedListener;
        this.idLayoutItem = idLayoutItem;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(idLayoutItem, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        idList_1 = new ArrayList<>();
        Random rd = new Random();
        int num_id = rd.nextInt(9);
        idList_1.add(idImageList[num_id]);

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
            imageCollapsingView.setStyleImageCollapsingView(1);
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


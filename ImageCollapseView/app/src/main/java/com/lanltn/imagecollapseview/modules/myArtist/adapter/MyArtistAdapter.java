package com.lanltn.imagecollapseview.modules.myArtist.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import com.lanltn.imagecollapseview.R;
import com.lanltn.imagecollapseview.databinding.ItemMyArtistBinding;
import com.lanltn.imagecollapseview.models.ArtistModel;
import com.lanltn.imagecollapseview.models.ImageData;
import com.lanltn.imagecollapseview.ui.ImageCollapsingView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyArtistAdapter extends RecyclerSwipeAdapter<MyArtistAdapter.RecyclerViewHolder> implements ImageCollapsingView.OnCollapsingImageListener {

    private Context mContext;
    private List<ArtistModel> data;



    public MyArtistAdapter() {
        this.data = new ArrayList<>();
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_my_artist, parent, false);
        mContext = parent.getContext();
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
        viewHolder.imvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mItemManger.removeShownLayouts(viewHolder.swipeLayout);
                data.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, data.size());
                mItemManger.closeAllItems();
                Toast.makeText(view.getContext(), "Deleted!", Toast.LENGTH_SHORT).show();
            }
        });

        ArtistModel artistModel = data.get(position);
        viewHolder.setViewModel(new MyArtistItemViewModel(artistModel, mContext));

    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    @Override
    public void onViewAttachedToWindow(RecyclerViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();

    }

    @Override
    public void onViewDetachedFromWindow(RecyclerViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
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

    public void updateData(List<ArtistModel> data) {
        if (data == null || data.isEmpty()) {
            this.data.clear();
        } else {
            this.data.addAll(data);
        }
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        SwipeLayout swipeLayout;
        ImageView imvDelete;
        ItemMyArtistBinding binding;


        public RecyclerViewHolder(View itemView) {
            super(itemView);
            bind();
            swipeLayout = binding.swipe;
            imvDelete = binding.delete;
        }

        public void bind() {
            if (binding == null) {
                binding = DataBindingUtil.bind(itemView);
            }
        }

        void unbind() {
            if (binding != null) {
                binding.unbind(); // Don't forget to unbind
            }
        }

        /* package */ void setViewModel(MyArtistItemViewModel viewModel) {
            if (binding != null) {
                binding.setViewModel(viewModel);
            }
        }
    }


}


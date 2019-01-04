package com.lanltn.imagecollapseview.modules.myLive;

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
import com.lanltn.imagecollapseview.models.ImageData;
import com.lanltn.imagecollapseview.models.MyLive;
import com.lanltn.imagecollapseview.ui.ImageCollapsingView;
import com.lanltn.imagecollapseview.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyLiveAdapter extends RecyclerSwipeAdapter<MyLiveAdapter.RecyclerViewHolder> implements ImageCollapsingView.OnCollapsingImageListener {
    private List<String> urlImages = ImageData.getUrlImageList();
    private Context mContext;
    private List<MyLive> myLiveList;

    public MyLiveAdapter(Context context, List<MyLive> myLiveList) {
        this.mContext = context;
        this.myLiveList = myLiveList;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_my_live, parent, false);
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
        viewHolder.imvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mItemManger.removeShownLayouts(viewHolder.swipeLayout);
                myLiveList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, myLiveList.size());
                mItemManger.closeAllItems();
                Toast.makeText(view.getContext(), "Deleted!", Toast.LENGTH_SHORT).show();
            }
        });

        List<String> urlImage1 = new ArrayList<>();
        urlImage1.add(urlImages.get(0));
        urlImage1.add(urlImages.get(1));
        urlImage1.add(urlImages.get(2));
        urlImage1.add(urlImages.get(3));
        urlImage1.add(urlImages.get(4));

        List<String> urlImage2 = new ArrayList<>();
        urlImage2.add(urlImages.get((new Random()).nextInt(urlImages.size())));

        //set data
        Random rd = new Random();
        int num = rd.nextInt(2);
        if (num == 0) {
            int num_id = rd.nextInt(9);
            viewHolder.imageCollapsingView.setUrlImageData(urlImage1);
        } else {
            viewHolder.imageCollapsingView.setUrlImageData(urlImage2);
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
        ImageView imvDelete;
        ImageCollapsingView imageCollapsingView;
        TextView date, title;


        public RecyclerViewHolder(View itemView) {
            super(itemView);
            imageCollapsingView = itemView.findViewById(R.id.imageCollapsingView);

            swipeLayout = itemView.findViewById(R.id.swipe);
            imvDelete = itemView.findViewById(R.id.delete);
            date = itemView.findViewById(R.id.date);
            title = itemView.findViewById(R.id.title);
            imageCollapsingView.setSizeButtonImage(48, 48);
        }
    }
}


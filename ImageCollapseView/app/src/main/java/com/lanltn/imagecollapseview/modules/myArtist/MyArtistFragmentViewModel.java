package com.lanltn.imagecollapseview.modules.myArtist;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;

import com.lanltn.imagecollapseview.BR;
import com.lanltn.imagecollapseview.models.ArtistModel;
import com.lanltn.imagecollapseview.modules.myArtist.adapter.MyArtistAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyArtistFragmentViewModel extends BaseObservable {
    private MyArtistAdapter adapter;

    private List<ArtistModel> data;

    private Activity mContext;

    public MyArtistFragmentViewModel(Activity mContext) {
        this.adapter = new MyArtistAdapter();
        this.data = new ArrayList<>();
        this.mContext = mContext;
    }

    public void setUp(){
        initDataArtist();
    }

    public void tearDown(){

    }

    public void refreshData(){
        initDataArtist();
    }

    @Bindable
    public List<ArtistModel> getData(){
        return this.data;
    }

    @Bindable
    public MyArtistAdapter getAdapter(){
        return this.adapter;
    }


    private void initDataArtist() {
        // populate the data from the source, such as the database.
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 25; i++) {
                    ArtistModel dataModel = new ArtistModel();
                    data.add(dataModel);
                }
                notifyPropertyChanged(BR.data);
            }
        }, 1500);
    }

    @BindingAdapter({"app:adapter", "app:data"})
    public static void bind(RecyclerView recyclerView, MyArtistAdapter adapter, List<ArtistModel> data) {
        recyclerView.setAdapter(adapter);
        adapter.updateData(data);
    }

}

package com.lanltn.imagecollapseview.modules.myArtist.adapter;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;

import com.lanltn.imagecollapseview.models.ArtistModel;
import com.lanltn.imagecollapseview.ui.ImageCollapsingView;

public class MyArtistItemViewModel
        extends BaseObservable
        implements ImageCollapsingView.OnCollapsingImageListener
{

    private ArtistModel mViewModel;

    private Context mContext;


    public MyArtistItemViewModel(ArtistModel mViewModel, Context mContext) {
        this.mViewModel = mViewModel;
        this.mContext = mContext;
    }

    @Bindable
    public String getNameArtist() {
        return mViewModel.getNameArtist();
    }

    @Bindable
    public String getUrlImage() {
        return mViewModel.getImage();
    }

    @BindingAdapter("artistImage")
    public static void loadImage(ImageCollapsingView imageCollapsingView, String urlImage) {
        imageCollapsingView.setSizeButtonImage(16, 16);
        imageCollapsingView.setSingleImageToCollapsing(urlImage);

    }


    @Override
    public void onClickPlayer() {

    }

    @Override
    public void onClickImageItem() {

    }
}

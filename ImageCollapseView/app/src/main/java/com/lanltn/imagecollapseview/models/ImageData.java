package com.lanltn.imagecollapseview.models;

import com.lanltn.imagecollapseview.R;

import java.util.List;

public class ImageData {
    private List<Integer> imageList;

    public ImageData() {
    }

    public List<Integer> getImageList() {
        return imageList;
    }

    public void setImageList(List<Integer> imageList) {
        this.imageList = imageList;
    }

    public static int[] getIdImageList() {
        int[] idImageTestList = {
                R.drawable.artist_02,
                R.drawable.artist_04png,
                R.drawable.artist_05,
                R.drawable.artist_06png,
                R.drawable.artist_07,
                R.drawable.artist,
                R.drawable.fes1,
                R.drawable.fes2,
                R.drawable.fes3
        };
        return idImageTestList;
    }

}

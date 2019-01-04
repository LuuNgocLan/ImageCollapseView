package com.lanltn.imagecollapseview.models;

import com.lanltn.imagecollapseview.R;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ImageData {
    private List<String> imageList;

    public ImageData() {
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public static List<String> getUrlImageList() {
        String[] urlImageTestList = {
                "https://api.androidhive.info/images/nature/david1.jpg",
                "https://api.androidhive.info/images/nature/1.jpg",
                "https://api.androidhive.info/images/nature/2.jpg",
                "https://api.androidhive.info/images/nature/3.jpg",
                "https://api.androidhive.info/images/nature/4.jpg",
                "https://api.androidhive.info/images/nature/5.jpg",
                "https://api.androidhive.info/images/nature/6.jpg",
                "https://api.androidhive.info/images/nature/7.jpg",
                "https://api.androidhive.info/images/nature/8.jpg",
                "https://api.androidhive.info/images/nature/9.jpg",
                "https://api.androidhive.info/images/nature/10.jpg",
                "https://api.androidhive.info/images/nature/11.jpg",
                "https://api.androidhive.info/images/nature/12.jpg",
                "https://api.androidhive.info/images/nature/13.jpg",
                "https://api.androidhive.info/images/nature/14.jpg"
        };
        return Arrays.asList(urlImageTestList);
    }

}

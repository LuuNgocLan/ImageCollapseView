package com.lanltn.imagecollapseview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lanltn.imagecollapseview.R;

import java.util.ArrayList;
import java.util.List;

public class ImageCollapsingView extends LinearLayout {
    private static final int MAX_IMAGE = 4;
    private static final int MIN_IMAGE = 1;
    private static final int NO_IMAGE = 0;

    private LinearLayout llImageTop, llImageBottom;
    private ImageView btn_play;

    private int[] idImageView = {R.id.imv_one, R.id.imv_two, R.id.imv_three, R.id.imv_four};
    private List<Integer> imageIdList = new ArrayList<>();

    public ImageCollapsingView(Context context) {
        super(context);
        init();
    }

    public ImageCollapsingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ImageCollapsingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.image_collapsing_view, this);

        this.btn_play = findViewById(R.id.btn_play);
        this.llImageTop = findViewById(R.id.ll_imageTop);
        this.llImageBottom = findViewById(R.id.ll_imageBottom);
    }

    private void setViewImage() {
        if (imageIdList.size() >= MAX_IMAGE) {
            setStyleImageCollapsingView(imageIdList.size());
            for (int i = 0; i < MAX_IMAGE; i++) {
                ImageView imageView = findViewById(idImageView[i]);
                imageView.setImageDrawable(getResources().getDrawable(imageIdList.get(i)));
            }
        } else if (imageIdList.size() == 1) {
            setStyleImageCollapsingView(imageIdList.size());
            ImageView imageView = findViewById(idImageView[0]);
            imageView.setImageDrawable(getResources().getDrawable(imageIdList.get(0)));
        } else {
            setStyleImageCollapsingView(imageIdList.size());
            for (int i = 0; i < imageIdList.size(); i++) {
                ImageView imageView = findViewById(idImageView[i]);
                imageView.setImageDrawable(getResources().getDrawable(imageIdList.get(i)));
            }
        }
    }

    public void setImageIdList(List<Integer> imageIdList) {
        this.imageIdList = imageIdList;
        setViewImage();
    }

    public void setStyleImageCollapsingView(int numImages) {
        if (numImages == 1) {
            llImageTop.setWeightSum(1f);
            llImageBottom.setVisibility(GONE);
        }
    }


    public interface IClickEvent {
        public void onClickPlayer();
    }
}

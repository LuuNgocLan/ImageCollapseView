package com.lanltn.imagecollapseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ImageCollapsingView extends LinearLayout {

    private static final int MAX_IMAGE = 4;
    private static final int MIN_IMAGE = 1;
    private static final int NO_IMAGE = 0;

    private LinearLayout llImageTop, llImageBottom;
    private ImageView mBtnPlay;

    private OnCollapsingImageListener onCollapsingImageListener;
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
        this.mBtnPlay = findViewById(R.id.btn_play);
        this.llImageTop = findViewById(R.id.ll_imageTop);
        this.llImageBottom = findViewById(R.id.ll_imageBottom);

    }

    private void setImageDataToCollapse() {

        int sizeImageData = imageIdList.size();
        setStyleImageCollapsingView(sizeImageData);

        if (sizeImageData >= MAX_IMAGE) {

            for (int i = 0; i < MAX_IMAGE; i++) {
                ImageView imageView = findViewById(idImageView[i]);
                imageView.setImageDrawable(getResources().getDrawable(imageIdList.get(i)));
            }

        } else if (sizeImageData == 1) {
            //display first image
            ImageView imageView = findViewById(idImageView[0]);
            imageView.setImageDrawable(getResources().getDrawable(imageIdList.get(0)));

        } else {

            for (int i = 0; i < imageIdList.size(); i++) {
                ImageView imageView = findViewById(idImageView[i]);
                imageView.setImageDrawable(getResources().getDrawable(imageIdList.get(i)));
            }

        }
    }

    public void setImageIdList(List<Integer> imageIdList) {

        this.imageIdList = imageIdList;
        setImageDataToCollapse();
    }


    /**
     * set number of images to display in collapsing
     *
     * @param numImages
     */
    public void setStyleImageCollapsingView(int numImages) {

        if (numImages == 1) {
            llImageTop.setWeightSum(1f);
            llImageBottom.setVisibility(GONE);
        }
    }

    public void setOnCollapsingImageListener(final OnCollapsingImageListener onCollapsingImageListener) {
        this.onCollapsingImageListener = onCollapsingImageListener;
        this.mBtnPlay.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onCollapsingImageListener.onClickPlayer();
            }
        });

    }


    public interface OnCollapsingImageListener {
        public void onClickPlayer();

        public void onClickImageItem();
    }

}

package com.lanltn.imagecollapseview.ui;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lanltn.imagecollapseview.R;
import com.lanltn.imagecollapseview.utills.ImageUtils;

import java.util.ArrayList;
import java.util.List;

public class ImageCollapsingView extends LinearLayout {

    private static final int MAX_IMAGE = 4;
    private static final int MIN_IMAGE = 1;
    private static final int NO_IMAGE = 0;

    /**
     * viewGroup contain 1st and 2nd Image
     */
    private LinearLayout llImageTop;
    /**
     * viewGroup contain 3rd and 4th Image
     */
    private LinearLayout llImageBottom;
    /**
     * button play in collapsingImageView
     */
    private ImageView mBtnPlay;
    /**
     * Listener to receive event click
     */
    private OnCollapsingImageListener onCollapsingImageListener;

    /**
     * Array contain id of 4 images
     */
    private int[] idImageView = {R.id.imv_one, R.id.imv_two, R.id.imv_three, R.id.imv_four};


    private List<Integer> imageIdList = new ArrayList<>();


    //  ============================================================
    //  Constructor
    //  ============================================================

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


    //  ========================================================
    //  Getters/Setters
    //  ========================================================

    public void setImageIdList(List<Integer> imageIdList) {

        this.imageIdList = imageIdList;
        setImageDataToCollapse();
    }

    public void setImageDataList(List<String> imageUriList) {
    }

    //  ===========================================================
    //  Methods
    //  ===========================================================

    private void setImageDataToCollapse() {

        int sizeImageData = imageIdList.size();
        setStyleImageCollapsingView(sizeImageData);

        if (sizeImageData >= MAX_IMAGE) {

            for (int i = 0; i < MAX_IMAGE; i++) {
                setImageToImageView(idImageView[i], imageIdList.get(i));
            }

        } else if (sizeImageData == 1) {
            //display first image
            setImageToImageView(idImageView[0], imageIdList.get(0));
        } else {

            for (int i = 0; i < imageIdList.size(); i++) {
                setImageToImageView(idImageView[i], imageIdList.get(i));
            }

        }
    }

    public void setImageToImageView(int id, int idImageDrawable) {
        ImageView imageView = findViewById(id);
        imageView.setImageDrawable(getResources().getDrawable(idImageDrawable));
    }


    public void setImageToImageView(int id, String uriImage) {
        ImageView imageView = findViewById(id);
        imageView.setImageURI(Uri.parse(uriImage));
    }


    /**
     * Re-size of ImageButton Player
     *
     * @param width_dp
     * @param height_dp
     */
    public void setSizeButtonImage(int width_dp, int height_dp) {

        mBtnPlay.getLayoutParams().height = (int) ImageUtils.convertDpToPixel(width_dp, getContext());
        mBtnPlay.getLayoutParams().width = (int) ImageUtils.convertDpToPixel(height_dp, getContext());
        mBtnPlay.requestLayout();
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
            ((ImageView) findViewById(R.id.imv_two)).setVisibility(GONE);
        }
    }

    /**
     * @param onCollapsingImageListener
     */
    public void setOnCollapsingImageListener(final OnCollapsingImageListener onCollapsingImageListener) {

        this.onCollapsingImageListener = onCollapsingImageListener;
        this.mBtnPlay.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onCollapsingImageListener.onClickPlayer();
            }
        });

    }


    //  ===========================================================
    //  Interface
    //  ===========================================================

    public interface OnCollapsingImageListener {
        public void onClickPlayer();

        public void onClickImageItem();
    }

}

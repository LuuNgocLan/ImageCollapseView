package com.lanltn.imagecollapseview.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lanltn.imagecollapseview.R;

public class ButtonDrawableView extends LinearLayout {

    /**
     * Style background Button color
     */
    private static final int BG_NONE = 0;

    private static final int BG_STROKE_WHITE = 1;

    private static final int BG_STROKE_COLOR = 2;

    private static final int BG_FILL = 3;

    /**
     * Style Button
     */

    private static final int NONE_BG = 1;
    private static final int STROKE_BORDER_WHITE = 2;
    private static final int STROKE_BORDER_COLOR = 3;


    private LinearLayout button;

    private ImageView ic_button;

    private TextView tv_button;

    /**
     * Icon button normal
     */
    private Drawable mIconNormal;

    /**
     * Icon button selected
     */
    private Drawable mIconSelected;

    /**
     * Text display in button
     */
    private String mTextButton;

    private int mColorTextNormal;

    private int mColorTextSelected;

    /**
     * Style background
     */
    private int mStyleBgNormal = BG_NONE;

    private int mStyleBgSelected = BG_NONE;

    private boolean isButtonSelected = false;

    private int mStyleButton;


    // =================================================
    // Constructor
    // =================================================

    public ButtonDrawableView(Context context) {
        super(context);
    }

    public ButtonDrawableView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ButtonDrawableView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    public ButtonDrawableView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {
        inflate(getContext(), R.layout.button_drawable_view, this);
        this.button = findViewById(R.id.button);
        this.ic_button = findViewById(R.id.ic_button);
        this.tv_button = findViewById(R.id.tv_button);

        TypedArray ta = getContext().obtainStyledAttributes(set, R.styleable.ButtonDrawableView);

        mColorTextNormal = ta.getColor(R.styleable.ButtonDrawableView_textColorNormal, Color.WHITE);
        tv_button.setTextColor(mColorTextNormal);

        mColorTextSelected = ta.getColor(R.styleable.ButtonDrawableView_textColorSelected, Color.WHITE);

        mTextButton = ta.getString(R.styleable.ButtonDrawableView_text);
        setTextButton(mTextButton);

        mIconNormal = ta.getDrawable(R.styleable.ButtonDrawableView_iconNormal);
        mIconSelected = ta.getDrawable(R.styleable.ButtonDrawableView_iconSelected);
        ic_button.setImageDrawable(mIconNormal);

        mStyleBgNormal = ta.getInt(R.styleable.ButtonDrawableView_styleNormalBackground, 0);
        mStyleBgSelected = ta.getInt(R.styleable.ButtonDrawableView_styleSelectedBackground, 0);

        mStyleButton = ta.getInt(R.styleable.ButtonDrawableView_styleButton, 0);
        if (mStyleButton > 0) {
            setStyleButton(mStyleButton);
        }

        setStyleBackgroundButton(mStyleBgNormal);

        ta.recycle();

    }


    // =================================================
    // Methods
    // =================================================

    public void setStyleBackgroundButton(int mStyle) {
        switch (mStyle) {
            case BG_NONE:
                break;
            case BG_STROKE_WHITE:
                button.setBackground(getContext().getResources().getDrawable(R.drawable.bg_stroke_white));
                break;
            case BG_STROKE_COLOR:
                button.setBackground(getContext().getResources().getDrawable(R.drawable.bg_stroke_color));
                break;
            case BG_FILL:
                button.setBackground(getContext().getResources().getDrawable(R.drawable.bg_fill_color));
                break;
        }
    }


    public void setTextButton(String textButton) {
        tv_button.setText(textButton);
    }

    public void setmIconSelected(Drawable mIconSelected) {
        mIconSelected = mIconSelected;
    }

    public void setmIconNormal(Drawable mIconNormal) {
        this.mIconNormal = mIconNormal;
    }

    public void setStatusButtonSelected(boolean isSelected) {
        if (isSelected) {
            tv_button.setTextColor(mColorTextSelected);
            ic_button.setImageDrawable(mIconSelected);
            setStyleBackgroundButton(mStyleBgSelected);
        } else {
            tv_button.setTextColor(mColorTextNormal);
            ic_button.setImageDrawable(mIconNormal);
            setStyleBackgroundButton(mStyleBgNormal);
        }
    }

    public void setStyleButton(int style) {
        switch (style) {
            case NONE_BG:
                tv_button.setTextColor(Color.WHITE);
                setStyleBackgroundButton(BG_NONE);
                break;
            case STROKE_BORDER_WHITE:
                tv_button.setTextColor(Color.WHITE);
                setStyleBackgroundButton(BG_STROKE_WHITE);
                break;
            case STROKE_BORDER_COLOR:
                tv_button.setTextColor(getResources().getColor(R.color.colorAccent));
                setStyleBackgroundButton(BG_STROKE_COLOR);
                break;
        }
    }

}

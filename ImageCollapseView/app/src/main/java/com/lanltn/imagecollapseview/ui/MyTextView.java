//package com.lanltn.imagecollapseview.ui;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.graphics.Typeface;
//import android.support.annotation.Nullable;
//import android.util.AttributeSet;
//
//public class MyTextView
//        extends android.support.v7.widget.AppCompatTextView {
//    public MyTextView(final Context context) {
//        super(context);
//        init(null);
//    }
//
//    public MyTextView(final Context context, @Nullable final AttributeSet attrs) {
//        super(context, attrs);
//        init(attrs);
//    }
//
//    public MyTextView(final Context context, @Nullable final AttributeSet attrs, final int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        init(attrs);
//    }
//
//    private void init(final AttributeSet attrs) {
//        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MyTextView);
//        if (attrs != null) {
//            String fontName = a.getString(R.styleable.MyTextView_fontName);
//            if (fontName != null && !fontName.equals("")) {
//                Typeface myTypeface = Typeface
//                        .createFromAsset(getContext().getAssets(), "fonts/" + "hiragino_W" + fontName + ".ttc");
//                setTypeface(myTypeface);
//            } else {
//                Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + "hiragino_W5.ttc");
//                setTypeface(myTypeface);
//            }
//            a.recycle();
//        } else {
//            Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + "hiragino_W5.ttc");
//            setTypeface(myTypeface);
//        }
//    }
//
//    public void updateTypeFace(String font) {
//        Typeface myTypeface = Typeface
//                .createFromAsset(getContext().getAssets(), "fonts/" + "hiragino_W" + font + ".ttc");
//        setTypeface(myTypeface);
//    }
//}

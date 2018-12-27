package com.lanltn.imagecollapseview.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.HashMap;


public class CustomCalendarView
        extends TableLayout {
    private HashMap<Integer, CalenderViewHolder> hashItem = new HashMap<>();
    private IListenDateChanged iListenDateChanged;
    private int lastTouch = -1;
    private int currentMonth;
    private int currentYear;
    private int fromDay = -1;
    private int fromMonth;
    private int fromYear;
    private int toDay;
    private int toMonth;
    private int toYear;
    private int pickDay;
    private int pickMonth;
    private int pickYear;

    public void setDateChanged() {
        iListenDateChanged.datePickChanged();
    }

    public void setiListenDateChanged(IListenDateChanged iListenDateChanged) {
        this.iListenDateChanged = iListenDateChanged;
    }

    public void clearCalendar() {
        fromYear = fromMonth = toMonth = toDay = toYear = pickYear = pickDay = pickMonth = 0;
        fromDay = -1;
    }

    public CustomCalendarView(Context context) {
        super(context);
        init();
    }

    public CustomCalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init() {
    }

    public int getFromDay() {
        return fromDay;
    }

    public int getFromMonth() {
        return fromMonth;
    }

    public int getFromYear() {
        return fromYear;
    }

    public int getToDay() {
        return toDay;
    }

    public int getToMonth() {
        return toMonth;
    }

    public int getToYear() {
        return toYear;
    }

    public int getPickDay() {
        return pickDay;
    }

    public int getPickMonth() {
        return pickMonth;
    }

    public int getPickYear() {
        return pickYear;
    }

    public int getCurrentMonth() {
        return currentMonth;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public void setCurrentMonth(int currentMonth) {
        this.currentMonth = currentMonth;
    }

    public void setFrom(int day, int month, int year) {
        this.fromDay = day;
        this.fromMonth = month;
        this.fromYear = year;
    }

    public void setTo(int day, int month, int year) {
        this.toDay = day;
        this.toMonth = month;
        this.toYear = year;
    }

    public void setPick(int day, int month, int year) {
        this.pickDay = day;
        this.pickMonth = month;
        this.pickYear = year;
    }

    public void setLastTouch(int lastTouch) {
        this.lastTouch = lastTouch;
    }

    public HashMap<Integer, CalenderViewHolder> getHashItem() {
        return hashItem;
    }

    public int getLastTouch() {
        return lastTouch;
    }

    public static class CalenderViewHolder {
        public TextView textView;
        public boolean isSelected;
        public int day, month, year;
        public boolean inMonthFocus;

        public CalenderViewHolder(TextView textView, int day, int month, int year, boolean isSelected, boolean inMonthFocus) {
            this.textView = textView;
            this.isSelected = isSelected;
            this.day = day;
            this.month = month;
            this.year = year;
            this.inMonthFocus = inMonthFocus;
        }
    }

    public interface IListenDateChanged {
        void datePickChanged();
    }
}
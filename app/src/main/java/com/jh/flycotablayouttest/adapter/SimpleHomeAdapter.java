package com.jh.flycotablayouttest.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Email: 1004260403@qq.com
 * Created by jinhui on 2019/1/6.
 */
public class SimpleHomeAdapter extends BaseAdapter {

    private Context mContext;
    private String [] mItems;
    private DisplayMetrics displayMetrics;

    public SimpleHomeAdapter(Context context, String[] mItems) {
        this.mContext = context;
        this.mItems = mItems;
        displayMetrics = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    }

    @Override
    public int getCount() {
        return mItems.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int padding = (int) (displayMetrics.density * 10);
        TextView textView = new TextView(mContext);
        textView.setText(mItems[position]);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        textView.setTextColor(Color.parseColor("#468ED0"));
        textView.setPadding(padding, padding, padding, padding);
        textView.setGravity(Gravity.CENTER);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,
                AbsListView.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(layoutParams);
        return textView;
    }
}

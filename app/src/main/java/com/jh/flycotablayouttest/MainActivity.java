package com.jh.flycotablayouttest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.jh.flycotablayouttest.adapter.SimpleHomeAdapter;
import com.jh.flycotablayouttest.ui.CommonTabActivity;
import com.jh.flycotablayouttest.ui.SegmentTabActivity;
import com.jh.flycotablayouttest.ui.SlidingTabActivity;

/**
 * 一个Android TabLayout库
 * https://github.com/H07000223/FlycoTabLayout
 *
 * 测试demo，用于调试FlycoTabLayout库
 */
public class MainActivity extends AppCompatActivity {

    private Context mContext = this;
    private String [] mItems = {"SlidingTabLayout", "CommonTabLayout", "SegmentTabLayout"};
    private Class<?> [] mClasses = {SlidingTabActivity.class, CommonTabActivity.class,
            SegmentTabActivity.class};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ListView listView = new ListView(mContext);
        listView.setCacheColorHint(Color.TRANSPARENT);
        listView.setFadingEdgeLength(0);
        listView.setAdapter(new SimpleHomeAdapter(mContext, mItems));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, mClasses[position]);
                startActivity(intent);
            }
        });

        setContentView(listView);

    }
}

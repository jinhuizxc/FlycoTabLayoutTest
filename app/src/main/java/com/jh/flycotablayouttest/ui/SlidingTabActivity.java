package com.jh.flycotablayouttest.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.flyco.tablayout.widget.MsgView;
import com.jh.flycotablayouttest.R;
import com.jh.flycotablayouttest.fragment.SimpleCardFragment;
import com.jh.flycotablayouttest.utils.ViewFindUtils;

import java.util.ArrayList;

/**
 * Email: 1004260403@qq.com
 * Created by jinhui on 2019/1/6.
 */
public class SlidingTabActivity extends AppCompatActivity implements OnTabSelectListener {

    private Context context = this;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private String[] mTitles = {"热门", "iOS", "Android"
            , "前端", "后端", "设计", "工具资源"};

    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_tab);

        for (String mTitle : mTitles) {
            fragments.add(SimpleCardFragment.getInstance(mTitle));
        }

        View decorView = getWindow().getDecorView();
        ViewPager viewPager = ViewFindUtils.find(decorView, R.id.vp);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        /** 默认 */
        SlidingTabLayout tabLayout_1 = ViewFindUtils.find(decorView, R.id.tl_1);
        /**自定义部分属性*/
        SlidingTabLayout tabLayout_2 = ViewFindUtils.find(decorView, R.id.tl_2);
        /** 字体加粗,大写 */
        SlidingTabLayout tabLayout_3 = ViewFindUtils.find(decorView, R.id.tl_3);
        /** tab固定宽度 */
        SlidingTabLayout tabLayout_4 = ViewFindUtils.find(decorView, R.id.tl_4);
        /** indicator固定宽度 */
        SlidingTabLayout tabLayout_5 = ViewFindUtils.find(decorView, R.id.tl_5);
        /** indicator圆 */
        SlidingTabLayout tabLayout_6 = ViewFindUtils.find(decorView, R.id.tl_6);
        /** indicator矩形圆角 */
        final SlidingTabLayout tabLayout_7 = ViewFindUtils.find(decorView, R.id.tl_7);
        /** indicator三角形 */
        SlidingTabLayout tabLayout_8 = ViewFindUtils.find(decorView, R.id.tl_8);
        /** indicator圆角色块 */
        SlidingTabLayout tabLayout_9 = ViewFindUtils.find(decorView, R.id.tl_9);
        /** indicator圆角色块 */
        SlidingTabLayout tabLayout_10 = ViewFindUtils.find(decorView, R.id.tl_10);

        tabLayout_1.setViewPager(viewPager);
        tabLayout_2.setViewPager(viewPager);
        tabLayout_2.setOnTabSelectListener(this);
        tabLayout_3.setViewPager(viewPager);
        tabLayout_4.setViewPager(viewPager);
        tabLayout_5.setViewPager(viewPager);
        tabLayout_6.setViewPager(viewPager);
        tabLayout_7.setViewPager(viewPager, mTitles);
        tabLayout_8.setViewPager(viewPager, mTitles, this, fragments);
        tabLayout_9.setViewPager(viewPager);
        tabLayout_10.setViewPager(viewPager);

        viewPager.setCurrentItem(4);
        tabLayout_1.showDot(4);
        tabLayout_2.showDot(4);
        tabLayout_3.showDot(4);

        tabLayout_2.showMsg(3, 5);
        tabLayout_2.setMsgMargin(3, 0, 10);

        MsgView msgView = tabLayout_2.getMsgView(3);
        if (msgView != null){
            msgView.setBackgroundColor(Color.parseColor("#6D8FB0"));
        }

        tabLayout_2.showMsg(5, 5);
        tabLayout_2.setMsgMargin(5, 0, 10);

        tabLayout_7.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                Toast.makeText(context, "onTabSelect&position--->" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabReselect(int position) {
                fragments.add(SimpleCardFragment.getInstance("后端"));

                adapter.notifyDataSetChanged();
                tabLayout_7.addNewTab("后端");
            }
        });

    }

    @Override
    public void onTabSelect(int position) {
        Toast.makeText(context, "onTabSelect&position--->" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabReselect(int position) {
        Toast.makeText(context, "onTabReselect&position--->" + position, Toast.LENGTH_SHORT).show();
    }

    private class MyPagerAdapter extends FragmentPagerAdapter{

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}

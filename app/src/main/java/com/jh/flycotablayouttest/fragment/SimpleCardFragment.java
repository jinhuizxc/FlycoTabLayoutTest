package com.jh.flycotablayouttest.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jh.flycotablayouttest.R;

/**
 * Email: 1004260403@qq.com
 * Created by jinhui on 2019/1/6.
 */
public class SimpleCardFragment extends Fragment {

    private String title;

    public static Fragment getInstance(String mTitle) {
        SimpleCardFragment simpleCardFragment = new SimpleCardFragment();
        simpleCardFragment.title = mTitle;
        return simpleCardFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_simple_card, null);
        TextView card_title_tv = view.findViewById(R.id.card_title_tv);
        card_title_tv.setText(title);
        return view;
    }
}

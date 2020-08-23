package com.dhruvdroid.sampleott.layoutmanager;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.dhruvdroid.sampleott.R;

//
// Created by Dhruv on 23/08/20.
//
public class ListDecorator extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = (int) parent.getContext().getResources().getDimension(R.dimen.settings_item_bottom_margin);
    }
}
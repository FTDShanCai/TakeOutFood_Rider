package com.lixin.takeoutfood.rider.ui.listener;

import android.view.View;

public interface OnItemClickListener<T> {
    void onItemClick(View view, int position, T t);
}

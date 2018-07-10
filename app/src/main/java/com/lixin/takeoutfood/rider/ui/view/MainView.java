package com.lixin.takeoutfood.rider.ui.view;

import android.support.v4.app.Fragment;

import com.lixin.takeoutfood.rider.ui.base.BaseView;

import java.util.ArrayList;

public interface MainView extends BaseView {
    void setFragments(ArrayList<Fragment> fragments);
}

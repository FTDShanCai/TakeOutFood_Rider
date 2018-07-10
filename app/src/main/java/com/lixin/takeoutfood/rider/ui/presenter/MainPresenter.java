package com.lixin.takeoutfood.rider.ui.presenter;

import android.support.v4.app.Fragment;

import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.fragment.MineFragment;
import com.lixin.takeoutfood.rider.ui.fragment.OrderListFragment;
import com.lixin.takeoutfood.rider.ui.fragment.RobOrderFragment;
import com.lixin.takeoutfood.rider.ui.view.MainView;

import java.util.ArrayList;

public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView view) {
        super(view);
    }


    public void initFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(RobOrderFragment.newInstance());
        fragments.add(OrderListFragment.newInstance());
        fragments.add(MineFragment.newInstance());
        view.get().setFragments(fragments);
    }
}

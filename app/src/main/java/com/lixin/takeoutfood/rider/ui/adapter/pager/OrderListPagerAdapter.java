package com.lixin.takeoutfood.rider.ui.adapter.pager;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lixin.takeoutfood.rider.ui.fragment.OrderListDetailFragment;
import com.lixin.takeoutfood.rider.ui.fragment.RobOrderFragment;

import java.util.ArrayList;

public class OrderListPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<String> tabs;
    private ArrayList<Fragment> fragments;

    public OrderListPagerAdapter(FragmentManager fm, ArrayList<String> tabs) {
        super(fm);
        this.tabs = tabs;
        initFragment();
    }

    private void initFragment() {
        if (tabs == null)
            return;

        fragments = new ArrayList<>();
        for (String s : tabs) {
            fragments.add(OrderListDetailFragment.newInstance());
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        if (fragments == null)
            return 0;
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position);
    }
}

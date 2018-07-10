package com.lixin.takeoutfood.rider.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.ui.adapter.pager.OrderListPagerAdapter;
import com.lixin.takeoutfood.rider.ui.base.BaseFragment;
import com.lixin.takeoutfood.rider.ui.presenter.OrderListPresenter;
import com.lixin.takeoutfood.rider.ui.view.OrderListView;

import java.util.ArrayList;

import butterknife.BindView;

public class OrderListFragment extends BaseFragment<OrderListPresenter> implements OrderListView {
    @BindView(R.id.tab_layout)
    TabLayout tab_layout;
    @BindView(R.id.view_pager)
    ViewPager view_pager;

    private OrderListPagerAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_order_list;
    }

    @Override
    protected OrderListPresenter getPresenter() {
        return new OrderListPresenter(this);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @Override
    protected void lazyLoad() {
        presenter.getTabs();
    }

    @Override
    public void ToastMessage(String msg) {
        toast(msg);
    }


    @Override
    public void setTab(ArrayList<String> tabs) {
        adapter = new OrderListPagerAdapter(getChildFragmentManager(), tabs);
        view_pager.setAdapter(adapter);
        tab_layout.setupWithViewPager(view_pager);
    }

    public static OrderListFragment newInstance() {

        Bundle args = new Bundle();
        OrderListFragment fragment = new OrderListFragment();
        fragment.setArguments(args);
        return fragment;
    }
}

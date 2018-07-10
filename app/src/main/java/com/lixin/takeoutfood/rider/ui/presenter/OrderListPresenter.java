package com.lixin.takeoutfood.rider.ui.presenter;

import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.view.OrderListView;

import java.util.ArrayList;

public class OrderListPresenter extends BasePresenter<OrderListView> {
    public OrderListPresenter(OrderListView view) {
        super(view);
    }

    public void getTabs() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add(activity.getString(R.string.order_tab_1));
        strings.add(activity.getString(R.string.order_tab_2));
        strings.add(activity.getString(R.string.order_tab_3));
        view.get().setTab(strings);
    }
}

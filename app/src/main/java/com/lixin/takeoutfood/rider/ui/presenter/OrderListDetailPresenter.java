package com.lixin.takeoutfood.rider.ui.presenter;

import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.view.OrderListDetailView;

public class OrderListDetailPresenter extends BasePresenter<OrderListDetailView> {
    public OrderListDetailPresenter(OrderListDetailView view) {
        super(view);
    }

    public void getList(boolean isRefresh) {
        view.get().refreshorLoadMoreComplete(isRefresh);
    }
}

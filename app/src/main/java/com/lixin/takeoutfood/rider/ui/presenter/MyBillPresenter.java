package com.lixin.takeoutfood.rider.ui.presenter;

import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.view.MyBillView;

public class MyBillPresenter extends BasePresenter<MyBillView> {

    public MyBillPresenter(MyBillView view) {
        super(view);
    }

    public void getList(boolean isRefresh) {
        view.get().refreshorLoadMoreComplete(isRefresh);
    }
}

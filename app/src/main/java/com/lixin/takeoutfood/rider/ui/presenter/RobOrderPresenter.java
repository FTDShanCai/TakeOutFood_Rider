package com.lixin.takeoutfood.rider.ui.presenter;

import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.view.RobOrderView;

public class RobOrderPresenter extends BasePresenter<RobOrderView> {

    public RobOrderPresenter(RobOrderView view) {
        super(view);
    }

    public void getList(boolean isRefresh) {
        view.get().refreshorLoadMoreComplete(isRefresh);
    }
}

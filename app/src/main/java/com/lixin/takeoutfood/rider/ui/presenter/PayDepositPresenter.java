package com.lixin.takeoutfood.rider.ui.presenter;

import com.lixin.takeoutfood.rider.ui.activity.PayResultActivity;
import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.view.PayDepositView;

public class PayDepositPresenter extends BasePresenter<PayDepositView> {
    public PayDepositPresenter(PayDepositView view) {
        super(view);
    }

    public void goPay() {
        startActivity(PayResultActivity.class);
    }
}

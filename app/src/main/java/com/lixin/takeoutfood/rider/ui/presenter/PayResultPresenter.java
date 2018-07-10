package com.lixin.takeoutfood.rider.ui.presenter;

import android.content.Intent;

import com.lixin.takeoutfood.rider.ui.activity.MainActivity;
import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.view.PayResultView;

public class PayResultPresenter extends BasePresenter<PayResultView> {
    public PayResultPresenter(PayResultView view) {
        super(view);
    }

    public void goBack() {
        Intent intent = new Intent(activity, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivity(intent);
    }
}

package com.lixin.takeoutfood.rider.ui.presenter;

import android.content.Intent;

import com.lixin.takeoutfood.rider.ui.activity.LoginActivity;
import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.view.ForgetPasswordView;

public class ForgetPasswordPresenter extends BasePresenter<ForgetPasswordView> {
    public ForgetPasswordPresenter(ForgetPasswordView view) {
        super(view);
    }

    public void submit() {
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        activity.startActivity(intent);
    }
}

package com.lixin.takeoutfood.rider.ui.presenter;

import com.lixin.takeoutfood.rider.ui.activity.ResetPassWordActivity;
import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.view.SetPasswordValidateView;

public class SetPasswordValidatePresenter extends BasePresenter<SetPasswordValidateView> {
    public SetPasswordValidatePresenter(SetPasswordValidateView view) {
        super(view);
    }

    public void next() {
        startActivity(ResetPassWordActivity.class);
    }
}

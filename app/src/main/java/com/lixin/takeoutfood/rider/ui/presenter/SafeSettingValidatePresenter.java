package com.lixin.takeoutfood.rider.ui.presenter;

import com.lixin.takeoutfood.rider.ui.activity.ResetPassWordActivity;
import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.view.SafeSettingValidateView;

public class SafeSettingValidatePresenter extends BasePresenter<SafeSettingValidateView> {

    public SafeSettingValidatePresenter(SafeSettingValidateView view) {
        super(view);
    }

    public void next() {
        startActivity(ResetPassWordActivity.class);
    }
}


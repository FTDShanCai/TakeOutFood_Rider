package com.lixin.takeoutfood.rider.ui.presenter;

import com.lixin.takeoutfood.rider.ui.activity.SafeSettingValidateActivity;
import com.lixin.takeoutfood.rider.ui.activity.SetPasswordValidateActivity;
import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.view.SafeSettingView;


public class SafeSettingPresenter extends BasePresenter<SafeSettingView> {
    public SafeSettingPresenter(SafeSettingView view) {
        super(view);
    }

    public void resetPayPW() {
        startActivity(SafeSettingValidateActivity.class);
    }

    public void resetLoginPW() {
        startActivity(SetPasswordValidateActivity.class);
    }
}

package com.lixin.takeoutfood.rider.ui.presenter;

import com.lixin.takeoutfood.rider.ui.activity.ForgetPasswordActivity;
import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.view.ValidateIdentityView;

public class ValidateIdentityPresenter extends BasePresenter<ValidateIdentityView> {
    public ValidateIdentityPresenter(ValidateIdentityView view) {
        super(view);
    }

    public void next() {
        startActivity(ForgetPasswordActivity.class);
    }
}

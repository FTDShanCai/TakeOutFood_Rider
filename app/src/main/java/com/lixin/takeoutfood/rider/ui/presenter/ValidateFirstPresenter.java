package com.lixin.takeoutfood.rider.ui.presenter;

import com.lixin.takeoutfood.rider.ui.activity.ValidateSecondActivity;
import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.view.ValidateFirstView;

public class ValidateFirstPresenter extends BasePresenter<ValidateFirstView> {

    public ValidateFirstPresenter(ValidateFirstView view) {
        super(view);
    }

    public void goNext() {
        startActivity(ValidateSecondActivity.class);
    }
}

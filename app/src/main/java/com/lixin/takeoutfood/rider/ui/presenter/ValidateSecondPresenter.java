package com.lixin.takeoutfood.rider.ui.presenter;

import com.lixin.takeoutfood.rider.ui.activity.ValidateResultActivity;
import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.view.ValidateSecondView;

public class ValidateSecondPresenter extends BasePresenter<ValidateSecondView> {

    public ValidateSecondPresenter(ValidateSecondView view) {
        super(view);
    }

    public void submit() {
        startActivity(ValidateResultActivity.class);
    }
}

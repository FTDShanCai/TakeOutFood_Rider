package com.lixin.takeoutfood.rider.ui.presenter;

import com.lixin.takeoutfood.rider.ui.activity.MainActivity;
import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.view.ValidateResultView;

public class ValidateResultPresenter extends BasePresenter<ValidateResultView> {

    public ValidateResultPresenter(ValidateResultView view) {
        super(view);
    }

    public void submit() {
        startActivity(MainActivity.class);
    }
}

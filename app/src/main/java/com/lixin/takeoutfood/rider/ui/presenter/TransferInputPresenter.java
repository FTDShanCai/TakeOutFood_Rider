package com.lixin.takeoutfood.rider.ui.presenter;

import com.lixin.takeoutfood.rider.ui.activity.TransferAccountsActivity;
import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.view.TransferInputView;

public class TransferInputPresenter extends BasePresenter<TransferInputView> {

    public TransferInputPresenter(TransferInputView view) {
        super(view);
    }

    public void goNext() {
        startActivity(TransferAccountsActivity.class);
    }
}

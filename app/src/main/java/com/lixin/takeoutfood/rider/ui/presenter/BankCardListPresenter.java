package com.lixin.takeoutfood.rider.ui.presenter;

import com.lixin.takeoutfood.rider.ui.activity.AddBankCardActivity;
import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.view.BankCardListView;

public class BankCardListPresenter extends BasePresenter<BankCardListView> {

    public BankCardListPresenter(BankCardListView view) {
        super(view);
    }

    public void goEditItem() {
        startActivity(AddBankCardActivity.class);
    }

    public void goAdd() {
        startActivity(AddBankCardActivity.class);
    }
}

package com.lixin.takeoutfood.rider.ui.presenter;

import com.lixin.takeoutfood.rider.ui.activity.ExtractActivity;
import com.lixin.takeoutfood.rider.ui.activity.MyBillActivity;
import com.lixin.takeoutfood.rider.ui.activity.TransferAccountsActivity;
import com.lixin.takeoutfood.rider.ui.activity.TransferInputActivity;
import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.view.MyWalletView;

public class MyWalletPresenter extends BasePresenter<MyWalletView> {
    public MyWalletPresenter(MyWalletView view) {
        super(view);
    }

    public void goExtract() {
        startActivity(ExtractActivity.class);
    }

    public void goTransferAccounts() {
        startActivity(TransferInputActivity.class);
    }

    public void goMyBill() {
        startActivity(MyBillActivity.class);
    }
}

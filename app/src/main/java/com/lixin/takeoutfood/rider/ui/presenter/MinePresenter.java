package com.lixin.takeoutfood.rider.ui.presenter;

import com.lixin.takeoutfood.rider.ui.activity.BankCardListActivity;
import com.lixin.takeoutfood.rider.ui.activity.MessageActivity;
import com.lixin.takeoutfood.rider.ui.activity.MyWalletActivity;
import com.lixin.takeoutfood.rider.ui.activity.PayDepositActivity;
import com.lixin.takeoutfood.rider.ui.activity.PersonalActivity;
import com.lixin.takeoutfood.rider.ui.activity.SettingActivity;
import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.view.MineView;

public class MinePresenter extends BasePresenter<MineView> {
    public MinePresenter(MineView view) {
        super(view);
    }

    public void goPersonal() {
        startActivity(PersonalActivity.class);
    }

    public void goMyWallet() {
        startActivity(MyWalletActivity.class);
    }

    public void goBankCard() {
        startActivity(BankCardListActivity.class);
    }

    public void goPayDeposit() {
        startActivity(PayDepositActivity.class);
    }

    public void goMessage() {
        startActivity(MessageActivity.class);
    }

    public void goKefu() {
//        startActivity();
    }

    public void goSetting() {
        startActivity(SettingActivity.class);
    }

}

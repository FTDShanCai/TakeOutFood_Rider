package com.lixin.takeoutfood.rider.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.ui.base.BaseActivity;
import com.lixin.takeoutfood.rider.ui.presenter.MyWalletPresenter;
import com.lixin.takeoutfood.rider.ui.view.MyWalletView;
import com.lixin.takeoutfood.rider.util.StatusBarUtil;

import butterknife.BindView;

public class MyWalletActivity extends BaseActivity<MyWalletPresenter> implements MyWalletView, View.OnClickListener {

    @BindView(R.id.tool_bar)
    Toolbar tool_bar;

    @BindView(R.id.tv_price_my)
    TextView tv_price_my;
    @BindView(R.id.tv_price_rmb)
    TextView tv_price_rmb;

    @BindView(R.id.tv_extract)
    TextView tv_extract;
    @BindView(R.id.tv_transfer_accounts)
    TextView tv_transfer_accounts;
    @BindView(R.id.tv_my_bill)
    TextView tv_my_bill;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_wallet;
    }

    @Override
    protected MyWalletPresenter getPresenter() {
        return new MyWalletPresenter(this);
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        initToolbar(tool_bar, R.string.wallet_title);

        tv_extract.setOnClickListener(this);
        tv_transfer_accounts.setOnClickListener(this);
        tv_my_bill.setOnClickListener(this);

    }

    @Override
    public void ToastMessage(String msg) {
        toast(msg);
    }
    @Override
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorAccent), 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_extract:
                presenter.goExtract();
                break;
            case R.id.tv_transfer_accounts:
                presenter.goTransferAccounts();
                break;
            case R.id.tv_my_bill:
                presenter.goMyBill();
                break;
        }
    }
}

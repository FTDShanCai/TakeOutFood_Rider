package com.lixin.takeoutfood.rider.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;

import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.ui.base.BaseActivity;
import com.lixin.takeoutfood.rider.ui.presenter.TransferAccountsPresenter;
import com.lixin.takeoutfood.rider.ui.view.TransferAccountsView;
import com.lixin.takeoutfood.rider.util.StatusBarUtil;

import butterknife.BindView;

public class TransferAccountsActivity extends BaseActivity<TransferAccountsPresenter> implements TransferAccountsView {

    @BindView(R.id.tool_bar)
    Toolbar tool_bar;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_transfer_accounts;
    }

    @Override
    protected TransferAccountsPresenter getPresenter() {
        return new TransferAccountsPresenter(this);
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        initToolbar(tool_bar, R.string.transfer_accounts);
    }

    @Override
    public void ToastMessage(String msg) {
        toast(msg);
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorAccent), 0);
    }
}

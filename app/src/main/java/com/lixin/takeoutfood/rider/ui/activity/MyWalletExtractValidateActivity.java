package com.lixin.takeoutfood.rider.ui.activity;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.ui.base.BaseActivity;
import com.lixin.takeoutfood.rider.ui.presenter.MyWalletExtractValidatePresenter;
import com.lixin.takeoutfood.rider.ui.view.MyWalletExtractValidateView;
import com.lixin.takeoutfood.rider.util.StatusBarUtil;

import butterknife.BindView;

public class MyWalletExtractValidateActivity extends BaseActivity<MyWalletExtractValidatePresenter> implements MyWalletExtractValidateView {

    @BindView(R.id.tool_bar)
    Toolbar tool_bar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_wallet_extract_validate;
    }

    @Override
    protected MyWalletExtractValidatePresenter getPresenter() {
        return new MyWalletExtractValidatePresenter(this);
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        initToolbar(tool_bar,R.string.validate_title);
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

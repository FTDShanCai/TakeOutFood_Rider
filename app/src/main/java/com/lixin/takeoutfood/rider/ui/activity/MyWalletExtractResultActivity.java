package com.lixin.takeoutfood.rider.ui.activity;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.ui.base.BaseActivity;
import com.lixin.takeoutfood.rider.ui.presenter.MyWalletExtractResultPresenter;
import com.lixin.takeoutfood.rider.ui.view.MyWalletExtractResultView;
import com.lixin.takeoutfood.rider.util.StatusBarUtil;

import butterknife.BindView;

public class MyWalletExtractResultActivity extends BaseActivity<MyWalletExtractResultPresenter> implements MyWalletExtractResultView {

    @BindView(R.id.tool_bar)
    Toolbar tool_bar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_wallet_extract_result;
    }

    @Override
    protected MyWalletExtractResultPresenter getPresenter() {
        return new MyWalletExtractResultPresenter(this);
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        initToolbar(tool_bar, R.string.safe_setting_validate_title);
    }

    @Override
    public void ToastMessage(String msg) {
        toast(msg);
    }
}

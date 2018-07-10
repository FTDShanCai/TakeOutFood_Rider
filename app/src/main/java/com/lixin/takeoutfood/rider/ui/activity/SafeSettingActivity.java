package com.lixin.takeoutfood.rider.ui.activity;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.ui.base.BaseActivity;
import com.lixin.takeoutfood.rider.ui.presenter.SafeSettingPresenter;
import com.lixin.takeoutfood.rider.ui.view.SafeSettingView;
import com.lixin.takeoutfood.rider.util.StatusBarUtil;

import butterknife.BindView;

public class SafeSettingActivity extends BaseActivity<SafeSettingPresenter> implements SafeSettingView, View.OnClickListener {

    @BindView(R.id.tool_bar)
    Toolbar toolbar;
    @BindView(R.id.tv_reset_pay_password)
    TextView tv_reset_pay_password;
    @BindView(R.id.tv_reset_login_password)
    TextView tv_reset_login_password;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_safe_setting;
    }

    @Override
    protected SafeSettingPresenter getPresenter() {
        return new SafeSettingPresenter(this);
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        initToolbar(toolbar, R.string.safe_set_title);
        tv_reset_pay_password.setOnClickListener(this);
        tv_reset_login_password.setOnClickListener(this);
    }

    @Override
    public void ToastMessage(String msg) {
        toast(msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_reset_pay_password:
                presenter.resetPayPW();
                break;
            case R.id.tv_reset_login_password:
                presenter.resetLoginPW();
                break;
        }
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorAccent), 0);
    }
}

package com.lixin.takeoutfood.rider.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;

import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.ui.base.BaseActivity;
import com.lixin.takeoutfood.rider.ui.presenter.ResetPassWordPresenter;
import com.lixin.takeoutfood.rider.ui.view.ResetPassWordView;
import com.lixin.takeoutfood.rider.util.StatusBarUtil;

import butterknife.BindView;


//提现和登录 密码的修改

public class ResetPassWordActivity extends BaseActivity<ResetPassWordPresenter> implements ResetPassWordView {
    @BindView(R.id.tool_bar)
    Toolbar toolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_reset_pass_word;
    }

    @Override
    protected ResetPassWordPresenter getPresenter() {
        return new ResetPassWordPresenter(this);
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        initToolbar(toolbar, R.string.reset_password_title_1);
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

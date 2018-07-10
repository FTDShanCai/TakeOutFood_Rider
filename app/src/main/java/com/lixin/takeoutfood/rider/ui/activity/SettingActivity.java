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
import com.lixin.takeoutfood.rider.ui.presenter.SettingPresenter;
import com.lixin.takeoutfood.rider.ui.view.SettingView;
import com.lixin.takeoutfood.rider.util.StatusBarUtil;

import butterknife.BindView;

public class SettingActivity extends BaseActivity<SettingPresenter> implements SettingView, View.OnClickListener {

    @BindView(R.id.tool_bar)
    Toolbar tool_bar;

    @BindView(R.id.tv_safe_set)
    TextView tv_safe_set;
    @BindView(R.id.tv_about_us)
    TextView tv_about_us;
    @BindView(R.id.tv_feed_back)
    TextView tv_feed_back;
    @BindView(R.id.tv_login_out)
    TextView tv_login_out;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected SettingPresenter getPresenter() {
        return new SettingPresenter(this);
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        initToolbar(tool_bar, R.string.setting_title);

        tv_safe_set.setOnClickListener(this);
        tv_about_us.setOnClickListener(this);
        tv_feed_back.setOnClickListener(this);
        tv_login_out.setOnClickListener(this);
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
            case R.id.tv_safe_set:
                presenter.goSet();
                break;
            case R.id.tv_about_us:
                presenter.goAboutUs();
                break;
            case R.id.tv_feed_back:
                presenter.goFeedBack();
                break;
            case R.id.tv_login_out:
                presenter.goLoginOut();
                break;
        }
    }
}

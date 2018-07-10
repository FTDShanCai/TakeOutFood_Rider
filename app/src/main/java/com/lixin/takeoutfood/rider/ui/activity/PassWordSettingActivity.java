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
import com.lixin.takeoutfood.rider.ui.presenter.PassWordSettingPresenter;
import com.lixin.takeoutfood.rider.ui.view.PassWordSettingView;
import com.lixin.takeoutfood.rider.util.StatusBarUtil;

import butterknife.BindView;

public class PassWordSettingActivity extends BaseActivity<PassWordSettingPresenter> implements PassWordSettingView, View.OnClickListener {

    @BindView(R.id.tool_bar)
    Toolbar tool_bar;
    @BindView(R.id.tv_submit)
    TextView tv_submit;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pass_word_setting;
    }

    @Override
    protected PassWordSettingPresenter getPresenter() {
        return new PassWordSettingPresenter(this);
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        initToolbar(tool_bar, R.string.password_set_title);
        tv_submit.setOnClickListener(this);
    }


    @Override
    public void ToastMessage(String msg) {
        toast(msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_submit:
                presenter.submit();
                break;
        }
    }
}

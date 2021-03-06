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
import com.lixin.takeoutfood.rider.ui.presenter.ValidateIdentityPresenter;
import com.lixin.takeoutfood.rider.ui.view.ValidateIdentityView;
import com.lixin.takeoutfood.rider.util.StatusBarUtil;

import butterknife.BindView;

public class ValidateIdentityActivity extends BaseActivity<ValidateIdentityPresenter> implements ValidateIdentityView,View.OnClickListener {

    @BindView(R.id.tool_bar)
    Toolbar tool_bar;
    @BindView(R.id.tv_next)
    TextView tv_next;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_validate_identity;
    }

    @Override
    protected ValidateIdentityPresenter getPresenter() {
        return new ValidateIdentityPresenter(this);
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        initToolbar(tool_bar,R.string.validate_submit);
        tv_next.setOnClickListener(this);
    }

    @Override
    public void ToastMessage(String msg) {
        toast(msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_next:
                presenter.next();
                break;
        }
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorAccent), 0);
    }
}

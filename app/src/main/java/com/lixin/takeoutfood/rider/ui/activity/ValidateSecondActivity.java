package com.lixin.takeoutfood.rider.ui.activity;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.ui.base.BaseActivity;
import com.lixin.takeoutfood.rider.ui.presenter.ValidateSecondPresenter;
import com.lixin.takeoutfood.rider.ui.view.ValidateSecondView;
import com.lixin.takeoutfood.rider.util.StatusBarUtil;

import butterknife.BindView;

public class ValidateSecondActivity extends BaseActivity<ValidateSecondPresenter> implements ValidateSecondView, View.OnClickListener {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_submit)
    TextView tv_submit;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_validate_second;
    }

    @Override
    protected ValidateSecondPresenter getPresenter() {
        return new ValidateSecondPresenter(this);
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        tv_title.setText(R.string.validate_submit);
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

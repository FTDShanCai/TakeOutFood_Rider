package com.lixin.takeoutfood.rider.ui.activity;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.ui.base.BaseActivity;
import com.lixin.takeoutfood.rider.ui.presenter.ValidateFirstPresenter;
import com.lixin.takeoutfood.rider.ui.view.ValidateFirstView;
import com.lixin.takeoutfood.rider.util.StatusBarUtil;

import butterknife.BindView;

public class ValidateFirstActivity extends BaseActivity<ValidateFirstPresenter> implements ValidateFirstView, View.OnClickListener {
    @BindView(R.id.tv_next)
    TextView tv_next;

    @BindView(R.id.tv_title)
    TextView tv_title;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_validate_first;
    }

    @Override
    protected ValidateFirstPresenter getPresenter() {
        return new ValidateFirstPresenter(this);
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        tv_title.setText(R.string.rider);
        tv_next.setOnClickListener(this);
    }

    @Override
    public void ToastMessage(String msg) {
        toast(msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_next:
                presenter.goNext();
                break;
        }
    }
}

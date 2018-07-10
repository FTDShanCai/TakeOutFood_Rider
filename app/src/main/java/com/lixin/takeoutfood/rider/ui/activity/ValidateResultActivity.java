package com.lixin.takeoutfood.rider.ui.activity;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.ui.base.BaseActivity;
import com.lixin.takeoutfood.rider.ui.presenter.ValidateResultPresenter;
import com.lixin.takeoutfood.rider.ui.view.ValidateResultView;
import com.lixin.takeoutfood.rider.util.StatusBarUtil;

import butterknife.BindView;

public class ValidateResultActivity extends BaseActivity<ValidateResultPresenter> implements ValidateResultView, View.OnClickListener {
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_submit)
    TextView tv_submit;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_validate_result;
    }

    @Override
    protected ValidateResultPresenter getPresenter() {
        return new ValidateResultPresenter(this);
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        tv_title.setText(R.string.result);
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

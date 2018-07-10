package com.lixin.takeoutfood.rider.ui.activity;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.ui.base.BaseActivity;
import com.lixin.takeoutfood.rider.ui.presenter.PayResultPresenter;
import com.lixin.takeoutfood.rider.ui.view.PayResultView;
import com.lixin.takeoutfood.rider.util.StatusBarUtil;

import butterknife.BindView;

public class PayResultActivity extends BaseActivity<PayResultPresenter> implements PayResultView, View.OnClickListener {

    @BindView(R.id.tv_back)
    TextView tv_back;

    @BindView(R.id.tv_title)
    TextView tv_title;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pay_result;
    }

    @Override
    protected PayResultPresenter getPresenter() {
        return new PayResultPresenter(this);
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        tv_title.setText(R.string.result);
        tv_back.setOnClickListener(this);
    }

    @Override
    public void ToastMessage(String msg) {
        toast(msg);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                presenter.goBack();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        presenter.goBack();
    }
}

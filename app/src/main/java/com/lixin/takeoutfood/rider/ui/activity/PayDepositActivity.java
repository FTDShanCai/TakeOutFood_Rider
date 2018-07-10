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
import com.lixin.takeoutfood.rider.ui.presenter.PayDepositPresenter;
import com.lixin.takeoutfood.rider.ui.view.PayDepositView;
import com.lixin.takeoutfood.rider.ui.widget.MyDialogs.PassWordDialog;
import com.lixin.takeoutfood.rider.util.StatusBarUtil;

import butterknife.BindView;

public class PayDepositActivity extends BaseActivity<PayDepositPresenter> implements PayDepositView, View.OnClickListener {

    @BindView(R.id.tool_bar)
    Toolbar tool_bar;

    @BindView(R.id.tv_pay)
    TextView tv_pay;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pay_deposit;
    }

    @Override
    protected PayDepositPresenter getPresenter() {
        return new PayDepositPresenter(this);
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        initToolbar(tool_bar, R.string.pay_deposit_title);
        tv_pay.setOnClickListener(this);
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
            case R.id.tv_pay:
                showPassWordDialog();
                break;
        }
    }

    private void showPassWordDialog() {
        PassWordDialog dialog = new PassWordDialog(this);
        dialog.setOnPayClickListener(new PassWordDialog.OnPayClickListener() {
            @Override
            public void onPayClick() {
                presenter.goPay();
            }
        });
        dialog.show();
    }
}

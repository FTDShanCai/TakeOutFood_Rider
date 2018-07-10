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
import com.lixin.takeoutfood.rider.ui.presenter.TransferInputPresenter;
import com.lixin.takeoutfood.rider.ui.view.TransferInputView;
import com.lixin.takeoutfood.rider.util.StatusBarUtil;

import butterknife.BindView;

public class TransferInputActivity extends BaseActivity<TransferInputPresenter> implements TransferInputView,View.OnClickListener {


    @BindView(R.id.tool_bar)
    Toolbar tool_bar;

    @BindView(R.id.tv_next)
    TextView tv_next;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_transfer_input;
    }

    @Override
    protected TransferInputPresenter getPresenter() {
        return new TransferInputPresenter(this);
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        initToolbar(tool_bar,R.string.transfer_accounts);
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
        switch (v.getId()){
            case R.id.tv_next:
                presenter.goNext();
                break;
        }
    }
}

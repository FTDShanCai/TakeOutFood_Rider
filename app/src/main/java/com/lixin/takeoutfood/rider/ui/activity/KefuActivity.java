package com.lixin.takeoutfood.rider.ui.activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.ui.base.BaseActivity;
import com.lixin.takeoutfood.rider.ui.presenter.KefuAPresenter;
import com.lixin.takeoutfood.rider.ui.view.KefuAView;

public class KefuActivity extends BaseActivity<KefuAPresenter> implements KefuAView {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_kefu;
    }

    @Override
    protected KefuAPresenter getPresenter() {
        return new KefuAPresenter(this);
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void ToastMessage(String msg) {

    }
}

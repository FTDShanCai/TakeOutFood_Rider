package com.lixin.takeoutfood.rider.ui.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lixin.takeoutfood.rider.App;
import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.util.StatusBarUtil;
import com.trello.navi2.component.support.NaviAppCompatActivity;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.navi.NaviLifecycle;

import butterknife.ButterKnife;


public abstract class BaseActivity<T extends BasePresenter> extends NaviAppCompatActivity {
    protected final LifecycleProvider<ActivityEvent> provider
            = NaviLifecycle.createActivityLifecycleProvider(this);

    protected abstract int getLayoutId();

    protected abstract T getPresenter();

    protected abstract void initViews(@Nullable Bundle savedInstanceState);

    public T presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        setStatusBar();
        presenter = getPresenter();
        if (presenter != null) {
            presenter.setActivity(this);
            presenter.setProvider_activity(provider);
        }
        initViews(savedInstanceState);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
            presenter = null;
        }
    }

    public void initToolbar(Toolbar toolbar, int title) {
        initToolbar(toolbar, getResources().getString(title));
    }


    public void initToolbar(Toolbar toolbar, String title) {
        toolbar.setTitle("");
        TextView tv_title = toolbar.findViewById(R.id.tv_title);
        ImageView iv_back = toolbar.findViewById(R.id.iv_back);
        setSupportActionBar(toolbar);
        tv_title.setText(title);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }


    protected void setStatusBar() {
        StatusBarUtil.StatusBarLightMode(this);
    }

    public void toast(final String text) {
        if (TextUtils.isEmpty(text))
            return;

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(App.getInstance(), text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

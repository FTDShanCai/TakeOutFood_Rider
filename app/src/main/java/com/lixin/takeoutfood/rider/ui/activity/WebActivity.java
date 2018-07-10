package com.lixin.takeoutfood.rider.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.lixin.takeoutfood.rider.Contants;
import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.ui.base.BaseActivity;
import com.lixin.takeoutfood.rider.ui.presenter.WebPresenter;
import com.lixin.takeoutfood.rider.ui.view.WebView;
import com.lixin.takeoutfood.rider.util.StatusBarUtil;

import butterknife.BindView;

public class WebActivity extends BaseActivity<WebPresenter> implements WebView {
    @BindView(R.id.tool_bar)
    Toolbar tool_bar;
    @BindView(R.id.web_view)
    android.webkit.WebView web_view;
    @BindView(R.id.head_progressBar)
    ProgressBar progressBar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    protected WebPresenter getPresenter() {
        return new WebPresenter(this);
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        presenter.getIntent(getIntent());
        initWebView();
    }

    private void initWebView() {
        web_view.setWebViewClient(new WebViewClient());
        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(android.webkit.WebView view, int newProgress) {
                if (newProgress == 100) {
                    // 网页加载完成
                    progressBar.setVisibility(View.GONE);
                } else {
                    // 加载中
                    progressBar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });

    }

    @Override
    public void setData(String title, String url) {
        initToolbar(tool_bar, title);
        web_view.loadUrl(url);
    }

    public static void goWeb(Activity activity, String title, String url) {
        Intent intent = new Intent(activity, WebActivity.class);
        intent.putExtra(Contants.B_TITLE, title);
        intent.putExtra(Contants.B_URL, url);
        activity.startActivity(intent);
    }

    @Override
    public void ToastMessage(String msg) {
        toast(msg);
    }

}

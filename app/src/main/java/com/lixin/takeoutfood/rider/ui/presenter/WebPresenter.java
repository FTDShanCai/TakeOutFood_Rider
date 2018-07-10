package com.lixin.takeoutfood.rider.ui.presenter;

import android.content.Intent;
import android.text.TextUtils;

import com.lixin.takeoutfood.rider.Contants;
import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.view.WebView;

public class WebPresenter extends BasePresenter<WebView> {
    private String url;
    private String title;

    public WebPresenter(WebView view) {
        super(view);
    }

    public void getIntent(Intent intent) {
        if (intent != null) {
            url = intent.getStringExtra(Contants.B_URL);
            title = intent.getStringExtra(Contants.B_TITLE);
        }

        if (!TextUtils.isEmpty(url)) {
            view.get().setData(title, url);
        }
    }
}

package com.lixin.takeoutfood.rider.ui.presenter;

import android.content.Intent;

import com.lixin.takeoutfood.rider.ui.activity.FeedBackActivity;
import com.lixin.takeoutfood.rider.ui.activity.LoginActivity;
import com.lixin.takeoutfood.rider.ui.activity.SafeSettingActivity;
import com.lixin.takeoutfood.rider.ui.activity.SettingActivity;
import com.lixin.takeoutfood.rider.ui.activity.WebActivity;
import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.view.SettingView;

public class SettingPresenter extends BasePresenter<SettingView> {
    public SettingPresenter(SettingView view) {
        super(view);
    }

    public void goSet() {
        startActivity(SafeSettingActivity.class);
    }

    public void goAboutUs() {
        WebActivity.goWeb(activity, "关于我们", "https://www.baidu.com");
    }

    public void goFeedBack() {
        startActivity(FeedBackActivity.class);
    }

    public void goLoginOut() {
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        activity.startActivity(intent);
    }
}

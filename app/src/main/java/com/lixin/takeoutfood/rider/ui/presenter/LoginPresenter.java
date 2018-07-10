package com.lixin.takeoutfood.rider.ui.presenter;

import com.lixin.takeoutfood.rider.bean.BaseResultBean;
import com.lixin.takeoutfood.rider.net.NetObserver;
import com.lixin.takeoutfood.rider.net.RetrofitUtil;
import com.lixin.takeoutfood.rider.net.RxProgress;
import com.lixin.takeoutfood.rider.net.RxSchedulers;
import com.lixin.takeoutfood.rider.ui.activity.ForgetPasswordActivity;
import com.lixin.takeoutfood.rider.ui.activity.RegisterActivity;
import com.lixin.takeoutfood.rider.ui.activity.ValidateFirstActivity;
import com.lixin.takeoutfood.rider.ui.activity.ValidateIdentityActivity;
import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.base.BaseView;
import com.lixin.takeoutfood.rider.ui.view.ValidateIdentityView;
import com.trello.rxlifecycle2.android.ActivityEvent;

public class LoginPresenter extends BasePresenter<BaseView> {

    public LoginPresenter(BaseView view) {
        super(view);
    }

    public void Login() {
        startActivity(ValidateFirstActivity.class);
    }

    public void goRegister() {
        startActivity(RegisterActivity.class);
    }

    public void goForgetPassWord() {
        startActivity(ValidateIdentityActivity.class);
    }
}

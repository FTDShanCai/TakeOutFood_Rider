package com.lixin.takeoutfood.rider.ui.presenter;

import com.lixin.takeoutfood.rider.ui.activity.WebActivity;
import com.lixin.takeoutfood.rider.ui.base.BasePresenter;
import com.lixin.takeoutfood.rider.ui.view.MessageView;

public class MessagePresenter extends BasePresenter<MessageView> {

    public MessagePresenter(MessageView view) {
        super(view);
    }

    public void goWeb() {
        WebActivity.goWeb(activity, "消息", "https://www.baidu.com");
    }
}

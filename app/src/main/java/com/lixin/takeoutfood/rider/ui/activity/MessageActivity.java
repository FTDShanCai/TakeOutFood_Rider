package com.lixin.takeoutfood.rider.ui.activity;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.bean.BaseResultBean;
import com.lixin.takeoutfood.rider.ui.adapter.recycler.MessageAdapter;
import com.lixin.takeoutfood.rider.ui.base.BaseActivity;
import com.lixin.takeoutfood.rider.ui.listener.OnItemClickListener;
import com.lixin.takeoutfood.rider.ui.presenter.MessagePresenter;
import com.lixin.takeoutfood.rider.ui.view.MessageView;
import com.lixin.takeoutfood.rider.util.StatusBarUtil;

import butterknife.BindView;

public class MessageActivity extends BaseActivity<MessagePresenter> implements MessageView {

    @BindView(R.id.tool_bar)
    Toolbar tool_bar;

    @BindView(R.id.recycler_view)
    XRecyclerView recycler_view;

    private MessageAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    protected MessagePresenter getPresenter() {
        return new MessagePresenter(this);
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        initToolbar(tool_bar, R.string.message);
        adapter = new MessageAdapter(this);
        recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler_view.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener<BaseResultBean.DataListBean>() {
            @Override
            public void onItemClick(View view, int position, BaseResultBean.DataListBean dataListBean) {
                presenter.goWeb();
            }
        });
    }

    @Override
    public void ToastMessage(String msg) {
        toast(msg);
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorAccent), 0);
    }
}

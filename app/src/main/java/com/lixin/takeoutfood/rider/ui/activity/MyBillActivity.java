package com.lixin.takeoutfood.rider.ui.activity;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.bean.BaseResultBean;
import com.lixin.takeoutfood.rider.ui.adapter.recycler.MyBillAdapter;
import com.lixin.takeoutfood.rider.ui.base.BaseActivity;
import com.lixin.takeoutfood.rider.ui.presenter.MyBillPresenter;
import com.lixin.takeoutfood.rider.ui.view.MyBillView;
import com.lixin.takeoutfood.rider.util.StatusBarUtil;

import java.util.ArrayList;

import butterknife.BindView;

public class MyBillActivity extends BaseActivity<MyBillPresenter> implements MyBillView {

    @BindView(R.id.tool_bar)
    Toolbar tool_bar;
    @BindView(R.id.recycler_view)
    XRecyclerView recycler_view;

    private MyBillAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_bill;
    }

    @Override
    protected MyBillPresenter getPresenter() {
        return new MyBillPresenter(this);
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        initToolbar(tool_bar, R.string.my_bill);
        adapter = new MyBillAdapter(this);
        recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler_view.setAdapter(adapter);
        recycler_view.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                presenter.getList(true);
            }

            @Override
            public void onLoadMore() {
                presenter.getList(false);
            }
        });
    }

    @Override
    public void ToastMessage(String msg) {
        toast(msg);
    }

    @Override
    public void setListData(ArrayList<BaseResultBean.DataListBean> list) {
        adapter.refresh(list);
    }

    @Override
    public void setLoadMoreEnable(boolean enable) {
        recycler_view.setLoadingMoreEnabled(enable);
    }

    @Override
    public void refreshorLoadMoreComplete(boolean isRefresh) {
        if (isRefresh) {
            recycler_view.refreshComplete();
        } else {
            recycler_view.loadMoreComplete();
        }
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorAccent), 0);
    }
}

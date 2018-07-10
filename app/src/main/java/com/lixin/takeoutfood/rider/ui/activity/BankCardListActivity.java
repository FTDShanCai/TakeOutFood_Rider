package com.lixin.takeoutfood.rider.ui.activity;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.bean.BaseResultBean;
import com.lixin.takeoutfood.rider.ui.adapter.recycler.BankListAdapter;
import com.lixin.takeoutfood.rider.ui.base.BaseActivity;
import com.lixin.takeoutfood.rider.ui.listener.OnItemClickListener;
import com.lixin.takeoutfood.rider.ui.presenter.BankCardListPresenter;
import com.lixin.takeoutfood.rider.ui.view.BankCardListView;
import com.lixin.takeoutfood.rider.util.StatusBarUtil;

import butterknife.BindView;

public class BankCardListActivity extends BaseActivity<BankCardListPresenter> implements BankCardListView, View.OnClickListener {

    @BindView(R.id.tool_bar)
    Toolbar tool_bar;
    @BindView(R.id.tv_add)
    TextView tv_add;
    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;

    private BankListAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bank_card_list;
    }

    @Override
    protected BankCardListPresenter getPresenter() {
        return new BankCardListPresenter(this);
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        initToolbar(tool_bar, R.string.bank_list_title);
        recycler_view.setNestedScrollingEnabled(false);
        recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new BankListAdapter(this);
        recycler_view.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener<BaseResultBean.DataListBean>() {
            @Override
            public void onItemClick(View view, int position, BaseResultBean.DataListBean dataListBean) {
                presenter.goEditItem();
            }
        });
        tv_add.setOnClickListener(this);
    }
    @Override
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorAccent), 0);
    }
    @Override
    public void ToastMessage(String msg) {
        toast(msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_add:
                presenter.goAdd();
                break;
        }
    }
}

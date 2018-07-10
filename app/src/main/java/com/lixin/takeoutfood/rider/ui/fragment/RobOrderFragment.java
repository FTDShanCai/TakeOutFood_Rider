package com.lixin.takeoutfood.rider.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.bean.BaseResultBean;
import com.lixin.takeoutfood.rider.type.LanguageType;
import com.lixin.takeoutfood.rider.ui.adapter.recycler.RobOrderAdapter;
import com.lixin.takeoutfood.rider.ui.base.BaseFragment;
import com.lixin.takeoutfood.rider.ui.presenter.RobOrderPresenter;
import com.lixin.takeoutfood.rider.ui.view.RobOrderView;
import com.lixin.takeoutfood.rider.ui.widget.MyDialogs.LanguageChoiceDialog;

import java.util.ArrayList;

import butterknife.BindView;

public class RobOrderFragment extends BaseFragment<RobOrderPresenter> implements RobOrderView, View.OnClickListener {

    @BindView(R.id.recycler_view)
    XRecyclerView recycler_view;
    @BindView(R.id.iv_choice_language)
    ImageView iv_choice_language;
    @BindView(R.id.switch_main)
    Switch switch_main;

    private RobOrderAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_rob_order;
    }

    @Override
    protected RobOrderPresenter getPresenter() {
        return new RobOrderPresenter(this);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        adapter = new RobOrderAdapter(getActivity());
        recycler_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
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
        recycler_view.setAdapter(adapter);
        iv_choice_language.setOnClickListener(this);
    }

    @Override
    protected void lazyLoad() {
        recycler_view.refresh();
    }

    @Override
    public void ToastMessage(String msg) {
        toast(msg);
    }

    public static RobOrderFragment newInstance() {
        Bundle args = new Bundle();
        RobOrderFragment fragment = new RobOrderFragment();
        fragment.setArguments(args);
        return fragment;
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

    private LanguageType languageType = LanguageType.Chinese;

    private void showChoiceLanuageDialog() {
        LanguageChoiceDialog dialog = new LanguageChoiceDialog(getActivity(), languageType);
        dialog.setLanguageChoiceListener(new LanguageChoiceDialog.OnLanguageChoiceListener() {
            @Override
            public void onLanguageChocie(LanguageType type) {
                languageType = type;
                if (type == LanguageType.Chinese) {
                    toast("中文");
                } else {
                    toast("缅甸文");
                }
            }
        });
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_choice_language:
                showChoiceLanuageDialog();
                break;
        }
    }
}

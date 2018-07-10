package com.lixin.takeoutfood.rider.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.bean.BaseResultBean;
import com.lixin.takeoutfood.rider.net.RxSchedulers;
import com.lixin.takeoutfood.rider.ui.adapter.recycler.OrderListDetailAdapter;
import com.lixin.takeoutfood.rider.ui.base.BaseFragment;
import com.lixin.takeoutfood.rider.ui.presenter.OrderListDetailPresenter;
import com.lixin.takeoutfood.rider.ui.view.OrderListDetailView;
import com.trello.rxlifecycle2.android.FragmentEvent;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class OrderListDetailFragment extends BaseFragment<OrderListDetailPresenter> implements OrderListDetailView {
    @BindView(R.id.recycler_view)
    XRecyclerView recycler_view;

    private OrderListDetailAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_order_list_detail;
    }

    @Override
    protected OrderListDetailPresenter getPresenter() {
        return new OrderListDetailPresenter(this);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        adapter = new OrderListDetailAdapter(getActivity());
        recycler_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
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
    protected void lazyLoad() {
        Observable.timer(100, TimeUnit.MILLISECONDS)
                .compose(RxSchedulers.<Long>compose())
                .compose(provider.<Long>bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        recycler_view.refresh();
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

    public static OrderListDetailFragment newInstance() {

        Bundle args = new Bundle();

        OrderListDetailFragment fragment = new OrderListDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }
}

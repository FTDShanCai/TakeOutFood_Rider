package com.lixin.takeoutfood.rider.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lixin.takeoutfood.rider.App;
import com.trello.navi2.component.support.NaviFragment;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.navi.NaviLifecycle;

import butterknife.ButterKnife;

public abstract class BaseFragment<T extends BasePresenter> extends NaviFragment {

    protected final LifecycleProvider<FragmentEvent> provider
            = NaviLifecycle.createFragmentLifecycleProvider(this);

    protected abstract @LayoutRes
    int getLayoutId();

    public T presenter;

    protected abstract T getPresenter();

    protected abstract void initViews(Bundle savedInstanceState);

    protected abstract void lazyLoad();

    //Fragment的View加载完毕的标记
    private boolean isViewCreated;

    //Fragment对用户可见的标记
    private boolean isUIVisible;


    protected View rootView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = getPresenter();
        if (presenter != null) {
            presenter.setActivity(getActivity());
            presenter.setProvider_fragment(provider);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        initViews(savedInstanceState);
        loadData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        if (rootView != null) {
            ButterKnife.bind(this, rootView);
            return rootView;
        }

        rootView = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser) {
            isUIVisible = true;
            loadData();
        } else {
            isUIVisible = false;
        }
    }

    private void loadData() {
        if (isViewCreated && isUIVisible) {
            lazyLoad();
            isViewCreated = false;
            isUIVisible = false;
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
            presenter = null;
        }
    }

    private void initVariable() {
        isViewCreated = false;
        isUIVisible = false;
        rootView = null;
    }

    public void toast(final String text) {
        if (TextUtils.isEmpty(text))
            return;

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(App.getInstance(), text, Toast.LENGTH_SHORT).show();
            }
        });
    }

}

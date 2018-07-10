package com.lixin.takeoutfood.rider.ui.base;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;

import java.lang.ref.WeakReference;


public abstract class BasePresenter<T extends BaseView> {

    protected LifecycleProvider<FragmentEvent> provider_fragment;
    protected LifecycleProvider<ActivityEvent> provider_activity;
    protected Activity activity;

    protected WeakReference<T> view;

    public BasePresenter(T view) {
        attachView(view);
    }

    public void attachView(T view) {
        this.view = new WeakReference<T>(view);
    }

    public void setProvider_fragment(LifecycleProvider<FragmentEvent> provider_fragment) {
        this.provider_fragment = provider_fragment;
    }

    public void setProvider_activity(LifecycleProvider<ActivityEvent> provider_activity) {
        this.provider_activity = provider_activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void detachView() {
        if (view != null) {
            view.clear();
            view = null;
        }

        if (activity != null) {
            activity = null;
        }
    }

    protected void startActivity(Class<?> cls) {
        if (activity == null)
            return;
        Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
    }

}

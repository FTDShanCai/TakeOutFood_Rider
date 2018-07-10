package com.lixin.takeoutfood.rider.ui.activity;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.ui.adapter.pager.MainPagerAdapter;
import com.lixin.takeoutfood.rider.ui.base.BaseActivity;
import com.lixin.takeoutfood.rider.ui.presenter.MainPresenter;
import com.lixin.takeoutfood.rider.ui.view.MainView;
import com.lixin.takeoutfood.rider.util.ProgressDialogUtil;
import com.lixin.takeoutfood.rider.util.StatusBarUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.item.NormalItemView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.bottom_view)
    PageNavigationView bottom_view;
    @BindView(R.id.view_pager)
    ViewPager view_pager;

    private MainPagerAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        presenter.initFragments();
    }

    @Override
    public void ToastMessage(String msg) {
        toast(msg);
    }

    /**
     * 初始化menu
     */
    private void initMenus() {
        NavigationController navigationController = bottom_view.custom()
                .addItem(newItem(R.mipmap.souye, R.mipmap.souyes, R.string.main_menu_home))
                .addItem(newItem(R.mipmap.dingdan, R.mipmap.dingdans, R.string.main_menu_order))
                .addItem(newItem(R.mipmap.wode, R.mipmap.wodes, R.string.main_menu_mine))
                .build();
        navigationController.setupWithViewPager(view_pager);
    }

    private BaseTabItem newItem(int drawable, int checkedDrawable, @StringRes int textId) {
        NormalItemView normalItemView = new NormalItemView(this);
        String text = getResources().getString(textId);
        normalItemView.initialize(drawable, checkedDrawable, text);
        normalItemView.setTextDefaultColor(Color.BLACK);
        normalItemView.setTextCheckedColor(ContextCompat.getColor(this, R.color.colorAccent));
        return normalItemView;
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorAccent), 0);
    }

    @Override
    public void setFragments(ArrayList<Fragment> fragments) {
        adapter = new MainPagerAdapter(getSupportFragmentManager(), fragments);
        view_pager.setAdapter(adapter);
        initMenus();
    }
}

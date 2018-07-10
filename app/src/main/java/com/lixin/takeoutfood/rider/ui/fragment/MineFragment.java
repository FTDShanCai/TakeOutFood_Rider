package com.lixin.takeoutfood.rider.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.ui.base.BaseFragment;
import com.lixin.takeoutfood.rider.ui.presenter.MinePresenter;
import com.lixin.takeoutfood.rider.ui.view.MineView;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

public class MineFragment extends BaseFragment<MinePresenter> implements MineView, View.OnClickListener {

    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.iv_header)
    CircleImageView iv_header;
    @BindView(R.id.tv_phone)
    TextView tv_phone;

    //menu
    @BindView(R.id.tv_personal)
    TextView tv_personal;
    @BindView(R.id.tv_my_wallet)
    TextView tv_my_wallet;
    @BindView(R.id.tv_bank_card)
    TextView tv_bank_card;
    @BindView(R.id.tv_pay_deposit)
    TextView tv_pay_deposit;
    @BindView(R.id.tv_message)
    TextView tv_message;
    @BindView(R.id.tv_kefu)
    TextView tv_kefu;
    @BindView(R.id.tv_setting)
    TextView tv_setting;

    @Override
    protected int getLayoutId() {
        return R.layout.layout_fragment_mine;
    }

    @Override
    protected MinePresenter getPresenter() {
        return new MinePresenter(this);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        tv_personal.setOnClickListener(this);
        tv_my_wallet.setOnClickListener(this);
        tv_bank_card.setOnClickListener(this);
        tv_pay_deposit.setOnClickListener(this);
        tv_message.setOnClickListener(this);
        tv_kefu.setOnClickListener(this);
        tv_setting.setOnClickListener(this);
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void ToastMessage(String msg) {
        toast(msg);
    }

    public static MineFragment newInstance() {

        Bundle args = new Bundle();

        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_personal:
                presenter.goPersonal();
                break;
            case R.id.tv_my_wallet:
                presenter.goMyWallet();
                break;
            case R.id.tv_bank_card:
                presenter.goBankCard();
                break;
            case R.id.tv_pay_deposit:
                presenter.goPayDeposit();
                break;
            case R.id.tv_message:
                presenter.goMessage();
                break;
            case R.id.tv_kefu:
                presenter.goKefu();
                break;
            case R.id.tv_setting:
                presenter.goSetting();
                break;
        }
    }
}

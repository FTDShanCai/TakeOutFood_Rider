package com.lixin.takeoutfood.rider.ui.activity;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.ui.base.BaseActivity;
import com.lixin.takeoutfood.rider.ui.presenter.AddBankCardPresenter;
import com.lixin.takeoutfood.rider.ui.view.AddBankCardView;
import com.lixin.takeoutfood.rider.ui.widget.MyDialogs.BankListChoiceDialog;
import com.lixin.takeoutfood.rider.util.StatusBarUtil;

import java.util.ArrayList;

import butterknife.BindView;

public class AddBankCardActivity extends BaseActivity<AddBankCardPresenter> implements AddBankCardView, View.OnClickListener {

    @BindView(R.id.tool_bar)
    Toolbar tool_bar;

    @BindView(R.id.tv_choice_card)
    TextView tv_choice_card;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_bank_card;
    }

    @Override
    protected AddBankCardPresenter getPresenter() {
        return new AddBankCardPresenter(this);
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        initToolbar(tool_bar, R.string.add_bank_card_title);
        tv_choice_card.setOnClickListener(this);
    }

    @Override
    public void ToastMessage(String msg) {
        toast(msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_choice_card:
                showChoiceDialog();
                break;
        }
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorAccent), 0);
    }

    private String checkstr = "中国银行1";

    private void showChoiceDialog() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("中国银行" + i);
        }
        BankListChoiceDialog dialog = new BankListChoiceDialog(this, list, checkstr);
        dialog.setBottomListItemClickListener(new BankListChoiceDialog.onBottomListItemClickListener() {
            @Override
            public void onItemClick(int position, String str) {
                toast(str);
                checkstr = str;
            }
        });
        dialog.show();
    }
}

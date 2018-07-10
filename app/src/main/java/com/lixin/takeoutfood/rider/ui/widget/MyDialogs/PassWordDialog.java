package com.lixin.takeoutfood.rider.ui.widget.MyDialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lixin.takeoutfood.rider.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PassWordDialog extends Dialog implements View.OnClickListener {

    @BindView(R.id.tv_pay)
    TextView tv_pay;

    private OnPayClickListener onPayClickListener;

    public PassWordDialog(@NonNull Context context) {
        super(context);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_dialog_password, null);
        ButterKnife.bind(this, view);
        setContentView(view);

        tv_pay.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_pay:
                pay();
                break;
        }
    }

    private void pay() {
        if (onPayClickListener == null)
            return;

        onPayClickListener.onPayClick();

    }

    public void setOnPayClickListener(OnPayClickListener onPayClickListener) {
        this.onPayClickListener = onPayClickListener;
    }

    public interface OnPayClickListener {
        void onPayClick();
    }
}

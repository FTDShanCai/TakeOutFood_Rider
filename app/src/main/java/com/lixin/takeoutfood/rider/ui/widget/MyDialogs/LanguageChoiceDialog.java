package com.lixin.takeoutfood.rider.ui.widget.MyDialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.type.LanguageType;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.http.Part;

public class LanguageChoiceDialog extends Dialog implements View.OnClickListener {

    @BindView(R.id.tv_chinese)
    TextView tv_chinese;
    @BindView(R.id.tv_myanmar)
    TextView tv_myanmar;

    private LanguageType checkType;

    public LanguageChoiceDialog(@NonNull Context context, LanguageType type) {
        super(context,R.style.Theme_AppCompat_DayNight_Dialog);
        this.checkType = type;
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_dialog_language_choice, null);
        ButterKnife.bind(this, view);
        setContentView(view);
//        WindowManager wm = (WindowManager) getContext()
//                .getSystemService(Context.WINDOW_SERVICE);
//        Display display = wm.getDefaultDisplay();
//        int width = display.getWidth();
//        int height = display.getHeight();
//        Window window = this.getWindow();
//        WindowManager.LayoutParams lp = window.getAttributes();
//        window.setGravity(Gravity.CENTER);
//        lp.width = width;
//        lp.y = 0;
//        window.setAttributes(lp);
        initView();
    }

    private void initView() {

        if (checkType == LanguageType.Chinese) {
            tv_chinese.setSelected(true);
            tv_myanmar.setSelected(false);
        } else {
            tv_chinese.setSelected(false);
            tv_myanmar.setSelected(true);
        }
        tv_chinese.setOnClickListener(this);
        tv_myanmar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_chinese:
                choice(LanguageType.Chinese);
                break;
            case R.id.tv_myanmar:
                choice(LanguageType.Myanmar);
                break;
        }
    }

    private void choice(LanguageType type) {
        if (this.isShowing()) {
            this.dismiss();
        }
        if (languageChoiceListener != null) {
            languageChoiceListener.onLanguageChocie(type);
        }
    }

    private OnLanguageChoiceListener languageChoiceListener;

    public void setLanguageChoiceListener(OnLanguageChoiceListener languageChoiceListener) {
        this.languageChoiceListener = languageChoiceListener;
    }

    public interface OnLanguageChoiceListener {
        void onLanguageChocie(LanguageType type);
    }
}

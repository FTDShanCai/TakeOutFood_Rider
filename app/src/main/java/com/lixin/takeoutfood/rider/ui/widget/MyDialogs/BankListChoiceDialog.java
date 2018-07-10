package com.lixin.takeoutfood.rider.ui.widget.MyDialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.ui.adapter.recycler.BankListDialogAdapter;
import com.lixin.takeoutfood.rider.ui.listener.OnItemClickListener;
import com.lixin.takeoutfood.rider.util.LogUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BankListChoiceDialog extends Dialog {
    private Context context;

    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;

    private String checkStr = "";

    private ArrayList<String> list;

    private BankListDialogAdapter adapter;
    private LinearLayoutManager layoutManager;

    private onBottomListItemClickListener bottomListItemClickListener;

    public BankListChoiceDialog(@NonNull Context context, ArrayList<String> strings, String checkStr) {
        super(context, R.style.ActionSheetDialogStyle);
        this.context = context;
        this.list = strings;
        this.checkStr = checkStr;
        init();
    }

    private void init() {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_dialog_default_list, null);
        ButterKnife.bind(this, view);
        setContentView(view);
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        Window window = this.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.BOTTOM);
        lp.width = width;
        lp.y = 0;
        window.setAttributes(lp);
        initView();
    }

    private void initView() {
        adapter = new BankListDialogAdapter(context, checkStr);
        layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setAdapter(adapter);
        adapter.refresh(list);
        adapter.setOnItemClickListener(new OnItemClickListener<String>() {
            @Override
            public void onItemClick(View view, int position, String s) {
                if (BankListChoiceDialog.this.isShowing()) {
                    BankListChoiceDialog.this.dismiss();
                }
                if (bottomListItemClickListener == null)
                    return;
                bottomListItemClickListener.onItemClick(position, s);
            }
        });
    }


    public interface onBottomListItemClickListener {
        void onItemClick(int position, String str);
    }

    public void setBottomListItemClickListener(onBottomListItemClickListener bottomListItemClickListener) {
        this.bottomListItemClickListener = bottomListItemClickListener;
    }
}

package com.lixin.takeoutfood.rider.ui.adapter.recycler;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.ui.adapter.base.BaseRecycleAdapter;

public class BankListDialogAdapter extends BaseRecycleAdapter<String> {

    private String checkStr;

    public BankListDialogAdapter(Context context, String checkStr) {
        super(context);
        this.checkStr = checkStr;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position, String s) {
        TextView tv_text = (TextView) holder.getView(R.id.tv_text);
        ImageView iv_check = (ImageView) holder.getView(R.id.iv_check);
        tv_text.setText(s);
        iv_check.setVisibility(View.INVISIBLE);
        if (!TextUtils.isEmpty(checkStr) && checkStr.equals(s)) {
            iv_check.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public int getLayoutId() {
        return R.layout.item_dialog_bank_list;
    }
}

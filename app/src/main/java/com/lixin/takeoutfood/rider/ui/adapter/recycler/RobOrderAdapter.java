package com.lixin.takeoutfood.rider.ui.adapter.recycler;

import android.content.Context;

import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.bean.BaseResultBean;
import com.lixin.takeoutfood.rider.ui.adapter.base.BaseRecycleAdapter;

public class RobOrderAdapter extends BaseRecycleAdapter<BaseResultBean.DataListBean> {


    public RobOrderAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position, BaseResultBean.DataListBean dataListBean) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.item_rob_order;
    }
}

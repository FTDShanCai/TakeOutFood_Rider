package com.lixin.takeoutfood.rider.ui.adapter.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.swipe.SimpleSwipeListener;
import com.daimajia.swipe.SwipeLayout;
import com.lixin.takeoutfood.rider.R;
import com.lixin.takeoutfood.rider.bean.BaseResultBean;
import com.lixin.takeoutfood.rider.ui.listener.OnItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private Context context;

    private OnItemClickListener<BaseResultBean.DataListBean> onItemClickListener;

    public MessageAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_message, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.swipe.setShowMode(SwipeLayout.ShowMode.PullOut);
        holder.swipe.addSwipeListener(new SimpleSwipeListener() {
            @Override
            public void onOpen(SwipeLayout layout) {
            }
        });
        holder.swipe.setOnDoubleClickListener(new SwipeLayout.DoubleClickListener() {
            @Override
            public void onDoubleClick(SwipeLayout layout, boolean surface) {
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener == null)
                    return;
                onItemClickListener.onItemClick(holder.itemView, position, null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 25;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.swipe)
        SwipeLayout swipe;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setOnItemClickListener(OnItemClickListener<BaseResultBean.DataListBean> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}

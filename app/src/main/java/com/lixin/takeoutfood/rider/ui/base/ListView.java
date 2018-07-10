package com.lixin.takeoutfood.rider.ui.base;

import java.util.ArrayList;

public interface ListView<T> {
    void setListData(ArrayList<T> list);

    void setLoadMoreEnable(boolean enable);

    void refreshorLoadMoreComplete(boolean isRefresh);

}

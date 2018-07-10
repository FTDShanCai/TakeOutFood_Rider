package com.lixin.takeoutfood.rider.api;

import com.lixin.takeoutfood.rider.bean.BaseResultBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MapApi {
    @GET("mapshop/api/service")
    Observable<BaseResultBean> getData(@Query("json") String json);

}

package com.lixin.takeoutfood.rider.net.interceoptor;

import android.text.TextUtils;


import com.lixin.takeoutfood.rider.util.LogUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ResponseLogInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());

        if (response.body() != null && response.body().contentType() != null) {
            String json = response.body().string();
            if (!TextUtils.isEmpty(json)) {
                LogUtil.d(json);
            } else {
                LogUtil.e("json is null");
            }
            MediaType mediaType = response.body().contentType();
            ResponseBody responseBody = ResponseBody.create(mediaType, json);

            return response.newBuilder().body(responseBody).build();
        } else {
            return response;
        }

    }
}

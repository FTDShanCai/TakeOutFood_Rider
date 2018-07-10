package com.lixin.takeoutfood.rider.net;

import com.blankj.utilcode.util.FileUtils;
import com.lixin.takeoutfood.rider.App;
import com.lixin.takeoutfood.rider.api.MapApi;
import com.lixin.takeoutfood.rider.net.interceoptor.RequestLogInterceoptor;
import com.lixin.takeoutfood.rider.net.interceoptor.ResponseLogInterceptor;
import com.lixin.takeoutfood.rider.util.ImageUtil;

import java.io.File;
import java.util.concurrent.TimeUnit;

import io.reactivex.annotations.NonNull;
import okhttp3.Cache;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitUtil {

    private static RetrofitUtil util;

    public static final String url = "http://47.93.253.91/";

    public static RetrofitUtil getInstance() {
        if (util == null) {
            synchronized (RetrofitUtil.class) {
                if (util == null) {
                    util = new RetrofitUtil();
                }
            }
        }
        return util;
    }

    private OkHttpClient getClient() {
        Cache cache = new Cache(App.getInstance().getCacheDir(), 1024 * 1024);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(new RequestLogInterceoptor())
                .addInterceptor(new ResponseLogInterceptor())
                .build();
        return okHttpClient;
    }

    public MapApi getMapApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(getClient())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MapApi api = retrofit.create(MapApi.class);
        return api;
    }


    public static final String MULTIPART_FORM_DATA = "multipart/form-data";


    @NonNull
    public static MultipartBody.Part prepareFilePart(String partName, String path) {
        File file = FileUtils.getFileByPath(path);

        // 为file建立RequestBody实例
        RequestBody requestFile =
                RequestBody.create(MediaType.parse(MULTIPART_FORM_DATA), ImageUtil.saveBitmapFile(ImageUtil.getSmallBitmap(path)));

        // MultipartBody.Part借助文件名完成最终的上传
        return MultipartBody.Part.createFormData(partName, file.getName(), requestFile);
    }

}

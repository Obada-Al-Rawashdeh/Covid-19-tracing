/*
 * Made With Love
 * Author @Moh Husni Mubaraq
 * Not for Commercial Purpose
 */

package com.obadarawashdeh.covid19.Data;

import com.obadarawashdeh.covid19.Utilities.AppUtils;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceApi {

    private static Retrofit CoronaApi=new Retrofit.Builder()
            .baseUrl(AppUtils.BASE_URL_CORONA)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build();

    private static Retrofit newsApi = new Retrofit.Builder()
            .baseUrl(AppUtils.BASE_URL_NEWS)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build();

    public static APIClient getCoronaApi(){ return CoronaApi.create(APIClient.class); }
    public static APIClient getNewsApi(){ return newsApi.create(APIClient.class); }
}

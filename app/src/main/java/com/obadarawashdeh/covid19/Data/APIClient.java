package com.obadarawashdeh.covid19.Data;

import com.obadarawashdeh.covid19.Model.Articles;
import com.obadarawashdeh.covid19.Model.CoronaModel;
import com.obadarawashdeh.covid19.Model.Headlines;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIClient {

    @GET("countries/jordan")
     Single<CoronaModel> getJordanData();

    @GET("countries")
     Single<List<CoronaModel>> getCountriesData();

    @GET("everything")
     Single<Headlines> getSpecificData(@Query("q") String query, @Query("apiKey") String apiKey);
}

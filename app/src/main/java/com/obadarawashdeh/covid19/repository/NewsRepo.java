package com.obadarawashdeh.covid19.repository;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.obadarawashdeh.covid19.Data.APIClient;
import com.obadarawashdeh.covid19.Data.RetrofitServiceApi;
import com.obadarawashdeh.covid19.Model.Articles;
import com.obadarawashdeh.covid19.Model.Headlines;
import com.obadarawashdeh.covid19.Utilities.AppUtils;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NewsRepo {

    private static NewsRepo newsRepo;
    private APIClient newsApi;
    private MutableLiveData<Headlines> newsML;
    private Single<Headlines> newsS;
    private SingleObserver<Headlines> newsSO;
    public static CompositeDisposable compositeDisposable=new CompositeDisposable();
    private Context context;

    public static NewsRepo getInstance(){
        if (newsRepo == null){
            newsRepo = new NewsRepo();
        }
        return newsRepo;
    }
    private NewsRepo(){
        newsApi = RetrofitServiceApi.getNewsApi();
    }

    public MutableLiveData<Headlines> getNews(){
        newsML=new MutableLiveData<>();
        //this.context=context;

        if (Resources.getSystem().getConfiguration().locale.getLanguage().equals("ar")){
            newsS=newsApi.getSpecificData("لقاح كورونا", AppUtils.API_KEY).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }else {
            newsS=newsApi.getSpecificData("corona vaccine",AppUtils.API_KEY).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }
//        newsSO=new SingleObserver<List<Articles>>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//                compositeDisposable.add(d);
//            }
//
//            @Override
//            public void onSuccess(@NonNull List<Articles> articles) {
//                newsML.setValue(articles);
//                Log.d("art", "onSuccess: "+articles.get(0).getTitle());
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                Log.d("art", "onSuccess: "+e.getMessage());
//            }
//        };
        newsSO=new SingleObserver<Headlines>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onSuccess(@NonNull Headlines headlines) {
                newsML.setValue(headlines);
                //Log.d("art", "onSuccess: "+articles.get(0).getTitle());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("art", "onSuccess: "+e.getMessage());
            }
        };
        newsS.subscribe(newsSO);
        return newsML;
    }

//    public MutableLiveData<Boolean> checkInternet(){
//        checkInternet=new MutableLiveData<>();
//        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
//        if(isConnected==false){
//            checkInternet.setValue(isConnected);
//            return checkInternet;
//        }
//
//        return checkInternet;
//    }

}

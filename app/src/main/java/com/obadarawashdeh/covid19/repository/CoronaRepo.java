package com.obadarawashdeh.covid19.repository;

import android.content.res.Resources;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.obadarawashdeh.covid19.Data.APIClient;
import com.obadarawashdeh.covid19.Data.RetrofitServiceApi;
import com.obadarawashdeh.covid19.Model.CoronaModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CoronaRepo {
    private static CoronaRepo jordanCoronaRepo;
    private APIClient coronaApi;
    private MutableLiveData<CoronaModel> jordanCoronaML;
    private Single<CoronaModel> jordanCoronaS;
    private SingleObserver<CoronaModel> jordanCoronaSO;
    public static CompositeDisposable compositeDisposable=new CompositeDisposable();

    private MutableLiveData<List<CoronaModel>> countriesCoronaML;
    private Single<List<CoronaModel>> countriesCoronaS;
    private SingleObserver<List<CoronaModel>> countriesCoronaSO;

    private CoronaRepo(){
        coronaApi=RetrofitServiceApi.getCoronaApi();
    }
    public static CoronaRepo getInstance(){
        if(jordanCoronaRepo ==null){
            jordanCoronaRepo =new CoronaRepo();
        }
        return jordanCoronaRepo;
    }

    public MutableLiveData<CoronaModel> getData(){
        jordanCoronaML=new MutableLiveData<>();
        jordanCoronaS=coronaApi.getJordanData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        jordanCoronaSO=new SingleObserver<CoronaModel>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onSuccess(@NonNull CoronaModel coronaModel) {
                jordanCoronaML.setValue(coronaModel);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("error","cases: "+e.getMessage());
            }
        };
        jordanCoronaS.subscribe(jordanCoronaSO);
        return jordanCoronaML;
    }

    public MutableLiveData<List<CoronaModel>> getCountriesData(){
        countriesCoronaML=new MutableLiveData<>();
        countriesCoronaS=coronaApi.getCountriesData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        countriesCoronaSO=new SingleObserver<List<CoronaModel>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onSuccess(@NonNull List<CoronaModel> coronaModels) {
                countriesCoronaML.setValue(coronaModels);
            }

            @Override
            public void onError(@NonNull Throwable e) {
            }
        };
        countriesCoronaS.subscribe(countriesCoronaSO);
        return countriesCoronaML;
    }
}

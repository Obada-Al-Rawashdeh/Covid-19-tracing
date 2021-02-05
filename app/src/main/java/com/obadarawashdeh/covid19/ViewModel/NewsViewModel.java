package com.obadarawashdeh.covid19.ViewModel;

import android.content.Context;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.obadarawashdeh.covid19.Model.Articles;
import com.obadarawashdeh.covid19.Model.Headlines;
import com.obadarawashdeh.covid19.repository.NewsRepo;

import java.util.List;


public class NewsViewModel extends ViewModel {
   // private MutableLiveData<List<Articles>> newsML;
    private MutableLiveData<Headlines> newsML;
    private MutableLiveData<Boolean> checkInter;
    private NewsRepo newsRepo;


    public void init(){
        newsRepo = NewsRepo.getInstance();
        //newsML = newsRepo.getNews();
        newsML = newsRepo.getNews();
        //checkInter = newsRepo.checkInternet();
    }

//    public LiveData<List<Articles>> getNews() {
//        return newsML;
//    }
    public LiveData<Headlines> getNews() {
        return newsML;
    }
    public LiveData<Boolean> getcheck() {
        return checkInter;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        NewsRepo.compositeDisposable.clear();
    }
}


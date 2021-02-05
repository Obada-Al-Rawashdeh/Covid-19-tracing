package com.obadarawashdeh.covid19.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.obadarawashdeh.covid19.Model.CoronaModel;
import com.obadarawashdeh.covid19.repository.CoronaRepo;

import java.util.List;

public class DashboardViewModel extends ViewModel {
    private MutableLiveData<CoronaModel> jordanCoronaML;
    private MutableLiveData<List<CoronaModel>> countriesCoronaML;
    private CoronaRepo coronaRepo;

    public void init(){
        coronaRepo = CoronaRepo.getInstance();
        jordanCoronaML = coronaRepo.getData();
        countriesCoronaML = coronaRepo.getCountriesData();
    }
    public LiveData<CoronaModel> getJordanCoronaData(){

        return jordanCoronaML;
    }
    public LiveData<List<CoronaModel>> getCountriesCoronaData(){

        return countriesCoronaML;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        CoronaRepo.compositeDisposable.clear();

    }
}

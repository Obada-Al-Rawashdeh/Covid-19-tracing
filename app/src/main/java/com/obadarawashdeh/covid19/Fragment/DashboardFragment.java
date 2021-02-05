package com.obadarawashdeh.covid19.Fragment;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obadarawashdeh.covid19.Adapter.CoronaCountriesAdapter;
import com.obadarawashdeh.covid19.ViewModel.DashboardViewModel;
import com.obadarawashdeh.covid19.Model.CoronaModel;
import com.obadarawashdeh.covid19.R;

import java.util.List;
import java.util.Locale;


public class DashboardFragment extends Fragment {
    DashboardViewModel viewModel;
    private TextView tvCases;
    private TextView tvTCases;
    private TextView tvTDeathes;
    private TextView tvRecoverd;
    private TextView tvActive;
    private TextView tvDeathes;
    private RecyclerView countriesRV;
    private CoronaCountriesAdapter coronaCountriesAdapter;

    public DashboardFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvCases=view.findViewById(R.id.vCases);
        tvTCases=view.findViewById(R.id.vtodayCases);
        tvTDeathes=view.findViewById(R.id.vtodayDeaths);
        tvRecoverd=view.findViewById(R.id.vtodayRecovered);
        tvActive=view.findViewById(R.id.vactive);
        tvDeathes=view.findViewById(R.id.vdeaths);
        countriesRV=view.findViewById(R.id.countriesRV);
        countriesRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        countriesRV.setHasFixedSize(true);
        countriesRV.setNestedScrollingEnabled(true);
        inti();
        loadJordanData();
        loadCountriesData();

    }

    private void inti(){
        viewModel = new ViewModelProvider(requireActivity()).get(DashboardViewModel.class);
        viewModel.init();
    }
    private void loadJordanData() {
        viewModel.getJordanCoronaData().observe(getViewLifecycleOwner(), new Observer<CoronaModel>() {
            @Override
            public void onChanged(CoronaModel coronaModel) {
                tvCases.setText(coronaModel.getCases());
                tvTCases.setText(coronaModel.getTodayCases());
                tvActive.setText(coronaModel.getActive());
                tvTDeathes.setText(coronaModel.getTodayDeaths());
                tvDeathes.setText(coronaModel.getDeaths());
                tvRecoverd.setText(coronaModel.getTodayRecovered());
            }
        });
    }

    private void loadCountriesData() {
        viewModel.getCountriesCoronaData().observe(getViewLifecycleOwner(), new Observer<List<CoronaModel>>() {
            @Override
            public void onChanged(List<CoronaModel> coronaModels) {
                coronaCountriesAdapter=new CoronaCountriesAdapter(coronaModels);
                countriesRV.setAdapter(coronaCountriesAdapter);
            }
        });
    }
}
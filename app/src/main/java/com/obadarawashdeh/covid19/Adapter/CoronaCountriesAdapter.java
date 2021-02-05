package com.obadarawashdeh.covid19.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.obadarawashdeh.covid19.Model.CoronaModel;
import com.obadarawashdeh.covid19.R;

import java.util.List;

public class CoronaCountriesAdapter extends RecyclerView.Adapter<CoronaCountriesAdapter.CoronaCountriesVH> {
    List<CoronaModel> coronaModels;

    public CoronaCountriesAdapter(List<CoronaModel> coronaModels) {
        this.coronaModels = coronaModels;
    }

    @NonNull
    @Override
    public CoronaCountriesVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CoronaCountriesVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.countries_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CoronaCountriesVH holder, int position) {
        CoronaModel coronaModel=coronaModels.get(position);
        holder.country.setText(coronaModel.getCountry());
        holder.cases.setText(coronaModel.getCases());
        holder.deaths.setText(coronaModel.getDeaths());
        holder.recovered.setText(coronaModel.getRecovered());
    }

    @Override
    public int getItemCount() {
        return coronaModels.size();
    }

    public class CoronaCountriesVH extends RecyclerView.ViewHolder {
        TextView country;
        TextView cases;
        TextView deaths;
        TextView recovered;
        public CoronaCountriesVH(@NonNull View itemView) {
            super(itemView);
            country=itemView.findViewById(R.id.rCountry);
            cases=itemView.findViewById(R.id.rCases);
            deaths=itemView.findViewById(R.id.rDeaths);
            recovered=itemView.findViewById(R.id.rRecovered);
        }
    }
}

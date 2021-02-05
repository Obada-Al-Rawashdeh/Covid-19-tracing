package com.obadarawashdeh.covid19.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.obadarawashdeh.covid19.Model.CoronaModel;
import com.obadarawashdeh.covid19.R;
import com.obadarawashdeh.covid19.ViewModel.DashboardViewModel;

public class TestAct extends AppCompatActivity {
    TextView t;
    TextView tt;
    TextView ttt;
    TextView tttt;
    TextView ttttt;
    DashboardViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        t=findViewById(R.id.textView3);
         tt=findViewById(R.id.textView4);
         ttt=findViewById(R.id.textView5);
         tttt=findViewById(R.id.textView6);
         ttttt=findViewById(R.id.textView);
         loadWorldData();
    }

    private void loadWorldData() {
        viewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        viewModel.init();
        viewModel.getJordanCoronaData().observe(this, new Observer<CoronaModel>() {
            @Override
            public void onChanged(CoronaModel coronaModel) {


                //tvCases.setText(jordanCoronaModel.getCases());
                t.setText("fhh");
                tt.setText(coronaModel.getTodayCases());
                ttt.setText(coronaModel.getActive());
                tttt.setText(coronaModel.getTodayDeaths());
                ttttt.setText(coronaModel.getTodayRecovered());
            }
        });
    }
}
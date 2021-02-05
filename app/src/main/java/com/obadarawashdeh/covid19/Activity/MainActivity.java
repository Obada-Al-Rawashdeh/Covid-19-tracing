package com.obadarawashdeh.covid19.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.obadarawashdeh.covid19.Fragment.DashboardFragment;
import com.obadarawashdeh.covid19.Fragment.HelpFragment;
import com.obadarawashdeh.covid19.Fragment.InfoFragment;
import com.obadarawashdeh.covid19.Fragment.NewsFragment;
import com.obadarawashdeh.covid19.R;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new DashboardFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                switch (item.getItemId()){
                    case R.id.mDashboard:
                        fragment=new DashboardFragment();
                        break;

                    case R.id.mInfo:
                        fragment=new InfoFragment();
                        break;

                    case R.id.mNews:
                        fragment=new NewsFragment();
                        break;

                    case R.id.mHelp:
                        fragment=new HelpFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
                return true;
            }
        });
    }


}
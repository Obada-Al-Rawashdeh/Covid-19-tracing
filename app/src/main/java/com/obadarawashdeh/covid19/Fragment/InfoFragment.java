package com.obadarawashdeh.covid19.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.obadarawashdeh.covid19.Adapter.InfoAdapter;
import com.obadarawashdeh.covid19.Model.Info;
import com.obadarawashdeh.covid19.R;

import java.util.ArrayList;


public class InfoFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Info> infoModels;
    LinearLayoutManager linearLayoutManager;

    public InfoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView=view.findViewById(R.id.infoRv);
        infoModels=new ArrayList<>();
        infoModels.add(new Info(R.drawable.ic_virus_pana,R.string.corona1dec,R.string.corona1tit));
        infoModels.add(new Info(R.drawable.ic_corona3,R.string.corona3dec,R.string.corona3tit));
        infoModels.add(new Info(R.drawable.ic_corona2,R.string.corona2dec,R.string.corona2tit));
        infoModels.add(new Info(R.drawable.ic_corona4,R.string.corona4dec,R.string.corona4tit));
        InfoAdapter infoAdapter=new InfoAdapter(infoModels);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(infoAdapter);
    }
}
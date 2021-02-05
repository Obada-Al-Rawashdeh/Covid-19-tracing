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

import com.obadarawashdeh.covid19.Adapter.HelpAdapter;
import com.obadarawashdeh.covid19.Adapter.InfoAdapter;
import com.obadarawashdeh.covid19.Model.Help;
import com.obadarawashdeh.covid19.Model.Info;
import com.obadarawashdeh.covid19.R;

import java.util.ArrayList;


public class HelpFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Help> helpModels;
    LinearLayoutManager linearLayoutManager;

    public HelpFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_help, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);

        recyclerView=view.findViewById(R.id.helpRv);
        helpModels=new ArrayList<>();
        helpModels.add(new Help("111",R.string.help1));
        helpModels.add(new Help("032033040",R.string.help2));
        helpModels.add(new Help("0782001015",R.string.help3));
        HelpAdapter helpAdapter=new HelpAdapter(helpModels);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(helpAdapter);
//        helpModels.add(new Help());
//        helpModels.add(new Help());
//        helpModels.add(new Help());
    }

}
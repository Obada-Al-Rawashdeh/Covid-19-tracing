package com.obadarawashdeh.covid19.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.obadarawashdeh.covid19.Adapter.NewsAdapter;
import com.obadarawashdeh.covid19.Model.Articles;
import com.obadarawashdeh.covid19.Model.Headlines;
import com.obadarawashdeh.covid19.R;
import com.obadarawashdeh.covid19.ViewModel.NewsViewModel;

import java.util.List;

public class NewsFragment extends Fragment {

    private RecyclerView newsRV;
    private NewsViewModel viewModel;
    private NewsAdapter newsAdapter;

    public NewsFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newsRV=view.findViewById(R.id.newsrv);
        newsRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        newsRV.setHasFixedSize(true);
        newsRV.setNestedScrollingEnabled(true);
        inti();
        loadNewsData();

    }

    private void inti(){
        viewModel=new ViewModelProvider(requireActivity()).get(NewsViewModel.class);
        viewModel.init();
    }
//    private void loadNewsData(){
//        viewModel.getNews().observe(getViewLifecycleOwner(), new Observer<List<Articles>>() {
//            @Override
//            public void onChanged(List<Articles> articles) {
//                newsAdapter=new NewsAdapter(articles);
//                newsRV.setAdapter(newsAdapter);
//            }
//        });
//    }

    private void loadNewsData(){
        viewModel.getNews().observe(getViewLifecycleOwner(), new Observer<Headlines>() {
            @Override
            public void onChanged(Headlines headlines) {
                newsAdapter=new NewsAdapter(headlines.getArticles());
                newsRV.setAdapter(newsAdapter);
            }
        });
    }
}
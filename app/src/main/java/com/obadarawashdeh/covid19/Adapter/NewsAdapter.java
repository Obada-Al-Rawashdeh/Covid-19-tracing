package com.obadarawashdeh.covid19.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.obadarawashdeh.covid19.Model.Articles;
import com.obadarawashdeh.covid19.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsVH> {

    Context context;
    List<Articles> articles;
    View v;

    public NewsAdapter(List<Articles> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public NewsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        v=LayoutInflater.from(parent.getContext()).inflate(R.layout.news_row,parent,false);
        return new NewsVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsVH holder, int position) {
        final Articles a=articles.get(position);
        holder.tvTitle.setText(a.getTitle());
        holder.tvDesc.setText(a.getDescription());
        Picasso.with(context).load(a.getUrlToImage()).into(holder.imageView, new Callback() {
            @Override
            public void onSuccess() {
                holder.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(context, Details.class);
//                intent.putExtra("url",a.getUrl());
//                context.startActivity(intent);
                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(a.getUrl())));
            }
        });

    }

    @Override
    public int getItemCount() {

        return articles.size();
    }

    public class NewsVH extends RecyclerView.ViewHolder {
        TextView tvTitle,tvDesc;
        ImageView imageView;
        CardView cardView;
        ProgressBar progressBar;
        public NewsVH(@NonNull View itemView) {
            super(itemView);
            tvTitle=itemView.findViewById(R.id.tvTiltle);
            tvDesc=itemView.findViewById(R.id.tvDesc);
            imageView=itemView.findViewById(R.id.image);
            cardView=itemView.findViewById(R.id.card);
            progressBar=itemView.findViewById(R.id.progressBar4);
        }
    }

}

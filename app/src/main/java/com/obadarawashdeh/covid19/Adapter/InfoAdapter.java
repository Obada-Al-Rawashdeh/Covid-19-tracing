package com.obadarawashdeh.covid19.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.obadarawashdeh.covid19.Model.Info;
import com.obadarawashdeh.covid19.R;

import java.util.ArrayList;


public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoVH> {

    ArrayList<Info> arrayList;
    public InfoAdapter(ArrayList<Info> infoModels){
        arrayList=infoModels;
    }
    @NonNull
    @Override
    public InfoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InfoVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.info_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull InfoVH holder, int position) {
        Info model=arrayList.get(position);
        holder.imageView.setImageResource(model.getImg());
        holder.textView.setText(model.getDesc());
        holder.title.setText(model.getTitle());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class InfoVH extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView title;
        public InfoVH(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iImageView);
            textView=itemView.findViewById(R.id.iDescriptionTv);
            title=itemView.findViewById(R.id.iTitle);
        }
    }
}

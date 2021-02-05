package com.obadarawashdeh.covid19.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.obadarawashdeh.covid19.Model.Help;
import com.obadarawashdeh.covid19.R;

import java.util.ArrayList;

public class HelpAdapter extends RecyclerView.Adapter<HelpAdapter.HelpVH> {

    ArrayList<Help> helpArrayList;
    Context context;

    public HelpAdapter(ArrayList<Help> helpArrayList) {
        this.helpArrayList = helpArrayList;
    }

    @NonNull
    @Override
    public HelpVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        return new HelpVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.help_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HelpVH holder, int position) {
        Help help=helpArrayList.get(position);
        holder.name.setText(help.getName());
        holder.phone.setText(help.getPhone());
        holder.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", holder.phone.getText().toString(), null));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return helpArrayList.size();
    }

    public class HelpVH extends RecyclerView.ViewHolder {
        TextView name;
        TextView phone;
        public HelpVH(@NonNull View itemView) {
            super(itemView);
            phone=itemView.findViewById(R.id.eTV);
            name=itemView.findViewById(R.id.dTV);
        }
    }
}

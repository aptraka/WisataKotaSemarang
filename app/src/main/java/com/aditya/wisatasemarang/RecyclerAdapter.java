package com.aditya.wisatasemarang;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aditya.wisatasemarang.models.WisataModel;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<WisataModel> list = new ArrayList<>();

    public RecyclerAdapter(Context context, ArrayList<WisataModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder myViewHolder, final int position) {
        myViewHolder.judul.setText(list.get(position).getNama());
        Glide.with(context).load(list.get(position).getGambar()).into(myViewHolder.gambar);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("NAMA",list.get(position).getNama());
                intent.putExtra("GAMBAR",list.get(position).getGambar());
                intent.putExtra("DETAIL",list.get(position).getDeskripsi());
                intent.putExtra("MAPS",list.get(position).getMaps());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView judul;
        ImageView gambar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            judul =itemView.findViewById(R.id.tvJudul);
            gambar=itemView.findViewById(R.id.ivGambar);
        }
    }
}

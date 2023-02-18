package com.example.bottom_navigation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottom_navigation.R;
import com.example.bottom_navigation.model.Message;

import java.util.List;

public class MessgeAdapter extends RecyclerView.Adapter<MessgeAdapter.ViewHolder> {
    private Context context;
    private List<Message> list;

    public MessgeAdapter(Context context, List<Message> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_message,parent ,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Message mes = list.get(position);
        holder.img.setImageResource(mes.getImg());
        holder.name.setText(mes.getName());
        holder.title.setText(mes.getTitile());
        holder.gio.setText(mes.getGio());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name,title,gio;
        public ViewHolder(@NonNull View v) {
            super(v);
            img = v.findViewById(R.id.img);
            name = v.findViewById(R.id.tname);
            title = v.findViewById(R.id.ttitle);
            gio = v.findViewById(R.id.tgio);

        }
    }
}

package com.example.thread.RSS_AsynTask.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thread.R;
import com.example.thread.RSS_AsynTask.DetalActivity;

import java.util.List;
import java.util.ListIterator;

public class RecycleViewAdapter extends
    RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{

    private Context context;
    private List<Item> list;

    public RecycleViewAdapter(Context context, List<Item> list) {
        this.context = context;
        this.list = list;
    }

    public List<Item> getItems(){
        return list;
    }
    public Item getItem(int position){
        return list.get(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item i = list.get(position);
        holder.title.setText(i.getTitle());
        holder.des.setText(i.getDes());
        holder.pubDate.setText(i.getPubdate());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetalActivity.class);
                String link = i.getLink();
                intent.putExtra("link", link);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title,des,pubDate;
        private CardView cardView;
        public ViewHolder(@NonNull View v) {
            super(v);
            title = v.findViewById(R.id.tvTitle);
            des = v.findViewById(R.id.tvDes);
            pubDate = v.findViewById(R.id.tvpubDate);
            cardView = v.findViewById(R.id.cardView);

        }
    }
}

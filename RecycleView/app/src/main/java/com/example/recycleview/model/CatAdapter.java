package com.example.recycleview.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder>{

    //private Context context;
    ;
    private List<Cat> mList;
    private CatItemListener catItemListener;
    public CatAdapter(List<Cat> mList){

        this.mList = mList;
    }

    public void setCatItemListener(CatItemListener catItemListener) {
        this.catItemListener = catItemListener;
    }

    @NonNull
    @Override
    //phuong thuc de tra ve view
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,false);

        return new CatViewHolder(view);
    }
    // thổi du lieu cho 1 item
    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat = mList.get(position);
        // neu cat chua co thi return
        if(cat==null) return;
        // neu co thi thoi du lieu cho 1 item
        holder.img.setImageResource(cat.getImg());
        holder.tv.setText(cat.getName());
        // tich chuot vao 1 carview
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context.getApplicationContext(), cat.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }
    // tra ve co bao nhieu item
    @Override
    public int getItemCount() {
        if(mList!=null) return mList.size();
        return 0;
    }
// ViewHolder la 1 item
    public class CatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView img;
        private TextView tv;
        //private CardView cardView;
        //CatViewHolder là 1 item gắn với dối tượng vào view(item layout)
        public CatViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            tv = itemView.findViewById(R.id.tname);

            itemView.setOnClickListener(this);
          //  cardView = itemView.findViewById(R.id.cview);
        }

    @Override
    public void onClick(View v) {
        if(catItemListener!=null){
            catItemListener.onItemClick(v, getAdapterPosition());
        }
    }
}

    public interface CatItemListener{
        public void onItemClick(View view, int positon);


    }
}

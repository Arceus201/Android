package com.example.crud.model;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crud.R;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {private Context context;
    private List<Cat> mList;
    private List<Cat> listBackup;
    private CatItemListener catItemListener;

    public CatAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
        listBackup = new ArrayList<>();
    }
    // phuong thuc de lay listbackup
    public List<Cat> getBackup(){
        return listBackup;
    }
    // tra ve khi search
    public void filterList(List<Cat> filterlist){
        mList = filterlist;
        notifyDataSetChanged();
    }

    public void setClickListener(CatItemListener catItemListener){
        this.catItemListener = catItemListener;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent,false);

        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat = mList.get(position);
        if(cat==null){
            return;
        }
        holder.img.setImageResource(cat.getImg());
        holder.tvName.setText(cat.getName());
        holder.tvDes.setText(cat.getDes());
        holder.tvPrice.setText(cat.getPrice()+"");

        holder.btRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thong bao xoa");
                builder.setMessage("Ban co chac chan muon xoa ?"+cat.getName());

                builder.setIcon(R.drawable.img_remove);
                // dong y xoa
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       listBackup.remove(position);
                        mList.remove(position);
                        notifyDataSetChanged();
                    }
                });
                // khong dong y xoa
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        if(mList!=null) return mList.size();
        return 0;
    }


    public Cat getItem(int position){
        return mList.get(position);
    }

    public class CatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView img;
        private TextView tvName,tvDes,tvPrice;
        private Button btRemove;
        public CatViewHolder(@NonNull View v) {
            super(v);
            img = v.findViewById(R.id.img);
            tvName = v.findViewById(R.id.txtName);
            tvDes = v.findViewById(R.id.txtDes);
            tvPrice = v.findViewById(R.id.txtPrice);
            btRemove = v.findViewById(R.id.btRemove);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(catItemListener!=null)
                catItemListener.onItemClick(v, getAdapterPosition());
        }
    }
    public void add(Cat c){
        listBackup.add((c));
        mList.add(c);
        notifyDataSetChanged();
    }

    public void update(int position, Cat cat){
        listBackup.set(position, cat);
        mList.set(position,cat);
        notifyDataSetChanged();
    }
    public interface CatItemListener{
        void onItemClick(View v,int position);
    }

}

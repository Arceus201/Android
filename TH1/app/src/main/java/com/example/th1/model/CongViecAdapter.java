package com.example.th1.model;

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

import com.example.th1.R;

import java.util.ArrayList;
import java.util.List;

public class CongViecAdapter extends RecyclerView.Adapter<CongViecAdapter.CongViecViewHolder>{
    private Context context;
    private List<CongViec> listcv;
    private List<CongViec> listBackup;

    private CongViecItemListener congViecItemListener;

    public CongViecAdapter(Context context) {
        this.context = context;
        listcv = new ArrayList<>();
        listBackup = new ArrayList<>();
    }

    public List<CongViec> getBackup(){
        return listBackup;
    }

    public void filterList(List<CongViec> filterlist){
        listcv = filterlist;
        notifyDataSetChanged();
    }

    public void setClickListener(CongViecItemListener congViecItemListener){
        this.congViecItemListener = congViecItemListener;
    }
    @NonNull
    @Override
    public CongViecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent,false);

        return new CongViecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CongViecViewHolder holder, int position) {
        CongViec cv = listcv.get(position);

        if(cv == null){
            return;
        }
        holder.img.setImageResource(cv.getImg());
        holder.tvName.setText(cv.getName());
        holder.tvDes.setText(cv.getDes());
        holder.tvDate.setText(cv.getDate());

        holder.btRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thong bao xoa");
                builder.setMessage("Ban co chac chan muon xoa cong viec "+cv.getName());

                builder.setIcon(R.drawable.img_remove);
                // dong y xoa
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listBackup.remove(position);
                        listcv.remove(position);
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
        if(listcv!=null) return listcv.size();
        return 0;
    }

    public CongViec getItem(int position){
        return listcv.get(position);
    }

    public class CongViecViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView img;
        private TextView tvName,tvDes,tvDate;
        private Button btRemove;

        public CongViecViewHolder(@NonNull View v) {
            super(v);
            img = v.findViewById(R.id.img);
            tvName = v.findViewById(R.id.txtName);
            tvDes = v.findViewById(R.id.txtDes);
            tvDate = v.findViewById(R.id.txtDate);
            btRemove = v.findViewById(R.id.btRemove);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(congViecItemListener!=null)
                congViecItemListener.onItemClick(v, getAdapterPosition());
        }
    }
    public void add(CongViec cv){
        listBackup.add(cv);
        listcv.add(cv);
        notifyDataSetChanged();
    }

    public void update(int position, CongViec cv){
        listBackup.set(position, cv);
        listcv.set(position,cv);
        notifyDataSetChanged();
    }

    public interface CongViecItemListener{
        void onItemClick(View v,int position);
    }
}

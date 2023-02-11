package com.example.crud.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.crud.R;

public class SpinnerAdapter extends BaseAdapter {
    private int[] imgs ={R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5};
    private Context context;

    public SpinnerAdapter(Context context) {
        this.context = context;
    }

    @Override
    // spiner co bao nhieu item
    public int getCount() {
        return imgs.length;
    }

    @Override
    // tra ve 1 anh o vi tri position
    public Object getItem(int position) {
        return position;
    }

    @Override

    public long getItemId(int position) {
        return position;
    }
    // tra ve 1 view ( trong spinner)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //moi view la 1 item
        View item = LayoutInflater.from(context).inflate(R.layout.item_img,parent,false );
        ImageView img = item.findViewById(R.id.img);

        img.setImageResource(imgs[position]);
        return item;
    }
}

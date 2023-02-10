package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recycleview.model.Cat;
import com.example.recycleview.model.CatAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CatAdapter.CatItemListener{
    private RecyclerView recyclerView;
    private CatAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rview);

        adapter = new CatAdapter(getList());
        adapter.setCatItemListener(this);
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }
    private List<Cat> getList(){
        List<Cat> list = new ArrayList<>();
        list.add(new Cat(R.drawable.img, "Meo_0"));
        list.add(new Cat(R.drawable.img_1, "Meo_1"));
        list.add(new Cat(R.drawable.img_2, "Meo_2"));
        list.add(new Cat(R.drawable.img_3, "Meo_3"));
        list.add(new Cat(R.drawable.img_4, "Meo_4"));
        list.add(new Cat(R.drawable.img_5, "Meo_5"));
        return list;
    }

    @Override
    public void onItemClick(View view, int positon) {
        Cat c = getList().get(positon);
        Toast.makeText(this, c.getName(), Toast.LENGTH_SHORT).show();
    }
}
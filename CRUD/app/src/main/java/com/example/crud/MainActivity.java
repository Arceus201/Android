package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.crud.model.Cat;
import com.example.crud.model.CatAdapter;
import com.example.crud.model.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements CatAdapter.CatItemListener,
                SearchView.OnQueryTextListener{
    private Spinner sp;
    private RecyclerView recyclerView;
    private CatAdapter adapter;

    private EditText eName,eDes,ePrice;
    private Button btAdd,btUpdate;
    private int positioncurren;
    private SearchView searchView;
    private int[] imgs ={R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        adapter = new CatAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        adapter.setClickListener(this);
        searchView.setOnQueryTextListener(this);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cat cat = new Cat();
                String  i = sp.getSelectedItem().toString();
                String name = eName.getText().toString();
                String descs = eDes.getText().toString();
                String p = ePrice.getText().toString();
                int img = R.drawable.img;
                double price = 0;
                try {
                    img = imgs[Integer.parseInt(i)];
                    price = Double.parseDouble(p);

                    cat.setImg(img);
                    cat.setName(name);
                    cat.setDes(descs);
                    cat.setPrice(price);

                    adapter.add(cat);
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "Nhap lai", Toast.LENGTH_LONG).show();
                }

            }
        });

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cat cat = new Cat();
                String  i = sp.getSelectedItem().toString();
                String name = eName.getText().toString();
                String descs = eDes.getText().toString();
                String p = ePrice.getText().toString();
                int img = R.drawable.img;
                double price = 0;
                try {
                    img = imgs[Integer.parseInt(i)];
                    price = Double.parseDouble(p);

                    cat.setImg(img);
                    cat.setName(name);
                    cat.setDes(descs);
                    cat.setPrice(price);

                    adapter.update(positioncurren, cat);
                    btAdd.setEnabled(true);
                    btUpdate.setEnabled(false);

                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "Nhap lai", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void initView(){
        sp = findViewById(R.id.img);
        SpinnerAdapter adapter = new SpinnerAdapter(this);
        sp.setAdapter(adapter);
        recyclerView = findViewById(R.id.recycleView);
        eName = findViewById(R.id.name);
        eDes = findViewById(R.id.des);
        ePrice = findViewById(R.id.price);
        btAdd = findViewById(R.id.btAdd);
        btUpdate = findViewById(R.id.btUpdate);
        btUpdate.setEnabled(false);
        searchView = findViewById(R.id.search);

    }

    @Override
    public void onItemClick(View v, int position) {
        btAdd.setEnabled(false);
        btUpdate.setEnabled(true);
        positioncurren = position;
        Cat cat = adapter.getItem(position);
        int img = cat.getImg();
        int p = 0;
        for (int i=0;i<imgs.length;i++){
            if(img==imgs[i]){
                p=i;
                break;
            }
            sp.setSelection(p);
            eName.setText(cat.getName() );
            eDes.setText(cat.getDes() );
            ePrice.setText(cat.getPrice()+"");

        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    // khi thay doi -them,xoa
    public boolean onQueryTextChange(String newText) {
        filter(newText);
        return false;
    }
    private void filter(String s){
        // tao ds de luu sau khi loc
        List<Cat> filterlist = new ArrayList<>();
        // duyet tren ds backup
        for(Cat i:adapter.getBackup()){
            // neu ten search trung tren trong ds
            if(i.getName().toLowerCase().contains(s.toLowerCase())){
                filterlist.add(i);
            }
        }// neu khong tim dc thif toast
        if(filterlist.isEmpty()){
            Toast.makeText(this, "khong tim duoc", Toast.LENGTH_LONG).show();

        }else{// neu tim dc thi day vao  filterlist
            adapter.filterList(filterlist);
        }
    }
}
package com.example.sqlite.fragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite.AddActivity;
import com.example.sqlite.R;
import com.example.sqlite.adapter.RecycleViewAdapter;
import com.example.sqlite.dal.SQLiteHelper;
import com.example.sqlite.model.Item;

import java.util.Calendar;
import java.util.List;
import java.util.ListIterator;

public class FragmntSearch extends Fragment
        implements View.OnClickListener {
    private RecyclerView recyclerView;
    private TextView tvTong;
    private Button btSearch;
    private SearchView searchView;
    private EditText eFrom,eTo;
    private Spinner spCategory;
    private RecycleViewAdapter adapter;
    private SQLiteHelper db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        adapter = new RecycleViewAdapter();
        db = new SQLiteHelper(getContext());
        List<Item> list = db.getAll();
        adapter.setList(list);
        tvTong.setText("Tong tien:" + tong(list)+"d");
        LinearLayoutManager manager = new LinearLayoutManager(getContext()
                                ,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<Item> list = db.searchByTitle(newText);
                tvTong.setText("Tong tien:"+tong(list));
                adapter.setList(list);
                return true;
            }
        });

        eFrom.setOnClickListener(this);
        eTo.setOnClickListener(this);
        btSearch.setOnClickListener(this);
        spCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String cat = spCategory.getItemAtPosition(position).toString();
                List<Item> list;
                if(!cat.equalsIgnoreCase("all")){
                    list = db.searchByCategory(cat);
                }else{
                    list = db.getAll();
                }
                adapter.setList(list);
                tvTong.setText("Tong tien"+tong(list));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    private void initView(View v){
        recyclerView = v.findViewById(R.id.recycleViewSearch);
        tvTong = v.findViewById(R.id.tvTong);
        btSearch = v.findViewById(R.id.btSearch);
        searchView = v.findViewById(R.id.search);
        eFrom = v.findViewById(R.id.mFrom);
        eTo = v.findViewById(R.id.mTo);
        spCategory = v.findViewById(R.id.spCategory);
        String[] arr = getResources().getStringArray(R.array.category);
        String[] arr1 = new String[arr.length+1];
        arr1[0]="All";
        for (int i=0;i<arr.length;i++){
            arr1[i+1] = arr[i];
        }
        spCategory.setAdapter(new ArrayAdapter<String>(getContext(), R.layout.item_spinner,arr1));
    }
    private int tong(List<Item> list){
        int t =0;
        for(Item i:list){
            t+=Integer.parseInt(i.getPrice());
        }return t;
    }

    @Override
    public void onClick(View v) {
        if(v == eFrom){
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(getContext(),
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                            String date = "";
                            if(month>8){
                                date = day+"/" +(month+1)+"/"+year;
                            }
                            else{
                                date = day+"/0" +(month+1)+"/"+year;
                            }
                            if(day<10) date = "0"+date;
                            eFrom.setText(date);
                        }
                    },year,month,day);
            dialog.show();
        }
        if(v == eTo){
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(getContext(),
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                            String date = "";
                            if(month>8){
                                date = day+"/" +(month+1)+"/"+year;
                            }
                            else{
                                date = day+"/0" +(month+1)+"/"+year;
                            }
                            if(day<10) date = "0"+date;
                            eTo.setText(date);
                        }
                    },year,month,day);
            dialog.show();
        }
        if(v==btSearch){
            String from = eFrom.getText().toString();
            String to = eTo.getText().toString();
            if(!from.isEmpty() && !to.isEmpty()){
                List<Item> list = db.searchByDateFromTo(from,to);
                adapter.setList(list);
                tvTong.setText("Tong tien"+tong(list));
            }
        }
    }
}

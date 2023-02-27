package com.example.th1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SearchView;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.th1.model.CongViec;
import com.example.th1.model.CongViecAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CongViecAdapter.CongViecItemListener,
        SearchView.OnQueryTextListener,View.OnClickListener{
    private RecyclerView recyclerView;
    private CongViecAdapter adapter;

    private EditText eName,eDes,eDate;
    private RadioButton gnam,gnu;
    private Button btAdd,btUpdate;
    private int positioncurren;
    private SearchView searchView;


    private int[] imgs ={R.drawable.img,
            R.drawable.img_1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        adapter = new CongViecAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        adapter.setClickListener(this);
        searchView.setOnQueryTextListener(this);
        // cong viec
        eDate.setOnClickListener(this);
        btAdd.setOnClickListener(this);
        btUpdate.setOnClickListener(this);

    }

    private void initView(){
        recyclerView = findViewById(R.id.recycle);
        eName = findViewById(R.id.edname);
        eDes = findViewById(R.id.eddes);
        eDate = findViewById(R.id.eddate);
        gnam = findViewById(R.id.gnam);
        gnu = findViewById(R.id.gnu);
        btAdd = findViewById(R.id.btadd);
        btUpdate = findViewById(R.id.btupdate);
        btUpdate.setEnabled(false);
        searchView = findViewById(R.id.search);

    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        filter(newText);
        return false;
    }

    @Override
    public void onItemClick(View v, int position) {
        btAdd.setEnabled(false);
        btUpdate.setEnabled(true);
        positioncurren = position;
        CongViec cv = adapter.getItem(position);

        int img = cv.getImg();
        if(img ==imgs[0]){
            gnam.setChecked(true);
        }
        if(img ==imgs[1]){
            gnu.setChecked(true);
        }
        eName.setText(cv.getName() );
        eDes.setText(cv.getDes() );
        eDate.setText(cv.getDate()+"");

    }

    private void filter(String s){
        // tao ds de luu sau khi loc
        List<CongViec> filterlist = new ArrayList<>();
        // duyet tren ds backup
        for(CongViec i:adapter.getBackup()){
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

    @Override
    public void onClick(View v) {
        if(v == eDate){
            Calendar c = Calendar.getInstance();
            int yyyy = c.get(Calendar.YEAR);
            int mm = c.get(Calendar.MONTH);
            int dd = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    eDate.setText(year+"/"+(month+1)+"/"+dayOfMonth);
                }
            },yyyy,mm,dd);
            datePickerDialog.show();
        }

        if(v == btAdd){
            CongViec cv = new CongViec();

            String name = eName.getText().toString();
            String descs = eDes.getText().toString();
            String date = eDate.getText().toString();
            int img = R.drawable.img;

            if(gnam.isChecked()){
                img = R.drawable.img;
            }
            if(gnu.isChecked()){
                img = R.drawable.img_1;
            }

            try {
                cv.setImg(img);
                cv.setName(name);
                cv.setDes(descs);
                cv.setDate(date);

                adapter.add(cv);
            }catch (NumberFormatException e){
                Toast.makeText(getApplicationContext(), "Nhap lai", Toast.LENGTH_LONG).show();
            }
        }
        if(v==btUpdate){
            CongViec cv = new CongViec();

            String name = eName.getText().toString();
            String descs = eDes.getText().toString();
            String date = eDate.getText().toString();
            int img = R.drawable.img;

            if(gnam.isChecked()){
                img = R.drawable.img;
            }
            if(gnu.isChecked()){
                img = R.drawable.img_1;
            }

            try {


                cv.setImg(img);
                cv.setName(name);
                cv.setDes(descs);
                cv.setDate(date);



                adapter.update(positioncurren, cv);
                btAdd.setEnabled(true);
                btUpdate.setEnabled(false);

            }catch (NumberFormatException e){
                Toast.makeText(getApplicationContext(), "Nhap lai", Toast.LENGTH_LONG).show();
            }
        }
    }
}
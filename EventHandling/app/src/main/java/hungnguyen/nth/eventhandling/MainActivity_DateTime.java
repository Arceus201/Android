package hungnguyen.nth.eventhandling;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity_DateTime extends AppCompatActivity implements View.OnClickListener{
    private EditText time,date;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_date_time);
        initView();
       time.setOnClickListener(this);
       date.setOnClickListener(this);

       // gan menu ngu canh vao textview
       registerForContextMenu(tv);

    }
    // khoi tao menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    // bat su kien cho menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mFile:
                Toast.makeText(this, "File", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mExit:
                System.exit(0);
                break;
            case R.id.mEmail:
                Toast.makeText(this, "Email", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mPhone:
                Toast.makeText(this, "Phone", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //khoi tao mmenu ngu canh
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_color, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    // bat su kien cho menu ngu canh
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_1:
                tv.setTextColor(Color.RED);
                break;
            case R.id.menu_2:
                tv.setTextColor(Color.BLUE);
                break;
            case R.id.menu_3:
                tv.setTextColor(Color.YELLOW);
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void initView(){
        time = findViewById(R.id.time);
        date =findViewById(R.id.date);
        tv = findViewById(R.id.tv);
    }
    // bat su kien cho time va date
    @Override
    public void onClick(View v) {
        if(v == time){
            Calendar c = Calendar.getInstance();
            int hh = c.get(Calendar.HOUR_OF_DAY);
            int mm = c.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    time.setText(hourOfDay+":"+minute);
                }
            }, hh, mm, false);
            timePickerDialog.show();
        }
        if(v == date){
            Calendar c = Calendar.getInstance();
            int yyyy = c.get(Calendar.YEAR);
            int mm = c.get(Calendar.MONTH);
            int dd = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    date.setText(year+"-"+(month+1)+"-"+dayOfMonth);
                }
            },yyyy,mm,dd);
        }
    }
}
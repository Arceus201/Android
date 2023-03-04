package com.example.notifications.Noti_AlarmManager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.notifications.R;

import java.util.Calendar;

public class MainActivity3 extends AppCompatActivity {
    private TimePicker time;
    private Button btDat,btDung;
    private TextView tv;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        time = findViewById(R.id.timePicker);
        btDat = findViewById(R.id.btDatgio);
        btDung = findViewById( R.id.btDungdat);
        tv = findViewById( R.id.tv);

        btDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("dung dat gio!");
                pendingIntent.cancel();
            }
        });

        btDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.set(Calendar.HOUR_OF_DAY,time.getCurrentHour());
                calendar.set(Calendar.MINUTE,time.getCurrentMinute());

                int gio = time.getCurrentHour();
                int phut = time.getCurrentMinute();
                String sgio = String.valueOf(gio);
                String sphut = String.valueOf(phut);
                if(gio>12){
                    sgio = String.valueOf(gio-12);
                }
                if(phut<10){
                    sphut = "0"+sphut;
                }
                tv.setText("thoi gian hen gio: "+ sgio+":"+sphut);
                Intent intent = new Intent(MainActivity3.this,AlarmReceiver.class);
                intent.setAction("MyAction");
                intent.putExtra("time", sgio+":"+sphut);
                alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                pendingIntent = PendingIntent.getBroadcast(MainActivity3.this, 0,
                        intent, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);


            }
        });
    }
}
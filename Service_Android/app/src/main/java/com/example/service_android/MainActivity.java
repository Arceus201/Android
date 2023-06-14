package com.example.service_android;

import static android.content.ContentValues.TAG;
import static com.example.service_android.MyService.ACTION_CLEAR;
import static com.example.service_android.MyService.ACTION_PAUSE;
import static com.example.service_android.MyService.ACTION_RESUM;
import static com.example.service_android.MyService.ACTION_START;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText ed;
    private Button start,stop;
    private RelativeLayout layoutbottom;
    private Song mSong;
    private boolean isPlaying;
    private AlarmManager alarmMgr;
    private PendingIntent pendingIntent;
    private ImageView imgSong,imgPlayorPause,imgCLear;

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if(bundle==null) return;

            mSong =(Song) bundle.get("object_song");
            isPlaying = bundle.getBoolean("status_player");
            int acctionMusic = bundle.getInt("action_music");

            handleLayoutMusic(acctionMusic);

        }
    };




    private TextView tvSong,tvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver,new IntentFilter("send_data_to_activity"));

        ed= findViewById(R.id.ed_data_intent);
        start = findViewById(R.id.bt_start_service);
        stop = findViewById(R.id.bt_stop_service);
        layoutbottom  = findViewById(R.id.layout_bottom);

        imgSong = findViewById(R.id.img_msong);
        imgCLear = findViewById(R.id.img_mclear);
        imgPlayorPause = findViewById(R.id.img_mplay_or_pause);
        tvSong = findViewById(R.id.tv_msong);
        tvTitle = findViewById(R.id.tv_mtitle);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickStartService();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickStopService();
            }
        });

    }
    private void clickStartService() {
//        alarmMgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(System.currentTimeMillis());
//        calendar.set(Calendar.HOUR_OF_DAY, 23);
//        calendar.set(Calendar.MINUTE, 49);

        Song song = new Song("Big city boy","Kien",R.drawable.ic_noti,R.raw.song);
        Intent intent = new Intent(this,MyService.class);
        //intent.setAction("MyAction");
        //intent.putExtra("key_data_intent", ed.getText().toString().trim());
        // gui ca 1 doi tuong
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_song",song);
        intent.putExtras(bundle);
   //    pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        PendingIntent pendingIntent = PendingIntent.getService(MainActivity.this, 0,
//                intent, PendingIntent.FLAG_IMMUTABLE);

//        if (Build.VERSION.SDK_INT >=23) {
//            alarmMgr.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
//        } else if (Build.VERSION.SDK_INT >= 19) {
//            alarmMgr.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
//        } else {
//            alarmMgr.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
//        }
        //alarmMgr.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        startService(intent);
    }

    private void clickStopService() {
        Intent intent = new Intent(this,MyService.class);
        stopService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Log.d(TAG, "onDestroy");
//        alarmMgr.cancel(pendingIntent);
//        Log.d(TAG, "onDestroy------------");
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }
    private void handleLayoutMusic(int acction) {
        switch (acction){
            case ACTION_START:
                layoutbottom.setVisibility(View.VISIBLE);
                showInforSong();
                setSatusButtonpPlayorPause();
                break;
            case ACTION_PAUSE:
                setSatusButtonpPlayorPause();
                break;
            case ACTION_RESUM:
                setSatusButtonpPlayorPause();
                break;
            case ACTION_CLEAR:
                layoutbottom.setVisibility(View.GONE);
                break;

        }
    }
    private void showInforSong(){
        if(mSong==null) return;
        imgSong.setImageResource(mSong.getImage());
        tvTitle.setText(mSong.getTiitle());
        tvSong.setText(mSong.getSingle());

        imgPlayorPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlaying){
                    sendAcciontoService(ACTION_PAUSE);
                }else{
                    sendAcciontoService(ACTION_RESUM);
                }
            }
        });

        imgCLear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendAcciontoService(ACTION_CLEAR);
            }
        });
    }
    private void setSatusButtonpPlayorPause(){
        if(isPlaying){
            imgPlayorPause.setImageResource(R.drawable.pause);
        }else{
            imgPlayorPause.setImageResource(R.drawable.play);
        }
    }

    private void sendAcciontoService(int action){
        Intent intent = new Intent(this,MyService.class);
        intent.putExtra("action_music_service", action);
        startService(intent);
    }
}
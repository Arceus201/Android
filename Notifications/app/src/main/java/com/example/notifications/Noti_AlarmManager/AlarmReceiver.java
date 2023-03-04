package com.example.notifications.Noti_AlarmManager;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.example.notifications.R;

import java.util.Date;

public class AlarmReceiver extends BroadcastReceiver {
    final String CHANNEL_ID = "2001";
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("MyAction")){
            String time = intent.getStringExtra("time");
            NotificationManager notificationManager =
                    (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                        "Channel 1",NotificationManager.IMPORTANCE_HIGH);
                channel.setDescription("Mieu ta cho kenh 1");
                notificationManager.createNotificationChannel(channel);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                        .setContentTitle("Bao thuc"+time)
                        .setContentText("Day thoi den gio "+time+" roi")
                        .setSmallIcon(R.drawable.ic_noti)
                        .setColor(Color.RED)
                        .setCategory(NotificationCompat.CATEGORY_ALARM);
                notificationManager.notify(getNotificationid(),builder.build());
            }

        }
    }
    private int getNotificationid(){
        int time = (int)new Date().getTime();
        return time;
    }
}

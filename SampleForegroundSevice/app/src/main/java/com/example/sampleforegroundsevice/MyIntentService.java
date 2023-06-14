package com.example.sampleforegroundsevice;

import static android.content.ContentValues.TAG;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.util.Log;


import androidx.core.app.NotificationCompat;



public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel( "Sample Channel", "Foreground Service Channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        // Tạo thông báo
        Notification notification = new NotificationCompat.Builder(this,  "Sample Channel")
                .setContentTitle("Thông báo")
                .setContentText("Đã đến giờ 22h:30p!")
                .setSmallIcon(R.drawable.inotification_icon)
                .build();
        Log.d(TAG, "onHandleIntent: send");
        // Đưa dịch vụ vào chế độ foreground và hiển thị thông báo
        startForeground(1, notification);

    }
}
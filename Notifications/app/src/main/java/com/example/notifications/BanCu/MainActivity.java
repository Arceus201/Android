package com.example.notifications.BanCu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.notifications.R;

public class MainActivity extends AppCompatActivity {
    private int notificationid = 1;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.bt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification builder = new Notification.Builder(getApplicationContext())
                        .setContentTitle("Thong bao")
                        .setContentText("Noi dung thong bao")
                        .setSmallIcon(R.drawable.ic_noti)
                        .setDefaults(NotificationCompat.DEFAULT_SOUND)
                        .setColor(Color.RED)
                        .build();
                NotificationManager notificationManager =
                        (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(notificationid, builder);

            }
        });

    }
}
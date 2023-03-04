package com.example.notifications.Noti_Base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.notifications.R;

import java.util.Date;

public class MainActivity2 extends AppCompatActivity {
    private Button bt1, bt2;
//    private int notificationid = 1;
//    private int notificationid2 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        MainActivity2.this, MyNotification.CHANNEL_ID)
                        .setContentTitle("Thong bao 1")
                        .setContentText("Noi dung cho thong bao 1,kenh 1")
                        .setSmallIcon(R.drawable.ic_noti)
                        .setColor(Color.RED)
                        .setCategory(NotificationCompat.CATEGORY_ALARM)
                        .setDefaults(NotificationCompat.DEFAULT_SOUND);
                NotificationManagerCompat managerCompat = NotificationManagerCompat
                        .from(getApplicationContext());

                if (ActivityCompat.checkSelfPermission(MainActivity2.this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                managerCompat.notify(getNotificationid(), builder.build());

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        MainActivity2.this, MyNotification.CHANNEL_ID)
                        .setContentTitle("Thong bao 2")
                        .setContentText("Noi dung cho thong bao 2,kenh 2")
                        .setSmallIcon(R.drawable.ic_noti2)
                        .setColor(Color.BLUE)
                        .setCategory(NotificationCompat.CATEGORY_ALARM)
                        .setDefaults(NotificationCompat.DEFAULT_SOUND);
                NotificationManagerCompat managerCompat = NotificationManagerCompat
                        .from(getApplicationContext());

                if (ActivityCompat.checkSelfPermission(MainActivity2.this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                managerCompat.notify(getNotificationid(), builder.build());

            }
        });
    }
    private int getNotificationid(){
        int time = (int)new Date().getTime();
        return time;
    }
}
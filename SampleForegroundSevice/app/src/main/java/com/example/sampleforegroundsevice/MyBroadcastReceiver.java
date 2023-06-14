package com.example.sampleforegroundsevice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.core.content.ContextCompat;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Bắt đầu service MyIntentService
        Intent serviceIntent = new Intent(context, MyIntentService.class);
        ContextCompat.startForegroundService(context, serviceIntent);
    }
}

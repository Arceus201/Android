package com.example.service_android;

import static android.content.ContentValues.TAG;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;

import androidx.legacy.content.WakefulBroadcastReceiver;

public class MyReciver extends  BroadcastReceiver {
  //  private MediaPlayer mediaPlayer;
    @Override
    public void onReceive(Context context, Intent intent) {
//        mediaPlayer = MediaPlayer.create(context.getApplicationContext(), R.raw.song);
//        mediaPlayer.start();
//        Log.d(TAG, "onReceive: heelo");
//        if(intent.getAction().equals("MyAction")){
//           Log.d(TAG, "onReceive: Recever ");
//            Bundle bundle = intent.getExtras();
//            Song song = (Song) bundle.get("object_song_reciver");
//          // Log.d(TAG, song.getTiitle());
//
//            Intent intentService = new Intent(context,MyService.class);
//            Bundle bundle2 = new Bundle();
//            bundle2.putSerializable("object_song",song);
//            intentService.putExtras(bundle2);;
//            context.startService(intentService);
//        }
//        else {
            int actionMussic = intent.getIntExtra("action_music", 0);

            Intent intentService = new Intent(context, MyService.class);
            intentService.putExtra("action_music_service", actionMussic);
            context.startService(intentService);
        //}

    }
}

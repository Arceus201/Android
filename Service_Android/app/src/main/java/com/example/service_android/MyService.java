package com.example.service_android;

import static android.content.ContentValues.TAG;
import static com.example.service_android.MyApplication.CHANNEL_ID;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

//13:10
public class MyService extends Service {
    private MediaPlayer mediaPlayer;
    public static final int ACTION_PAUSE = 1;
    public static final int ACTION_RESUM = 2;
    public static final int ACTION_CLEAR = 3;
    public static final int ACTION_START = 4;
    private boolean isPlaying;
    private  Song mSong;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Hello", "MyService Oncreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       // String dataIntent = intent.getStringExtra("key_data_intent");
            Bundle bundle = intent.getExtras();

            if (bundle != null) {
                Song song = (Song) bundle.get("object_song");
//                Log.e("Hello", song.getTiitle());
                if (song != null) {
                    mSong = song;
                    startMusic(song);
                    // Log.e("Hello", song.getTiitle());

                    sendNotification(song);
                }
            }
            int acctionMusic = intent.getIntExtra("action_music_service", 0);
            handleActionMusic(acctionMusic);

       //sendNotification(dataIntent);
        return START_NOT_STICKY;
    }

    private void startMusic(Song song) {
        if(mediaPlayer==null) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), song.getResource());
        }
        isPlaying = true;
        mediaPlayer.start();
        sendActionToActivity(ACTION_START);

    }

    private void handleActionMusic(int action){
        switch(action){
            case ACTION_PAUSE:
                pauseMussic();
                break;
            case ACTION_RESUM:
                resumMussic();
                break;
            case ACTION_CLEAR:
                stopSelf();
                sendActionToActivity(ACTION_CLEAR);
                break;
        }
    }
    private void pauseMussic(){
        if(mediaPlayer!=null && isPlaying){
            mediaPlayer.pause();
            isPlaying = false;
            sendNotification(mSong);
            sendActionToActivity(ACTION_PAUSE);
        }
    }
    private void resumMussic(){
        if(mediaPlayer!=null && !isPlaying){
            mediaPlayer.start();
            isPlaying = true;
            sendNotification(mSong);
            sendActionToActivity(ACTION_RESUM);
        }
    }


    private void sendNotification(Song song) {
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), song.getImage());

        RemoteViews remoteView = new RemoteViews(getPackageName(),R.layout.custom_notification);
        remoteView.setTextViewText(R.id.tv_title, song.getTiitle());
        remoteView.setTextViewText(R.id.tv_song, song.getSingle());
        remoteView.setImageViewBitmap(R.id.img_song, bitmap);
        remoteView.setImageViewResource(R.id.img_play_or_pause, R.drawable.pause);

        if(isPlaying){
            remoteView.setOnClickPendingIntent(R.id.img_play_or_pause, getPendingIntent(this,ACTION_PAUSE));
            remoteView.setImageViewResource(R.id.img_play_or_pause, R.drawable.pause);
        }
        else{
            remoteView.setOnClickPendingIntent(R.id.img_play_or_pause, getPendingIntent(this,ACTION_RESUM));
            remoteView.setImageViewResource(R.id.img_play_or_pause, R.drawable.play);
        }
        remoteView.setOnClickPendingIntent(R.id.img_clear, getPendingIntent(this,ACTION_CLEAR));


        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_noti)
                .setContentIntent(pendingIntent)
                .setCustomContentView(remoteView)
                .setSound(null)
                .build();

        startForeground(1, notification);
    }


    private PendingIntent getPendingIntent(Context context,int action){
        Intent intent = new Intent(this,MyReciver.class);
        intent.putExtra("action_music", action);
        Log.d(TAG, "action:" + action);
        return PendingIntent.getBroadcast(context.getApplicationContext(),action, intent, PendingIntent.FLAG_UPDATE_CURRENT);

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Hello", "MyService onDestroy");
        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }

    private void sendActionToActivity(int action){
        Intent intent = new Intent("send_data_to_activity");
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_song", mSong);
        bundle.putBoolean("status_player", isPlaying);
        bundle.putInt("action_music", action);
        intent.putExtras(bundle);

        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}

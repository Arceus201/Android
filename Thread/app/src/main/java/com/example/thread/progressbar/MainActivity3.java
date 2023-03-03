package com.example.thread.progressbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.thread.R;

public class MainActivity3 extends AppCompatActivity {
    private TextView tv;
    private ProgressBar bar;
    private Button bt;
    private Handler handler;

    private ProgressThread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tv = findViewById(R.id.tv);
        bar = findViewById(R.id.progressBar);
        bt = findViewById(R.id.btStart);

        // cap nhat cho bar
        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                bar.setProgress(msg.arg1);
                tv.setText(msg.arg1+"%");
            }
        };
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thread!=null)
                    thread.interrupt();
                bar.setProgress(0);
                thread = new ProgressThread();
                thread.start();
            }
        });
    }

    class ProgressThread extends Thread{
        @Override
        public void run() {
            for(int i=1;i<=100;i++){
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Log.d("Loi", e.getMessage());
                }
                Message ms = handler.obtainMessage();
                ms.arg1 = i;
                handler.sendMessage(ms);
            }
        }
    }
}
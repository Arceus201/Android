package com.example.thread.countdown;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thread.R;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private  Button btCount;
    private Handler handler;
    private static final int MESSAGE_COUNT_DOWN = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        btCount = findViewById(R.id.btCount);
        btCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDown().start();
            }
        });
        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what){
                    case MESSAGE_COUNT_DOWN:
                        tv.setText(msg.arg1+"");
                        break;
                    case 234:
                        Toast.makeText(MainActivity.this,"Finish" , Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                }
            }
        };
    }

    class  CountDown extends Thread{
        @Override
        public void run() {
            int count = 10;

            while (count>0){
                count--;
                Message msg = new Message();
                msg.what = MESSAGE_COUNT_DOWN;
                msg.arg1 = count;
                handler.sendMessage(msg);
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Log.d("Loi", e.getMessage());
                }
            }
            handler.sendEmptyMessage(234);

        }
    }
}
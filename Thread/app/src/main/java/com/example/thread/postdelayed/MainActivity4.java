package com.example.thread.postdelayed;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.thread.R;

public class MainActivity4 extends AppCompatActivity {
    private ImageView img;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        img = findViewById(R.id.img);
        bt = findViewById(R.id.btStart);
        ClipDrawable clip = (ClipDrawable)img.getDrawable();
        img.setImageLevel(0);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        int currentLevel = clip.getLevel();
                        if(currentLevel>=10000){
                            currentLevel=0;
                        }
                        img.setImageLevel(currentLevel+1000);
                        handler.postDelayed(this, 400);
                    }
                }, 400);
            }
        });
    }
}
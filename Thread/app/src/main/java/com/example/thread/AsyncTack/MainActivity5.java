package com.example.thread.AsyncTack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.thread.R;

public class MainActivity5 extends AppCompatActivity {


    private Button bt;
    private MyTask myTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);



        bt = findViewById(R.id.btStart);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTask = new MyTask(MainActivity5.this);
                myTask.execute();
                bt.setEnabled(false);
            }
        });
    }
}
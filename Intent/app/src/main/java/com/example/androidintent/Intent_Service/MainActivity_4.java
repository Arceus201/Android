package com.example.androidintent.Intent_Service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidintent.R;

public class MainActivity_4 extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        intent = new Intent(this,MyService.class);
    }
    public void start(View v){
        intent.putExtra("data", "Du lieu truyen vao Service");
        startService(intent);
    }
    public void stop(View v){
        stopService(intent);
    }
}
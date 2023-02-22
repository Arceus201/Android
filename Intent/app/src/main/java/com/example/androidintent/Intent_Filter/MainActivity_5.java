package com.example.androidintent.Intent_Filter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidintent.R;

public class MainActivity_5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


    }
    public  void email(View v){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, "hungnguyen090050@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "HELLO HUNG NGUYEN");
        startActivity(Intent.createChooser(intent, "Chon email..."));
    }
    public  void send(View v){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        startActivity(intent);
    }
}
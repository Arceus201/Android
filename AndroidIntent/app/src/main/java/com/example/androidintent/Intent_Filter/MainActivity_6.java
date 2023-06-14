package com.example.androidintent.Intent_Filter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.androidintent.R;

public class MainActivity_6 extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        intent = new Intent();
    }

    public void openweb(View v){
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://github.com/"));
        startActivity(intent);
    }

    public  void send(View v){
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("sms:094944234"));
        intent.putExtra("sms_body", "hello");
        startActivity(intent);
    }
    public  void call(View v){
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0493949"));
        startActivity(intent);
    }
}
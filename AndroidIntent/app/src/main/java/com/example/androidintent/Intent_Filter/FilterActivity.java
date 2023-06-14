package com.example.androidintent.Intent_Filter;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.example.androidintent.R;

public class FilterActivity extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        tv = findViewById(R.id.tv);
        //send mail
//        Uri url = getIntent().getData();
//        String s = "Scheme:" + url.getScheme()+
//                "\nHost:"+url.getHost();
//        int k = 1;
//        for(String i:url.getPathSegments()){
//            s += "\npara" + (k++)+": "+i;
//        }
//        s+="\n aciton:" + getIntent().getAction();
//        tv.setText(s);
        // send message

//        String s = " Content:" + getIntent().getStringExtra("sms_body").toString();
//        s += "\ndata:" + getIntent().getDataString();//sms:0320332
//        tv.setText(s);

        // tel
        String number = getIntent().getDataString().substring(4);//tel:003332758
        tv.setText(number);
    }
}
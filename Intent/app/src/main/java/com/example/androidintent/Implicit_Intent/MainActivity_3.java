package com.example.androidintent.Implicit_Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.androidintent.R;

public class MainActivity_3 extends AppCompatActivity implements View.OnClickListener{
    private ImageView imgweb,imgemail,imgphone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        imgweb = findViewById(R.id.img1);
        imgemail = findViewById(R.id.img2);
        imgphone = findViewById(R.id.img3);

        imgweb.setOnClickListener(this);
        imgphone.setOnClickListener(this);
        imgemail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img1:
                Intent w = new Intent(Intent.ACTION_VIEW);
                w.setData(Uri.parse("https://www.youtube.com/@sinhvienIT.official"));
                startActivity(w);
                break;
            case R.id.img2:
                Intent sms = new Intent(Intent.ACTION_VIEW);
                sms.setData(Uri.parse("sms:"+"034239688"));
                sms.putExtra("sms_body", "");
                startActivity(sms);
            case R.id.img3:
                Intent p = new Intent(Intent.ACTION_DIAL);
                p.setData(Uri.parse("tel:09493493"));
                startActivity(p);
                break;

        }
    }
}
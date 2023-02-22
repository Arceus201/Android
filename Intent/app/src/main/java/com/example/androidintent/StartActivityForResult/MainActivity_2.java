package com.example.androidintent.StartActivityForResult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.androidintent.R;
import com.example.androidintent.StartActivityForResult.model.Account_1;

public class MainActivity_2 extends AppCompatActivity {
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt = findViewById(R.id.tvmain);
        Intent intent = getIntent();
        if(intent.getSerializableExtra("account")!=null &&
                intent.getSerializableExtra("user")!=null){
            Account_1 log = (Account_1) intent.getSerializableExtra("account");
            Account_1 user = (Account_1) intent.getSerializableExtra("user");
            if(log.getUsername().equalsIgnoreCase(user.getUsername())
                    && log.getPassword().equalsIgnoreCase(user.getPassword())){
                txt.setText("Dang nhap thanh cong");
            }else{
                txt.setText("tai khoan khong ton tai");
            }
        }
    }
}
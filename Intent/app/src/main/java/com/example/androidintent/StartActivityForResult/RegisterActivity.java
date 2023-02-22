package com.example.androidintent.StartActivityForResult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidintent.R;
import com.example.androidintent.StartActivityForResult.model.Account_1;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText tvUser,tvPass;
    private Button btCancel,btRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
        btCancel.setOnClickListener(this);
        btRegister.setOnClickListener(this);
    }
    private  void initView(){
        tvUser = findViewById(R.id.tName);
        tvPass = findViewById(R.id.tpassword);
        btCancel = findViewById(R.id.btcancel);
        btRegister = findViewById(R.id.btregister);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btregister:
                Account_1 acc =
                        new Account_1(tvUser.getText().toString(),tvPass.getText().toString());
                Intent intent = new Intent();
                intent.putExtra("data", acc);
                setResult(RESULT_OK,intent);
                finish();
                break;
            case R.id.btcancel:
                setResult(RESULT_CANCELED,null);
                finish();
                break;
        }
    }
}
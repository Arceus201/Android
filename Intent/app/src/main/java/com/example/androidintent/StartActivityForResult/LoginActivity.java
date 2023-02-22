package com.example.androidintent.StartActivityForResult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidintent.R;
import com.example.androidintent.StartActivityForResult.model.Account_1;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText tvUser,tvPass;
    private Button btLogin,btRegister;

    private final static int REQUEST = 1000;

    private Account_1 user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        btLogin.setOnClickListener(this);
        btRegister.setOnClickListener(this);


    }
    private  void initView(){
        tvUser = findViewById(R.id.tName);
        tvPass = findViewById(R.id.tpassword);
        btLogin = findViewById(R.id.btlogin);
        btRegister = findViewById(R.id.btregister);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btlogin:
                Intent logIntent = new Intent(LoginActivity.this,MainActivity_2.class);
                Account_1 acc =
                        new Account_1(tvUser.getText().toString(),tvPass.getText().toString());

                logIntent.putExtra("account", acc);
                logIntent.putExtra("user", user);
                startActivity(logIntent);
                break;
            case R.id.btregister:
                Intent resIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivityForResult(resIntent, REQUEST);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST && resultCode == RESULT_OK){
            if(data==null){
                Toast.makeText(this, "Nguoi dung huy dang ky", Toast.LENGTH_LONG).show();
            }
            else{
                user =(Account_1) data.getSerializableExtra("data");
                tvUser.setText(user.getUsername());
                tvPass.setText(user.getPassword());
            }
        }else{
            user =null;
        }
    }
}
package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragment.model.FragmentA;
import com.example.fragment.model.FragmentB;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
    private Button bta,btb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();
    }

    private void initView(){
        bta = findViewById(R.id.bta);
        btb = findViewById(R.id.btb);

        bta.setOnClickListener(this);
        btb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        Fragment fg;
        switch (v.getId()){
            case R.id.bta:
                fg = new FragmentA();
                transaction.add(R.id.fragment_2, fg);
                break;
            case R.id.btb:
                fg = new FragmentB();
                transaction.add(R.id.fragment_2, fg);
                break;

        }
        transaction.commit();
    }
}
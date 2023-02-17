package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.fragment.model.FragmentA;
import com.example.fragment.model.FragmentB;
import com.example.fragment.model.FragmentC;

public class Activity_Backstack extends AppCompatActivity {
    private FragmentManager manager;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backstack);

        manager = getSupportFragmentManager();
    }
    // add
    private  void add(Fragment fg,String tag,String name){
        transaction = manager.beginTransaction();
        transaction.add(R.id.frame, fg,tag);

        transaction.addToBackStack(name);
        transaction.commit();
    }

    public  void addA(View v){
        FragmentA fg = new FragmentA();
        add(fg,"fragA", "fa");
    }
    public  void addB(View v){
        FragmentB fg = new FragmentB();
        add(fg,"fragB", "fb");
    }
    public  void addC(View v){
        FragmentC fg = new FragmentC();
        add(fg,"fragC", "fc");
    }

    //remove
    private void remove(Fragment fg,String tag){
        transaction = manager.beginTransaction();
        fg = manager.findFragmentByTag(tag);
        transaction.remove(fg);
        transaction.commit();
    }
    public void rmA(View v){
        FragmentA fg = new FragmentA();
        remove(fg, "fragA");
    }
    public void rmB(View v){
        FragmentB fg = new FragmentB();
        remove(fg, "fragB");

    } public void rmC(View v){
        FragmentC fg = new FragmentC();
        remove(fg, "fragC");
    }

    // back
    public  void back(View v){
        manager.popBackStack();
    }

    //pop A
    public  void popA(View v){
        manager.popBackStack("fa",0);
    }

    @Override
    public void onBackPressed() {
        if(manager.getBackStackEntryCount()>0)
            manager.popBackStack();
        super.onBackPressed();
    }
}
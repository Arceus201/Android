package com.example.thread.RSS_AsynTask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.thread.R;

public class MainActivity6 extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        recyclerView = findViewById(R.id.recycleViewA);
        String link = "https://vnexpress.net/rss/the-gioi.rss";
        MyAsyncTask myAsyncTask = new MyAsyncTask(MainActivity6.this, link, recyclerView);
        myAsyncTask.execute();
    }
}
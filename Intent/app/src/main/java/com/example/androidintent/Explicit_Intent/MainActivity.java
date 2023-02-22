package com.example.androidintent.Explicit_Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidintent.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(MainActivity.this, SecondActivity.class);
                String name = "nguyen trong hung";
                int age =22;
                String [] sub = {"oop","web","android"};
                Student sv = new Student(R.drawable.ic_launcher_background,"hung nguyen",22);
                Student sv2 = new Student(R.drawable.ic_launcher_background,"hung nguyen 1",23);
                Student sv3 = new Student(R.drawable.ic_launcher_background,"hung nguyen 2",24);
                List<Student> list = new ArrayList<>();

                list.add(sv);
                list.add(sv2);
                list.add(sv3);

                t.putExtra("name", name);
                t.putExtra("age", age);
                t.putExtra("sub", sub);
                t.putExtra("st", sv);
                t.putExtra("data", (Serializable)list);

                startActivity(t);
            }
        });
    }
}
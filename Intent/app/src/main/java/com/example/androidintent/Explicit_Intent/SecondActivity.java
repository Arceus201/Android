package com.example.androidintent.Explicit_Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidintent.R;

import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private Button bt;
    private TextView tvName,tvage, tvsub;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        bt = findViewById(R.id.button2);
        tvName = findViewById(R.id.textView2);
        tvage = findViewById(R.id.textView4);
        tvsub = findViewById(R.id.textView5);
        img = findViewById(R.id.imageView);

        Intent t = getIntent();
        String name = t.getStringExtra("name");
        int age = t.getIntExtra("age", 21);
        String[] sub = t.getStringArrayExtra("sub");
        Student s = (Student) t.getSerializableExtra("st");
        List<Student> list = (List<Student>) t.getSerializableExtra("data");
        String tmp="";
        for(Student i: list){
            tmp += (i.getName() +","+ i.getAge());
        }


        img.setImageResource(s.getImg());
        tvName.setText(s.getName());
        tvage.setText(s.getAge()+"");
        tvsub.setText(tmp);

//        tvage.setText(""+tvage);
//        tvName.setText(name);
//        tvsub.setText(Arrays.toString(sub));
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
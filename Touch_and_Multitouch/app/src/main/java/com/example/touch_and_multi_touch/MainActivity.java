package com.example.touch_and_multi_touch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private EditText e1,e2,e3,e4;
    private ImageView img;
    private float xDown=0,yDow=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int action = event.getAction();
                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        xDown = event.getX();
                        yDow = event.getY();
                        e1.setText(xDown+"" );
                        e2.setText(yDow+"");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float moveX = event.getX();
                        float moveY = event.getY();
                        e3.setText(moveX+"" );
                        e4.setText(moveY+"");
                        float dx = moveX-xDown;
                        float dy = moveY -yDow;
                        img.setX(img.getX()+dx);
                        img.setY(img.getY()+dy);
                        break;

                }
                return true;

            }
        });
    }
    private void initView(){
        e1 = findViewById(R.id.txt1);
        e2 = findViewById(R.id.txt2);
        e3 = findViewById(R.id.txt3);
        e4 = findViewById(R.id.txt4);
        img = findViewById(R.id.img);

    }
}
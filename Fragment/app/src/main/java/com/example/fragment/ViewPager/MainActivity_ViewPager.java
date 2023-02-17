package com.example.fragment.ViewPager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragment.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity_ViewPager extends AppCompatActivity implements View.OnClickListener{
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Button btP,btN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view_pager);
        initView();
        btP.setOnClickListener(this);
        btN.setOnClickListener(this);

        FragmentManager manager = getSupportFragmentManager();

        ViewPagerAdapter adapter = new ViewPagerAdapter(manager,3);

     //   viewPager.setPageTransformer(true,new ajnncncnsdjcnj);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        setTabLayouColor();

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               switch (tab.getPosition()){
                   case 0:
                       tabLayout.setTabTextColors(Color.BLACK,getResources().getColor(R.color.colorPink ));
                       btP.setBackgroundColor(getResources().getColor(R.color.colorPink));
                       btN.setBackgroundColor(getResources().getColor(R.color.colorPink));
                       break;
                   case 1:
                       tabLayout.setTabTextColors(Color.BLACK,getResources().getColor(R.color.colorBlue ));
                       btP.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                       btN.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                       break;
                   case 2:
                       tabLayout.setTabTextColors(Color.BLACK,getResources().getColor(R.color.colorGreen ));
                       btP.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                       btN.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                       break;
               }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    private void initView(){
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabLayout);
        btP = findViewById(R.id.bt1);
        btN = findViewById(R.id.bt2);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt2:
                if(viewPager.getCurrentItem()==2){
                    return;
                }else{
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    setTabLayouColor();
                }
                break;
            case R.id.bt1:
                if(viewPager.getCurrentItem()==0){
                    return;
                }else{
                    viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
                    setTabLayouColor();
                }
                break;

        }
    }
    // set lai mau cho fragment khi Next or Back
    private void setTabLayouColor() {
        switch (viewPager.getCurrentItem()){
            case 0:
                tabLayout.setTabTextColors(Color.BLACK,getResources().getColor(R.color.colorPink ));
                break;
            case 1:
                tabLayout.setTabTextColors(Color.BLACK,getResources().getColor(R.color.colorBlue ));
                break;
            case 2:
                tabLayout.setTabTextColors(Color.BLACK,getResources().getColor(R.color.colorGreen ));
                break;
        }
    }
    // Back
    @Override
    public void onBackPressed() {
        if(viewPager.getCurrentItem()==0)
             super.onBackPressed();
        else
            viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
    }
}
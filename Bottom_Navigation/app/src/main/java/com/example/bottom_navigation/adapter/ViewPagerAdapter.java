package com.example.bottom_navigation.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.bottom_navigation.fragment.FragmentNotification;
import com.example.bottom_navigation.fragment.fragmentCafe;
import com.example.bottom_navigation.fragment.fragmentHome;
import com.example.bottom_navigation.fragment.fragmentSearch;

public class ViewPagerAdapter extends FragmentStatePagerAdapter{
    int pageNumber;
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.pageNumber = behavior;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new fragmentHome();
            case 1:
                return new FragmentNotification();
            case 2:
                return new fragmentSearch();
            case 3:
                return new fragmentCafe();
            default:return new fragmentHome();

        }
    }

    @Override
    public int getCount() {
        return pageNumber;
    }
}

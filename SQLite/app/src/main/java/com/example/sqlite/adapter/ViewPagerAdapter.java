package com.example.sqlite.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.sqlite.fragment.FragmntHistory;
import com.example.sqlite.fragment.FragmntHome;
import com.example.sqlite.fragment.FragmntSearch;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new FragmntHome();
            case 1:return new FragmntHistory();
            case 2:return new FragmntSearch();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}

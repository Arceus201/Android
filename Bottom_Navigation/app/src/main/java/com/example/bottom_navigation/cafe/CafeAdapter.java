package com.example.bottom_navigation.cafe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class CafeAdapter extends FragmentStatePagerAdapter {
    public CafeAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new fragmentCafe1();
            case 1:
                return new fragmentCafe2();
            case 2:
                return new fragmentCafe3();
            default:return new fragmentCafe1();


        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Cafe 1";
            case 1: return "Cafe 2";
            case 2: return "Cafe 3";

            default:return "Cafe 1";


        }
    }
}

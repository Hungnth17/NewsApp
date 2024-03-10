package com.example.newsapp.View.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.newsapp.View.EntertainmentFragment;
import com.example.newsapp.View.HealthFragment;
import com.example.newsapp.View.HomeFragment;
import com.example.newsapp.View.ScienceFragment;
import com.example.newsapp.View.SportFragment;
import com.example.newsapp.View.TechnologyFragment;

public class pagerAdapter extends FragmentPagerAdapter {

    int tabcount;

    public pagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new SportFragment();
            case 2:
                return new HealthFragment();
            case 3:
                return new ScienceFragment();
            case 4:
                return new EntertainmentFragment();
            case 5:
                return new TechnologyFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}

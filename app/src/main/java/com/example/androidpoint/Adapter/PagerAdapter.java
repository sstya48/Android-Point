package com.example.androidpoint.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.androidpoint.Fragment.AdvanceFragment;
import com.example.androidpoint.Fragment.BasicFragment;
import com.example.androidpoint.Fragment.HomeFragment;
import com.example.androidpoint.Fragment.LearnFragment;


public class PagerAdapter extends FragmentPagerAdapter {

    private int tabno;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior,int tabno) {
        super(fm, behavior);
        this.tabno = tabno;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new BasicFragment();
            case 1:
                return new AdvanceFragment();
            case 2:
                return new LearnFragment();
           /* case 3:
                return new IGTVFragment();
            case 4:
                return new ProfilePicFragment();*/
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return tabno;
    }
}

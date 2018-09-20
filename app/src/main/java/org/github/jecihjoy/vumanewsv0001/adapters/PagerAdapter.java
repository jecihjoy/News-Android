package org.github.jecihjoy.vumanewsv0001.adapters;

/**
 * Created by Jecihjoy on 6/9/2018.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.github.jecihjoy.vumanewsv0001.fragments.GoogleFragment;
import org.github.jecihjoy.vumanewsv0001.fragments.HomeFragment;
import org.github.jecihjoy.vumanewsv0001.fragments.SportsFragment;
import org.github.jecihjoy.vumanewsv0001.fragments.EnterFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new  HomeFragment();
            case 1:
                return new GoogleFragment();
            case 2:
                return new SportsFragment();
            case 3:
                return new EnterFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
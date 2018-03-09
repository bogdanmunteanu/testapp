package ro.bogdanmunteanu.testapp.helpers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import ro.bogdanmunteanu.testapp.fragments.one.FragmentOne;
import ro.bogdanmunteanu.testapp.fragments.two.FragmentTwo;

public class ViewPagerAdapter extends FragmentPagerAdapter{

    private ArrayList<Fragment> fragmentList;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragmentList = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return FragmentOne.newInstance();
            case 1: return FragmentTwo.newInstance();
            default: return FragmentOne.newInstance();
        }
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}

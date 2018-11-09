package com.example.yo.pgl_rgc_tabs_fragments_try_03;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {
    public MainFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new MainFragment().newInstance(position);

    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Country";
            case 1:
                return "Agreement";
            case 2:
                return "Profile";
            case 3:
                return "Employee";
            case 4:
                return "Payroll";
        }
        return super.getPageTitle(position);
    }
}

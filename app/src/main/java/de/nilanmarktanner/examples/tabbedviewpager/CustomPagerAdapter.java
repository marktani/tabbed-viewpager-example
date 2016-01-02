package de.nilanmarktanner.examples.tabbedviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class CustomPagerAdapter extends FragmentStatePagerAdapter {
    private final List<String> tabTitles = new ArrayList<String>() {{
        add("Normal");
        add("Big");
    }};

    private List<Fragment> tabs = new ArrayList<>();

    public CustomPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);

        initializeTabs();
    }

    private void initializeTabs() {
        tabs.add(HostFragment.newInstance(new ContentFragment()));
        tabs.add(HostFragment.newInstance(ContentFragment.newInstance(1, 30)));
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);
    }
}

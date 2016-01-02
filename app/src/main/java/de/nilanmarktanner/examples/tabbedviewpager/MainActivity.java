package de.nilanmarktanner.examples.tabbedviewpager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private CustomPagerAdapter customPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        customPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager());

        // increase this limit if you have more tabs!
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(customPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onBackPressed()
    {
        if(!BackStackFragment.handleBackPressed(getSupportFragmentManager())){
            super.onBackPressed();
        }
    }

    public void openNewContentFragment(int depth, int fontSize) {
        HostFragment hostFragment = (HostFragment) customPagerAdapter.getItem(viewPager.getCurrentItem());
        hostFragment.replaceFragment(ContentFragment.newInstance(depth, fontSize), true);
    }
}

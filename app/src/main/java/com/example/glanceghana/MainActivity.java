package com.example.glanceghana;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.view_pager);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
//        initialise and create page fragments with their various titles
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new WelcomeFragment(), getResources().getString(R.string.welcome));
        adapter.addFragment(new HomeFragment(), getResources().getString(R.string.home));
        adapter.addFragment(new HotelsFragment(), getResources().getString(R.string.hotels));
        adapter.addFragment(new TipsFragment(), getResources().getString(R.string.tips));
        viewPager.setAdapter(adapter);
    }

}
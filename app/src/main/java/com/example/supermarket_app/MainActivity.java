package com.example.supermarket_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewpager;
    private TabLayout tablayout;
    private expiry expiry;
    private weight weight;
    private nearby nearby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewpager=findViewById(R.id.viewpager);
        tablayout=findViewById(R.id.tablayout);
        expiry=new expiry();
        weight=new weight();
        nearby=new nearby();
        tablayout.setupWithViewPager(viewpager);
        ViewPagerAdapter viewpageadapter=new ViewPagerAdapter(getSupportFragmentManager(),0);

        viewpageadapter.addFragment(expiry,"Expiry");
        viewpageadapter.addFragment(weight,"Weight");
        viewpageadapter.addFragment(nearby,"Nearby");
        viewpager.setAdapter(viewpageadapter);
        tablayout.getTabAt(0).setIcon(R.drawable.ic_baseline_access_alarm_24);
        tablayout.getTabAt(1).setIcon(R.drawable.ic_weight);
        tablayout.getTabAt(2).setIcon(R.drawable.ic_baseline_location_on_24);

    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments=new ArrayList<>();
        private List<String> fragmenttitle=new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }
        public void addFragment(Fragment fragment, String title){
            fragments.add(fragment);
            fragmenttitle.add(title);
        }
        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmenttitle.get(position);
        }
    }
}
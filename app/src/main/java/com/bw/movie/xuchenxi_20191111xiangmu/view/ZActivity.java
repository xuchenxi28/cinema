package com.bw.movie.xuchenxi_20191111xiangmu.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.bw.movie.xuchenxi_20191111xiangmu.fragment.CinemaFragment;
import com.bw.movie.xuchenxi_20191111xiangmu.fragment.MovieFragment;
import com.bw.movie.xuchenxi_20191111xiangmu.fragment.MyFragment;

import java.util.ArrayList;

public class ZActivity extends AppCompatActivity {

    private RadioGroup radiogroup_one;
    private NoScrollViewPager viewpger_one;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_z);
        radiogroup_one = findViewById(R.id.radiogroup_one);
        viewpger_one = findViewById(R.id.viewpger_one);


        fragments = new ArrayList<>();
        fragments.add(new MovieFragment());
        fragments.add(new CinemaFragment());
        fragments.add(new MyFragment());

        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return fragments.size();
            }

            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }
        };
        viewpger_one.setAdapter(fragmentPagerAdapter);
        radiogroup_one.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_movie:
                        viewpger_one.setCurrentItem(0);
                        break;
                    case R.id.radio_cinema:
                        viewpger_one.setCurrentItem(1);
                        break;
                    case R.id.radio_my:
                        viewpger_one.setCurrentItem(2);
                        break;
                }
            }
        });
        viewpger_one.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radiogroup_one.check(R.id.radio_movie);
                        break;
                    case 1:
                        radiogroup_one.check(R.id.radio_cinema);
                        break;
                    case 2:
                        radiogroup_one.check(R.id.radio_my);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}

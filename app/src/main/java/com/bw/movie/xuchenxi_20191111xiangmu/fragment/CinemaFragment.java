package com.bw.movie.xuchenxi_20191111xiangmu.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.library.base.BaseFragment;
import com.bawei.library.base.BasePresenter;
import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;


public class CinemaFragment extends BaseFragment {

    @BindView(R.id.tabls_one)
    TabLayout tablsOne;
    @BindView(R.id.cinema_vp)
    ViewPager cinemaVp;
    private ArrayList<String> strings;
    private ArrayList<Fragment> fragments;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_cinema;
    }

    @Override
    protected void initView() {
        strings = new ArrayList<>();
        fragments = new ArrayList<>();
        strings.add("推荐影院");
        strings.add("附近影院");
        strings.add("海淀区▼");
        fragments.add(new RecommendedFragment());
        fragments.add(new NearbyFragment());
        fragments.add(new HaiDianFragment());
    }

    @Override
    protected void initData() {
        cinemaVp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
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
                return strings.get(position);
            }
        });
        tablsOne.setupWithViewPager(cinemaVp);
    }
}

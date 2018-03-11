package jp.androidbook.mystudiyproject.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jp.androidbook.mystudiyproject.R;
import jp.androidbook.mystudiyproject.adapter.MainFragmentPagerAdapter;

public class MainFragment extends Fragment {

    private Unbinder unbinder;

    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    public static MainFragment getMainFragment(){
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_main_home,container, false);
        unbinder = ButterKnife.bind(this,view);
        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MainFragmentPagerAdapter adapter = new MainFragmentPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

}

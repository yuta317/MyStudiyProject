package jp.androidbook.mystudiyproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import jp.androidbook.mystudiyproject.fragment.MainNameFragment;
import jp.androidbook.mystudiyproject.fragment.MainMemoFragment;
import jp.androidbook.mystudiyproject.fragment.MainTimeFragment;



public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[]{"名前", "メモ", "時間"};

    public MainFragmentPagerAdapter(FragmentManager manager) {
        super(manager);
    }


    //TODO  表示するフラグメントを渡す
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return MainNameFragment.getMainNameFragment();
            case 1:
                return MainMemoFragment.getMainTeamFragment();
            case 2:
                return MainTimeFragment.getMainTimeFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}

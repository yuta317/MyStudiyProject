package jp.androidbook.mystudiyproject.adapter;







import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import jp.androidbook.mystudiyproject.fragment.MainNameFragment;
import jp.androidbook.mystudiyproject.fragment.MainTeamFragment;
import jp.androidbook.mystudiyproject.fragment.MainTimeFragment;

/**
 * Created by kikumayuuta on 2018/03/04.
 */

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

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
                return MainTeamFragment.getMainTeamFragment();
            case 2:
                return MainTimeFragment.getMainTimeFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}

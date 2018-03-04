package jp.androidbook.mystudiyproject.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jp.androidbook.mystudiyproject.R;

public class MainFragment extends Fragment {

    public static MainFragment getMainFragment(){
        MainFragment mainFragment = new MainFragment();

        return mainFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_main_home,container, false);

        return view;
    }
}

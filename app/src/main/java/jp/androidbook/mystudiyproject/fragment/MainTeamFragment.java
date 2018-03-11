package jp.androidbook.mystudiyproject.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import jp.androidbook.mystudiyproject.R;



public class MainTeamFragment extends android.support.v4.app.Fragment{
    private Unbinder unbinder;

    public static MainTeamFragment getMainTeamFragment(){
        MainTeamFragment mainFragmentTeam = new MainTeamFragment();

        return mainFragmentTeam;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_main_team,container, false);
       unbinder = ButterKnife.bind(this,view);

        return view;
    }
}

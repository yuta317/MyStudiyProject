package jp.androidbook.mystudiyproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jp.androidbook.mystudiyproject.R;



public class MainNameFragment extends android.support.v4.app.Fragment{

    private Unbinder unbinder;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    
    public static MainNameFragment getMainNameFragment(){
        MainNameFragment mainFragmentName = new MainNameFragment();

        return mainFragmentName;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_main_name,container, false);
        unbinder = ButterKnife.bind(this,view);
        return view;
    }
}

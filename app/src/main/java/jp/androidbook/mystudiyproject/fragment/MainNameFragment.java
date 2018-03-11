package jp.androidbook.mystudiyproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jp.androidbook.mystudiyproject.R;
import jp.androidbook.mystudiyproject.adapter.MainNameRecycleViewAdapter;
import jp.androidbook.mystudiyproject.data.NameData;


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

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainNameRecycleViewAdapter adapter = new MainNameRecycleViewAdapter(this.createDataset());

        LinearLayoutManager llm = new LinearLayoutManager(getContext());

        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(llm);

        mRecyclerView.setAdapter(adapter);
    }

    private List<NameData> createDataset() {
        List<NameData> dataset = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            NameData data = new NameData();
            data.setName("けやき" + (i + 1) + "号");
            dataset.add(data);
        }
        return dataset;
    }
}

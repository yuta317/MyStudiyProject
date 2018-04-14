package jp.androidbook.mystudiyproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import jp.androidbook.mystudiyproject.R;
import jp.androidbook.mystudiyproject.data.NameData;
import jp.androidbook.mystudiyproject.viewHolder.MainHomeViewHolder;


public class MainNameRecycleViewAdapter extends RecyclerView.Adapter<MainHomeViewHolder> {

    private List<NameData> list;
    private View.OnClickListener listener;

    public MainNameRecycleViewAdapter(List<NameData> list) {
        this.list = list;
    }

    @Override
    public MainHomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_name_item, parent,false);
        MainHomeViewHolder viewHolder = new MainHomeViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainHomeViewHolder holder, int position) {
        holder.nameText.setText(list.get(position).getName());
        holder.linearLayout.setId(holder.getAdapterPosition());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(view);
            }
        });
    }

    public void setOnItemClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

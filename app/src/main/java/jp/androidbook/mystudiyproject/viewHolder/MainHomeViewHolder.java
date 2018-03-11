package jp.androidbook.mystudiyproject.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jp.androidbook.mystudiyproject.R;



public class MainHomeViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.nameTextView)
    public TextView nameText;

    Unbinder unbinder;


    public MainHomeViewHolder(View itemView) {
        super(itemView);
        unbinder = ButterKnife.bind(this, itemView);
    }
}

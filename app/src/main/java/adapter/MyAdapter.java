package adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import baway.com.recyclerviewdemo.R;

/**
 * Created by 贾秀坤 on 2017/8/31.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<String> list;

    public MyAdapter() {
        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("条目" + i);
        }
    }

    //创建布局和viewholder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View recy = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_item, null);
        return new MyViewHolder(recy);
    }

    //绑定数据
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(list.get(position));
        if (position % 2 == 1) {
            holder.icon.setImageResource(R.drawable.brad_pitt);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv;
        private final ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
            icon = (ImageView) itemView.findViewById(R.id.icon);

        }
    }


}

package com.example.x.walletstory;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by X on 5/20/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context mContext;
    List<Expenses> mData;

    public RecyclerViewAdapter(Context mContext, List<Expenses> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_expenses, parent, false);
        MyViewHolder vHolder = new MyViewHolder(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.expenses_title.setText(mData.get(position).getTitle());
        holder.expenses_img.setImageResource(mData.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView expenses_title;
        private ImageView expenses_img;

        public MyViewHolder(View itemView) {
            super(itemView);

            expenses_title = (TextView) itemView.findViewById(R.id.title_expenses);
            expenses_img = (ImageView)  itemView.findViewById(R.id.img_expenses);
        }
    }


}

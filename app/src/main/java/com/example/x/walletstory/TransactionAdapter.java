package com.example.x.walletstory;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by X on 5/25/2018.
 */

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.MyViewHolder> {
    Context mContext;
    List<Data> mData;

    public TransactionAdapter(Context mContext, List<Data> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_transaction, parent, false);
        final MyViewHolder myViewHolder = new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.category_img.setImageResource(mData.get(position).getIcon());
        holder.date.setText(mData.get(position).getDate());
        holder.month.setText(mData.get(position).getMonth());
        holder.year.setText(mData.get(position).getYear());
        holder.description.setText(mData.get(position).getDescription());
        holder.amount.setText((int) mData.get(position).getAmount());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout layout;
        private ImageView category_img;
        private TextView date;
        private TextView month;
        private TextView year;
        private TextView description;
        private TextView amount;

        public MyViewHolder(View itemView) {
            super(itemView);

            layout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
            category_img = (ImageView) itemView.findViewById(R.id.category_imgview);
            date = (TextView) itemView.findViewById(R.id.date_txtview);
            month = (TextView) itemView.findViewById(R.id.month_txtview);
            year = (TextView) itemView.findViewById(R.id.year_txtview);
            description = (TextView) itemView.findViewById(R.id.desc_txtview);
            amount = (TextView) itemView.findViewById(R.id.amount_txtview);
        }
    }
}

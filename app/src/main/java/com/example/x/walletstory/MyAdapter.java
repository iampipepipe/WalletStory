package com.example.x.walletstory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<Data> mDatas;
    private LayoutInflater mLayoutInflater;

    public MyAdapter(Context context, List<Data> aList) {
        mDatas = aList;
        mLayoutInflater = LayoutInflater.from(context);
    }


    static class ViewHolder {
        TextView tvId;
        TextView tvDate;
        TextView tvMonth;
        TextView tvYear;
        TextView tvAmount;
        TextView tvDescription;
        TextView tvCategory;
        TextView tvType;
        //ImageView img;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.layout_detail,viewGroup,false);
            holder = new ViewHolder();
            holder.tvId = (TextView)view.findViewById(R.id.txtId);
            holder.tvDate = (TextView)view.findViewById(R.id.txtDate);
            holder.tvMonth = (TextView)view.findViewById(R.id.txtMonth);
            holder.tvYear = (TextView)view.findViewById(R.id.txtYear);
            holder.tvAmount = (TextView)view.findViewById(R.id.txtAmount);
            holder.tvDescription = (TextView)view.findViewById(R.id.txtDescription);
            holder.tvCategory = (TextView)view.findViewById(R.id.txtCategory);
            holder.tvType = (TextView)view.findViewById(R.id.txtType);
            //holder.img = (TextView)view.findViewById(R.id.img);
            view.setTag(holder);
        } else {
            holder = (ViewHolder)view.getTag();
        }
        holder.tvId.setText(Integer.toString(mDatas.get(position).getId()));
        holder.tvDate.setText(Integer.toString(mDatas.get(position).getDate()));
        holder.tvMonth.setText(Integer.toString(mDatas.get(position).getMonth()));
        holder.tvYear.setText(Integer.toString(mDatas.get(position).getYear()));
        holder.tvAmount.setText(Double.toString(mDatas.get(position).getAmount()));
        holder.tvDescription.setText(mDatas.get(position).getDescription());
        holder.tvCategory.setText(mDatas.get(position).getCategory());
        holder.tvType.setText(mDatas.get(position).getType());
        //holder.img.setText(mDatas.get(position).getId());
        return view;
    }

}

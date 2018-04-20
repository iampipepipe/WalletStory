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
        TextView tvTitle;
        TextView tvDesc;
        TextView tvValue;
        ImageView img;
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
            holder.tvTitle = (TextView)view.findViewById(R.id.txtTitle);
            holder.tvDesc = (TextView)view.findViewById(R.id.txtDescription);
            holder.tvValue = (TextView)view.findViewById(R.id.txtValue);
          //  holder.img = (ImageView)view.findViewById(R.id.icon);
            view.setTag(holder);
        } else {
            holder = (ViewHolder)view.getTag();
        }
        String title = mDatas.get(position).getmText1();
        holder.tvTitle.setText(title);
        holder.tvDesc.setText(mDatas.get(position).getmText2());
        holder.tvValue.setText(mDatas.get(position).getValue());
        //holder.img.setImageResource(mDatas.get(position).getmIcon());

        return view;
    }

}

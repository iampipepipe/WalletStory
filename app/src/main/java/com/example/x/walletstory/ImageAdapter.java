package com.example.x.walletstory;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private static final Integer[] mThumbIds = {
            R.mipmap.award,
            R.mipmap.beauty,
            R.mipmap.bills,
            R.mipmap.car,
            R.mipmap.cat,
            R.mipmap.computer,
            R.mipmap.credit,
            R.mipmap.delivery,
            R.mipmap.dog,
            R.mipmap.education,
            R.mipmap.electricity,
            R.mipmap.entertainment,
            R.mipmap.family,
            R.mipmap.fire,
            R.mipmap.food,
            R.mipmap.gift,
            R.mipmap.groceries,
            R.mipmap.health,
            R.mipmap.home,
            R.mipmap.icecream,
            R.mipmap.interest,
            R.mipmap.laptop,
            R.mipmap.question,
            R.mipmap.repair,
            R.mipmap.salary,
            R.mipmap.sale,
            R.mipmap.shopping,
            R.mipmap.smartphone,
            R.mipmap.sport,
            R.mipmap.transaction,
            R.mipmap.transport,
            R.mipmap.travel,
            R.mipmap.water,
            R.mipmap.work
    };
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(100, 100));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0, 0, 0, 0);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    public int getIconId(int index){
        return mThumbIds[index];
    }
}

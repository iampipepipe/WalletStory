package com.example.x.walletstory;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by X on 4/26/2018.
 */

public class CategoriesAdapter extends BaseAdapter {
    private List<CategoriesData> categoriesData;
    private LayoutInflater layoutInflater;

    public CategoriesAdapter(Context context, List<CategoriesData> categoriesList) {
        categoriesData = categoriesList;
        layoutInflater = LayoutInflater.from(context);
    }

    static class ViewHolder {
        TextView categoriesTitle;
        ImageView categoriesImage;
    }

    @Override
    public int getCount() {
        return categoriesData.size();
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
            view = layoutInflater.inflate(R.layout.categories_layout,viewGroup,false);
            holder = new ViewHolder();
            holder.categoriesTitle = (TextView)view.findViewById(R.id.categories_title);
            holder.categoriesImage = (ImageView)view.findViewById(R.id.categories_image);
            view.setTag(holder);
        } else {
            holder = (ViewHolder)view.getTag();
        }

        String title = categoriesData.get(position).getTitle();
        holder.categoriesTitle.setText(title);
        holder.categoriesImage.setImageResource(categoriesData.get(position).getIcon());

        return view;
    }
}

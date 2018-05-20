package com.example.x.walletstory;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by X on 5/20/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context mContext;
    List<Categories> mData;
    Dialog myDialog;

    public RecyclerViewAdapter(Context mContext, List<Categories> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.categories_item, parent, false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.categories_dialog);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        vHolder.categories_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView dialog_title = (TextView) myDialog.findViewById(R.id.category_title);
                TextView dialog_type = (TextView) myDialog.findViewById(R.id.category_type);
                ImageView dialog_img = (ImageView) myDialog.findViewById(R.id.category_img);
                Button dialog_close = (Button) myDialog.findViewById(R.id.close_button);

                dialog_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDialog.dismiss();
                    }
                });

                dialog_title.setText(mData.get(vHolder.getAdapterPosition()).getTitle());
                dialog_type.setText(mData.get(vHolder.getAdapterPosition()).getDesc());
                dialog_img.setImageResource(mData.get(vHolder.getAdapterPosition()).getImage());

                myDialog.show();
            }
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.categories_title.setText(mData.get(position).getTitle());
        holder.categories_desc.setText(mData.get(position).getDesc());
        holder.categories_img.setImageResource(mData.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout categories_item;
        private TextView categories_title;
        private TextView categories_desc;
        private ImageView categories_img;

        public MyViewHolder(View itemView) {
            super(itemView);

            categories_item = (LinearLayout) itemView.findViewById(R.id.item_categories);
            categories_title = (TextView) itemView.findViewById(R.id.title_categories);
            categories_desc = (TextView) itemView.findViewById(R.id.desc_categories);
            categories_img = (ImageView)  itemView.findViewById(R.id.img_categories);
        }
    }

}

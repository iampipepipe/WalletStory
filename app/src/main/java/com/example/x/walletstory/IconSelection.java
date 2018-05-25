package com.example.x.walletstory;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;

public class IconSelection extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private  GridView gridView;
    private  ImageAdapter imageAdapter;
    private  Dialog dialog;
    private static int icon = R.mipmap.question;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.icon_category);

        gridView = (GridView)findViewById(R.id.gridview);
        imageAdapter = new ImageAdapter(this);
        gridView.setAdapter(imageAdapter);
        gridView.setOnItemClickListener(this);
    }


    public int getIcon() {
        return icon;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        icon = imageAdapter.getIconId(position);

        Intent intent = new Intent(this,AddCategoryActivity.class);
        startActivity(intent);
    }
}

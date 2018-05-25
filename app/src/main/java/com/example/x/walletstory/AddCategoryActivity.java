package com.example.x.walletstory;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AddCategoryActivity extends AppCompatActivity {
    private DatabaseHandler mydb = new DatabaseHandler(this);

    private IconSelection iconSelection = new IconSelection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageButton editIcon = (ImageButton) findViewById(R.id.category_imgbtn);
        editIcon.setImageResource(iconSelection.getIcon());



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void saveCategory(View v) {
        EditText editCategory = (EditText)findViewById(R.id.category_input);
        ImageButton editIcon = (ImageButton) findViewById(R.id.category_imgbtn);
        RadioButton radioExpense = (RadioButton)findViewById(R.id.expense_radiobtn);
        RadioButton radioIncome = (RadioButton)findViewById(R.id.income_radiobtn);
        String type = null;

        if(radioExpense.isChecked()){
            type = "expense";
        }
        if(radioIncome.isChecked()){
            type = "income";
        }

        String category = editCategory.getText().toString();
        int icon = editIcon.getId();
        mydb.addCategoryRecord(category,type,icon);




        Intent intent = new Intent(this,CategoriesActivity.class);
        startActivity(intent);
    }

    public void addIcon(View v){
        Intent intent = new Intent(this,IconSelection.class);
        startActivity(intent);

    }

}

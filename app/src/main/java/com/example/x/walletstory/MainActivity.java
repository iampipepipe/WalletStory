package com.example.x.walletstory;

import android.content.Intent;

import android.support.constraint.ConstraintLayout;

import android.support.annotation.NonNull;

import android.support.design.internal.NavigationMenu;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;

import android.widget.PopupWindow;
import android.widget.TextView;

import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    DatabaseHandler mydb = new DatabaseHandler(this);
    ListView lv;
    MyAdapter adapter;

    private List<Data> datas = new ArrayList<>();
    public static Data detail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        //show database all



        for(int i=1;i<=mydb.getRecordCount();i++){
            datas.add(mydb.getRecord(i));
        }
        adapter = new MyAdapter(this,datas);
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /* int id = item.getItemId();

        switch (id) {
            case R.id.transaction_id :
                Toast.makeText(this, "Transaction clicked", Toast.LENGTH_SHORT).show();
            case R.id.categories_id :
                Toast.makeText(this, "Categories clicked", Toast.LENGTH_SHORT).show();
        } */
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.transaction_id :
                Toast.makeText(this, "Transaction clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.categories_id :
                Toast.makeText(this, "Categories clicked", Toast.LENGTH_SHORT).show();
                Intent categories = new Intent();
                categories.setClass(MainActivity.this, CategoriesActivity.class);
                startActivity(categories);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    public void addIncome(View v){

        FrameLayout frame = (FrameLayout)findViewById(R.id.frameIn);

        frame.setVisibility(View.VISIBLE);

        FrameLayout frame2 = (FrameLayout)findViewById(R.id.frameEx);
        frame2.setVisibility(View.INVISIBLE);
        /*mydb.addRecord("food",30,"06-04-2018");
            datas.add(mydb.getRecord(mydb.getRecordCount()));

        mydb.addRecord("food",30,"06-04-2018");
        datas.add(mydb.getRecord(mydb.getRecordCount()));

        adapter = new MyAdapter(this,datas);
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);*/

    }
    public void addExpense(View v){
        FrameLayout frame = (FrameLayout)findViewById(R.id.frameEx);

        frame.setVisibility(View.VISIBLE);
        FrameLayout frame1 = (FrameLayout)findViewById(R.id.frameIn);
        frame1.setVisibility(View.INVISIBLE);
        /*mydb.addRecord("tea",-35,"06-04-2018");
        datas.add(mydb.getRecord(mydb.getRecordCount()));
        adapter = new MyAdapter(this,datas);
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);*/
    }
    public void clickSave(View v){
        FrameLayout frame1 = (FrameLayout)findViewById(R.id.frameIn);
        frame1.setVisibility(View.INVISIBLE);
        FrameLayout frame2 = (FrameLayout)findViewById(R.id.frameEx);
        frame2.setVisibility(View.INVISIBLE);


    }
    public void clickCancel(View v){
        FrameLayout frame1 = (FrameLayout)findViewById(R.id.frameIn);
        frame1.setVisibility(View.INVISIBLE);
        FrameLayout frame2 = (FrameLayout)findViewById(R.id.frameEx);
        frame2.setVisibility(View.INVISIBLE);
    }
}

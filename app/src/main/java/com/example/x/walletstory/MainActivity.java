package com.example.x.walletstory;

import android.app.Dialog;
import android.content.Intent;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;

import android.widget.Toast;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private DatabaseHandler mydb = new DatabaseHandler(this);
    private ListView lv;
    private MyAdapter adapter;

    private List<Data> datas = new ArrayList<>();
    private Data detail;


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



        for(int i=1;i<=mydb.getTransactionRecordCount();i++){
            datas.add(mydb.getTransactionRecord(i));
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

        /*FrameLayout frame = (FrameLayout)findViewById(R.id.frameIn);

        frame.setVisibility(View.VISIBLE);

        FrameLayout frame2 = (FrameLayout)findViewById(R.id.frameEx);
        frame2.setVisibility(View.INVISIBLE);*/

        Dialog incomeDialog = new Dialog(MainActivity.this);
        incomeDialog.setContentView(R.layout.add_incomes_dialog);
        incomeDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        incomeDialog.show();


    }
    public void addExpense(View v){
        /*FrameLayout frame = (FrameLayout)findViewById(R.id.frameEx);

        frame.setVisibility(View.VISIBLE);
        FrameLayout frame1 = (FrameLayout)findViewById(R.id.frameIn);
        frame1.setVisibility(View.INVISIBLE);*/

        Dialog expenseDialog = new Dialog(MainActivity.this);
        expenseDialog.setContentView(R.layout.add_expenses_dialog);
        expenseDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        expenseDialog.show();

    }
    public void saveIncome(View v){
        /*FrameLayout frame1 = (FrameLayout)findViewById(R.id.frameIn);
        frame1.setVisibility(View.INVISIBLE);

        EditText editInAmount = (EditText)findViewById(R.id.editAmountIn);
        EditText editInDescription = (EditText)findViewById(R.id.editDescriptionIn);
        EditText editInCategory = (EditText)findViewById(R.id.editCategoryIn);

        double incomeAmount = Double.parseDouble(editInAmount.getText().toString());
        String incomeDescription = editInDescription.getText().toString();
        String incomeCategory = editInCategory.getText().toString();

<<<<<<< HEAD


        mydb.addTransactionRecord(Calendar.getInstance().getTime(),incomeAmount,incomeDescription,incomeCategory,"income");
        datas.add(mydb.getTransactionRecord(mydb.getTransactionRecordCount()));
=======
        int incomeAmountInteger = Integer.parseInt(incomeAmount);*/



        /*mydb.addRecord(incomeCategory,incomeAmountInteger,incomeDate);
        datas.add(mydb.getRecord(mydb.getRecordCount()));

        adapter = new MyAdapter(this,datas);
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);*/

        Dialog incomeDialog = new Dialog(MainActivity.this);
        incomeDialog.setContentView(R.layout.add_incomes_dialog);

        EditText inputDate = (EditText) incomeDialog.findViewById(R.id.income_date_input);
        EditText inputCosts = (EditText) incomeDialog.findViewById(R.id.income_costs_input);
        EditText inputCategory = (EditText) incomeDialog.findViewById(R.id.income_category_input);

        String incomeDate = inputDate.getText().toString();
        String incomeCosts = inputCosts.getText().toString();
        String incomeCategory = inputCategory.getText().toString();

        int incomeCostsInt = Integer.parseInt(incomeCosts);


        mydb.addRecord(incomeCategory, incomeCostsInt, incomeDate);
        datas.add(mydb.getRecord(mydb.getRecordCount()));
>>>>>>> master

        adapter = new MyAdapter(this,datas);
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);

        incomeDialog.hide();

    }

    public void saveExpense(View v) {

        FrameLayout frame2 = (FrameLayout) findViewById(R.id.frameEx);
        frame2.setVisibility(View.INVISIBLE);

        EditText editExAmount = (EditText)findViewById(R.id.editAmountEx);
        EditText editExDescription = (EditText)findViewById(R.id.editDescriptionEx);
        EditText editExCategory = (EditText)findViewById(R.id.editCategoryEx);

        double expenseAmount = -Double.parseDouble(editExAmount.getText().toString());
        String expenseDescription = editExDescription.getText().toString();
        String expenseCategory = editExCategory.getText().toString();


        mydb.addTransactionRecord(Calendar.getInstance().getTime(),expenseAmount,expenseDescription,expenseCategory,"expense");
        datas.add(mydb.getTransactionRecord(mydb.getTransactionRecordCount()));

        adapter = new MyAdapter(this,datas);
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);

    }
    public void cancelIncome(View v){
        /*FrameLayout frame1 = (FrameLayout)findViewById(R.id.frameIn);
        frame1.setVisibility(View.INVISIBLE);
        FrameLayout frame2 = (FrameLayout)findViewById(R.id.frameEx);
        frame2.setVisibility(View.INVISIBLE);*/


    }
}

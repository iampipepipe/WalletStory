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
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

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

    private Dialog incomeDialog;
    private Dialog expenseDialog;
    private List<Data> datas = new ArrayList<>();

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


        /* show database all */

        for(int i=1;i<=mydb.getTransactionRecordCount();i++){
            datas.add(mydb.getTransactionRecord(i));
        }

        adapter = new MyAdapter(this,datas);
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.transaction_id :
                Intent transaction = new Intent();
                transaction.setClass(MainActivity.this, TransactionActivity.class);
                startActivity(transaction);
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
        incomeDialog = new Dialog(MainActivity.this);
        incomeDialog.setContentView(R.layout.add_incomes_dialog);
        incomeDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        incomeDialog.show();
    }
    public void addExpense(View v){
        expenseDialog = new Dialog(MainActivity.this);
        expenseDialog.setContentView(R.layout.add_expenses_dialog);
        expenseDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        expenseDialog.show();
    }
    public void saveIncome(View v){
        EditText editInAmount = (EditText) incomeDialog.findViewById(R.id.income_costs_input);
        EditText editInDescription = (EditText) incomeDialog.findViewById(R.id.income_category_input);
        EditText editInCategory = (EditText) incomeDialog.findViewById(R.id.income_note_input);

        double incomeAmount = Double.parseDouble(editInAmount.getText().toString());
        String incomeDescription = editInDescription.getText().toString();
        String incomeCategory = editInCategory.getText().toString();


        mydb.addTransactionRecord(Calendar.getInstance().getTime(),incomeAmount,incomeDescription,incomeCategory,"income");
        datas.add(mydb.getTransactionRecord(mydb.getTransactionRecordCount()));


        adapter = new MyAdapter(this,datas);
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);

        incomeDialog.hide();

    }

    public void saveExpense(View v) {
        EditText editExAmount = (EditText) expenseDialog.findViewById(R.id.expense_costs_input);
        EditText editExDescription = (EditText) expenseDialog.findViewById(R.id.expense_category_input);
        EditText editExCategory = (EditText) expenseDialog.findViewById(R.id.expense_note_input);

        double expenseAmount = -Double.parseDouble(editExAmount.getText().toString());
        String expenseDescription = editExDescription.getText().toString();
        String expenseCategory = editExCategory.getText().toString();


        mydb.addTransactionRecord(Calendar.getInstance().getTime(),expenseAmount,expenseDescription,expenseCategory,"expense");
        datas.add(mydb.getTransactionRecord(mydb.getTransactionRecordCount()));

        adapter = new MyAdapter(this,datas);
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);

        expenseDialog.hide();

    }
    public void cancelExpense(View v){
        expenseDialog.hide();
    }

    public void cancelIncome(View v) {
        incomeDialog.hide();
    }
}

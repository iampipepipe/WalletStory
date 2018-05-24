package com.example.x.walletstory;

import android.database.Cursor;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by X on 5/20/2018.
 */

public class ExpensesFragment extends Fragment {
    View v;
    private RecyclerView myRecyclerView;


    public ExpensesFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        /*expensesList.add(new Categories("Food & Drink", "Expense", R.mipmap.food));
        expensesList.add(new Categories("Shopping","Expense", R.mipmap.shopping));
        expensesList.add(new Categories("Transport","Expense", R.mipmap.transport));
        expensesList.add(new Categories("Home","Expense", R.mipmap.home));
        expensesList.add(new Categories("Entertainment","Expense", R.mipmap.entertainment));
        expensesList.add(new Categories("Bills & Fees","Expense", R.mipmap.bills));
        expensesList.add(new Categories("Car","Expense", R.mipmap.car));
        expensesList.add(new Categories("Travel","Expense", R.mipmap.travel));
        expensesList.add(new Categories("Family & Personal","Expense", R.mipmap.family));
        expensesList.add(new Categories("Health","Expense", R.mipmap.health));
        expensesList.add(new Categories("Education","Expense", R.mipmap.education));
        expensesList.add(new Categories("Groceries","Expense", R.mipmap.groceries));
        expensesList.add(new Categories("Gifts","Expense", R.mipmap.gift));
        expensesList.add(new Categories("Sport & Hobbies","Expense", R.mipmap.sport));
        expensesList.add(new Categories("Beauty","Expense", R.mipmap.beauty));
        expensesList.add(new Categories("Work","Expense", R.mipmap.work));
        expensesList.add(new Categories("Others","Expense", R.mipmap.transaction));*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.categories_fragment, container, false);
        myRecyclerView = (RecyclerView) v.findViewById(R.id.categories_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), new DataList().getExpensesList());
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);

        return v;
    }
}

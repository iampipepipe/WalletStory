package com.example.x.walletstory;

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
    private List<Expenses> expensesList = new ArrayList<>();

    public ExpensesFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        expensesList.add(new Expenses("Food", R.mipmap.popcorn));
        expensesList.add(new Expenses("Clothes", R.mipmap.dress));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.expenses_fragment, container, false);
        myRecyclerView = (RecyclerView) v.findViewById(R.id.expenses_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), expensesList);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);

        return v;
    }
}

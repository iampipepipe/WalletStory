package com.example.x.walletstory;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by X on 5/20/2018.
 */

public class IncomesFragment extends Fragment {
    View v;
    private RecyclerView myRecyclerView;




    public IncomesFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        /*incomesList.add(new Categories("Salary","Income", R.mipmap.salary));
        incomesList.add(new Categories("Selling","Income", R.mipmap.sale));
        incomesList.add(new Categories("Award","Income", R.mipmap.award));
        incomesList.add(new Categories("Interest Money","Income", R.mipmap.interest));
        incomesList.add(new Categories("Gifts","Income", R.mipmap.gift));
        incomesList.add(new Categories("Others","Income", R.mipmap.transaction));*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.categories_fragment, container, false);
        myRecyclerView = (RecyclerView) v.findViewById(R.id.categories_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), new DataList().getIncomesList());
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);

        return v;
    }
}

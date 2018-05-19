package com.example.x.walletstory;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by X on 5/20/2018.
 */

public class IncomesFragment extends Fragment {
    View v;

    public IncomesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.incomes_fragment, container, false);
        return v;
    }
}

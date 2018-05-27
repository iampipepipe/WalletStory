package com.example.x.walletstory;

import java.util.ArrayList;
import java.util.List;

public class DataList {
    private static List<Data> expensesList = new ArrayList<>();
    private static List<Data> incomesList = new ArrayList<>();


    public List<Data> getExpensesList() {
        return expensesList;
    }

    public void setExpensesList(List<Data> expensesList) {
        this.expensesList = expensesList;
    }

    public List<Data> getIncomesList() {
        return incomesList;
    }

    public void setIncomesList(List<Data> incomesList) {
        this.incomesList = incomesList;
    }
}

package com.example.x.walletstory;

import java.util.Date;

public class Data {
    private int id;
    private int date;
    private int month;
    private int year;
    private double amount;
    private String description;
    private String category;
    private String type;
    private int icon;

    public Data() { }

    public Data(int id, int date, int month, int year, double amount, String description, String category, String type, int icon) {
        this.id = id;
        this.date = date;
        this.month = month;
        this.year = year;
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.type = type;
        this.icon = icon;
    }

    // all date
    public Data(int id, int date, int month, int year, double amount, String description, String category, String type) {
        this.id = id;
        this.date = date;
        this.month = month;
        this.year = year;
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.type = type;
    }

    //for calculate amount
    public Data(double amount) {
        this.amount = amount;
    }

    public Data(int date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public Data(int date, int month, double amount) {
        this.date = date;
        this.month = month;
        this.amount = amount;
    }

    public Data(int date, int month, int year, double amount) {
        this.date = date;
        this.month = month;
        this.year = year;
        this.amount = amount;
    }

    public Data(int id, String category, int icon, String type) {
        this.id = id;
        this.category = category;
        this.type = type;
        this.icon = icon;
    }

    public Data(String category, String type, int icon) {
        this.category = category;
        this.type = type;
        this.icon = icon;
    }

    //for show detail per day
    public Data(double amount, String description, String category, String type, int icon) {
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.type = type;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
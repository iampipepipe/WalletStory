package com.example.x.walletstory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydb5.db";


    //transaction table
    static final String TABLE_TRANSACTION = "myTransaction";

    static final String TRANSACTION_DATE = "date";
    static final String TRANSACTION_MONTH = "month";
    static final String TRANSACTION_YEAR = "year";
    static final String TRANSACTION_AMOUNT = "amount";
    static final String TRANSACTION_DESCRIPTION = "discription";
    static final String TRANSACTION_CATEGORY = "category";
    static final String TRANSACTION_TYPE = "type";


    //category table
    static final String TABLE_CATEGORY = "myCategory";

    static final String CATEGORY_NAME = "name";
    static final String CATEGORY_ICON = "icon";
    static final String CATEGORY_TYPE = "type";

    private static final int DATABASE_VERSION = 1;

    public DatabaseHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public DatabaseHandler(ExpensesFragment expensesFragment){
        super(expensesFragment.getContext(),DATABASE_NAME,null,DATABASE_VERSION);
    }
    public DatabaseHandler(IncomesFragment incomesFragment){
        super(incomesFragment.getContext(),DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE TRANSACTION TABLE
        db.execSQL("CREATE TABLE "
                + TABLE_TRANSACTION + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TRANSACTION_DATE + " INTEGER,"
                + TRANSACTION_MONTH + " INTEGER,"
                + TRANSACTION_YEAR + " INTEGER,"
                + TRANSACTION_AMOUNT + " DOUBLE, "
                + TRANSACTION_DESCRIPTION + " TEXT, "
                + TRANSACTION_CATEGORY + " TEXT, "
                + TRANSACTION_TYPE + " TEXT );");


        //CREATE CATEGORY TABLE
        db.execSQL("CREATE TABLE "
                + TABLE_CATEGORY + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CATEGORY_NAME + " TEXT,"
                + CATEGORY_ICON + " INTEGER,"
                + CATEGORY_TYPE + " TEXT );");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }


    //transaction tools
    /*------------------------------------------------------------------------------------------------------------------------------------*/
    public void addTransactionRecord(Date date,double amount,String description,String category,String type){
        DateFormat formatterDay,formatterMonth,formatterYear;
        ContentValues values = new ContentValues();

        formatterDay = new SimpleDateFormat("dd");
        formatterMonth = new SimpleDateFormat("MM");
        formatterYear = new SimpleDateFormat("yyyy");

        int day = Integer.parseInt(formatterDay.format(date));
        int month = Integer.parseInt(formatterMonth.format(date));
        int year = Integer.parseInt(formatterYear.format(date));
        values.put(TRANSACTION_DATE,day);
        values.put(TRANSACTION_MONTH,month);
        values.put(TRANSACTION_YEAR,year);
        values.put(TRANSACTION_AMOUNT,amount);
        values.put(TRANSACTION_DESCRIPTION,description);
        values.put(TRANSACTION_CATEGORY,category);
        values.put(TRANSACTION_TYPE,type);

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_TRANSACTION,null,values);
        db.close();
    }

    public Data getTransactionRecord(int id){
        Data data = null;
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = { "_id",TRANSACTION_DATE,TRANSACTION_MONTH,TRANSACTION_YEAR,TRANSACTION_AMOUNT,TRANSACTION_DESCRIPTION,TRANSACTION_CATEGORY,TRANSACTION_TYPE};
        Cursor c = db.query(TABLE_TRANSACTION,
                columns,
                "_id=?",new String[]{String.valueOf(id)},
                null,null,null,null);
        if(c!=null){
            if(c.moveToFirst()){
                int idCol = c.getColumnIndex("_id");
                int dateCol = c.getColumnIndex(TRANSACTION_DATE);
                int monthCol = c.getColumnIndex(TRANSACTION_MONTH);
                int yearCol = c.getColumnIndex(TRANSACTION_YEAR);
                int amountCol = c.getColumnIndex(TRANSACTION_AMOUNT);
                int descriptionCol = c.getColumnIndex(TRANSACTION_DESCRIPTION);
                int categoryCol = c.getColumnIndex(TRANSACTION_CATEGORY);
                int typeCol = c.getColumnIndex(TRANSACTION_TYPE);

                data = new Data(c.getInt(idCol),
                        c.getInt(dateCol),
                        c.getInt(monthCol),
                        c.getInt(yearCol),
                        c.getDouble(amountCol),
                        c.getString(descriptionCol),
                        c.getString(categoryCol),
                        c.getString(typeCol));
            }
        }
        c.close();
        return data;
    }

    public int getTransactionRecordCount(){
        String countQuery = "SELECT _id FROM " + TABLE_TRANSACTION;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery(countQuery,null);
        return cur.getCount();
    }

    public Cursor getTransactionAllRecord() {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = { "_id",TRANSACTION_DATE,TRANSACTION_MONTH,TRANSACTION_YEAR,TRANSACTION_AMOUNT,TRANSACTION_DESCRIPTION,TABLE_CATEGORY,TRANSACTION_TYPE};
        Cursor cur = db.query(TABLE_TRANSACTION,columns,null,null,null,null,null);
        return cur;
    }

    public void deleteTransactionRecord(int recID){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TRANSACTION,"_id =?",
                new String[]{String.valueOf(recID)});
        db.close();
    }
    public void deleteTransactionRecordLast(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TRANSACTION,"_id =?",
                new String[]{String.valueOf(getTransactionRecordCount())});
        db.close();
    }
    /*------------------------------------------------------------------------------------------------------------------------------------*/
    //category tools
    /*------------------------------------------------------------------------------------------------------------------------------------*/
    public void addCategoryRecord(String category,String type,int icon){
        ContentValues values = new ContentValues();

        values.put(CATEGORY_NAME,category);
        values.put(CATEGORY_ICON,icon);
        values.put(CATEGORY_TYPE,type);

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_CATEGORY,null,values);
        db.close();
    }

    public Cursor getIncomeCategoryAllRecord() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM "+ TABLE_CATEGORY + " WHERE " + CATEGORY_TYPE + " == 'income' ",null);
        return cur;
    }

    public Cursor getExpenseCategoryAllRecord() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM "+ TABLE_CATEGORY + " WHERE " + CATEGORY_TYPE + " == 'expense' ",null);
        return cur;
    }


    public static String getTableCategory() {
        return TABLE_CATEGORY;
    }

    public static String getCategoryName() {
        return CATEGORY_NAME;
    }

    public static String getCategoryIcon() {
        return CATEGORY_ICON;
    }

    public static String getCategoryType() {
        return CATEGORY_TYPE;
    }
}

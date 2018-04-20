package com.example.x.walletstory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydb.db";
    static final String TABLE_NAME = "mytable";

    static final String COLUMN_DATE = "date";
    static final String COLUMN_NAME = "name";
    static final String COLUMN_VALUE = "value";

    private static final int DATABASE_VERSION = 1;

    public DatabaseHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "
                + TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT," + COLUMN_VALUE + " INTEGER, " + COLUMN_DATE + " TEXT );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

    public void addRecord(String name,int value,String date){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,name);
        values.put(COLUMN_VALUE,value);
        values.put(COLUMN_DATE,date);

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(DatabaseHandler.TABLE_NAME,null,values);
        db.close();
    }

    public Data getRecord(long id){
        Data data = null;

        SQLiteDatabase db = this.getWritableDatabase();

        String[] columns = { "_id","name","value","date"};
        Cursor c = db.query(TABLE_NAME,
                columns,
                "_id=?",new String[]{String.valueOf(id)},
                null,null,null,null);
        if(c!=null){
            if(c.moveToFirst()){
                int idCol = c.getColumnIndex("_id");
                int  nameCol = c.getColumnIndex("name");
                int valueCol = c.getColumnIndex("value");
                int dateCol = c.getColumnIndex("date");


                data = new Data(c.getString(nameCol),c.getString(valueCol),c.getString(dateCol));
                //String strId = Integer.toString(c.getInt(idCol));
                //String strName = c.getString(nameCol);
                //String strValue = Integer.toString(c.getInt(valueCol));
                //String strDate = c.getString(dateCol);

                //data = "id" + strId +  "\n" + strName + "\n" + strValue + "\n" + strDate + "\n";

            }
        }
        c.close();
        return data;
    }
    public int getRecordCount(){
        String countQuery = "SELECT _id FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery(countQuery,null);
        return cur.getCount();
    }

    public Cursor getAllRecord() {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = {"_id","name","value","date"};
        Cursor cur = db.query(TABLE_NAME,columns,null,null,null,null,null);
        return cur;
    }

    public void deleteRecord(long recID){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,"_id =?",
                new String[]{String.valueOf(recID)});
        db.close();
    }
    public void deleteRecordLast(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,"_id =?",
                new String[]{String.valueOf(getRecordCount())});
        db.close();
    }


}

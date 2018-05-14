package com.example.kiguno.baseofdate;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {


    public SQLHelper(Context context)
    {
        super(context,"TrainBase", null, 3);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + "table1 (id integer primary key autoincrement, name text not null, age integer not null);");

        db.execSQL("create table " + "autoShop (id integer primary key autoincrement,year integer not null,mileage integer not null, color text not null, helm text not null);");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS table1");
        db.execSQL("DROP TABLE IF EXISTS autoShop");
        onCreate(db);
    }

    public void removeClassmate(){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("table1",null,null);
    }
    public void removeAllCars(){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("autoShop", null, null);
    }

    public Cursor getFullTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.query("table1", new String[] {"_id", "name", "age"},
                null, null,null,null,null);
    }

    public Cursor getFullShop(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.query("autoShop", new String[] {"id", "year", "mileage","color","helm"},
                null, null,null,null,null);
    }
}
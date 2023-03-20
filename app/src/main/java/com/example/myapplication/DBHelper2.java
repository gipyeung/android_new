package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.Date;

public class DBHelper2 extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.

    public static final String DATABASE_NAME = "sale.db";

    public static final String TABLE_NAME2 = "sale";
    public static final String TABLE_NAME3 = "sale2";


    public static final String SPE_1 = "S_Quantity";
    public static final String SPE_2 = "S_Name";
    public static final String SPE_3 = "S_Num";



    public DBHelper2(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS " + TABLE_NAME2 + "(" + SPE_3 + " INTEGER PRIMARY KEY AUTOINCREMENT ," + SPE_2 + " VARCHAR(30)," + SPE_1 + " INTEGER ," +
                " S_Date  Date)");
        sqLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS " + TABLE_NAME3 + "(" + SPE_3 + " INTEGER PRIMARY KEY AUTOINCREMENT ," + SPE_2 + " VARCHAR(30)," + SPE_1 + " INTEGER ," +
                " S_Date  Date)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS sale");
        onCreate(sqLiteDatabase);
    }
    public void onUpgrade2(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS sale2");
        onCreate(sqLiteDatabase);
    }

    public void insert1(String SRO, String sale )
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("INSERT INTO " + TABLE_NAME2 + "(" + SPE_2 + "," + SPE_1 + ",S_Date) VALUES  ( '" + SRO + "' , '" + sale + "',date())");
    }
    public void insert2(String SRO, String sale )
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("INSERT INTO " + TABLE_NAME3 + "(" + SPE_2 + "," + SPE_1 + ",S_Date) VALUES  ( '" + SRO + "' , '" + sale + "',date())");
    }


    public Cursor getAllData1(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from sale",null);
        return res;
    }
    public Cursor getAllData2(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from sale2",null);
        return res;
    }
    public Cursor DataSum(String a){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " + SPE_3 + "," + SPE_2 + " , SUM(" + SPE_1 + ")  from " + TABLE_NAME2 + " where "+SPE_2+" = '"+a+"' GROUP BY " + SPE_2 + "  ",null);

        return res;
    }


}


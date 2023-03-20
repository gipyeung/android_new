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

import java.text.SimpleDateFormat;
import java.util.Date;

public class DBHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.

    public static final String DATABASE_NAME = "purchase.db";


    public static final String TABLE_NAME3 = "purchase";
    public static final String TABLE_NAME4 = "purchase2";


    public static final String PU_1 = "P_Name";
    public static final String PU_2 = "P_Quantity";
    public static final String PU_3 = "P_Num";




  //  @RequiresApi(api = Build.VERSION_CODES.P)
    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS " + TABLE_NAME3 + "(" + PU_3 + " INTEGER PRIMARY KEY AUTOINCREMENT ," + PU_1 + " VARCHAR(30)," + PU_2 + " INTEGER ," +
                " P_Date  Date)");
        sqLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS " + TABLE_NAME4 + "(" + PU_3 + " INTEGER PRIMARY KEY AUTOINCREMENT ," + PU_1 + " VARCHAR(30)," + PU_2 + " INTEGER ," +
                " P_Date  Date)");
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS purchase");
        onCreate(sqLiteDatabase);
    }
    public void onUpgrade2(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS purchase2");
        onCreate(sqLiteDatabase);
    }



    public void insert1(String PRO, String PURCAHSE )
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("INSERT INTO " + TABLE_NAME3 + "(" + PU_1 + "," + PU_2 + ",P_Date) VALUES  ( '" + PRO + "' , '" + PURCAHSE + "',date())");
    }
    public void insert2(String PRO, String PURCAHSE )
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("INSERT INTO " + TABLE_NAME4 + "(" + PU_1 + "," + PU_2 + ",P_Date) VALUES  ( '" + PRO + "' , '" + PURCAHSE + "',date())");
    }



    public Cursor getAllData1(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME3 + " ",null);
        return res;
    }
    public Cursor getAllData2(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME4 + " ",null);
        return res;
    }



    public Cursor DataSum(String a){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " + PU_3 + "," + PU_1 + " , SUM(" + PU_2 + ")  from " + TABLE_NAME3 + " where "+PU_1+" = '"+a+"' GROUP BY " + PU_1 + "  ",null);

        return res;
    }

    public Cursor DataSumAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select  SUM(" + PU_2 + ")  from " + TABLE_NAME3 + " ",null);

        return res;
    }



}

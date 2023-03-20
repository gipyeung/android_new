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

public class DBHelper3 extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final String DATABASE_NAME = "chart1.db";


    public static final String TABLE_NAME3 = "chart";


    public static final String C_1 = "C_Num";
    public static final String C_2 = "C_Name";
    public static final String C_3 = "C_Quantity";


    //  @RequiresApi(api = Build.VERSION_CODES.P)
    public DBHelper3(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_NAME3 + "(" + C_3 + " INTEGER, P_Date  Date )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS chart");
        onCreate(sqLiteDatabase);
    }


    public void insert(Integer C_Q )
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("INSERT INTO " + TABLE_NAME3 + "(" + C_3 + ",P_Date) VALUES  ( '" + C_Q + "',date())");
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME3 + " ",null);
        return res;
    }



}

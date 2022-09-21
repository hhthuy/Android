package com.example.onck_app_provider1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    //contructor
    public DBHelper(@Nullable Context context) {
        super(context, "OnTapProvider.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       sqLiteDatabase.execSQL("CREATE TABLE Products("+
               "id integer primary key, " +
               "name text, " +
               "unit text, " +
               "madein text)");
        sqLiteDatabase.execSQL("CREATE TABLE Orders(id integer primary key, ngaylap text," +
                " id_product integer not null, foreign key(id_product) REFERENCES Products(id) on delete cascade on update cascade);");


    }
    @Override
    public void onConfigure(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
        super.onConfigure(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Products");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Orders");
        onCreate(sqLiteDatabase);

    }



}

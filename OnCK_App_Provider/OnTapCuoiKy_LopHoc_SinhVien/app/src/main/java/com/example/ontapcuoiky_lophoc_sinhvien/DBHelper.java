package com.example.ontapcuoiky_lophoc_sinhvien;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "MyDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE LopHoc(malop int not null primary key," +
                "tenlop text)");
        sqLiteDatabase.execSQL("CREATE TABLE SinhVien (id text not null primary key," +
                "firstname text," +
                "lastname text," +
                "birthdate date," +
                "malop int not null," +
                "FOREIGN KEY(malop) references LopHoc(malop)" +
                "ON DELETE CASCADE ON UPDATE CASCADE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LopHoc");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS SinhVien");
        onCreate(sqLiteDatabase);
    }
}

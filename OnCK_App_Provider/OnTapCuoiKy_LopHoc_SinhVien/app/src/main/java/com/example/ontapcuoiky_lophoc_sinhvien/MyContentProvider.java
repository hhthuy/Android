package com.example.ontapcuoiky_lophoc_sinhvien;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;

public class MyContentProvider extends ContentProvider {

    static final String AUTHORITY="com.example.ontapcuoiky_lophoc_sinhvien";
    static final String CONTENT_PROVIDER="contentprovider";
    static final String URL="content://"+AUTHORITY+"/"+CONTENT_PROVIDER;
    static final Uri CONTENT_URI=Uri.parse(URL);
    static final String LOPHOC_TABLE="LopHoc";
    static final String SINHVIEN_TABLE="SinhVien";

    private SQLiteDatabase db;

    static final int ONE=1;
    static final int TWO=2;
    static final int ALLLP=3;
    static final int ALLSV=4;
    static final UriMatcher uriMatcher;

    static {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        // truy cập
        uriMatcher.addURI(AUTHORITY,LOPHOC_TABLE+"/*",ALLLP);
        uriMatcher.addURI(AUTHORITY,SINHVIEN_TABLE+"/*",ALLSV);
        uriMatcher.addURI(AUTHORITY,LOPHOC_TABLE,ONE);
        uriMatcher.addURI(AUTHORITY,SINHVIEN_TABLE,TWO);
    }

    private static HashMap<String,String> PROJECTION_MAP;

    public MyContentProvider() {
    }

    @Override
    public boolean onCreate() {
        Context context=getContext();
        DBHelper dbHelper=new DBHelper(context);
        db=dbHelper.getWritableDatabase();
        if(db==null)
            return false;
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        SQLiteQueryBuilder sqLiteQueryBuilder=new SQLiteQueryBuilder();


        Log.d("match", uriMatcher.match(uri)+"");
        switch (uriMatcher.match(uri)) {
            case ONE:
                sqLiteQueryBuilder.setTables(LOPHOC_TABLE);
                break;
            case TWO:
                sqLiteQueryBuilder.setTables(SINHVIEN_TABLE);
                break;
            case ALLLP:
                sqLiteQueryBuilder.appendWhere("malop =" +s);
                break;

            case ALLSV:
                sqLiteQueryBuilder.appendWhere("id =" +s);
                break;

            default:
        }
        Cursor cursor=sqLiteQueryBuilder.query(db,strings,s,strings1,null,null,s1);
        cursor.setNotificationUri(getContext().getContentResolver(),uri);

        return  cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        Log.d("match", uriMatcher.match(uri)+"");
        Uri temp_uri=null;
        switch (uriMatcher.match(uri)){
            case ONE:
               temp_uri= insertLopHoc(contentValues);
                break;
            case TWO:
                temp_uri=insertSinhVien(contentValues);
                break;

        }

        return temp_uri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        int delCount = 0;
        Log.d("match del", uriMatcher.match(uri)+"");

        switch (uriMatcher.match(uri)) {
            case 1:
                delCount = db.delete(LOPHOC_TABLE,s,strings);
                break;
            case 2:
                delCount = db.delete(SINHVIEN_TABLE,s,strings);
                break;
            default:
                throw new IllegalArgumentException("This is an Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return delCount;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        int updateCount = 0;
        switch (uriMatcher.match(uri)) {
            case 1:
                updateCount = db.update(LOPHOC_TABLE,contentValues,s,strings);
                break;
            case 2:
                updateCount = db.update(SINHVIEN_TABLE,contentValues,s,strings);
                break;
            default:
                throw new IllegalArgumentException("This is an Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return updateCount;
    }

    private  Uri insertLopHoc(ContentValues contentValues){
                long number_row = db.insert(LOPHOC_TABLE, "", contentValues);
        if (number_row > 0) {
            Uri uri1 = ContentUris.withAppendedId(CONTENT_URI, number_row);
            getContext().getContentResolver().notifyChange(uri1, null);
            return uri1;
        }
        return null;
    }
    private Uri insertSinhVien(ContentValues contentValues){
        long number_row = db.insert(SINHVIEN_TABLE, "", contentValues);
        if (number_row > 0) {
            Uri uri1 = ContentUris.withAppendedId(CONTENT_URI, number_row);
            getContext().getContentResolver().notifyChange(uri1, null);
            return uri1;
        }
        return null;
    }


}

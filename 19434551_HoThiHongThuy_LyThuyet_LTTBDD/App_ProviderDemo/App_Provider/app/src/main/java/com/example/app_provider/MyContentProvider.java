package com.example.app_provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.widget.Switch;

import java.util.HashMap;

public class MyContentProvider extends ContentProvider {
    //1-Khai bao--------------
    static final String AUTHORITY ="com.example.app_provider";
    static final String CONTEXT_PROVIDER="contentprovider";
    static final String URL ="content://"+AUTHORITY+"/"+CONTEXT_PROVIDER;
    static final Uri CONTENT_URI =Uri.parse(URL);
    static final String PRODUCT_TABLE ="Products";

    private SQLiteDatabase db;

    static final int ONE=1;//Tim co dk theo id
    static final int ALL=2;
    static final UriMatcher uriMatcher;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, PRODUCT_TABLE,ONE);
        uriMatcher.addURI(AUTHORITY, PRODUCT_TABLE +"/#", ALL);

    }
    private static HashMap<String, String> PROJECTION_MAP;

    //--------------xu ly-------------

    public MyContentProvider() {
    }

    //--------------------------------
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    //--------------------------------
    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    //3-inser-------------------------------
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.

        long number_row= db.insert(PRODUCT_TABLE,"", values);
        if(number_row > 0) {//chen thanh cong
            Uri uri1 = ContentUris.withAppendedId(CONTENT_URI, number_row);
            getContext().getContentResolver().notifyChange(uri1, null);
            return uri1;

        }throw new UnsupportedOperationException("Failed to add a record into"+uri);
    }

    //2-onCreate-------------------------------
    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        Context context = getContext();
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
        if(db == null){
            return false;
        }return true;

    }

    //4-query-------------------------------
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(PRODUCT_TABLE);//Dang truy van tren table Produts
        switch(uriMatcher.match(uri)){
            case ALL:
                queryBuilder.setProjectionMap(PROJECTION_MAP);
                break;
            case ONE:
                queryBuilder.appendWhere("id="+uri.getPathSegments().get(0));
                //break;
        }
        Cursor cursor = queryBuilder.query(db,projection,selection,selectionArgs,null,null,sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(),uri);
        return cursor;

    }
    //5--------------------------------
    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
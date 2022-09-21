package com.example.ontapthtuan10_sqlline;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {

        super(context, "MyDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Authors(id integer primary key, name text, address text, email text);");
        sqLiteDatabase.execSQL("CREATE TABLE Books(id integer primary key, title text," +
                " id_author integer not null, foreign key(id_author) REFERENCES Authors(id) on delete cascade on update cascade);");
        //on delete cascade on update cascade
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
        super.onConfigure(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Authors");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Books");
        onCreate(sqLiteDatabase);
    }

    public int insertAuthor(Author author){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", author.getId()+"");
        contentValues.put("name", author.getName());
        contentValues.put("address", author.getAddress());
        contentValues.put("email", author.getEmail());
        int res = (int)db.insert("Authors", null, contentValues);
        db.close();
        return res;
    }

    public ArrayList<Author> getAllAuthor(){
        ArrayList<Author> list = new ArrayList<>();
        String strSQL = "Select * from Authors";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(strSQL, null);
        if(cursor != null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                list.add(new Author(cursor.getInt(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3)));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return list;
    }
    public  Author getAuthorId(int id){
        Author author = new Author();
        String strSQL = "Select * from Authors where id="+id;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(strSQL, null);
        if(cursor != null){
            cursor.moveToFirst();
            try {
                author.setId(cursor.getInt(0));
            }
            catch (Exception e){
                return null;
            }
            author.setName(cursor.getString(1));
            author.setAddress(cursor.getString(2));
            author.setEmail(cursor.getString(3));
            cursor.close();
            db.close();
        }
        return author;

    }
public int deleteAuthor(int id) {
    SQLiteDatabase db = this.getWritableDatabase();
    int res = (int)db.delete("Authors", "id" + " = ?", new String[] { String.valueOf(id) });
    db.close();
    return res;
}

    public int updateAuthor(Author author) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", author.getName());
        contentValues.put("address", author.getAddress());
        contentValues.put("email", author.getEmail());

        int res = (int)db.update("Authors", contentValues, "id" + " = ?", new String[] { String.valueOf(author.getId()) });
        db.close();
        return  res;
    }

    public int insertBook(Book book){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", book.getId()+"");
        contentValues.put("title", book.getTitle());
        contentValues.put("id_author", book.getId_author());
        int res = (int)db.insert("Books", null, contentValues);
        db.close();
        return res;
    }

    public ArrayList<Book> getAllBook(){
        ArrayList<Book> list = new ArrayList<>();
        String strSQL = "Select * from Books";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(strSQL, null);
        if(cursor != null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                list.add(new Book(cursor.getInt(0), cursor.getString(1),
                        cursor.getInt(2)));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return list;
    }
    public  Book getBookId(int id){

        Book book = new Book();
        String strSQL = "Select * from Books where id="+id;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(strSQL, null);
        if(cursor != null){
            cursor.moveToFirst();
            try {
                book.setId(cursor.getInt(0));
            }
            catch (Exception e){
                return null;
            }
            book.setTitle(cursor.getString(1));
            book.setId_author(cursor.getInt(2));
            cursor.close();
            db.close();
        }
        return book;

    }
    public int deleteBook(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int res = (int)db.delete("Books", "id" + " = ?", new String[] { String.valueOf(id) });
        db.close();
        return res;
    }

    public int updateBook(Book book) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", book.getTitle());
        contentValues.put("id_author", book.getId_author());
        int res = (int)db.update("Books", contentValues, "id" + " = ?", new String[] { String.valueOf(book.getId()) });
        db.close();
        return  res;
    }

    public ArrayList<Book> getBookfromAuthor(int id){
        ArrayList<Book> list = new ArrayList<>();
        String strSQL = "Select * from Books where id_author="+id;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(strSQL, null);
        if(cursor != null){
            cursor.moveToFirst();
            try{
                while (!cursor.isAfterLast()){
                    list.add(new Book(cursor.getInt(0), cursor.getString(1),
                            cursor.getInt(2)));
                    cursor.moveToNext();
                }
            } catch (Exception e){
                return null;
            }

            cursor.close();
            db.close();
        }
        return list;

    }
}

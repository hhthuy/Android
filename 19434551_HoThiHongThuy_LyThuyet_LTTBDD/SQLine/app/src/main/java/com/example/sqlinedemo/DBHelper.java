package com.example.sqlinedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    //contructor(generate): layContext
    public DBHelper(@Nullable Context context) {
        super(context,"mydb", null ,  1);
    }



    //dèfault
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Authors(id interger primary key,"+
                "name text,"+
                "address text,"+
                "email text);");//tên table
        sqLiteDatabase.execSQL("CREATE TABLE Books(" +
                "id interger primary key," +
                "title text," +
                "id_author interger not null " +
                "constraint id_author references Authors(id)"+
                "ON DELETE CASCADE ON UPDATE CASCADE);");

    }
    //default: Neu CSDL co thay doi cau truc thi Xoa cu va goi lai onUpgrade de tao lai
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Books");//xoa Book truoc
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Authors");
        onCreate(sqLiteDatabase);
    }

    //THÊM-XÓA-SỬA-TRUY VẤN Author
    //--------------------Thêm author---------------------------
    public int insertAuthor(Author author){
        SQLiteDatabase db = getWritableDatabase();//xin cấp quyền ghi dl vào db
        ContentValues content = new ContentValues();//truyền dl vào table ContentValues
        content.put("id",author.getIdAuthor()+ "");//"id": tên table
        content.put("name", author.getName());
        content.put("address", author.getAddress());
        content.put("email", author.getEmail());
        int res = (int)db.insert("Authors", null, content);//lấy số dòng đã chèn vào
        db.close();
        return res;
    }
    public ArrayList<Author> getAllAuthor(){
        ArrayList<Author> list = new ArrayList<>();
        String strQSL = "Select * from Authors";
        SQLiteDatabase db = getReadableDatabase();//mở db để đọc
        Cursor cursor = db.rawQuery(strQSL,null);//Cursor chưa biến kết quả
        //Kiểm tra có dl hay ko?
        if(cursor != null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                list.add(new Author(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return list;
    }
    //Lay dieu kien
    public Author getIdAuthor(int id){
        Author author = new Author();
        String strSQL ="Select * from Authors id="+id;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(strSQL, null);
        if (cursor != null){
            cursor.moveToFirst();
            author.setIdAuthor(cursor.getInt(0));
            author.setName(cursor.getString(1));
            author.setAddress(cursor.getString(2));
            author.setEmail(cursor.getString(3));
            cursor.close();
            db.close();
        }return author;

    }
    public int deleteAuthor(String idnew){
        SQLiteDatabase db = getReadableDatabase();//mở db để đọc
        return db.delete("Authors","id=?", new String[] {idnew});
    }

//    public boolean updateAuthor(String idnew1, String namenew, String addressnew, String emailnew){
//        SQLiteDatabase db = getReadableDatabase();//mở db để đọc
//        ContentValues content = new ContentValues();//truyền dl vào table ContentValues
//        content.put("id",idnew1);//"id": tên table
//        content.put("name", namenew);
//        content.put("address", addressnew);
//        content.put("email", emailnew);
//
//        int res = db.update("Authors", "id =?", new String[]{idnew1});
//        if(res ==-1){
//            return false;
//        }return true;
 //   }




    //-----------------------------------------------------


    //Them-xoa-sua-truy van book
    public int insertBook(Book book){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("id",book.getId()+ "");
        content.put("title", book.getTitle());
        content.put("id_author", book.getId_author());
        int result = (int)db.insert("Books", null, content);
        db.close();
        return result;
    }

    public ArrayList<Book> getAllBook(){
        ArrayList<Book> list = new ArrayList<>();
        String strQSL = "Select * from Books";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(strQSL,null);
        if(cursor != null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                list.add(new Book(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return list;
    }

    public Book getIdBook(int id){
        Book book = new Book();
        String strSQL ="Select * from Books id="+id;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(strSQL, null);
        if (cursor != null){
            cursor.moveToFirst();
            book.setId(cursor.getInt(0));
            book.setTitle(cursor.getString(1));
            book.setId_author(cursor.getInt(2));
            cursor.close();
            db.close();
        }return book;
    }

}

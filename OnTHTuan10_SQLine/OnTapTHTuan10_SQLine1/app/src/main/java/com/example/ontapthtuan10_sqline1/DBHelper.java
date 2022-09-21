package com.example.ontapthtuan10_sqline1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

// AUTHOR (1) --------------> BOOK(1..*)
public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "BooKStoreDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Authors(id interger primary key, name text, address text, email text);");//table Authors (co 's')
        sqLiteDatabase.execSQL("CREATE TABLE Books(id integer primary key, title text," +
                " id_author integer not null, foreign key(id_author) REFERENCES Authors(id) on delete cascade on update cascade);");
        //on delete cascade on update cascade
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
        super.onConfigure(db);
    }

    @Override//int oldVersion, int newVersion
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Authors");//khi  csdl thay doi cau truc->Xoa di onCreate
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Books");
        onCreate(sqLiteDatabase);// -> tao lai onUpgrade
    }

    /**-------I.THÊM-XÓA-SỬA-TÌM AUTHOR(1)----------**/
    //--------------1. Thêm author(Save)--------------
    public int insertAuthor(Author author){//Trả về số dòng insert được
        SQLiteDatabase db = getWritableDatabase();//Mở db để ghi dl vào
        ContentValues content = new ContentValues();//Xin Cấp phát 1 contentvalue
        content.put("id",author.getId()+"");//"id": table
        content.put("name", author.getName());
        content.put("address", author.getAddress());
        content.put("email", author.getEmail());
        int res = (int) db.insert("Authors",null,content);
        db.close();
        return res;
    }
    //--------------2. Truy vấn Tất cả author--------------
    public ArrayList<Author> getAlllAuthor(){
        ArrayList<Author> list = new ArrayList<>();
        String strSQL = "Select * from Authors";
        SQLiteDatabase db = getReadableDatabase();//Mở db để đọc dl
        Cursor cursor = db.rawQuery(strSQL, null);//Trả về kết quả trong cursor
        //Kiểm tra truy vấn có dữ liệu hay không?
        if (cursor != null){//Có dl -> xử lý
            cursor.moveToFirst();//dl đổ vào cursor con trỏ từ vị trí đầu tiên
            while (!cursor.isAfterLast()){//lấy dl đến sau vị trí cuối cùng (chưa hết dl)
                list.add(new Author(cursor.getInt(0),cursor.getString(1), cursor.getString(2), cursor.getString(3)));//chưa hết dl, lấy dl theo từng cột
            cursor.moveToNext();//lần lượt chuyển dl vào
            }
            cursor.close();
            db.close();
        }
        return list;
    }
    //--------------3. Truy vấn author theo Id--------------
    public Author getIdAuthor(int id){
        Author author = new Author();
        String strSQL ="Select * from Authors where id=" + id;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(strSQL, null);
        if (cursor != null){
            cursor.moveToFirst();
            author.setId(cursor.getInt(0));
            author.setName(cursor.getString(1));
            author.setAddress(cursor.getString(2));
            author.setEmail(cursor.getString(3));
            cursor.moveToNext();
            cursor.close();
            db.close();
        }
        return author;
    }
    //--------------4.Xóa author --------------
    public int deleteAuthor(int id){
        SQLiteDatabase db = getWritableDatabase();
        int res = (int) db.delete("Authors","id"+"=?", new String[]{String.valueOf(id)});
        db.close();
        return res;
    }
    //--------------4.Cập nhật sửa author --------------
    public int updateAuthor(Author author){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("name", author.getName());
        content.put("address", author.getAddress());
        content.put("email", author.getEmail());

        int res = (int) db.update("Authors", content, "id"+"=?", new String[]{String.valueOf(author.getId())});
        db.close();
        return res;
    }

    /**----------II.THÊM-XÓA-SỬA-TÌM BOOK (1..*)----------**/
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

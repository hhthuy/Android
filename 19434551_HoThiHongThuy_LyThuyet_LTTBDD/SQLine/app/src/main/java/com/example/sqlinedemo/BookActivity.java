package com.example.sqlinedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        EditText et_IdBook = findViewById(R.id.edittext_Id);
        EditText et_Title = findViewById(R.id.edittext_title);
        EditText et_IdAuthor = findViewById(R.id.edittext_IdAuthor);

        GridView gv_Display = findViewById(R.id.gridview_BookList);
        DBHelper dbHelper = new DBHelper(this);

        Button bt_save = findViewById(R.id.button_Save);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setId(Integer.parseInt(et_IdBook.getText().toString()));
                book.setTitle(et_Title.getText().toString());
                book.setId_author(Integer.parseInt(et_IdAuthor.getText().toString()));
                if(dbHelper.insertBook(book) > 0){//insert thanh cong
                    Toast.makeText(getApplicationContext(), "Bạn đã lưu thành công!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Bạn đã lưu không thành công!", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        Button bt_Select = findViewById(R.id.button_Select);
//        bt_Select.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ArrayList<Book> list_book = new ArrayList<>();
//                ArrayList<String> list_String = new ArrayList<>();//đưa dl vào list
//                if (et_IdBook.getText().toString().equals("")) {//rong getAll, khac rong getId
//                    list_book = dbHelper.getAllBook();
//                } else {//LAY 1
//                    Book b = dbHelper.getIdBook(Integer.parseInt(et_IdBook.getText().toString()));
//                    //.....lam tiep.....
//                }for (Book b: list_book) {
//                    list_String.add(b.getId()+"");
//                    list_String.add(b.getTitle());
//                    list_String.add(b.getId_author() + "");
//                    ArrayAdapter<String> adapter = new ArrayAdapter<>(BookActivity.this, android.R.layout.simple_list_item_1, list_String);//Dua vao tung o trong list
//                    gv_Display.setAdapter(adapter);
//
//                }
//            });
//
        }
    }
package com.example.sqlinedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class AuthorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        EditText et_Id = findViewById(R.id.editText_id);
        EditText et_Name = findViewById(R.id.editText_name);
        EditText et_Address = findViewById(R.id.editText_address);
        EditText et_Email = findViewById(R.id.editText_email);

        GridView gv_Display = findViewById(R.id.gridview_AuthorList);
        DBHelper dbHelper = new DBHelper(this);

        Button bt_save = findViewById(R.id.button_Save);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Author author = new Author();
                author.setIdAuthor(Integer.parseInt(et_Id.getText().toString()));
                author.setName(et_Name.getText().toString());
                author.setAddress(et_Address.getText().toString());
                author.setEmail(et_Email.getText().toString());
                if(dbHelper.insertAuthor(author) > 0){//insert thanh cong
                    Toast.makeText(getApplicationContext(), "Bạn đã lưu thành công!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Bạn đã lưu không thành công!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button bt_Select = findViewById(R.id.button_Select);
        bt_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Author> list_Author = new ArrayList<>();
                ArrayList<String> list_String = new ArrayList<>();//đưa dl vào list
                if (et_Id.getText().toString().equals("")) {//rong getAll, khac rong getId
                    list_Author = dbHelper.getAllAuthor();
                    for (Author au : list_Author) {
                        list_String.add(au.getIdAuthor() + "");
                        list_String.add(au.getName());
                        list_String.add(au.getAddress());
                        list_String.add(au.getEmail());
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(AuthorActivity.this, android.R.layout.simple_list_item_1, list_String);//Dua vao tung o trong list
                        gv_Display.setAdapter(adapter);

                    }

                } else {//LAY 1
                    Author au = dbHelper.getIdAuthor(Integer.parseInt(et_Id.getText().toString()));
                    //.....lam tiep.....neu tim thay dua thong tin va list_String va setAdpater
                }

            }
        });

        Button bt_delete = findViewById(R.id.button_Delete);
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Author> list_Author = new ArrayList<>();
                ArrayList<String> list_String = new ArrayList<>();//đưa dl vào list
                if (et_Id.getText().toString().equals("")) {//rong getAll, khac rong getId
                    list_Author = dbHelper.getAllAuthor();
                    for (Author au : list_Author) {
                        list_String.add(au.getIdAuthor() + "");
                        list_String.add(au.getName());
                        list_String.add(au.getAddress());
                        list_String.add(au.getEmail());
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(AuthorActivity.this, android.R.layout.simple_list_item_1, list_String);//Dua vao tung o trong list
                        gv_Display.setAdapter(adapter);

                    }

                } else {//LAY 1
                    Author au = dbHelper.getIdAuthor(Integer.parseInt(et_Id.getText().toString()));
                    //.....lam tiep.....neu tim thay dua thong tin va list_String va setAdpater
                }

            }
        });


    }
}
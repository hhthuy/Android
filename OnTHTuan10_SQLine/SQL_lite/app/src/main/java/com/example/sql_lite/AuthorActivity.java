package com.example.sql_lite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class AuthorActivity extends AppCompatActivity {

    EditText ed_id, ed_name, ed_address, ed_email;
    GridView gridViewAuthors;
    Button bt_save,bt_rs;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        ed_id = findViewById(R.id.ed_id);
        ed_name = findViewById(R.id.ed_name);
        ed_address = findViewById(R.id.ed_address);
        ed_email = findViewById(R.id.ed_email);
        gridViewAuthors = findViewById(R.id.gridview_list);
        bt_save = findViewById(R.id.bt_save);
        bt_rs = findViewById(R.id.bt_rs);

        dbHelper = new DBHelper(this);

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Author author = new Author();
                author.setId(Integer.parseInt(ed_id.getText().toString()));
                author.setName(ed_name.getText().toString());
                author.setAddress(ed_address.getText().toString());
                author.setEmail(ed_email.getText().toString());
                if (dbHelper.insertAuthor(author) > 0) {
                    Toast.makeText(getApplicationContext(), "Bạn đã lưu thành công", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Bạn lưu Không thành công", Toast.LENGTH_LONG).show();
                }
                Resetview();

            }
        });

        Button bt_select = findViewById(R.id.bt_select);
        bt_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Author> authorArrayList = new ArrayList<>();
                ArrayList<String> listString = new ArrayList<>();
                if (ed_id.getText().toString().equals("")) {
                    authorArrayList = dbHelper.getAllAuthor();
                    for (Author author : authorArrayList) {
                        listString.add(author.getId() + "");
                        listString.add(author.getName());
                        listString.add(author.getAddress());
                        listString.add(author.getEmail());
                    }
                } else {
                    Author author = dbHelper.getAuthorId(Integer.parseInt(ed_id.getText().toString()));
                    if (author != null) {
                        listString.add(author.getId() + "");
                        listString.add(author.getName());
                        listString.add(author.getAddress());
                        listString.add(author.getEmail());
                    } else {
//                        listString.add("Mã này không tồn tại author");
                        Toast.makeText(getApplicationContext(), "Author không tồn tại với mã này", Toast.LENGTH_LONG).show();
                    }

                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(AuthorActivity.this, android.R.layout.simple_list_item_1, listString);
                gridViewAuthors.setAdapter(adapter);
                ed_id.setEnabled(true);

            }
        });
        gridViewAuthors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayList<Author> listAuthor = dbHelper.getAllAuthor();
                int so = i / 4;
                Author author = listAuthor.get(so);
                ed_id.setText(author.getId() + "");
                ed_name.setText(author.getName());
                ed_address.setText(author.getAddress());
                ed_email.setText(author.getEmail());
                ed_id.setEnabled(false);
            }
        });
        Button bt_delete = findViewById(R.id.bt_delete);
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder mydialog = new AlertDialog.Builder(AuthorActivity.this);
                mydialog.setTitle("Thông báo\n"+"Bạn có chắc muốn xóa không?");


                mydialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int id = Integer.parseInt(ed_id.getText().toString());
                        if (dbHelper.deleteAuthor(id) > 0) {
                            Toast.makeText(getApplicationContext(), "Đã xóa thành công", Toast.LENGTH_LONG).show();
                            Resetview();
                        } else {
                            Toast.makeText(getApplicationContext(), "Chưa xóa", Toast.LENGTH_LONG).show();

                        }
                    }
                });
                mydialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AuthorActivity.this, "Bạn đã chọn nút No, chưa xóa",Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog dialog = mydialog.create();
                dialog.show();


            }
        });

        Button bt_update = findViewById(R.id.bt_update);
        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(ed_id.getText().toString());
                String name = ed_name.getText().toString();
                String address = ed_address.getText().toString();
                String email = ed_email.getText().toString();
                Author author = new Author(id, name, address, email);
                if (dbHelper.updateAuthor(author) > 0) {
                    Toast.makeText(getApplicationContext(), "Update thành công", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Update fail", Toast.LENGTH_LONG).show();

                }
                Resetview();

            }
        });
        bt_rs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resetview();
            }
            });
    }
    public void Resetview(){
        ed_id.setText("");
        ed_name.setText("");
        ed_address.setText("");
        ed_email.setText("");
        ed_id.setEnabled(true);
        ArrayList<Author> authorArrayList = new ArrayList<>();
        ArrayList<String> listString = new ArrayList<>();
        authorArrayList = dbHelper.getAllAuthor();
        for (Author author : authorArrayList) {
            listString.add(author.getId() + "");
            listString.add(author.getName());
            listString.add(author.getAddress());
            listString.add(author.getEmail());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(AuthorActivity.this, android.R.layout.simple_list_item_1, listString);
        gridViewAuthors.setAdapter(adapter);
    }
}
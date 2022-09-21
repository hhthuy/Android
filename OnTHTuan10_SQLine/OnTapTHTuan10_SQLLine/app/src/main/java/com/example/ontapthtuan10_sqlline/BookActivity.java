package com.example.ontapthtuan10_sqlline;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private EditText ed_id, ed_title,ed_idauthor;
    Button bt_save, bt_rs;
    GridView gridViewBooks;
    DBHelper dbHelper;
    EditText ed_search;
    Button bt_search;
    //Spinner
    ArrayList<Author> au_list= new ArrayList<>();//Lưu trữ NhanVien khi được nhập vào
    String[] name_list;//name_list mảng chứa <string-array name="listArray_authors"> trong strings.xml
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        ed_id = findViewById(R.id.ed_idbook);
        ed_title = findViewById(R.id.ed_title);
        ed_idauthor = findViewById(R.id.id_author);
        gridViewBooks = findViewById(R.id.gridview_listbook);
        bt_save = findViewById(R.id.bt_savebook);
        bt_rs = findViewById(R.id.bt_rs);
        ed_search = findViewById(R.id.ed_search);
        bt_search = findViewById(R.id.bt_bookintoidauthor);

        dbHelper = new DBHelper(this);
        //đơn vị
        Spinner sp_Name=findViewById(R.id.spinner_TacGia);
        name_list = getResources().getStringArray(R.array.listArray_authors);//<string-array name="donvi_list"> trong strings.xml
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,name_list);
        sp_Name.setAdapter(adapter);
        sp_Name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                name = name_list[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //serch
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Book> bookrArrayList = new ArrayList<Book>();
                ArrayList<String> listString = new ArrayList<>();
                if (ed_search.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Chưa nhập mã tác giả cần tìm sách", Toast.LENGTH_LONG).show();

                } else {
                    int id =  Integer.parseInt(ed_search.getText().toString());
                    bookrArrayList = dbHelper.getBookfromAuthor(id);
                    if(bookrArrayList != null){
                        for (Book book : bookrArrayList) {
                            listString.add(book.getId() + "");
                            listString.add(book.getTitle());
                            listString.add(book.getId_author()+"");
                        }
                    }else {
                        Toast.makeText(getApplicationContext(), "không tìm thấy book nào với mã author này", Toast.LENGTH_LONG).show();

                    }
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(BookActivity.this, android.R.layout.simple_list_item_1, listString);
                gridViewBooks.setAdapter(adapter);
                ed_id.setEnabled(true);

            }
        });

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setId(Integer.parseInt(ed_id.getText().toString()));
                book.setTitle(ed_title.getText().toString());
                book.setId_author(Integer.parseInt(ed_idauthor.getText().toString()));

                if (dbHelper.insertBook(book) > 0) {
                    Toast.makeText(getApplicationContext(), "Bạn đã lưu thành công", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Bạn lưu Không thành công, kiểm tra lại thông tin nhập", Toast.LENGTH_LONG).show();
                }
                Resetview();

            }
        });

        Button bt_select = findViewById(R.id.bt_selectook);
        bt_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Book> bookrArrayList = new ArrayList<>();
                ArrayList<String> listString = new ArrayList<>();
                if (ed_id.getText().toString().equals("")) {
                    bookrArrayList = dbHelper.getAllBook();
                    for (Book book : bookrArrayList) {
                        listString.add(book.getId() + "");
                        listString.add(book.getTitle());
                        listString.add(book.getId_author()+"");
                    }
                } else {
                    Book book = dbHelper.getBookId(Integer.parseInt(ed_id.getText().toString()));
                    if (book != null) {
                        listString.add(book.getId() + "");
                        listString.add(book.getTitle());
                        listString.add(book.getId_author()+"");
                    } else {
                        Toast.makeText(getApplicationContext(), "Book không tồn tại sách với mã này", Toast.LENGTH_LONG).show();
                    }

                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(BookActivity.this, android.R.layout.simple_list_item_1, listString);
                gridViewBooks.setAdapter(adapter);
                ed_id.setEnabled(true);

            }
        });
        gridViewBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayList<Book> listBook = dbHelper.getAllBook();
                int so = i / 3;
                Book book = listBook.get(so);
                ed_id.setText(book.getId() + "");
                ed_title.setText(book.getTitle());
                ed_idauthor.setText(book.getId_author()+"");
                ed_id.setEnabled(false);

            }
        });
        Button bt_delete = findViewById(R.id.bt_deletebook);
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder mydialog = new AlertDialog.Builder(BookActivity.this);
                mydialog.setTitle("Thông báo\n"+"Bạn có chắc muốn xóa không?");


                mydialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int id = Integer.parseInt(ed_id.getText().toString());
                        if (dbHelper.deleteBook(id) > 0) {
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
                        Toast.makeText(BookActivity.this, "Bạn đã chọn nút No, chưa xóa",Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog dialog = mydialog.create();
                dialog.show();


            }
        });

        Button bt_update = findViewById(R.id.bt_updatebook);
        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(ed_id.getText().toString());
                String title = ed_title.getText().toString();
                int id_author = Integer.parseInt(ed_idauthor.getText().toString());
                Book book = new Book(id, title, id_author);
                if (dbHelper.updateBook(book) > 0) {
                    Toast.makeText(getApplicationContext(), "Update book thành công", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Update book fail", Toast.LENGTH_LONG).show();

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
        ed_title.setText("");
        ed_idauthor.setText("");
        ed_id.setEnabled(true);
        ArrayList<Book> bookArrayList = new ArrayList<>();
        ArrayList<String> listString = new ArrayList<>();
        bookArrayList = dbHelper.getAllBook();
        for (Book book : bookArrayList) {
            listString.add(book.getId() + "");
            listString.add(book.getTitle());
            listString.add(book.getId_author()+"");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(BookActivity.this, android.R.layout.simple_list_item_1, listString);
        gridViewBooks.setAdapter(adapter);
    }


}
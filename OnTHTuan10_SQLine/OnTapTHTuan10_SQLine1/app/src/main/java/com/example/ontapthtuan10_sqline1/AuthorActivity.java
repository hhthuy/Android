package com.example.ontapthtuan10_sqline1;

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
import android.widget.Toast;

import java.util.ArrayList;

public class AuthorActivity extends AppCompatActivity {
    EditText et_Id,et_Name,et_Address,et_Email;
    GridView gv_author;
    DBHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        et_Id = findViewById(R.id.edittext_id);
        et_Name = findViewById(R.id.edittext_name);
        et_Address = findViewById(R.id.edittext_address);
        et_Email = findViewById(R.id.edittext_email);
        GridView gv_author = findViewById(R.id.gridView_AuthorList);
        DBHelper dbhelper = new DBHelper(this);

        //1. Save(Thêm Author)
        Button btn_Save = findViewById(R.id.button_Save);
        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Author author = new Author();
                author.setId(Integer.parseInt(et_Id.getText().toString()));
                author.setName(et_Name.getText().toString());
                author.setAddress(et_Address.getText().toString());
                author.setEmail(et_Email.getText().toString());
                if (dbhelper.insertAuthor(author) > 0){
                    Toast.makeText(getApplicationContext(), "Bạn đã Lưu thành công", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Bạn lưu không thành côn", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //2. Select(Truy vấn Author)
        Button btn_Select = findViewById(R.id.button_select);
        btn_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Author> list_Author;//đưa dl vào trong ds
                ArrayList<String> list_String = new ArrayList<>();//trả về từng oo
                //Nếu et_Id rỗng --> getAllAuthor, khác rỗng getIdAuthor
                if(et_Id.getText().toString().equals("")){
                    list_Author = dbhelper.getAlllAuthor();//goi dl Author
                    for (Author au:list_Author){//đưa vào list_string
                        list_String.add(au.getId()+"");
                        list_String.add(au.getName());
                        list_String.add(au.getAddress());
                        list_String.add(au.getEmail());
                    }
                }else{
                    Author au = dbhelper.getIdAuthor(Integer.parseInt(et_Id.getText().toString()));
                    if(au!= null){
                        list_String.add(au.getId()+"");
                        list_String.add(au.getName());
                        list_String.add(au.getAddress());
                        list_String.add(au.getEmail());
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Mã này không có trong Author!", Toast.LENGTH_SHORT).show();
                    }

                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(AuthorActivity.this, android.R.layout.simple_list_item_1, list_String);
                gv_author.setAdapter(adapter);
                et_Id.setEnabled(true);
            }
        });
        //Chọn dữ liệu từ gridView và hiển thị lên Editext để xóa/sửa
        gv_author.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                ArrayList<Author> listAuthor = dbhelper.getAlllAuthor();
                int vitri = i/4;//gridview: 4 ô
                Author author = listAuthor.get(vitri);
                et_Id.setText(author.getId()+"");
                et_Name.setText(author.getName());
                et_Address.setText(author.getAddress());
                et_Email.setText(author.getEmail());
                et_Id.setEnabled(false);//Không hiện Id
            }
        });
        //3. (Xóa Author)
        Button btn_Delete = findViewById(R.id.button_Delete);
        btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mydialog = new AlertDialog.Builder(AuthorActivity.this);
                mydialog.setTitle("Thông báo\n"+"Bạn có chắc muốn xóa không?");
                mydialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int id = Integer.parseInt(et_Id.getText().toString());
                        if(dbhelper.deleteAuthor(id) > 0){
                            Toast.makeText(getApplicationContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Xóa không thành công", Toast.LENGTH_SHORT).show();
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
        //4. Update(Sửa Author)
        Button bt_update = findViewById(R.id.button_Update);
        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(et_Id.getText().toString());
                String name = et_Name.getText().toString();
                String address = et_Address.getText().toString();
                String email = et_Email.getText().toString();

                Author author = new Author(id,name,address,email);
                if(dbhelper.updateAuthor(author) > 0){
                    Toast.makeText(getApplicationContext(), "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Cập nhật không thành công", Toast.LENGTH_SHORT).show();
                }
                //xoaTrang();

            }
        });
        //5. Reset(Xóa trắng Author)
        Button btn_Reset = findViewById(R.id.button_xoatrang);
        btn_Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xoaTrang();
            }
        });

    }//onCreate
    public void xoaTrang(){
        et_Id.setText("");
        et_Name.setText("");
        et_Address.setText("");
        et_Email.setText("");
        ArrayList<Author> authorArrayList = new ArrayList<>();
        ArrayList<String> listString = new ArrayList<>();
        authorArrayList = dbhelper.getAlllAuthor();
        for (Author author : authorArrayList) {
            listString.add(author.getId() + "");
            listString.add(author.getName());
            listString.add(author.getAddress());
            listString.add(author.getEmail());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(AuthorActivity.this, android.R.layout.simple_list_item_1, listString);
        gv_author.setAdapter(adapter);
    }

}
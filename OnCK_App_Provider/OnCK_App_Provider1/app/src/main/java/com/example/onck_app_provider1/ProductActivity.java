package com.example.onck_app_provider1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    static final String uri="content://com.example.onck_app_provider1";//
    static final String ID="id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        EditText et_Id = findViewById(R.id.editText_Id);
        EditText et_Name = findViewById(R.id.editText_Name);
        EditText et_Unit = findViewById(R.id.editText_Unit);
        EditText et_Madein = findViewById(R.id.editText_Madein);
        GridView gv_display = findViewById(R.id.gridview_ProductList);

        Button bt_save = findViewById(R.id.button_Save);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("id", et_Id.getText().toString());
                values.put("name", et_Name.getText().toString());
                values.put("unit", et_Unit.getText().toString());
                values.put("madein", et_Madein.getText().toString());
                Uri product = Uri.parse(uri);
                Uri insert_uri = getContentResolver().insert(product,values);
                Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
                
            }
        });
        Button bt_select = findViewById(R.id.button_Select);
        bt_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> string_list = new ArrayList<>();
                Uri product = Uri.parse(uri);
                Cursor cursor = getContentResolver().query(product,null,null,null,"name");
                if(cursor != null){
                    cursor.moveToFirst();
                    do{
                        string_list.add(cursor.getInt(0)+"");
                        string_list.add(cursor.getString(1)+"");
                        string_list.add(cursor.getString(2)+"");
                        string_list.add(cursor.getString(3)+"");
                    }while(cursor.moveToNext());
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(ProductActivity.this, android.R.layout.simple_list_item_1,string_list);
                    gv_display.setAdapter(adapter);
                    
                }else{
                    Toast.makeText(getApplicationContext(), "Không có kết quả", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button bt_delete= findViewById(R.id.button_Delete);
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("id", et_Id.getText().toString());
//                values.put("name", et_Name.getText().toString());
//                values.put("unit", et_Unit.getText().toString());
//                values.put("madein", et_Madein.getText().toString());
                Uri product = Uri.parse(uri);
                Uri insert_uri = getContentResolver().insert(product,values);
                int delete = getContentResolver().delete(product,"id=?",null);
//                String selection = "id = \"" + ID +"\"";
//                ContentValues values = new ContentValues();
//                values.put("id", et_Id.getText().toString());
//                Uri product = Uri.parse(uri);
//                int insert_uri = getContentResolver().delete(product,"id=?",null);
                if(delete > 0){
                    Toast.makeText(getApplicationContext(), "Xoa thành công", Toast.LENGTH_SHORT).show();
                }


            }
        });
   }



}
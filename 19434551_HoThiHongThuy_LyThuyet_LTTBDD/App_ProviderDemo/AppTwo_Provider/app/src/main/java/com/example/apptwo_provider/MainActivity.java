package com.example.apptwo_provider;

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

public class MainActivity extends AppCompatActivity {
    static final String AUTHORITY ="com.example.app_provider";
    static final String CONTEXT_PROVIDER="contentprovider";
    static final String URL ="content://"+AUTHORITY+"/"+CONTEXT_PROVIDER;
    static final Uri CONTENT_URI =Uri.parse(URL);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_Id = findViewById(R.id.editText_Id);
        EditText et_Name = findViewById(R.id.editText_Name);
        EditText et_Unit = findViewById(R.id.editText_Unit);
        EditText et_Madein = findViewById(R.id.editText_Madein);
        GridView gv_display = findViewById(R.id.gridview_ProductList);


        Button btn_Save = findViewById(R.id.button_Save);
        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                //dua dl vao content values
                values.put("id", et_Id.getText().toString());
                values.put("name", et_Name.getText().toString());
                values.put("unit", et_Unit.getText().toString());
                values.put("madein", et_Madein.getText().toString());
                Uri insert_uri = getContentResolver().insert(CONTENT_URI, values);
                Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
            }
        });

        Button btn_Select = findViewById(R.id.button_Select);
        btn_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> string_list = new ArrayList<>();
                Cursor cursor = getContentResolver().query(CONTENT_URI, null, null,null,"name");//sap xep theo name
                if(cursor != null){
                    cursor.moveToFirst();
                    do{
                        string_list.add(cursor.getInt(0)+"");//id
                        string_list.add(cursor.getString(1));
                        string_list.add(cursor.getString(2));
                        string_list.add(cursor.getString(3));
                    }while(cursor.moveToNext());
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                            android.R.layout.simple_list_item_1, string_list);
                    gv_display.setAdapter(adapter);
                }else{
                    Toast.makeText(getApplicationContext(), "Không có kết quả", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
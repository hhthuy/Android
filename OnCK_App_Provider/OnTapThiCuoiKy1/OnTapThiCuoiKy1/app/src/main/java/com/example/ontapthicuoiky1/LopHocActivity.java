package com.example.ontapthicuoiky1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LopHocActivity extends AppCompatActivity {
    String uri="content://com.example.ontapthicuoiky1/LopHoc";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lop_hoc);

        EditText etMaLop=findViewById(R.id.etMaLop);
        EditText etTenLop=findViewById(R.id.etTenLop);

        //Thoát
        Button btThoat=findViewById(R.id.btThoatLP);
        btThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //Insert
        Button btInsert=findViewById(R.id.btInsert);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int maLop=Integer.valueOf(etMaLop.getText().toString());
                String tenLop=etTenLop.getText().toString();
                LopHoc lopHoc=new LopHoc(maLop,tenLop);

                ContentValues values=new ContentValues();
                values.put("malop",lopHoc.getMaLop());
                values.put("tenlop",lopHoc.getTenLop());
                Uri lophoc=Uri.parse(uri);
                Log.d("lophoc", lophoc.toString());
                Uri insert_uri=getContentResolver().insert(lophoc,values);
                Toast.makeText(getApplicationContext(),"Lưu thành công",Toast.LENGTH_SHORT).show();
            }
        });

        //Search
        Button btSearch=findViewById(R.id.btTimKiem);
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<LopHoc> lopHocs=new ArrayList<>();
                Uri lophoc=Uri.parse("content://com.example.ontapthicuoiky1/LopHoc");
                Cursor cursor=getContentResolver().query(lophoc,null,null,null,"malop");
                if(cursor!=null){
                    cursor.moveToNext();
                    while (!cursor.isAfterLast()){
                        lopHocs.add(new LopHoc(cursor.getInt(0),cursor.getString(1)));
                        cursor.moveToNext();
                    }
                }
            }
        });

        //Delete
        Button btDelete=findViewById(R.id.btDelete);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri lophoc=Uri.parse("content://com.example.ontapthicuoiky1/LopHoc");
                int maLop=Integer.valueOf(etMaLop.getText().toString());
                int del=getContentResolver().delete(lophoc,"malop=?",new String[]{etMaLop.getText().toString()});
                if(del>0){
                    Toast.makeText(getApplicationContext(),"Xóa thành công",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Xóa không thành công",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Update
        Button btUpdate=findViewById(R.id.btUpdate);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri lophoc=Uri.parse("content://com.example.ontapthicuoiky1/LopHoc");
                ContentValues values=new ContentValues();
                values.put("malop",etMaLop.getText().toString());
                values.put("tenlop",etTenLop.getText().toString());
                int update=getContentResolver().update(lophoc,values,"malop=?",new String[]{etMaLop.getText().toString()});
                if(update>0){
                    Toast.makeText(getApplicationContext(),"Cập nhật thành công",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
package com.example.a19434551_hothihongthuy_kt;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_goilophoc = findViewById(R.id.button_goiLopHoc);
        Button bt_goisinhvien = findViewById(R.id.bt_goiSinhVien);

        button_goilophoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LopHocActivity.class);
                startActivity(intent);
            }
        });
        bt_goisinhvien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.example.a19434551_hothihongthuy_kt.SinhVienActivity.class);
                startActivity(intent);
            }
        });
    }//onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menubar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_sv:
                Intent intent=new Intent(MainActivity.this, com.example.a19434551_hothihongthuy_kt.SinhVienActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_lophoc:
                Intent intent1=new Intent(MainActivity.this,LopHocActivity.class);
                startActivity(intent1);
                return true;
            case R.id.menu_thoat:
                    finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}
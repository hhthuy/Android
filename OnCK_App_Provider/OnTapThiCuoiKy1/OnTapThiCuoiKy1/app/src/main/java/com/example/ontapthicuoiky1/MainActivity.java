package com.example.ontapthicuoiky1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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
                Intent intent=new Intent(MainActivity.this,SinhVienActivity.class);
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
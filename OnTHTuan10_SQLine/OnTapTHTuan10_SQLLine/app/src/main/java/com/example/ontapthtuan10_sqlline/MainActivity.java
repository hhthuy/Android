package com.example.ontapthtuan10_sqlline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button_goiauthor,bt_goibook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_goiauthor = findViewById(R.id.button_goiauthor);
        bt_goibook = findViewById(R.id.bt_goibook);

        button_goiauthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AuthorActivity.class);
                startActivity(intent);
            }
        });
        bt_goibook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BookActivity.class);
                startActivity(intent);
            }
        });


    }//onCreate
    //MENU book---------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menubar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mni_book:
                Intent intent = new Intent(MainActivity.this, BookActivity.class);
                startActivity(intent);
                return true;
            case R.id.mni_author:
                Intent intent_author = new Intent(MainActivity.this, AuthorActivity.class);
                startActivity(intent_author);
                return true;
            case R.id.mni_thoat:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
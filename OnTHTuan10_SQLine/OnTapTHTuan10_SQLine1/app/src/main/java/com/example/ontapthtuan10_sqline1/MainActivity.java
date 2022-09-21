package com.example.ontapthtuan10_sqline1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Gọi Author
        Button bt_Author = findViewById(R.id.button_Author);
        bt_Author.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAuthor = new Intent(MainActivity.this, AuthorActivity.class);
                startActivity(intentAuthor);
            }
        });
        //Gọi Book
        Button bt_Book = findViewById(R.id.button_Book);
        bt_Book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBook = new Intent(MainActivity.this, BookActivity.class);
                startActivity(intentBook);
            }
        });
        //Menu
    }//onCreate
}
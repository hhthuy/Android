package com.example.cs02_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_hoten = findViewById(R.id.editText_Hoten);
        EditText et_namsinh = findViewById(R.id.editText_NamSinh);
        Button btn_Submit = findViewById(R.id.button_Submit);

        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //truyen dl mainactivity--> second activity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);//cầu nối
                intent.putExtra("ht", et_hoten.getText().toString());//truyền dữ liệu
                intent.putExtra("ns", et_namsinh.getText().toString());
                startActivity(intent);
            }
        });

    }
}
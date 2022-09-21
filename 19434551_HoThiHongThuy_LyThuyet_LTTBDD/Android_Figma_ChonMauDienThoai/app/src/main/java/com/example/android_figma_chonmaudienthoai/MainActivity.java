package com.example.android_figma_chonmaudienthoai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_ChonMMau = findViewById(R.id.button_Chon4Mau);
        btn_ChonMMau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent familyIntent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(familyIntent);
            }
        });
//        Button btn_Chon4Mau = findViewById(R.id.button_Chon4Mau);
//        btn_Chon4Mau.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}
package com.example.module21_bai3_chuyendoinamduonglich;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText et_NamDuong = findViewById(R.id.edittext_namduonglich);
        EditText et_NamAm = findViewById(R.id.edittext_namamlich);
        Button btnDoiNam = findViewById(R.id.button_ChuyenDoi);
        btnDoiNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int duong  =Integer.parseInt(et_NamDuong.getText().toString());
                String can[] = {"Canh","Tân","Nhâm","Qúy","Giáp","Ất","Bính","Đinh","Mậu", "Kỷ"};
                String chi[] = {"Thân","Dậu","Tuất","Hợi","Tý","Sửu","Dần","Mẹo","Thìn","Tỵ","Ngọ","Mùi"};
                String am = can[duong%10]+" "+chi[duong%12];
                et_NamAm.setText(""+am);
            }
         }

        );
    }
}
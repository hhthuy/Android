package com.example.module21_bai1_tonghieutichthuonguscln;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        EditText et_SoA = findViewById(R.id.editext_Soa);
        EditText et_SoB = findViewById(R.id.editext_Sob);
        Button btn_Tong = findViewById(R.id.button_tong);
        Button btn_Hieu = findViewById(R.id.button_hieu);
        Button btn_Tich = findViewById(R.id.button_tich);
        Button btn_Thuong = findViewById(R.id.button_thuong);
        Button btn_uocchung = findViewById(R.id.button_uscln);
        Button btn_Thoat = findViewById(R.id.button_thoat);
        TextView tv_KetQua = findViewById(R.id.textview_ketqua);

        //Xử lý sự kiện nút Tổng
        btn_Tong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a  =Integer.parseInt(et_SoA.getText().toString());
                int b  =Integer.parseInt(et_SoB.getText().toString());
                int c = a+b;
                tv_KetQua.setText(""+c);
            }
        });
        //Xử lý sự kiện nút Hiệu
        btn_Hieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a  =Integer.parseInt(et_SoA.getText().toString());
                int b  =Integer.parseInt(et_SoB.getText().toString());
                int d = a-b;
                tv_KetQua.setText(""+d);
            }
        });
        //Xử lý sự kiện nút Tích
        btn_Tich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a  =Integer.parseInt(et_SoA.getText().toString());
                int b  =Integer.parseInt(et_SoB.getText().toString());
                int e = a*b;
                tv_KetQua.setText(""+e);
            }
        });
        //Xử lý sự kiện nút Thương
        btn_Thuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a  =Integer.parseInt(et_SoA.getText().toString());
                int b  =Integer.parseInt(et_SoB.getText().toString());
                int f = a/b;
                tv_KetQua.setText(""+f);
            }
        });
        //Xử lý sự kiện nút ƯỚC CHUNG
        btn_uocchung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a  =Integer.parseInt(et_SoA.getText().toString());
                int b  =Integer.parseInt(et_SoB.getText().toString());
                while (a != b) {
                    if(a > b)
                        a = a - b;
                    else
                        b = b - a;
                }
                tv_KetQua.setText(""+ b);
            }
        });
        btn_Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khoi tao lai Activity main
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                // Tao su kien ket thuc app
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startActivity(startMain);
                finish();
            }
        });


    }
}


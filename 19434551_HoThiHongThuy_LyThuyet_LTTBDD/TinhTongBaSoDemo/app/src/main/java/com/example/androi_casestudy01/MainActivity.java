package com.example.androi_casestudy01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.InterfaceAddress;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //kết nối đối tượng trong layout
        EditText et_HeSoA = findViewById(R.id.editText_HeSoA);
        EditText et_HeSoB = findViewById(R.id.editText_HeSoB);
        Button bt_Tong = findViewById(R.id.button_Tong);
        TextView tv_KetQua = findViewById(R.id.textView_KetQua);
        //Xử lý
        bt_Tong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(et_HeSoA.getText().toString());
                int b = Integer.parseInt(et_HeSoB.getText().toString());
                int c = a+b;
                tv_KetQua.setText("Tổng là: " + c);
            }
        });
    }
}
package com.example.ontapgk_android1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

//INTENT: AndroidMainifest.xml
//<activity
//            android:name=".SecondActivity"
//                    android:exported="false" />
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_item_layout);//Main --> my_item_layout


        //truyen du lieu
        String maso = getIntent().getExtras().getString("ma");
        String hoten = getIntent().getExtras().getString("ten");
        String st1,st2 ="";
        st1 ="Mã số:" +maso;
        st2 ="Họ và tên: " +hoten;

        TextView tv_KetQua1 = findViewById(R.id.txtMaso);
        tv_KetQua1.setText(st1);
        TextView tv_KetQua2 = findViewById(R.id.txtHoTen);
        tv_KetQua2.setText(st2);
    }
}

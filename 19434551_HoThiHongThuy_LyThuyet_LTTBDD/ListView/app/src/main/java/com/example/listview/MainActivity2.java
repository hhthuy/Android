package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {
    ImageView img;
    TextView tv_ten,tv_dongia;
    AppCompatButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        img = findViewById(R.id.img_sp);
        tv_ten = findViewById(R.id.tv_tenSanPham);
        tv_dongia = findViewById(R.id.tv_dongiasp);
        btn = findViewById(R.id.btn_trove);
        Intent intent = getIntent();
        Sanpham sp = (Sanpham) intent.getSerializableExtra("sp");

        img.setImageResource(sp.getHinh());
        tv_ten.setText("Tên Sản Phẩm : " + sp.getTenSanPham());
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        tv_dongia.setText("Đơn Giá : " + formatter.format(sp.getDonGia())+" VND");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
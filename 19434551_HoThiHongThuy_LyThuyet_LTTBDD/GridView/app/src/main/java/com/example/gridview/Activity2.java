package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    ImageView imgvAnhSp, imgvGioHang;
    TextView tvTen, tvGia, tvThongTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        imgvAnhSp= findViewById(R.id.imageview_anhsanpham);
        tvGia = findViewById(R.id.tv_guiGia);
        tvTen = findViewById(R.id.tv_guiTen);
        tvThongTin = findViewById(R.id.textview_thongtinchitiet);

        int hinh = getIntent().getIntExtra("hinh", 0);
        double gia = getIntent().getDoubleExtra("gia",0);
        String ten= getIntent().getStringExtra("ten");
        String mota = getIntent().getStringExtra("mota");

        imgvAnhSp.setImageResource(hinh);
        tvTen.setText(ten);
        tvGia.setText(String.valueOf(gia));
        tvThongTin.setText(mota);

    }
}
package com.example.fragmenttestdemo;

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
        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra("ThongTinSanPham");
        Fragment2 fragment2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.detailFragment);
        fragment2.setProduct(product);
    }
}
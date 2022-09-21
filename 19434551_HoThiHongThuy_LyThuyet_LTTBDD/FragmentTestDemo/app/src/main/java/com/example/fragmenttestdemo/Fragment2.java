package com.example.fragmenttestdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;

public class Fragment2 extends Fragment {
    TextView txtName,txtPrice;
    ImageView imgproduct;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);

        txtName = (TextView) view.findViewById(R.id.tv_tenSanPham);
        txtPrice = (TextView) view.findViewById(R.id.tv_dongiasp);
        imgproduct = (ImageView) view.findViewById(R.id.img_sp);

        return view;
    }
    public  void setProduct(Product product){
        txtName.setText("Tên Sản Phẩm : " +product.getName());
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        txtPrice.setText("Đơn Giá : " +formatter.format(product.getPrice())+" VND");
        imgproduct.setImageResource(product.getImg());
    }
}
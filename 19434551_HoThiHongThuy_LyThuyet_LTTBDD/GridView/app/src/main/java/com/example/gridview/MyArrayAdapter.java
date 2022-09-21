package com.example.gridview;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<SanPham> {
    Activity context = null;
    ArrayList<SanPham> myArray = null;
    int layoutId;

    public MyArrayAdapter(Activity context, int textViewResourceId, ArrayList<SanPham> obj) {
        super(context, textViewResourceId, obj);
        this.context = context;
        this.layoutId = textViewResourceId;
        this.myArray = obj;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);
        if (myArray.size() > 0 && position >= 0) {
            final ImageView imgvHienThi = convertView.findViewById(R.id.imageview_hinhsanpham);
            final SanPham sanPham = myArray.get(position);
            imgvHienThi.setImageResource(sanPham.getHinhAnh());
            final TextView tvTen = convertView.findViewById(R.id.textview_tensanpham);
            tvTen.setText(sanPham.getTenSanPham());
            final TextView tvGia = convertView.findViewById(R.id.textview_giasanpham);
            tvGia.setText(String.valueOf(sanPham.getGiaSanPham()));
        }
        return convertView;
    }
}

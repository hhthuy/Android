package com.example.ontapgk_android1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class NhanVienArrayAdapter extends ArrayAdapter<NhanVien> {
    Activity context = null;
    ArrayList<NhanVien> myArray = null;
    int layoutId;

    public NhanVienArrayAdapter(Activity context, int layoutId, ArrayList<NhanVien> myArray) {
        super(context, layoutId, myArray);
        this.context = context;
        this.layoutId = layoutId;
        this.myArray = myArray;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);
        if (myArray.size() > 0 && position >= 0) {
            //lấy TextView ra để hiển thị Mã, tên, giơi tính, đơn vị
            final ImageView imageView = convertView.findViewById(R.id.image);
            final TextView txt_MasoDisplay = convertView.findViewById(R.id.txtMaso);
            final TextView txt_HotenDisplay = convertView.findViewById(R.id.txtHoTen);
            final TextView txt_GioitinhDisplay = convertView.findViewById(R.id.txtGioiTinh);
            final TextView txt_DonViDisplay = convertView.findViewById(R.id.txtDonVi);
            final TextView txt_NgonNguDisplay = convertView.findViewById(R.id.txtNgonNgu);
            // final TextView txt_NgonNguDisplay = convertView.findViewById(R.id.txtNgonNgu);
            //lấy ra nhân viên thứ position
            imageView.setImageResource(getItem(position).getImage());
            txt_MasoDisplay.setText("Mã số: " + getItem(position).getMaso() + "");
            txt_HotenDisplay.setText("Họ tên: " + getItem(position).getHoTen());
            txt_GioitinhDisplay.setText("Giới tính: " + getItem(position).getGioiTinh());
            txt_DonViDisplay.setText("Đơn vị : " + getItem(position).getDonVi());
            txt_NgonNguDisplay.setText("Ngôn ngữ : " + getItem(position).getNgonNgu());

        }
        return convertView;//trả về View thông tin vừa thay đổi

    }

//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        LayoutInflater inflater = context.getLayoutInflater();
//        convertView = inflater.inflate(layoutId, null);
//        if(myArray.size() > 0 && position >=0 ){
//            final TextView txtDisplay = convertView.findViewById(R.id.tv_item);
//            final NhanVien nv = myArray.get(position);
//            txtDisplay.setText(nv.toString());
//            final ImageView imgitem = (ImageView) convertView.findViewById(R.id.img_item);
//            if(nv.isGender()){
//                imgitem.setImageResource(R.drawable.nam_icon);
//            }else{
//                imgitem.setImageResource(R.drawable.nu_icon);
//            }
//        }
//        return convertView;
//    }
}

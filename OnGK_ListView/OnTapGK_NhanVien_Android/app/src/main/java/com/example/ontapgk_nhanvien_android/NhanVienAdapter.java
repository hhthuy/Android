package com.example.ontapgk_nhanvien_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import java.util.ArrayList;

public class NhanVienAdapter  extends BaseAdapter{
    Context myContext;
    ArrayList<NhanVien> myList;

    public NhanVienAdapter(Context context, ArrayList<NhanVien> listNhanVien){
        myContext = context;
        myList = listNhanVien;
    }
    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int i) {
        return myList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.list_nhan_vien,null);
        NhanVien nhanvien = myList.get(i);
        EditText maNV = view.findViewById(R.id.Et_maSo);
        maNV.setText(nhanvien.getMaNV());
        EditText hoTen = view.findViewById(R.id.Et_hoTen);
        hoTen.setText(nhanvien.getHoTen());
        EditText gioiTinh = view.findViewById(R.id.Et_gioiTinh);
        gioiTinh.setText(nhanvien.getGioiTinh());
        EditText donVi = view.findViewById(R.id.Et_donVi);
        donVi.setText(nhanvien.getDonVi());
        return view;
    }
}

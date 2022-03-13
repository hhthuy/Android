package com.example.module23_bai1_quanlynhanvien;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
//ArrayAdapterNhanVien kế thừa từ ArrayAdapter, mục đích của nó là giúp chúng ta Custom lại layout cho ListView.
//Tạo lớp ArrayAdapterNhanVien để thay thế cho lớp ArrayAdapter
public class MyArrayAdapter extends ArrayAdapter<NhanVien> {
    Activity context = null;
    ArrayList<NhanVien> myArray = null;
    int layoutId;

    /**
     * Constructor khởi tạo các giá trị từ MainActivity truyền vào
     *
     * @param context   : là Activity từ Main
     * @param layoutId: Là layout custom do ta tạo (my_item_layout.xml)
     * @param arr       : Danh sách nhân viên truyền từ Main
     */
    public MyArrayAdapter(Activity context, int layoutId, ArrayList<NhanVien>arr){
        super(context, layoutId, arr);
        this.context=context;
        this.layoutId=layoutId;
        this.myArray=arr;
    }

    /**
     * hàm dùng để custom layout, ta phải override lại hàm này
     * từ MainActivity truyền vào
     *
     * @param position     : là vị trí của phần tử trong danh sách nhân viên
     * @param convertView: convertView, dùng nó để xử lý Item
     * @param parent       : Danh sách nhân viên truyền từ Main
     * @return View: trả về chính convertView
     */

    public View getView(int position, View convertView, ViewGroup parent) {
         LayoutInflater inflater= context.getLayoutInflater();
         convertView=inflater.inflate(layoutId, null);
		if(myArray.size()>0 && position>=0) {
        //lấy TextView ra để hiển thị Mã và tên
        final TextView txtdisplay=(TextView) convertView.findViewById(R.id.tv_item);
        //lấy ra nhân viên thứ position
        final NhanVien emp=myArray.get(position);
        txtdisplay.setText(emp.toString());   //đưa thông tin lên TextViewemp.toString() sẽ trả về Id và Name
        //lấy ImageView ra để thiết lập hình ảnh cho đúng
        final ImageView imgitem=(ImageView) convertView.findViewById(R.id.img_item);

        if(emp.isGender()){
            imgitem.setImageResource(R.drawable.nam_icon);
        }else{
            imgitem.setImageResource(R.drawable.nu_icon);
        }
    }return convertView;//trả về View thông tin vừa thay đổi
}

}

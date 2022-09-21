package com.example.a19434551_hothihongthuy_tk2_nhanvienui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
//NhanVienAdapter kế thừa từ ArrayAdapter, mục đích của nó là giúp chúng ta Custom lại layout cho ListView.
//Tạo lớp NhanVienAdapter để thay thế cho lớp ArrayAdapter
public class NhanVienAdapter extends ArrayAdapter<NhanVien> {
    private Context mContext;
    private int mResource;
    ArrayList<NhanVien> myArray = null;

    /**
     * Constructor khởi tạo các giá trị từ MainActivity truyền vào
     *
     * @param context   : là Activity từ Main
     * @param resource: Là layout custom do ta tạo (my_item_layout.xml)
     * @param objects       : Danh sách nhân viên truyền từ Main
     */
    public NhanVienAdapter(@NonNull Context context, int resource, @NonNull ArrayList<NhanVien> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
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
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource, parent, false);
        //lấy ImageView ra để thiết lập hình ảnh cho đúng
        ImageView imageView = convertView.findViewById(R.id.image);

        //lấy TextView ra để hiển thị Mã, tên, giơi tính, đơn vị
        TextView txtMaso = convertView.findViewById(R.id.txtMaso);
        TextView txtHoten = convertView.findViewById(R.id.txtHoTen);
        TextView txtGioitinh = convertView.findViewById(R.id.txtGioiTinh);
        TextView txtDonVi = convertView.findViewById(R.id.txtDonVi);

        //lấy ra nhân viên thứ position
        imageView.setImageResource(getItem(position).getImage());
        txtMaso.setText("Mã số: " + getItem(position).getMaso() + "");
        txtHoten.setText("Họ tên: " + getItem(position).getHoTen());
        txtGioitinh.setText("Giới tính: " + getItem(position).getGioiTinh());
        txtDonVi.setText("Đơn vị : " + getItem(position).getDonVi());

        return convertView;//trả về View thông tin vừa thay đổi
    }
}

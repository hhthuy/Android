package com.example.a19434551_hothihongthuy_tk2_nhanvienui;
/**
 * Đọc dữ liệu listView
 *
 * Bổ sung: 2 NÚT: ĐỌC VÀ GHI
 * Xử lý:
 * Nhập nv: add vao listView
 * Bấm Ghi -->lấy thông tin NV ghi xuống bộ nhớ trong
 * Đọc: Đóng app --> Mở app --> (Bộ nhớ trong)DL trong listView --> bấm Đọc --> hiển thị dl trong listView
 */

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.shadow.ShadowRenderer;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    ArrayList<NhanVien> nv_List = new ArrayList<>();
    String[] dv_List;
    ArrayAdapter<String> adapterDonvi;
    NhanVienAdapter nhanVienAdapter;//Sử dụng NhanVienAdapter thay thì ArrayAdapter

    EditText et_MaSo, et_HoTen;
    ListView lv_NhanVien;
    RadioGroup rg_GioiTinh;
    RadioButton rb_Nam, rb_Nu;
    Spinner sp_DonVi;
    ImageView iv_Avatar;
    Button bt_Them, bt_Sua, bt_ChonAnh, bt_Thoat;
    ImageButton btn_Xoa;
    Button bt_Doc, bt_Ghi;
    

    int mangHinhAnh[] = {
            R.drawable.avatar1, R.drawable.avatar2,
            R.drawable.avatar3, R.drawable.avatar4,
            R.drawable.avatar5, R.drawable.avatar6
    };

    int maso, image;
    String hoTen, gioiTinh, donVi;
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_MaSo = findViewById(R.id.et_MaSo);
        et_HoTen = findViewById(R.id.et_HoTen);
        lv_NhanVien = findViewById(R.id.listView_NhanVien);
        rg_GioiTinh = findViewById(R.id.radioGroup);
        rb_Nam = findViewById(R.id.radioButton_Nam);
        rb_Nu = findViewById(R.id.radioButton_Nu);
        sp_DonVi = findViewById(R.id.spinner_DonVi);
        bt_Them = findViewById(R.id.btn_Them);
        bt_ChonAnh = findViewById(R.id.btn_ChonAnh);
        bt_Sua = findViewById(R.id.btn_Sua);
        iv_Avatar = findViewById(R.id.iv_AnhPreview);
        bt_Thoat = findViewById(R.id.btn_Thoat);
        bt_Doc = findViewById(R.id.btn_docDL);
        bt_Ghi = findViewById(R.id.btn_ghiDL);
        //   btn_Xoa=(ImageButton) findViewById(R.id.imgbutton_Xoa);

        //Xử lý chọn đơn vị
        dv_List = getResources().getStringArray(R.array.donvi_list);
        //Khởi tạo đối tượng adapter và gán Data source: simple_list_item_1: lấy custom layout;dv_List: thiết lập data source
        adapterDonvi = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, dv_List);
        sp_DonVi.setAdapter(adapterDonvi);//gán Adapter vào Lisview
        //Xử lý chọn đơn vị
        sp_DonVi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                donVi = dv_List[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Xử lý chọn ảnh
        bt_ChonAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int min = 0;
                int max = 5;
                //Chọn hình ảnh ngẫu nhiên từ 6 hình
                //Math.random()có phạm vi [0,1), muốn [min,max)(hoặc [min,max+1)= [min,max]
                int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
                image = mangHinhAnh[random_int];
                iv_Avatar.setImageResource(image);
            }
        });

        //Đưa danh sách nhân viên vào listView
        nhanVienAdapter = new NhanVienAdapter(this, R.layout.show_img, nv_List);
        lv_NhanVien.setAdapter(nhanVienAdapter);

        //Xử lý thêm nhân viên
        bt_Them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maso = Integer.parseInt(et_MaSo.getText().toString());
                hoTen = et_HoTen.getText().toString();
                gioiTinh = ((RadioButton) findViewById(rg_GioiTinh.getCheckedRadioButtonId())).getText().toString();

                //Tạo đối tượng nhân viên
                NhanVien nv = new NhanVien(image, maso, hoTen, gioiTinh, donVi);
                //Thêm nhân viên vào danh sách
                nv_List.add(nv);

                nhanVienAdapter.notifyDataSetChanged(); // Cập nhật lại adapter khi dữ liệu trong mảng thay đổi
                xoaTrang(); // Xoá dl NV đã nhập
            }
        });

        //View nhan vien
        lv_NhanVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NhanVien nv = nv_List.get(i);
                iv_Avatar.setImageResource(nv.getImage());
                et_MaSo.setText(nv.getMaso() + "");
                et_HoTen.setText(nv.getHoTen());

                Log.d("AA", nv.getGioiTinh());
                //Xử lý giới tính
                if (nv.getGioiTinh().equals("Nam"))
                    rb_Nam.setChecked(true);
                else
                    rb_Nu.setChecked(true);

                //Xử lý đơn vị
                for (int j = 0; j < dv_List.length; j++) {
                    if (dv_List[j].equals(nv.getDonVi()))
                        sp_DonVi.setSelection(j);
                }
                index = i;
            }
        });

        //Xử lý sửa nhân viên
        bt_Sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhanVien nv = nv_List.get(index);
                nv.setImage(image);
                nv.setMaso(Integer.parseInt(et_MaSo.getText().toString()));
                nv.setHoTen(et_HoTen.getText().toString());
                nv.setGioiTinh(((RadioButton) findViewById(rg_GioiTinh.getCheckedRadioButtonId())).getText().toString());
                nv.setDonVi(donVi);

                nhanVienAdapter.notifyDataSetChanged(); // Cập nhật lại adapter khi dữ liệu trong mảng thay đổi
                xoaTrang(); // Xoá data NV đã nhập
            }
        });

        //Xử lý nút thoát
        bt_Thoat.setOnClickListener(new View.OnClickListener() {
            //private Context context;
            @Override
            public void onClick(View v) {
                //               finishAffinity();
//                System.exit(0);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông báo");
                //set icon title
                builder.setCancelable(true);
                builder.setIcon(R.drawable.icon_thongbao);
                builder.setMessage("Bạn muốn thoát chương trình không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Toast.makeText(context,"Bạn đã chọn nút Có thoát chương trình", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Toast.makeText(context,"Bạn đã chọn nút Không thoát chương trình", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                builder.create().show();
            }
        });
        //ĐỌC GHI FILE
        bt_Ghi.setOnClickListener(new View.OnClickListener() {
            String prefname="my_data";
            @Override
            public void onClick(View v) {
//                SharedPreferences pre=getSharedPreferences
//                        (prefname,MODE_PRIVATE);
//                //lấy giá trị checked ra, nếu không thấy thì giá trị mặc định là false
//                boolean bchk=pre.getBoolean("checked", false);
//                if(bchk)
//                {
//                    //lấy user, pwd, nếu không thấy giá trị mặc định là rỗng
//                    String user=pre.getString("user", "");
//                    String pwd=pre.getString("pwd", "");
//                    edit.setText(user);
//                    editpassword.setText(pwd);
//                }
//                chksaveaccount.setChecked(bchk);
            }
        });
    }

            //----------------------------
            private void xoaTrang() {
                iv_Avatar.setImageResource(0);
                et_MaSo.getText().clear();
                et_HoTen.getText().clear();
                rb_Nam.setChecked(false);
                rb_Nu.setChecked(false);
                sp_DonVi.setSelection(0);
            }

}
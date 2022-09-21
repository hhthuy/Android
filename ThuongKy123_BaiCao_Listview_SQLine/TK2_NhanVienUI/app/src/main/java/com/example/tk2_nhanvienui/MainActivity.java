package com.example.tk2_nhanvienui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * BTVN:
 *Nhấn vào nút "Chọn hình" sẽ hiện thị đến thư mục chứa hình
 *Hiển thị hình vào listView gồm hình và ten, ma, gioitinh,donvi
 *https://helpex.vn/question/lam-cach-nao-de-tai-imageview-bang-url-trong-android-dong-cua-5cb06606ae03f646208d833a
 *
 */
public class MainActivity extends AppCompatActivity {

    ArrayList<NhanVien> nv_list= new ArrayList<>();//Lưu trữ NhanVien khi được nhập vào
    String[] dv_list;//dv_list mảng chứa <string-array name="donvi_list"> trong strings.xml
    String donvi;// biến donvi lưu trữ gía trị đơn vị
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et_MaSo= findViewById(R.id.editText_MaSo);
        EditText et_HoTen= findViewById(R.id.editText_HoTen);
        RadioGroup rg_GioiTinh = findViewById(R.id.radioGroup_GioiTinh);
        RadioButton rb_Nam = findViewById(R.id.radioButton_Nam);
        RadioButton rb_Nu = findViewById(R.id.radioButton_Nu);
        ListView lv_NhanVien = findViewById(R.id.listView_NhanVien);

        //đơn vị
        Spinner sp_DonVi=findViewById(R.id.spinner_DonVi);
        dv_list = getResources().getStringArray(R.array.donvi_list);//<string-array name="donvi_list"> trong strings.xml
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,dv_list);
        sp_DonVi.setAdapter(adapter);
        sp_DonVi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                donvi = dv_list[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //Thêm
        Button bt_them = findViewById(R.id.button_Them);
        bt_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int maso = Integer.parseInt(et_MaSo.getText().toString());
                String hoten = et_HoTen.getText().toString();
                String gioitinh = ((RadioButton)findViewById(rg_GioiTinh.getCheckedRadioButtonId())).getText().toString();

                //Tạo đối tượng nhân viên
                NhanVien nv = new NhanVien(maso,hoten,gioitinh,donvi);
                //Thêm nhân viên vào ds
                nv_list.add(nv);
                //Đưa ds nhân viên vào listview
                ArrayList<String> listItems = new ArrayList<>();
                for (NhanVien nv1: nv_list)
                    listItems.add(nv1.toString());

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1,listItems);
                lv_NhanVien.setAdapter(adapter);
            }
        });
        lv_NhanVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NhanVien nv = nv_list.get(i);
                et_MaSo.setText(nv.getMaso()+ "");
                et_HoTen.setText(nv.getHoten()+ "");
                //Xử lý giới tính
                if(nv.getGioitinh().equals("Nam"))
                    rb_Nam.setChecked(true);
                else
                    rb_Nu.setChecked(true);
                //Xử lý đơn vị
                for (int j =0; i < dv_list.length; j++)
                    if(dv_list[j].equals(nv.getDonvi()))
                        sp_DonVi.setSelection(j);

                //Xử lý ảnh

            }
        });
//



    }
}
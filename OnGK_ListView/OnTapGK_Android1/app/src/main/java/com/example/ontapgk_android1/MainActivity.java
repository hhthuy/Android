package com.example.ontapgk_android1;
/**
 * Đọc dữ liệu listView
 *
 * Bổ sung: 2 NÚT: ĐỌC VÀ GHI
 * Xử lý:
 * Nhập nv: add vao listView
 * Bấm Ghi -->lấy thông tin NV ghi xuống bộ nhớ trong
 * Đọc: Đóng app --> Mở app --> (Bộ nhớ trong)DL trong listView --> bấm Đọc --> hiển thị dl trong listView
 */


import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //----------
    ArrayList<NhanVien> nv_List = new ArrayList<>();
    String[] dv_List;
    String donvi;
    int vitri;

    ArrayAdapter<String> adapterDonvi;
    NhanVienArrayAdapter nhanVienAdapter;
    //------------

    EditText et_MaSo, et_HoTen;
    ListView lv_NhanVien;
    RadioGroup rg_GioiTinh;
    RadioButton rb_Nam, rb_Nu;
    CheckBox check_VN, check_France, check_English;
    Spinner sp_donvi;
    ImageView iv_Avatar;
    Button bt_Them, bt_Sua, bt_ChonAnh, bt_Thoat,bt_Truyvan,bt_Doc, bt_Ghi;
    ImageButton btn_Xoa;

    int image;
    int mangHinhAnh[] = {
            R.drawable.avatar1, R.drawable.avatar2,
            R.drawable.avatar3, R.drawable.avatar4,
            R.drawable.avatar5, R.drawable.avatar6
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent----------------
        Button btn_Khac = findViewById(R.id.button_Khac);
        btn_Khac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // startActivity(intent);
                intent.putExtra("ma", et_MaSo.getText().toString());//truyền dữ liệu
                intent.putExtra("ten", et_HoTen.getText().toString());
                startActivity(intent);
            }
        });
        //------------------
        et_MaSo = findViewById(R.id.editText_MaSo);
        et_HoTen = findViewById(R.id.editText_Ten);
        lv_NhanVien = findViewById(R.id.listView_NhanVien);
        rg_GioiTinh = findViewById(R.id.radioGroup_GioiTinh);
        rb_Nam = findViewById(R.id.radionButton_Nam);
        rb_Nu = findViewById(R.id.radionButton_Nu);
        check_VN = findViewById(R.id.checkBox_VN);
        check_English = findViewById(R.id.checkBox_English);
        check_France = findViewById(R.id.checkBox_France);
        sp_donvi = findViewById(R.id.spinner_DonVi);
        bt_Them = findViewById(R.id.button_Them);
        bt_ChonAnh = findViewById(R.id.button_ChonAnh);
        bt_Sua = findViewById(R.id.button_Sua);
        iv_Avatar = findViewById(R.id.imageview_AnhDaiDien);
        bt_Thoat = findViewById(R.id.button_Thoat);
        bt_Truyvan = findViewById(R.id.button_TruyVan);
        //Doc-ghi
        bt_Doc = findViewById(R.id.button_Doc);
        bt_Ghi = findViewById(R.id.button_Ghi);

        //Xu ly don vi
        dv_List = getResources().getStringArray(R.array.donvi_list);
        adapterDonvi = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dv_List);
        sp_donvi.setAdapter(adapterDonvi);//gán Adapter vào Lisview
        sp_donvi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                donvi = dv_List[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        loadData();
        nhanVienAdapter = new NhanVienArrayAdapter(this, R.layout.my_item_layout, nv_List);
        lv_NhanVien.setAdapter(nhanVienAdapter);
        //Xu ly anh
        bt_ChonAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int min = 0;
                int max = 5;
                int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
                image = mangHinhAnh[random_int];
                iv_Avatar.setImageResource(image);
            }
        });
        bt_Them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int ma = Integer.parseInt(et_MaSo.getText().toString());
                String ten = et_HoTen.getText().toString();
                String gioiTinh = ((RadioButton) findViewById(rg_GioiTinh.getCheckedRadioButtonId())).getText().toString();
                String ngonngu = "";
                if (check_VN.isChecked()) {
                    ngonngu += check_VN.getText().toString() + ", ";
                }
                if (check_English.isChecked()) {
                    ngonngu += check_English.getText().toString() + ", ";
                }
                if (check_France.isChecked()) {
                    ngonngu += check_France.getText().toString() + ", ";
                }
                NhanVien nv = new NhanVien(image, ma, ten, gioiTinh, donvi, ngonngu);
                nv_List.add(nv);

                nhanVienAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Thêm nhân viên thành công! ", Toast.LENGTH_SHORT).show();
                xoaTrang();

            }
        });

        //Xử lý nút thoát
        bt_Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finishAffinity();
                //System.exit(0);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông báo");
                //builder.setCancelable(true);
                //builder.setIcon(R.drawable.icon_thongbao);
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
        //Xử lý sửa nhân viên
        bt_Sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhanVien nv = nv_List.get(vitri);
                nv.setImage(image);
                nv.setMaso(Integer.parseInt(et_MaSo.getText().toString()));
                nv.setHoTen(et_HoTen.getText().toString());
                nv.setGioiTinh(((RadioButton) findViewById(rg_GioiTinh.getCheckedRadioButtonId())).getText().toString());
                nv.setDonVi(donvi);

                nhanVienAdapter.notifyDataSetChanged();
                xoaTrang();
            }
        });
        bt_Ghi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
                Toast.makeText(MainActivity.this, "Lưu thành công!", Toast.LENGTH_LONG).show();
            }
        });
        lv_NhanVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NhanVien nv = nv_List.get(i);
                vitri = i;
                iv_Avatar.setImageResource(nv.getImage());
                et_MaSo.setText(nv.getMaso() + "");
                et_HoTen.setText(nv.getHoTen());

                //Log.d("AA", nv.getGioiTinh());
                // Xử lý giới tính
                if (nv.getGioiTinh().equals("Nam"))
                    rb_Nam.setChecked(true);
                else
                    rb_Nu.setChecked(true);

                //Xử lý Spinner đơn vị
                for (int j = 0; j < dv_List.length; j++) {
                    if (dv_List[j].equals(nv.getDonVi()))
                        sp_donvi.setSelection(j);
                }
                String ngonngu = "";
                if (check_VN.isChecked()) {
                    ngonngu += check_VN.getText().toString() + ", ";
                }
                if (check_English.isChecked()) {
                    ngonngu += check_English.getText().toString() + ", ";
                }
                if (check_France.isChecked()) {
                    ngonngu += check_France.getText().toString() + ", ";
                }



            }
        });
        }
    private void xoaTrang() {
        iv_Avatar.setImageResource(0);
        et_MaSo.getText().clear();
        et_HoTen.getText().clear();
        rb_Nam.setChecked(false);
        rb_Nu.setChecked(false);
        sp_donvi.setSelection(0);
    }
    //Menu------------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnDSNV:{
                Toast.makeText(this, "Bạn đã chọn Xem DSDV", Toast.LENGTH_SHORT).show();
                Intent familyIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(familyIntent);
                break;
            }
            case R.id.mnInDS:{
                Toast.makeText(this, "Bạn đã chọn mục In DSSV", Toast.LENGTH_SHORT).show();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    //--------------------------------------------------------
    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("myArray",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(nv_List);
        editor.putString("List",json);
        editor.apply();
    }
    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("myArray",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("List",null);
        Type type = new TypeToken<ArrayList<NhanVien>>(){}.getType();
        nv_List = gson.fromJson(json,type);
        if(nv_List == null){
            nv_List = new ArrayList<>();
        }
    }
}//main

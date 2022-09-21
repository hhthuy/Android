package com.example.ontapgk_nhanvien_android;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST_CODE = 102;
    private static int RESULT_LOAD_IMAGE = 1;
    private static final int CAMERA_PERM_REQUEST = 101;;
    ListView listView;
    NhanVienAdapter nhanVienAdapter;
    ArrayList<NhanVien> nhanViens;
    Button btn_Thoat,btn_them,btn_sua,btn_truyvan,btn_ghi;
    EditText ma,hoten;
    RadioButton nam,nu;
    Spinner spiner;
    int index = -1;
    String[] dv_list;
    ArrayAdapter<String> adapterDv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhXa();
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ma.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Mã nhân viên không được rỗng!", Toast.LENGTH_SHORT).show();
                }else if(hoten.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Họ tên nhân viên không được rỗng!", Toast.LENGTH_SHORT).show();
                }else{
                    String maNV = ma.getText().toString();
                    String hoTen = hoten.getText().toString();
                    String gioitinh = "";
                    if(nam.isChecked()){
                        gioitinh = "Nam";
                    }else{
                        gioitinh = "Nữ";
                    }
                    String donvi = spiner.getSelectedItem().toString();
                    nhanViens.add(new NhanVien(maNV,hoTen,gioitinh,donvi));
                    nhanVienAdapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Thêm nhân viên thành công! ", Toast.LENGTH_SHORT).show();
                    clearText();
                }
            }
        });
        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index==-1){
                    Toast.makeText(MainActivity.this, "Bạn chưa chọn nhân viên cần sửa!", Toast.LENGTH_SHORT).show();
                }else if(index!=-1){
                    String manv = ma.getText().toString();
                    String ten = hoten.getText().toString();
                    String gioitinh = "";
                    if(nam.isChecked()){
                        gioitinh = "Nam";
                    }else{
                        gioitinh = "Nữ";
                    }
                    String donvi = spiner.getSelectedItem().toString();

                    NhanVien s = (NhanVien) listView.getItemAtPosition(index);
                    s.setMaNV(manv);
                    s.setHoTen(ten);
                    s.setGioiTinh(gioitinh);
                    s.setDonVi(donvi);
                    nhanVienAdapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Sửa thành công!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_truyvan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String manv = ma.getText().toString();
                NhanVien temp = null;
                for (NhanVien list: nhanViens) {
                    if(list.getMaNV().equals(manv)==true){
                        Toast.makeText(MainActivity.this, "Đã tìm thấy!", Toast.LENGTH_SHORT).show();
                        temp = list;
                        hoten.setText(temp.getHoTen().toString());
                        if(temp.getGioiTinh().equals("Nam")){
                            nam.isChecked();
                        }else if(temp.getGioiTinh().equals("Nữ")){
                            nu.isChecked();
                        }
                        spiner.setSelection(adapterDv.getPosition(temp.getDonVi()));
                        break;
                    }else{
                        Toast.makeText(MainActivity.this, "Không tìm thấy!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btn_Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông báo")
                .setMessage("Bạn có muốn thoát không?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.show();
            }
        });
        btn_ghi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
                Toast.makeText(MainActivity.this, "Lưu thành công!", Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Bạn đang chọn nhân viên này!", Toast.LENGTH_SHORT).show();
                index = i;
                NhanVien s = (NhanVien) listView.getItemAtPosition(i);
                ma.setText(s.getMaNV().toString());
                hoten.setText(s.getHoTen().toString());
                if(s.getGioiTinh().equals("Nam")){
                    nam.isChecked();
                }else if(s.getGioiTinh().equals("Nữ")){
                    nu.isChecked();
                }
                spiner.setSelection(adapterDv.getPosition(s.getDonVi()));
            }
        });
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("ListNhanVien",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(nhanViens);
        editor.putString("List",json);
        editor.apply();
    }
    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("ListNhanVien",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("List",null);
        Type type = new TypeToken<ArrayList<NhanVien>>(){}.getType();
        nhanViens = gson.fromJson(json,type);
        if(nhanViens == null){
            nhanViens = new ArrayList<>();
        }
    }

    public void init(){
        btn_sua = findViewById(R.id.Btn_Sua);
        btn_them = findViewById(R.id.Btn_Them);
        btn_Thoat = findViewById(R.id.Btn_Thoat);
        btn_truyvan = findViewById(R.id.Btn_Truy_van);
        btn_ghi = findViewById(R.id.Btn_ghi);
        ma = findViewById(R.id.Et_Ma);
        hoten = findViewById(R.id.Et_Hoten);
        nam = findViewById(R.id.Radio_Nam);
        nu = findViewById(R.id.Radio_Nu);
        spiner = findViewById(R.id.Spinner_Chon);
        listView = findViewById(R.id.Lv_List);
    }
    public void anhXa(){
        loadData();
        nhanVienAdapter = new NhanVienAdapter(MainActivity.this,nhanViens);
        listView.setAdapter(nhanVienAdapter);
        dv_list = getResources().getStringArray(R.array.list_items);
        adapterDv = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,dv_list);
        spiner.setAdapter(adapterDv);
    }
    public void clearText(){
        ma.setText("");
        hoten.setText("");
        nam.isChecked();
        spiner.setSelection(0);
    }
}
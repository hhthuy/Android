package com.example.module2_bai5_tinhtienbansachonline;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et_tenKH = findViewById(R.id.editText_tenKH);
        EditText et_slSach = findViewById(R.id.editText_slSach);
        CheckBox check_Vip = findViewById(R.id.checkBow_KHVip);
        TextView et_thanhTien = findViewById(R.id.editText_thanhTien);
        Button btn_thanhTien = findViewById(R.id.button_tinhTT);
        Button btn_tiep = findViewById(R.id.button_tiep);
        Button btn_TK = findViewById(R.id.button_thongke);
        EditText et_tongKH = findViewById(R.id.editText_tongKH);
        EditText et_tongKHVip = findViewById(R.id.editText_tongKHVip);
        EditText et_tongDT = findViewById(R.id.editText_tongDT);
        ImageButton btnImg_Thoat = findViewById(R.id.imgButton_Thoat);
        DSKhachHang dskh = new DSKhachHang();

        btn_thanhTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KhachHang kh = new KhachHang();
                kh.setTenKH(et_tenKH.getText()+"");
                kh.setSlSach(Integer.parseInt(et_slSach.getText()+""));
                kh.setIskhVip(check_Vip.isChecked());
                et_thanhTien.setText(kh.tinhThanhTien()+"");
                dskh.addKH(kh);
            }
        });
        btn_tiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_tenKH.setText("");
                et_slSach.setText("");
                et_thanhTien.setText("");
                et_tenKH.requestFocus();
            }
        });

        //
        btn_TK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_tongKH.setText(dskh.tongKhachHang()+"");
                et_tongKHVip.setText(dskh.tongKhachHangVip()+"");
                et_tongDT.setText(dskh.tongDoanhThu()+"");
            }
        });
        //
        btnImg_Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doThoat();
            }
        });
    }
    private void doThoat() {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Thoát chương trình ");

        builder.setMessage("Bạn có muốn thoát chương trình không?");
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.create().show();

    }

}
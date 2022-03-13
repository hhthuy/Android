package com.example.module22_bai2_dangnhaphethong;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Khi người dùng nhấn nút Đăng nhập :
 *  Nếu người dùng chọn Lưu thông tin thì câu thông báo sẽ là : “Chào mừng bạn đăng
 * nhập hệ thống, thông tin của bạn đã được lưu” .
 *  Nếu người dùng không chọn Lưu thông tin thì câu thông báo sẽ là : “Chào mừng bạn
 * đăng nhập hệ thống, thông tin của bạn không được lưu” .
 * _ Khi nhấn nút Thoát, sẽ hiện 1 dialog như sau :
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et_TK = findViewById(R.id.editText_TaiKhoan);
        EditText et_MK = findViewById(R.id.editText_Matkhau);
        CheckBox check_Luu = findViewById(R.id.checkBox_Luu);
        Button btn_DN = findViewById(R.id.button_DangNhap);
        Button btn_Thoat = findViewById(R.id.button_Thoat);

        btn_DN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check_Luu.isChecked()){
                    Toast toast=Toast.makeText(MainActivity.this, "Chào mừng bạn đăng nhập hệ thống, thông tin của bạn đã được lưu",   Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        btn_Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn muốn thoát không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.create().show();
            }
        });

    }
}
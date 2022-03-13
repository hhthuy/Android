package com.example.module21_bai3_thongtncanhan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_Ten = (EditText) findViewById(R.id.edittext_hoten);
        EditText et_CMND = (EditText) findViewById(R.id.edittext_CMND);
        CheckBox check_code = findViewById(R.id.check_DocCode);
        CheckBox check_bao = findViewById(R.id.check_DocBao);
        CheckBox check_sach = findViewById(R.id.check_DocSach);
        Button btn_Gui = findViewById(R.id.button_Gui);
        String regex = "^[0-9]{9}$";
        btn_Gui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (et_Ten.getText().toString().equals("")) {
            String ten = et_Ten.getText() + "";
            ten = ten.trim();//xóa khoảng trắng
                 if (ten.length() < 3) {
                    et_Ten.requestFocus();//nháy chuột
                    et_Ten.selectAll();//
                    Toast.makeText(MainActivity.this, "Tên người không được để trống và phải có ít nhất 3 ký tự ", Toast.LENGTH_LONG).show();
                    return;
                }
            }else if (Pattern.matches(regex, et_CMND.getText().toString()) == false) {
            Toast.makeText(MainActivity.this, "Chứng minh nhân dân chỉ được nhập kiểu số và phải có đúng 9 chữ số", Toast.LENGTH_SHORT).show();

            }else if(!(check_code.isChecked()||check_bao.isChecked()||check_sach.isChecked())){
            Toast.makeText(MainActivity.this, "Bạn chưa chọn sở thích!", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MainActivity.this, "Thành công!", Toast.LENGTH_SHORT).show();
            }
            }
        });
    }
}



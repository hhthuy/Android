package com.example.module22_bai5_quanlynhanvienfullparttime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Employee> arrEmployee = new ArrayList<Employee>();
    ArrayAdapter<Employee> adapter = null;
    Employee emp=null;//Khai báo 1 employee object
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_manv = findViewById(R.id.edittext_manv);
        EditText et_tennv = findViewById(R.id.edittext_tennv);
        RadioGroup radGroup_loaiNV = findViewById(R.id.radioGroup_loaiNV);
        Button btn_nhap = findViewById(R.id.button_NhapNV);
        ListView lv_nhanvien = findViewById(R.id.listView_nhanvien);
        //đưa Data Source là các employee vào Adapter
        adapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1,arrEmployee);
        //đưa adapter vào ListView
        lv_nhanvien.setAdapter(adapter);

        //Xử lý nút nhập
        btn_nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radId = radGroup_loaiNV.getCheckedRadioButtonId();//Lấy ra đúng id của Radio Button được checked
                String ma = et_manv.getText()+"";
                String ten = et_tennv.getText()+"";
                if(radId==R.id.radBtn_ChinhThuc){
                    emp = new EmployeeFullTime();
                }else{
                    emp = new EmployeePartTime();
                }
                emp.setId(ma);
                emp.setName(ten);
                arrEmployee.add(emp);
            }
        });

    }
}
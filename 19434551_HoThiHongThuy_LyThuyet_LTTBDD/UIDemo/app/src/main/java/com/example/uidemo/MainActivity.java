package com.example.uidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<NhanVien> nv_List = new ArrayList<>();
    String[] dv_List;
    String donvi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_MaSo = findViewById(R.id.edittext_MaSo);
        EditText et_HoTen = findViewById(R.id.edittext_HoTen);
        ListView lv_NhanVien = findViewById(R.id.listview_NhanVien);
        RadioButton rg_GioiTinh = findViewById(R.id.radioGroup);
        RadioButton rb_Nam = findViewById(R.id.radioButton_Nam);
        RadioButton rb_Nu = findViewById(R.id.radioButton_Nu);

        //đơn vị
        Spinner sp_DonVi=findViewById(R.id.spinner_traicay);
        dv_List = getResources().getStringArray(R.array.donvi_list);//<string-array name="donvi_list"> trong strings.xml
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,dv_list);
        sp_DonVi.setAdapter(adapter);
        sp_DonVi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                donvi = dv_List[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    String[] listItems;

    GridView gv_Sp;
    String[] ten= {
            "Nước cam","Nước suối","Sữa hà lan",
            "Bánh hộp","Bánh quy","Bánh Karo",
            "Kẹo cake","Kẹo dẻo","Kẹo Panda",
            "Cocacola","7 up","Nước dừa"
    };
    int[] hinh={
            R.drawable.nuoccam,R.drawable.nuocsuoi, R.drawable.suahalan,
            R.drawable.banhhop, R.drawable.banhquybo, R.drawable.banhkaro,
            R.drawable.keocake, R.drawable.keodeo, R.drawable.keopanda,
            R.drawable.nuoccocola, R.drawable.nuocbayup,R.drawable.nuocdua
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gv_Sp = (GridView)findViewById(R.id.gridView_SP);
        GridAdapter gridAdapter = new GridAdapter(this, ten, hinh);
        gv_Sp.setAdapter(gridAdapter);
        gv_Sp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(MainActivity.this, ten[position], Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//                startActivity(intent);
            }
        });







        //GridView
//        GridView gv_traicay = findViewById(R.id.gridView_traicay);
//        listItems =  getResources().getStringArray(R.array.traicay_array);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,android.R.id.text1, listItems);
//        gv_traicay.setAdapter(adapter);
//        gv_traicay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, listItems[i], Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//
//        });


        //-------------------------------------------

        //LISTVIEW
//        ListView listView = findViewById(R.id.listview_traicay);
        //Lay ds item trong string.xml
//        listItems = getResources().getStringArray(R.array.traicay_array);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,android.R.id.text1, listItems);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String st = listItems[i];
//                Toast.makeText(MainActivity.this, "st", Toast.LENGTH_SHORT).show();
//            }
//        });
        //spinner
//        Spinner spinner = findViewById(R.id.spinner_traicay);
//        listItems =  getResources().getStringArray(R.array.traicay_array);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listItems);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                String st = listItems[i];
//                Toast.makeText(MainActivity.this, "st", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

    }
}
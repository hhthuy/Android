package com.example.module22_bai3_listviewnhapten;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * 19434551_hồ Thị Hồng Thủy
 */
/**
 * _ Mỗi lần người dùng nhấn nút Nhập, chương trình sẽ lưu dữ liệu trong mục Nhập tên vào
 * ArrayList đồng thời cập nhật lại danh sách ListView .
 * _ Khi chọn từng phần tử trong ListView, chương trình sẽ hiển thị vị trí và giá trị của phần tử
 * đang chọn vào TextView màu xanh .
 */
public class MainActivity extends AppCompatActivity {
    ArrayList<String> arrListTen=null;
    ArrayAdapter<String> adapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et_nhapten = findViewById(R.id.editText_nhapTen);
        Button btn_nhap = findViewById(R.id.button_nhap);
        TextView tv_chon = findViewById(R.id.txt_chonHoTen);
        ListView lv_Ten = findViewById(R.id.listview_hoten);
        //1. Tạo ArrayList object
        arrListTen = new ArrayList<String>();
        //2. Gán Data Source (ArrayList object) vào ArrayAdapter
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrListTen);
        //3. gán Adapter vào ListView
        lv_Ten.setAdapter(adapter);

        //Xử lý nút nhập
        /**
         * Đề: Mỗi lần người dùng nhấn nút Nhập, chương trình sẽ lưu dữ liệu trong mục Nhập tên vào
         * ArrayList đồng thời cập nhật lại danh sách ListView .
         */
        btn_nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrListTen.add(et_nhapten.getText()+"");// lưu dữ liệu trong mục Nhậ
                adapter.notifyDataSetChanged();//cập nhật lại danh sách ListView
            }
        });
        //Xử lý sự kiện khi chọn 1 phân tử trong listView
        /**
         *  Đề: Khi chọn từng phần tử trong ListView, chương trình sẽ hiển thị vị trí và giá trị của phần tử
         *  * đang chọn vào TextView màu xanh.
         */
        lv_Ten.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //Xử lý sự khiện khi chọn 1 phân tử trong listView
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                    String msg ="Position: " + i;
                    msg += ";value: "+parent.getItemAtPosition(i).toString();
                    tv_chon.setText(msg);
                }
        });

    }
}
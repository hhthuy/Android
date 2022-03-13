package com.example.module2_bai6_listviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
/**
 * _ Giao diện gồm 1 TextView và 1 ListView
 * _ Trong res/values/strings.xml tạo một String-Array : chứa một số các giá trị như hình trên
 * _ Khi ứng dụng được khởi động, nó sẽ tự động đọc các giá trị trong String-Array và hiển thị
 * lên ListView
 * _ Khi chọn từng phần tử trong ListView, sẽ hiển thị vị trí và giá trị phần tử được chọn vào
 * TextView .
 */
public class MainActivity extends AppCompatActivity {
    String listItems[];//1. Khởi tạo dữ liệu cho mảng arr(data source)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2. Lấy đối tượng Listview dựa vào id
        ListView listView = findViewById(R.id.listview_hoten);
        listItems = getResources().getStringArray(R.array.hoten_array);//Lay ds item trong string.xml
        //3. Gán Data source vào ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,android.R.id.text1, listItems);
        //4. Đưa Data source vào ListView
        listView.setAdapter(adapter);
        //5. Thiết lập sự kiện cho Listview, khi chọn phần tử nào thì hiển thị lên TextView
        final TextView tv_chon =(TextView) findViewById(R.id.txt_chonHoTen);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String st = listItems[i];
                Toast.makeText(MainActivity.this, "đã chọn", Toast.LENGTH_SHORT).show();
                tv_chon.setText("position :"+i+" ; value ="+listItems[i]);
            }
        });
    }
}

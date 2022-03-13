package com.example.module23_bai1_quanlynhanvien;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    ArrayList<NhanVien> arrEmployee=new ArrayList<NhanVien>();
    //Sử dụng MyArrayAdapter thay thì ArrayAdapter
    MyArrayAdapter adapter=null;
    ListView lv_Nhanvien=null;

    Button btn_Nhap;
    ImageButton btn_Xoa;
    EditText et_Ma,et_Ten;
    RadioGroup radGroup_GT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Nhap=(Button) findViewById(R.id.button_NhapNV);
        btn_Xoa=(ImageButton) findViewById(R.id.imgbutton_Xoa);
        et_Ma=(EditText) findViewById(R.id.edittext_manv);
        et_Ten=(EditText) findViewById(R.id.edittext_tennv);
        radGroup_GT=(RadioGroup) findViewById(R.id.radioGroup_GioiTinh);

        lv_Nhanvien=(ListView) findViewById(R.id.listView_nhanVien);
        arrEmployee=new ArrayList<NhanVien>();
        //Khởi tạo đối tượng adapter và gán Data source: lấy custom layout;thiết lập data source
        adapter=new MyArrayAdapter(this, R.layout.my_item_layout, arrEmployee);
        lv_Nhanvien.setAdapter(adapter);//gán Adapter vào Lisview

        btn_Nhap.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String ma=et_Ma.getText()+"";
                String ten=et_Ten.getText()+"";
                boolean gioitinh=false;//Nam =false
                if(radGroup_GT.getCheckedRadioButtonId()==R.id.radBtn_Nu)
                    gioitinh=true;
                //Tạo một employee
                NhanVien emp=new NhanVien();
                emp.setId(ma);
                emp.setName(ten);
                emp.setGender(gioitinh);
                //Đưa vào danh sách
                arrEmployee.add(emp);
                //gọi hàm cập nhật giao diện
                adapter.notifyDataSetChanged();
                //Sau khi update thì xóa trắng dữ liệu và cho editma focus
                et_Ma.setText("");
                et_Ten.setText("");
                et_Ma.requestFocus();
            }
        });
        btn_Xoa.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //duyệt ngược danh sách, kiểm tra phần tử nào checked thì xóa đúng vị trí đó ra khỏi arrEmployee
                for(int i=lv_Nhanvien.getChildCount()-1;i>=0;i--) {
                    //lấy ra dòng thứ i trong ListView có 3 phần tử: ImageView, TextView, Checkbox
                    View v=lv_Nhanvien.getChildAt(i);
                    //lấy CheckBox ra kiểm tra
                    CheckBox chk=(CheckBox) v.findViewById(R.id.chk_item);
                    //Nếu nó Checked thì xóa ra khỏi arrEmployee
                    if(chk.isChecked()) {
                        //xóa phần tử thứ i ra khỏi danh sách
                        arrEmployee.remove(i);
                    }
                } adapter.notifyDataSetChanged();//Sau khi xóa xong thì gọi update giao diện
            }
        });
    }
}

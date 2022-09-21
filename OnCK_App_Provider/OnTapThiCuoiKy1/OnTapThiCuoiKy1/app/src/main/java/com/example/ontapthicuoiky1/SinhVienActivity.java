package com.example.ontapthicuoiky1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SinhVienActivity extends AppCompatActivity {
    String uri = "content://com.example.ontapthicuoiky1/SinhVien";
    private List<LopHoc> lopHocs;
    ArrayList<String> listString;
    String itemSelected="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinh_vien);

        EditText etId=findViewById(R.id.etMaSV);
        EditText etTenSv=findViewById(R.id.etFirstName);
        EditText etHo=findViewById(R.id.etLastName);
        EditText etNgaySinh=findViewById(R.id.etNgaySinh);


        Spinner spinner = findViewById(R.id.spinnerLH);
        lopHocs = new ArrayList<>();
        Uri lophoc = Uri.parse("content://com.example.ontapthicuoiky1/LopHoc");
        Cursor cursor = getContentResolver().query(lophoc, null, null, null, "malop");
        if (cursor != null) {
            cursor.moveToNext();
            while (!cursor.isAfterLast()) {
                lopHocs.add(new LopHoc(cursor.getInt(0), cursor.getString(1)));
                cursor.moveToNext();
            }
        }
        listString=new ArrayList<>();
        for (LopHoc lh:lopHocs
             ) {
            listString.add(lh.getTenLop());
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1,listString);
        spinner.setAdapter(adapter);

        Button btThoat=findViewById(R.id.btThoatSV);
        btThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                itemSelected=listString.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button btInsert=findViewById(R.id.btInsertSV);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String id=etId.getText().toString();
                    String lastName=etHo.getText().toString();
                    String firstName=etTenSv.getText().toString();
                    String birthdate=etNgaySinh.getText().toString();
                    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date utilDate=format.parse(birthdate);
                    Date ngaySinh=new Date(utilDate.getTime());
                    int maLop=0;
                    for (LopHoc lh: lopHocs
                    ) {
                        Log.d("ten lop", itemSelected);
                        if(lh.getTenLop().equals(itemSelected)){
                            maLop=lh.getMaLop();
                            Log.d("malop", maLop+"");
                        }
                    }
                    SinhVien sinhVien =new SinhVien(id,lastName,firstName,ngaySinh,maLop);

                    ContentValues contentValues=new ContentValues();
                    contentValues.put("id",sinhVien.getId());
                    contentValues.put("lastname",sinhVien.getLastName());
                    contentValues.put("firstname",sinhVien.getFirstName());
                    contentValues.put("birthdate",sinhVien.getBirthdate().toString());
                    contentValues.put("malop",sinhVien.getMaLop()+"");
                    Uri sinhvien=Uri.parse("content://com.example.ontapthicuoiky1/SinhVien");

                    Uri insert_uri=getContentResolver().insert(sinhvien,contentValues);
                    Toast.makeText(getApplicationContext(),"Lưu sinh viên thành công",Toast.LENGTH_SHORT).show();
                }
              catch (Exception ex){
                    ex.printStackTrace();
              }



            }
        });

//

        //delete
//        int del=getContentResolver().delete(sinhvien,"id=?",new String[]{"19530041"});
//        Log.d("del", del+"");
//        if(del>0)
//            Toast.makeText(getApplicationContext(),"Xoa thanh cong",Toast.LENGTH_SHORT).show();
        //select
//        List<SinhVien> sinhViens=new ArrayList<>();
//        Cursor cursor=getContentResolver().query(sinhvien,null,null,null,"id");
//        if(cursor!=null){
//            cursor.moveToNext();
//            while (!cursor.isAfterLast()){
//                Log.d("malop", cursor.getInt(4)+"");
//                sinhViens.add(new SinhVien(cursor.getString(0),cursor.getString(1), cursor.getString(2),cursor.getInt(4) ));
//                cursor.moveToNext();
//            }
//        }
//        for (SinhVien sv:sinhViens
//             ) {
//            Log.d("sv", sv.toString());
//
//        }
//        Uri queryUri =Uri.parse("content://com.example.ontapthicuoiky1/SinhVien/*");
//        Cursor cursor1=getContentResolver().query(queryUri,null,"19530047",null,null);
//        SinhVien sinhVien1=new SinhVien();
//        try{
//            if(cursor1!=null){
//                cursor1.moveToFirst();
//
//                sinhVien1.setId(cursor1.getString(0));
//                sinhVien1.setFirstName(cursor1.getString(1));
//                sinhVien1.setLastName(cursor1.getString(2));
//                String sdate= cursor1.getString(3);
//                SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
//                java.util.Date utilDate=format.parse(sdate);
//                Date ngaySinh=new Date(utilDate.getTime());
//                sinhVien1.setBirthdate(ngaySinh);
//                sinhVien1.setMaLop(cursor1.getInt(4));
//                cursor1.moveToNext();
//
//            }
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//
//        Log.d("sinhvien tim kiem", sinhVien1.toString());
//    }

    }
}
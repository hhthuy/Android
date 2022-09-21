package com.example.a19434551_hothihongthuy_tk1_androidbaicao;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    int manghinhbai[]={
            R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
            R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
            R.drawable.cj,R.drawable.cq,R.drawable.ck,
            R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
            R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
            R.drawable.dj,R.drawable.dq,R.drawable.dk,
            R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
            R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
            R.drawable.hj,R.drawable.hq,R.drawable.hk,
            R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
            R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
            R.drawable.sj,R.drawable.sq,R.drawable.sk};
    CountDownTimer Timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ImageView imgV1 = findViewById(R.id.La_1);
        ImageView imgV2 = findViewById(R.id.La_2);
        ImageView imgV3 = findViewById(R.id.La_3);
        ImageView imgV4 = findViewById(R.id.La_4);
        ImageView imgV5 = findViewById(R.id.La_5);
        ImageView imgV6 = findViewById(R.id.La_6);

        TextView tVKetQua1 = findViewById(R.id.ketQua);
        TextView tVKetQua2 = findViewById(R.id.ketQua2);
        TextView tVKetQua3 = findViewById(R.id.Dem);
        Button btnbatDau = findViewById(R.id.batDau);
        Button btnDung = findViewById(R.id.Dung);

        btnbatDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Timer = new CountDownTimer(1000000,1000) {
                    @Override
                    public void onTick(long l) {
                        int[] sauLaBai = lay6LaNgauNhien(0,51);
                        imgV1.setImageResource(manghinhbai[sauLaBai[0]]);
                        imgV2.setImageResource(manghinhbai[sauLaBai[1]]);
                        imgV3.setImageResource(manghinhbai[sauLaBai[2]]);
                        imgV4.setImageResource(manghinhbai[sauLaBai[3]]);
                        imgV5.setImageResource(manghinhbai[sauLaBai[4]]);
                        imgV6.setImageResource(manghinhbai[sauLaBai[5]]);
                        int[] N1 = {sauLaBai[0],sauLaBai[1],sauLaBai[2]};
                        int[] N2 = {sauLaBai[3],sauLaBai[4],sauLaBai[5]};
                        tVKetQua1.setText(tinhKetQua(N1));
                        tVKetQua2.setText(tinhKetQua(N2));
                        tVKetQua3.setText(tinhKetQua2(N1,N2));
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(MainActivity3.this,"Hết thời gian",Toast.LENGTH_LONG);
                    }
                };
                Timer.start();
            }
        });
        btnDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Timer.cancel();
            }
        });
    }
    private String tinhKetQua2(int[] arr,int[] arr2 ){
        String ketQua = "";
        if(tinhSoTay(arr)==3 && tinhSoTay(arr2)==3)
            ketQua="Hòa";
        else if (tinhSoTay(arr)==3)
            ketQua = "Máy 1 thắng";
        else if (tinhSoTay(arr2)==3)
            ketQua = "Máy 2 thắng";
        else if(tinhSoNut(arr)>tinhSoNut(arr2))
            ketQua="Máy 1 thắng";
        else if(tinhSoNut(arr)<tinhSoNut(arr2))
            ketQua="Máy 2 thắng";
        else if(tinhSoNut(arr)==tinhSoNut(arr2))
            ketQua="Hòa";
        return ketQua;
    }

    private String tinhKetQua(int arr[]){
        String ketQua = "";
        if (tinhSoTay(arr) == 3)
            ketQua = "Kết quả 3 tây!!!";
        else {
            int tong = 0;
            for (int i = 0; i < arr.length; i++)
                if (arr[i] % 13 < 10)
                    tong += arr[i] % 13 + 1;
            if (tong %10 ==0)
                ketQua="Kết quả bù, số tây là: "+tinhSoTay(arr);
            else
                ketQua = "Kết quả là: " + (tong % 10) +" nút, số tây là: "+tinhSoTay(arr);
        }
        return ketQua;
    }
    private int tinhSoNut(int[] arr){
        int tong = 0;
        for (int i = 0;i<arr.length;i++)
            if (arr[i] % 13 < 10)
                tong += arr[i] % 13 + 1;
        return tong;
    }
    private int tinhSoTay(int[]arr){
        int k = 0; //k để đếm co bn lá bài tây
        for(int i =0; i < arr.length; i++)
            if(arr[i] % 13 >= 10)//(lấy phần dư)rút 1 lá nếu >=10(j=[i=10],q=[i=11],k=[i=12])(VD:Rút j: 10%13= 0,dư 10  --> dư 10 thuộc (i=10 thỏa j).VD: rút 9%13 = 0 dư 9 ---> dư 9 không phải ba tây)
                k ++;// nếu thuộc khoảng j,q,k thì k tăng lên 1, rút tiếp...
        return k;
    }
    private int[] lay6LaNgauNhien(int min,int max){
        int[] sauLa = new int[6];
        int i = 0;
        sauLa[i++]=random(min,max);
        do {
            int k = random(min,max);
            if (!kiemTraTrung(k,sauLa))
                sauLa[i++]=k;
        }while (i<6);
        return sauLa;
    }
    private Boolean kiemTraTrung(int k,int[] arr){
        for (int i = 0;i<arr.length;i++)
            if (arr[i]==k)
                return  true;
        return false;
    }
    private int random(int min,int max){
        return min + (int)(Math.random()*((max-min)+1));
    }
}
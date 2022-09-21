package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.resources.TextAppearance;

/**
 * BTVN1:
 * Hiển thị người chơi và máy, sau mỗi lần bấm rút ngẫu nhiên 3 lá, phát người chơi 3 lá, máy 3 lá, và đếm nút.
 * Nếu bấm 10 lần thì máy thắng bao nhiêu và người chơi thắng bao nhiêu.
 * BTVN2:
 * Không nhấn nút button, máy hiện lên số phút người dùng nhập, và 2 máy tự chơi vơi nhau,
 * chơi vơi thời gian người dùng cung cấp
 * --> sử dụng hàm coutdowntimer để đếm, 10-1s, sau đó hiển thị kết quả.
 * -->Gợi ý: lấy 6 lá không trùng nhau.
 * Lấy 3 lá đầu tiên cho người chơi --> đếm só nút.
 * 3 lá sau cho máy --> đếm số nút.
 */
public class MainActivity extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //3.1
        ImageView iv1 = findViewById(R.id.imageView1);
        ImageView iv2 = findViewById(R.id.imageView2);
        ImageView iv3 = findViewById(R.id.imageView3);
        Button bt_rutLaBai = findViewById(R.id.button_rutlabai);
        TextView tv_KetQua = findViewById(R.id.textView_KetQua);

        /**
         * Xử lý rút là bài
         */

        bt_rutLaBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int[]balabai = layBaSoNgauNhien(0,51);// lấy ngầu nhiên 3 lá bài không trùng
              iv1.setImageResource(manghinhbai[balabai[0]]);//hiện hình ảnh lá bài ImageView
              iv2.setImageResource(manghinhbai[balabai[1]]);
              iv3.setImageResource(manghinhbai[balabai[2]]);
              tv_KetQua.setText(tinhKetQua(balabai));
            }
        });
    }

    //-------------------------------------

    /**
     * 4. Rút 3 lá ngẫu nhiên rồi và đếm xem mấy nút và số tây là bao nhiêu???
     * @param arr
     * @return
     */
    //-------------------------------------
    //4.1 Đếm số bài Tây
    private int tinhSoTay(int[]arr){
        int k = 0; //k để đếm co bn lá bài tây
        for(int i =0; i < arr.length; i++)
            if(arr[i] % 13 >= 10)//(lấy phần dư)rút 1 lá nếu >=10(j=[i=10],q=[i=11],k=[i=12])(VD:Rút j: 10%13= 0,dư 10  --> dư 10 thuộc (i=10 thỏa j).VD: rút 9%13 = 0 dư 9 ---> dư 9 không phải ba tây)
                k ++;// nếu thuộc khoảng j,q,k thì k tăng lên 1, rút tiếp...
        return k;
    }
    //4.2. Tinh kết quả
    private String tinhKetQua(int[]arr){
        String ketqua ="";
        //tính 3 tây
        if(tinhSoTay(arr)==3)
            ketqua="Kết quả 3 tây";
//      //Tính tổng số nút
        else {
            int tong = 0;//khai báo biến tổng để tính tổng số nút
            for (int i = 0; i < arr.length; i++)
                if (arr[i] % 13 < 10)
                    tong += arr[i] % 13 + 1;
            if(tong % 10 ==0)//VD: 20 NÚT: 20%10 = 2 dư 0 --> du
                ketqua ="Kết quả bù, số tây là: "+ tinhSoTay(arr);
            else
                ketqua ="Kết quả là: "+(tong%10)+" nút, số tây là:"+tinhSoTay(arr);

        }
        return ketqua;
    }
//    //-------------------------------------
        //VD: rút lá 6[i=5],7[i=6],8[i=7]
        //             tong = tong + (a[i]%13 + 1)
        // lá thứ 1 là 6 a[5]: 0 = 0 + (5%13 + 1) = 6
        // lá thứ 2 là 7 a[6]: 6 = 6 +(6 + 6%13 + 1)= 13
        // lá thứ 3 là 8 a[7]: 7 = 13 + (7 + 7%13 +1)=21
        /**
         * 3. Lấy ngẫu nhiên 3 số trong [min, max] trả về mảng 1 chiều
         * @param min
         * @param max
         * @return 3 số không trùng nhau
         */
        private int[] layBaSoNgauNhien(int min, int max){
            int[] baso = new int[3];// mảng có 3 số nguyên
            int i = 0;//đếm số phần tử chạy trong mảng đủ chưa
            baso[i] = random(min,max);// random 1 số từ max đến min bỏ vào ptu đầu tiên
            //i< 3 số tiếp tục lặp
            do{
                int k = random(min, max);//random số k trong [min,max]
                if(!kiemTraTrung(k, baso))//nếu k không nằm trong 3 số
                    baso[i++] = k; //bỏ k vào 3 số, i++(thực hiện xong rồi tăng i=0,i=1,i=2; #++i)
            }while(i<3);
            return baso;// 3 số không trùng nhau
        }
    //-------------------------------------
        /**
         * 2. Kiểm tra trùng (k có chứa trong mảng(số) không)
         * @param k
         * @param arr
         * @return
         */
        private boolean kiemTraTrung(int k,int[]arr){
            for(int i =0; i < arr.length; i++)
                if(arr[i] == k)
                    return true;
            return false;
        }

        /**
         * 1. Rút ngẫu nhiên 3 lá bài không trùng nhau trong khoảng min và max
         * VD: Rút 1 số ngẫu nhiên (1,2,3,4,5,6,7,8,9,10,J,Q,K) là 13 lá
         * @param max
         * @return
         */
        private int random(int min,int max){
            return min +(int)(Math.random()*((max-min)+1));
        }
}
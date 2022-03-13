package com.example.module2_bai5_tinhtienbansachonline;

import java.util.ArrayList;

//lass DanhSachKhachHang dùng để lưu trữ các khách hàng mua sách, đồng thời cung cấp một số hàm như:
// tổng tiền, tính tổng số khách hàng, tính tổng số khách hàng VIP….
public class DSKhachHang {
    ArrayList<KhachHang> listKH = new ArrayList<>();

    //Thêm KH Mới
    public void addKH(KhachHang kh){
        listKH.add(kh);
    }
    //Tính Tổng KH là Vip
    public int tongKhachHang(){
        return listKH.size();
    }
    public int tongKhachHangVip(){
        int tongKHV=0;
        for (KhachHang kh:listKH){
            if(kh.isIskhVip()){
                tongKHV++;
            }
        }return tongKHV;
    }
    //Tính Tổng Doanh Thu
    public double tongDoanhThu(){
        double tongDT =0;
        for (KhachHang kh:listKH) {
            tongDT += kh.tinhThanhTien();//(!iskhVip ? slSach*Gia : slSach*Gia*0.9);
        }return tongDT;
    }
}

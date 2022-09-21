package com.example.listview;
public class Sanpham {
    private String tenSanPham;
    private double donGia;
    private int hinh;

    public Sanpham(String tenSanPham, double donGia, int hinh) {
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
        this.hinh = hinh;
    }

    public Sanpham() {
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "tenSanPham='" + tenSanPham + '\'' +
                ", donGia=" + donGia +
                ", hinh=" + hinh +
                '}';
    }
}

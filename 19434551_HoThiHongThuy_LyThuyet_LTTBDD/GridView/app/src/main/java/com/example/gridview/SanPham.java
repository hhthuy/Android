package com.example.gridview;
public class SanPham {
    private int maSanPham;
    private String tenSanPham;
    private int hinhAnh;
    private double giaSanPham;
    private String thongTinChiTiet;

    public SanPham(int maSanPham, String tenSanPham, int hinhAnh, double giaSanPham, String thongTinChiTiet) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.hinhAnh = hinhAnh;
        this.giaSanPham = giaSanPham;
        this.thongTinChiTiet = thongTinChiTiet;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public double getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(double giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public String getThongTinChiTiet() {
        return thongTinChiTiet;
    }

    public void setThongTinChiTiet(String thongTinChiTiet) {
        this.thongTinChiTiet = thongTinChiTiet;
    }

    public SanPham() {
    }

    public SanPham(int maSanPham, String tenSanPham, int hinhAnh, double giaSanPham) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.hinhAnh = hinhAnh;
        this.giaSanPham = giaSanPham;
    }



    @Override
    public String toString() {
        return "SanPham{" +
                "maSanPham=" + maSanPham +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", hinhAnh=" + hinhAnh +
                ", giaSanPham=" + giaSanPham +
                ", thongTinChiTiet='" + thongTinChiTiet + '\'' +
                '}';
    }
}

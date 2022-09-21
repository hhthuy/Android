package com.example.a19434551_hothihongthuy_tk2_nhanvienui;

public class NhanVien {
    private int image;
    private int maso;
    private String hoTen;
    private String gioiTinh;
    private String donVi;

    public NhanVien(int image, int maso, String hoTen, String gioiTinh, String donVi) {
        this.image = image;
        this.maso = maso;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.donVi = donVi;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getMaso() {
        return maso;
    }

    public void setMaso(int maso) {
        this.maso = maso;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }


    @Override
    public String toString() {
        return "NhanVien {" + maso + '\'' + hoTen + '\'' + gioiTinh + '\'' + donVi + '\'' +
                '}';
    }

}

package com.example.ontapgk_android1;

public class NhanVien {
    private int image;
    private int maso;
    private String hoTen;
    private String gioiTinh;
    private String donVi;
    private String ngonNgu;

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public NhanVien(int image, int maso, String hoTen, String gioiTinh, String donVi, String ngonNgu) {
        this.image = image;
        this.maso = maso;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.donVi = donVi;
        this.ngonNgu = ngonNgu;
    }

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
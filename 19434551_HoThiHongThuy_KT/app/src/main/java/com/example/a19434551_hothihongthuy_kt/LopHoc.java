package com.example.a19434551_hothihongthuy_kt;

public class LopHoc {
    private int maLop;
    private String tenLop;

    public LopHoc() {
    }

    public LopHoc(int maLop, String tenLop) {
        this.maLop = maLop;
        this.tenLop = tenLop;
    }

    public int getMaLop() {
        return maLop;
    }

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    @Override
    public String toString() {
        return "LopHoc{" +
                "maLop=" + maLop +
                ", tenLop='" + tenLop + '\'' +
                '}';
    }
}

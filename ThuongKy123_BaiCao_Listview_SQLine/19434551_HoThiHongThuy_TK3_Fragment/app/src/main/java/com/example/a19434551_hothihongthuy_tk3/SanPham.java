package com.example.a19434551_hothihongthuy_tk3;

public class SanPham {
    private String tenSP;
    private String mota;
    private double giaSP;
    private int imageSP;

    public SanPham(String nameCake, String descriptionCake, double priceCake, int imageCake ){
        this.tenSP=nameCake;
        this.mota=descriptionCake;
        this.giaSP=priceCake;
        this.imageSP=imageCake;
    }

    public void setNameCake(String nameCake) {
        this.tenSP = nameCake;
    }

    public String getNameCake() {
        return tenSP;
    }

    public void setDescriptionCake(String descriptionCake) {
        this.mota = descriptionCake;
    }

    public String getDescriptionCake() {
        return mota;
    }

    public void setPriceCake(double priceCake) {
        this.giaSP = priceCake;
    }

    public double getPriceCake() {
        return giaSP;
    }

    public void setImageCake(int imageCake) {
        this.imageSP = imageCake;
    }

    public int getImageCake() {
        return imageSP;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "tenSP='" + tenSP + '\'' +
                ", mota='" + mota + '\'' +
                ", giaSP=" + giaSP +
                ", imageSP=" + imageSP +
                '}';
    }
}


package com.example.onck_app_provider1;

public class Order {
    private int id;
    private String ngayLap;
    private String productId;

    public Order(int id, String ngayLap, String productId) {
        this.id = id;
        this.ngayLap = ngayLap;
        this.productId = productId;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ngayLap='" + ngayLap + '\'' +
                ", productId='" + productId + '\'' +
                '}';
    }
}

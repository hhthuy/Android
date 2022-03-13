package com.example.module2_bai5_tinhtienbansachonline;
//class KhachHang dùng để lưu thông tin của khách hàng: Tên khách hàng, số lượng mua, thành tiền, là VIP hay không
public class KhachHang {
    private String tenKH;
    private int slSach;
    private boolean iskhVip;
    public static final int Gia=20000;

    public KhachHang() {
    }

    public KhachHang(String tenKH, int slSach, boolean iskhVip) {
        this.tenKH = tenKH;
        this.slSach = slSach;
        this.iskhVip = iskhVip;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getSlSach() {
        return slSach;
    }

    public void setSlSach(int slSach) {
        this.slSach = slSach;
    }

    public boolean isIskhVip() {
        return iskhVip;
    }

    public void setIskhVip(boolean iskhVip) {
        this.iskhVip = iskhVip;
    }
//Khi nhấn nút Tính Thành tiền (Tính TT) chương trình sẽ tính thành tiền biết rằng mỗi
//cốn sách có đơn giá là 20000, nếu là khách hàng VIP thì giảm 10%
    public double tinhThanhTien() {
        return (!iskhVip ? slSach*Gia : slSach*Gia*0.9);
    }
}

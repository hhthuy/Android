package com.example.module22_bai5_quanlynhanvienfullparttime;

public class EmployeePartTime extends Employee{
    @Override
    public double tinhLuong() {
        return 150;
    }

    @Override
    public String toString() {
        return super.toString() +"-->PartTime="+tinhLuong();
    }
}

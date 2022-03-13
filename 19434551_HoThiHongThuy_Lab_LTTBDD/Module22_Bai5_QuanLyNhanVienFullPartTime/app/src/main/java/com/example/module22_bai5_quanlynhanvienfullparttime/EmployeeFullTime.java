package com.example.module22_bai5_quanlynhanvienfullparttime;

public class EmployeeFullTime extends Employee{

    @Override
    public double tinhLuong(){
        return 500;
    }

    @Override
    public String toString() {
        return super.toString()+"-->FullTime="+tinhLuong();
    }
}

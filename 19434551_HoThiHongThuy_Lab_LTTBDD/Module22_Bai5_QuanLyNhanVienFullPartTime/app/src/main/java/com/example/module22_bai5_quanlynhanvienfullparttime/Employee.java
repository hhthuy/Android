package com.example.module22_bai5_quanlynhanvienfullparttime;

public abstract class Employee {
    private String id;
    private String name;

    public Employee() {
    }

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double tinhLuong();
    @Override
    public String toString() {
        return this.id +"-"+ this.name;
    }
}

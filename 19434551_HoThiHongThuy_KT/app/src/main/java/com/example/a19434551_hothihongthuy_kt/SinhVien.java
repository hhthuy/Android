package com.example.a19434551_hothihongthuy_kt;

import java.util.Date;

public class SinhVien {
    private String id;
    private String lastName;
    private String firstName;
    private Date birthdate;
    private int maLop;

    public SinhVien() {
    }

    public SinhVien(String id, String lastName, String firstName, int maLop) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.maLop = maLop;
    }

    public SinhVien(String id, String lastName, String firstName, Date birthdate, int maLop) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthdate = birthdate;
        this.maLop = maLop;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getMaLop() {
        return maLop;
    }

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthdate=" + birthdate +
                ", maLop=" + maLop +
                '}';
    }
}


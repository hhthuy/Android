package com.example.onck_app_provider1;

public class Product {
    private int id;
    private String name;
    private String unit;
    private String madein;

    public Product() {
    }

    public Product(int id, String name, String unit, String madein) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.madein = madein;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMadein() {
        return madein;
    }

    public void setMadein(String madein) {
        this.madein = madein;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", madein='" + madein + '\'' +
                '}';
    }
}

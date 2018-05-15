package com.example.user.hciapp;

public class Nhanvien {
    String HoTen;
    int SDT;

    public Nhanvien(String hoTen, int SDT) {
        HoTen = hoTen;
        this.SDT = SDT;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }
}

package com.example.user.hciapp;

public class DanhSachCay {
    private int ID;
    private String tencay;
    private String tinhtrang;
    private int luongnuoc;

    public DanhSachCay(int ID, String tencay, String tinhtrang, int luongnuoc) {
        this.ID = ID;
        this.tencay = tencay;
        this.tinhtrang = tinhtrang;
        this.luongnuoc = luongnuoc;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTencay() {
        return tencay;
    }

    public void setTencay(String tencay) {
        this.tencay = tencay;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public int getLuongnuoc() {
        return luongnuoc;
    }

    public void setLuongnuoc(int luongnuoc) {
        this.luongnuoc = luongnuoc;
    }
}

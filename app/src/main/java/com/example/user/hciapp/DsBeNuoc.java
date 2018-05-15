package com.example.user.hciapp;

public class DsBeNuoc {
    private String TenBeNuoc;
    private int LuongNuocTrongBe;
    private int ID;

    public DsBeNuoc(String tenBeNuoc, int luongNuocTrongBe, int ID) {
        TenBeNuoc = tenBeNuoc;
        LuongNuocTrongBe = luongNuocTrongBe;
        this.ID = ID;
    }

    public String getTenBeNuoc() {
        return TenBeNuoc;
    }

    public void setTenBeNuoc(String tenBeNuoc) {
        TenBeNuoc = tenBeNuoc;
    }

    public int getLuongNuocTrongBe() {
        return LuongNuocTrongBe;
    }

    public void setLuongNuocTrongBe(int luongNuocTrongBe) {
        LuongNuocTrongBe = luongNuocTrongBe;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}

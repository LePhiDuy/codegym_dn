package furama_resort.models;

import java.util.Date;

public abstract class Person {
    private int ID;
    private String hoTen;
    private String ngaySinh;
    private boolean gioiTinh;
    private String CMND;
    private String soDienThoai;
    private String email;

    public Person() {
    }

    public Person(int ID, String hoTen, String ngaySinh, boolean gioiTinh, String CMND, String soDienThoai, String email) {
        this.ID = ID;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.CMND = CMND;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return getID() +
                "," + getHoTen() +
                "," + getNgaySinh() +
                "," + (isGioiTinh() ? "Nam" : "Nữ") +
                "," + getCMND() +
                "," + getSoDienThoai() +
                "," + getEmail();
    }
}

package furama_resort.models;

import java.util.Date;

public class Employee extends Person{
    private String trinhDo;
    private String viTri;
    private double luong;

    public Employee() {
    }

    public Employee(int ID, String hoTen, String ngaySinh, boolean gioiTinh, String CMND, String soDienThoai, String email, String trinhDo, String viTri, double luong) {
        super(ID, hoTen, ngaySinh, gioiTinh, CMND, soDienThoai, email);
        this.trinhDo = trinhDo;
        this.viTri = viTri;
        this.luong = luong;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    @Override
    public String toString() {
        return getID() +
                "," + getHoTen() +
                "," + getNgaySinh() +
                "," + (isGioiTinh() ? "Nam" : "Nữ") +
                "," + getCMND() +
                "," + getSoDienThoai() +
                "," + getEmail() +
                "," + getTrinhDo() +
                "," + getViTri() +
                "," + getLuong();
    }
}

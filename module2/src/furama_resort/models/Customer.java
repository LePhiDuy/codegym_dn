package furama_resort.models;

import java.util.Date;

public class Customer extends Person{
    private String loaiKhach;
    private String diaChi;

    public Customer(int ID, String hoTen, String ngaySinh, boolean gioiTinh, String CMND, String soDienThoai, String email, String loaiKhach, String diaChi) {
        super(ID, hoTen, ngaySinh, gioiTinh, CMND, soDienThoai, email);
        this.loaiKhach = loaiKhach;
        this.diaChi = diaChi;
    }
    public Customer() {

    }

    public String getLoaiKhach() {
        return loaiKhach;
    }

    public void setLoaiKhach(String loaiKhach) {
        this.loaiKhach = loaiKhach;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + getLoaiKhach() +
                "," + getDiaChi();
    }
}

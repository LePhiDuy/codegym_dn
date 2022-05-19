package furama_resort.models;

public class Villa extends Facility {
    private String tieuChuanPhong;
    private double dienTichSuDUng;
    private int soTang;

    public Villa(String tenDichVu, double dienTich, double chiPhiThue, int soLuongNguoiToiDa, String kieuThue, String tieuChuanPhong, double dienTichSuDUng, int soTang) {
        super(tenDichVu, dienTich, chiPhiThue, soLuongNguoiToiDa, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.dienTichSuDUng = dienTichSuDUng;
        this.soTang = soTang;
    }

    public Villa(String tieuChuanPhong, double dienTichSuDUng, int soTang) {
        this.tieuChuanPhong = tieuChuanPhong;
        this.dienTichSuDUng = dienTichSuDUng;
        this.soTang = soTang;
    }
    public Villa() {

    }

    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public double getDienTichSuDUng() {
        return dienTichSuDUng;
    }

    public void setDienTichSuDUng(double dienTichSuDUng) {
        this.dienTichSuDUng = dienTichSuDUng;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }
}

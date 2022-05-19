package thi_thuc_hanh.model;

public class SanPhamNhapKhau extends SanPham {
    private double giaNhapKhau;
    private String tinhThanhNhap;
    private double thueNhapKhau;

    public SanPhamNhapKhau(int id, String maSanPham, String tenSanPham, double giaBan, int soLuong, String nhaSanXuat, double giaNhapKhau, String tinhThanhNhap, double thueNhapKhau) {
        super(id, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanhNhap = tinhThanhNhap;
        this.thueNhapKhau = thueNhapKhau;
    }

    public SanPhamNhapKhau(double giaNhapKhau, String tinhThanhNhap, double thueNhapKhau) {
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanhNhap = tinhThanhNhap;
        this.thueNhapKhau = thueNhapKhau;
    }

    public SanPhamNhapKhau() {
    }

    public double getGiaNhapKhau() {
        return giaNhapKhau;
    }

    public void setGiaNhapKhau(double giaNhapKhau) {
        this.giaNhapKhau = giaNhapKhau;
    }

    public String getTinhThanhNhap() {
        return tinhThanhNhap;
    }

    public void setTinhThanhNhap(String tinhThanhNhap) {
        this.tinhThanhNhap = tinhThanhNhap;
    }

    public double getThueNhapKhau() {
        return thueNhapKhau;
    }

    public void setThueNhapKhau(double thueNhapKhau) {
        this.thueNhapKhau = thueNhapKhau;
    }

    @Override
    public String toString() {
        return String.format("%s,%f,%s,%f", super.toString(), giaNhapKhau, tinhThanhNhap, thueNhapKhau);
    }

    @Override
    public void display() {
        System.out.printf("Sản phẩm nhập khẩu: id = %d, mã sản phẩm =  %s, tên sản phẩm = %s, giá bán = %f, số lượng = %d" +
                ", nhà sản xuất = %s, giá nhập khẩu = %f, tỉnh thành nhập = %s, thuế nhập khẩu = %f \n", getId(), getMaSanPham(),
                getTenSanPham(), getGiaBan(), getSoLuong(), getNhaSanXuat(), getGiaNhapKhau(), getTinhThanhNhap(), getThueNhapKhau());
    }
}

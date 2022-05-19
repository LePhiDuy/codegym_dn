package thi_thuc_hanh.model;

public class SanPhamXuatKhau extends SanPham {
    private double giaXuatKhau;
    private String quocGia;

    public SanPhamXuatKhau(int id, String maSanPham, String tenSanPham, double giaBan, int soLuong, String nhaSanXuat, double giaXuatKhau, String quocGia) {
        super(id, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
        this.giaXuatKhau = giaXuatKhau;
        this.quocGia = quocGia;
    }

    public SanPhamXuatKhau(double giaXuatKhau, String quocGia) {
        this.giaXuatKhau = giaXuatKhau;
        this.quocGia = quocGia;
    }

    public SanPhamXuatKhau() {
    }

    public double getGiaXuatKhau() {
        return giaXuatKhau;
    }

    public void setGiaXuatKhau(double giaXuatKhau) {
        this.giaXuatKhau = giaXuatKhau;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    @Override
    public String toString() {
        return String.format("%s,%f,%s", super.toString(), giaXuatKhau, quocGia);
    }
    public void display() {
        System.out.printf("Sản phẩm xuất khẩu: id = %d, mã sản phẩm =  %s, tên sản phẩm = %s, giá bán = %f, số lượng = %d" +
                        ", nhà sản xuất = %s, giá xuất khẩu = %f, quốc gia nhập sản phẩm = %s\n", getId(),
                getMaSanPham(), getTenSanPham(), getGiaBan(), getSoLuong(), getNhaSanXuat(), getGiaXuatKhau(), getQuocGia());
    }
}

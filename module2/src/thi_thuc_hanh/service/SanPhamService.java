package thi_thuc_hanh.service;

import thi_thuc_hanh.exception.NotFoundProductException;
import thi_thuc_hanh.model.SanPham;
import thi_thuc_hanh.model.SanPhamNhapKhau;
import thi_thuc_hanh.model.SanPhamXuatKhau;
import thi_thuc_hanh.util.ConstantUtils;
import thi_thuc_hanh.util.FileHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SanPhamService {
    public List<SanPham> sanPhamList = new ArrayList<SanPham>();
    FileHelper fileHelper = new FileHelper();
    public SanPhamService() {
        sanPhamList = mapToSanPhamList();
    }

    public void create(SanPham sanPham) {
        int lastId = 0;
        if (sanPhamList.size() > 0) {
            lastId = sanPhamList.get(sanPhamList.size() - 1).getId();
        }
        sanPham.setId(lastId + 1);
        sanPhamList.add(sanPham);
        fileHelper.write(ConstantUtils.path, Collections.singletonList(sanPham), true);
    }

    public List findAll() {
        return sanPhamList;
    }

    public List<SanPham> searchByName(String tenSanPham) {
        List<SanPham> result = new ArrayList<>();
        for (SanPham sanPham : sanPhamList) {
            if (sanPham.getTenSanPham().contains(tenSanPham)) {
                result.add(sanPham);
            }
        }
        return result;
    }
    private List mapToSanPhamList(){
        List result = new ArrayList();
        List<String> lines = fileHelper.read(ConstantUtils.path);
        for (String line : lines){
            String[] tmp = line.split(",");
            int id = Integer.parseInt(tmp[0]);
            String maSanPham = tmp[1];
            String tenSanPham = tmp[2];
            double giaBan = Double.parseDouble(tmp[3]);
            int soLuong = Integer.parseInt(tmp[4]);
            String nhaSanXuat = tmp[5];

            SanPham sanPham;
            if(tmp.length == 9){
                double giaNhapKhau = Double.parseDouble(tmp[6]);
                String tinhThanhNhap = tmp[7];
                Double thueNhapKhau = Double.parseDouble(tmp[8]);
                sanPham = new SanPhamNhapKhau(id, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat, giaNhapKhau, tinhThanhNhap, thueNhapKhau);
            }
            else{
                Double giaXuatKhau = Double.parseDouble(tmp[6]);
                String quocGia = tmp[7];
                sanPham = new SanPhamXuatKhau(id, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat, giaXuatKhau, quocGia);
            }

            result.add(sanPham);
        }

        return result;
    }
    public void delete(String maSanPham) throws NotFoundProductException {
        if(!sanPhamList.removeIf(e-> e.getMaSanPham().equals(maSanPham))) {
            throw new NotFoundProductException("Mã sản phẩm " + maSanPham + " không thể tìm thấy");
        }
        fileHelper.write(ConstantUtils.path, sanPhamList, false);
    }
}

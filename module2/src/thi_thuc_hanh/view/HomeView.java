package thi_thuc_hanh.view;

import thi_thuc_hanh.exception.NotFoundProductException;
import thi_thuc_hanh.model.SanPham;
import thi_thuc_hanh.model.SanPhamNhapKhau;
import thi_thuc_hanh.model.SanPhamXuatKhau;
import thi_thuc_hanh.service.SanPhamService;
import thi_thuc_hanh.validation.Validation;

import java.util.List;
import java.util.Scanner;

public class HomeView {
    public static void main(String[] args) {
        displayMain();
    }

    private static SanPhamService sanPhamService = new SanPhamService();
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMain() {
        while (true) {
            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM----");
            System.out.println("Chọn chức năng theo số (để tiếp tục): ");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách các sản phẩm");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Thoát");

            int choice = inputChoice(5);
            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    List<SanPham> sanPhamList = sanPhamService.findAll();
                    display(sanPhamList);
                    break;
                case 4:
                    searchByName();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

    public static int inputChoice(int end) {
        int choice = 0;
        String temp;
        boolean isNumber = false;
        do {
            System.out.print("Input choice from 1 to " + end + ": ");
            temp = scanner.nextLine();
            if (Validation.validChoice(temp)) {
                choice = Integer.parseInt(temp);
                if (choice >= 1 && choice <= end) {
                    isNumber = true;
                } else {
                    System.out.println("Choice have from 1 to " + end + ". Please input again");
                }
            } else {
                System.out.println("Choice number regex '\\d{1}'. Input again");
            }
        } while (!isNumber);
        return choice;
    }

    public static void create() {
        System.out.println("Chọn loại sản phẩm: ");
        System.out.println("1. Sản phẩm nhập khẩu");
        System.out.println("2. Sản phẩm xuất khẩu");
        int choice = inputChoice(2);
        String maSanPham = inputWithoutEmpty("mã sản phẩm");
        String tenSanPham = inputWithoutEmpty("tên sản phẩm");
        double giaBan = Double.parseDouble(inputValuePositive("giá bán"));
        int soLuong = Integer.parseInt(inputValuePositive("số lượng"));
        String nhaSanXuat = inputWithoutEmpty("nhà sản xuất");
        SanPham sanPham;
        if (choice == 1) {
            double giaNhapKhau = Double.parseDouble(inputValuePositive("giá nhập khẩu"));
            String tinhThanhNhap = inputWithoutEmpty("tỉnh thành nhập");
            double thueNhapKhau = Double.parseDouble(inputValuePositive("thuế nhập khẩu"));
            sanPham = new SanPhamNhapKhau(0, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat, giaNhapKhau, tinhThanhNhap, thueNhapKhau);
        } else {
            double giaXuatKhau = Double.parseDouble(inputValuePositive("giá xuất khẩu"));
            String quocGia = inputWithoutEmpty("quốc gia nhập sản phẩm");
            sanPham = new SanPhamXuatKhau(0, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat, giaXuatKhau, quocGia);
        }
        sanPhamService.create(sanPham);
        System.out.println("Thêm thành công!");
    }

    public static void delete() {
        display(sanPhamService.sanPhamList);
        System.out.print("Nhập vào mã sản phẩm cần xóa: ");
        String maSanPham = scanner.nextLine();
        String answer;
        boolean isExists;
        do {
            System.out.print("Bạn có muốn xóa sản phẩm có mã là " + maSanPham + " không ? (Y/N): ");
            answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
                System.out.println("Vui lòng chỉ chọn Y hoặc N");
            }
        } while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N"));
        if (answer.equalsIgnoreCase("Y")) {
            do {
                try {
                    sanPhamService.delete(maSanPham);
                    isExists = true;
                    System.out.println("Xóa thành công");
                    System.out.println("Danh sách sản phẩm sau khi xóa là: ");
                    display(sanPhamService.sanPhamList);
                } catch (NotFoundProductException e) {
                    System.out.println(e.getMessage() + "Vui lòng nhập lại");
                    maSanPham = scanner.nextLine();
                    isExists = false;
                }
            } while (!isExists);
        } else {
            System.out.println("Nhấn phím bất kì để quay về menu chính");
            scanner.nextLine();
            displayMain();
        }

    }

    public static void display(List<SanPham> sanPhamList) {
        if (sanPhamList.size() > 0) {
            for (SanPham sanPham : sanPhamList) {
                sanPham.display();
            }
        } else {
            System.out.println("Danh sách sản phẩm trống");
        }
    }

    public static void searchByName() {
        display(sanPhamService.sanPhamList);
        System.out.print("Nhập vào tên sản phẩm cần tìm kiếm:");
        String tenSanPham = scanner.nextLine();
        List<SanPham> sanPhamList = sanPhamService.searchByName(tenSanPham);
        for (SanPham sanPham : sanPhamList) {
            sanPham.display();
        }
    }

    public static String inputWithoutEmpty(String fieldName) {
        String result = "";
        System.out.print("Nhập vào " + fieldName + ": ");
        do {
            result = scanner.nextLine();
            if (result.isEmpty()) {
                System.out.println(fieldName + " không thể trống. Vui lòng nhập lại");
            }
        } while (result.isEmpty());
        return result;
    }

    private static String inputValuePositive(String fieldName) {
        String result = "";
        do {
            System.out.print(result.isEmpty() ? "Nhập vào " + fieldName + ": " : fieldName + " phải là số dương. Vui lòng nhập lại: ");
            result = scanner.nextLine();
        } while (!Validation.validNumberPositive(result));
        return result;
    }
}

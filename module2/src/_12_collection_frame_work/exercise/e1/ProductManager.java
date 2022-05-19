package _12_collection_frame_work.exercise.e1;

import java.util.ArrayList;

public class ProductManager {
    private ArrayList<Product> data = new ArrayList<>();
    public void addProduct(Product product) {
        if (getAllId().contains(product.getId())) {
            System.out.println("Lỗi!. Sản phẩm thêm vào trùng id");
            return;
        } else {
            data.add(product);
        }
    }

    public void update(int id) {
        if (!getAllId().contains(id)) {
            System.out.println("Sản phẩm không có trong danh sách");
            return;
        }

    }
    public ArrayList<Integer> getAllId() {
        ArrayList<Integer> result = new ArrayList<>();
        for (Product i : data) {
            result.add(i.getId());
        }
        return result;
    }

    public void delete(int id) {

    }



}

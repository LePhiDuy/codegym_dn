package vn.codegym.product_demo_md4.util;

public class CommonUtil {
    public static double parseDouble(String val) {
        try {
            return Double.parseDouble(val);
        } catch (Exception ex) {
            return 0;
        }
    }
}

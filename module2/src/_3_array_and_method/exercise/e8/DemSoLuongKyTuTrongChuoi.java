package _3_array_and_method.exercise.e8;

import java.util.Scanner;

public class DemSoLuongKyTuTrongChuoi {
    public static void main(String[] args) {
        String s = "abcahsgaakdajakaahshsy";
        System.out.println("Nhập vào ký tự cần kiểm tra: ");
        Scanner sc = new Scanner(System.in);
        char character = sc.next().charAt(0);
        System.out.println("Ký tự " + character + " xuất hiện trong chuỗi " + s + " " + demSoLuongKyTuTrongChuoi(s, character) + " lần");
    }
    static int demSoLuongKyTuTrongChuoi(String s, char character) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (character == s.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}

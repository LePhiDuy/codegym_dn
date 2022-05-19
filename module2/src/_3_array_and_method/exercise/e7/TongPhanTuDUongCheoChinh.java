package _3_array_and_method.exercise.e7;

import java.util.Scanner;

public class TongPhanTuDUongCheoChinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số hàng: ");
        int row = sc.nextInt();
        System.out.println("Nhập vào số cột: ");
        int column = sc.nextInt();
        double[][] arr = new double[row][column];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print("Nhập vào phần tử hàng " + i + " cột " + j + " : ");
                arr[i][j] = sc.nextDouble();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Tong các phần tử ở dường chéo chính là: " + tinhTongPhanTuDuongCheoChinh(arr));
    }

    static double tinhTongPhanTuDuongCheoChinh(double[][] arr) {
        double S = 0.0f;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    S += arr[i][j];
                }
            }
        }
        return S;
    }
}

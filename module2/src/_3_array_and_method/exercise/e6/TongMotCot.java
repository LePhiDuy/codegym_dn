package _3_array_and_method.exercise.e6;

import java.util.Scanner;

public class TongMotCot {
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
        int inputColumn;
        do {
            System.out.println("Nhập vào cột cần tính tổng: ");
            inputColumn = sc.nextInt();
            if (inputColumn < 0 || inputColumn > column - 1) {
                System.out.println("Cột bạn nhập vào không hợp lệ");
            }
        } while (inputColumn < 0 || inputColumn > column - 1);
        System.out.println("Sum element in column is " + calSumInColumn(arr, inputColumn));
    }

    static double calSumInColumn(double[][] arr, int column) {
        double S = 0;
        for (int i = 0; i < arr.length; i++) {
            S += arr[i][column];
        }
        return S;
    }
}

package _3_array_and_method.exercise.e4;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số hàng: ");
        int row = sc.nextInt();
        System.out.println("Nhập vào số cột: ");
        int column = sc.nextInt();
        int[][] arr = new int[row][column];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print("Nhập vào phần tử hàng " + i + " cột " + j + " : ");
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        findElementMaxInMatrix(arr);
    }

    static void findElementMaxInMatrix(int[][] arr) {
        int max = arr[0][0];
        int indexColumn = 0;
        int indexRow = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    indexRow = i;
                    indexColumn = j;
                }
            }
        }
        System.out.println("Element max is " + max + " at row " + indexRow + ", column " + indexColumn);
    }
}

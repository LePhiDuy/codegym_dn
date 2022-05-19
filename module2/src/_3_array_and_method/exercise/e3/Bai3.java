package _3_array_and_method.exercise.e3;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        int[] arr1 = new int[5];
        int[] arr2 = new int[6];
        System.out.println("Input element of arr1: ");
        input(arr1);
        System.out.println("Input element of arr2: ");
        input(arr2);
        int[] arr3 = new int[arr1.length + arr2.length];
        System.out.println("Array1: ");
        output(arr1);
        System.out.println("\n" + "Array2: ");
        output(arr2);
        arr3 = mergerArray(arr1, arr2);
        System.out.println("\n" + "Array is merger arr1 and arr2: ");
        output(arr3);
    }
    static void input(int[] arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Input element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
    }
    static int[] mergerArray(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }
        for (int i = 0, j = arr2.length - 1; i < arr2.length; i++, j++) {
            arr3[j] = arr2[i];
        }
        return arr3;
    }
    static void output(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

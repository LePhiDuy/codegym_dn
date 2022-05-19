package _3_array_and_method.practice.p1;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        do {
            System.out.println("Enter a size of array: ");
            size = sc.nextInt();
            if (size > 20) {
                System.out.println("Size does not exceed 20 ");
            }
        } while (size > 20);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter element " + (i + 1));
            arr[i] = sc.nextInt();
        }
//
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        System.out.println();
        System.out.println("Array after change is: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

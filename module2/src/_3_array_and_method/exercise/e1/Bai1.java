package _3_array_and_method.exercise.e1;

import java.sql.Array;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 2, 5, 9, 10, -9, 16, 80};
        deleteElement(arr, 5);
    }

    static void deleteElement(int[] array, int number) {
        int index = -1;
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (number == array[i]) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = j = 0; i < index; i++) {
                array[j] = array[i];
                j++;
            }
            for (int i = index; i < array.length - 1; i++) {
                array[j] = array[i + 1];
                j++;
            }
            System.out.println("Array after delete element has value = " + number);
            for (int i = 0; i < j; i++) {
                System.out.print(array[i] + " ");
            }
        } else {
            System.out.println("Cannot find number is " + number + " in the array");
        }
    }
}

package _2_loop_in_java.exercise.e2;

import java.util.Scanner;

public class PrimeNumberAmount20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng số nguyên tố cần in: ");
        int amount = sc.nextInt();
        int N = 2;
        int count = 0;
        while (count < amount) {
            if (isPrimeNumber(N)) {
                System.out.print(N + " ");
                count++;
            }
            N++;
        }
    }

    static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        } else {
            int i = 2;
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    return false;
                }
                i++;
            }
            return true;
        }
    }
}

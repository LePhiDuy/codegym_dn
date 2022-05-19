package _2_loop_in_java.practice.p1;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = sc.nextInt();
        boolean isPrimeNumber = true;
        if (number < 2) {
            System.out.println(number + " is not a number");
        } else {
            int i = 2;
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    isPrimeNumber = false;
                    break;
                }
                i++;
            }
            if (isPrimeNumber) {
                System.out.println(number + " is a prime number");
            } else {
                System.out.println(number + " is not a prime number");
            }
        }

    }
}

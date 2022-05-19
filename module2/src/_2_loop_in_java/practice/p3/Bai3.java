package _2_loop_in_java.practice.p3;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input first number: ");
        int firstNumber = sc.nextInt();
        System.out.println("Input second number: ");
        int secondNumber = sc.nextInt();
        firstNumber = Math.abs(firstNumber);
        secondNumber = Math.abs(secondNumber);
        if (firstNumber == 0 && secondNumber == 0) {
            System.out.println("Khong co UCLN");
        } else {
            while (firstNumber != secondNumber) {
                if (firstNumber < secondNumber) {
                    secondNumber -= firstNumber;
                } else {
                    firstNumber -= secondNumber;
                }
            }
            System.out.println("UCLN = " + firstNumber);
        }
    }
}

package _2_loop_in_java.practice.p2;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter money: ");
        double money = sc.nextDouble();
        System.out.println("Enter rate: ");
        double rate = sc.nextDouble();
        System.out.println("Enter month: ");
        int month = sc.nextInt();
        double totalInterest = 0;
        for (int i = 0; i < month; i++) {
            totalInterest += money * (rate / 12) * month;
        }
        System.out.println("Total Interest = " + totalInterest);
    }
}

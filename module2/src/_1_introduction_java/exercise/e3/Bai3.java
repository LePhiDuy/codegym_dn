package _1_introduction_java.exercise.e3;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        double rate = 23000;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số tiền USD: ");
        double USD = sc.nextDouble();
        double VND = USD * rate;
        System.out.println(USD + " USD = " + VND + " VND");
    }
}

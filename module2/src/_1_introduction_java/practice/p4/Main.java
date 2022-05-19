package _1_introduction_java.practice.p4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = c', please enter constants:");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so thu nhat: ");
        double a = sc.nextDouble();
        System.out.println("Nhap vao so thu hai: ");
        double b = sc.nextDouble();
        System.out.println("Nhap vao so thu 3: ");
        double c = sc.nextDouble();

        if (a == 0) {
            if(b == c) {
                System.out.println("Phuong trinh vo so nghiem ");
            } else {
                System.out.println("Phuong trinh vo nghiem ");
            }
        } else {
            System.out.println("Nghiem cua phuong trinh la: " + (c - b) / a);
        }
    }
}

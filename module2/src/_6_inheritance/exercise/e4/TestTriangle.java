package _6_inheritance.exercise.e4;

import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a side1: ");
        double side1 = sc.nextDouble();
        System.out.print("Enter a side2: ");
        double side2 = sc.nextDouble();
        System.out.print("Enter a side3: ");
        double side3 = sc.nextDouble();
        Triangle triangle = new Triangle(side1, side2, side3);
        System.out.println("Enter a color: ");
        sc = new Scanner(System.in);
        String color = sc.nextLine();
        triangle.setColor(color);
        System.out.println(triangle.toString());
        System.out.println("Area = " + triangle.getArea());
        System.out.println("Perimeter = " + triangle.getPerimeter());
    }
}

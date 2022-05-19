package _2_loop_in_java.exercise.e1;

import java.util.Scanner;

public class HienThiHinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Draw rectangle");
            System.out.println("2. Draw square triangle");
            System.out.println("3. Draw  isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("Input choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    drawRectanle(3, 5);
                    break;
                case 2:
                    System.out.println("1. Top Left");
                    System.out.println("2. Top Right");
                    System.out.println("3. Botton Left");
                    System.out.println("4. Botton Right");
                    System.out.println("Input choice ");
                    int k = sc.nextInt();
                    switch (k) {
                        case 1:
                            drawTriangleTopLeft(5);
                            break;
                        case 2:
                            drawTriangleTopRight(5);
                            break;
                        case 3:
                            drawTriangleBottonLeft(5);
                            break;
                        case 4:
                            drawTriangleBottonRight(5);
                            break;
                    }
                    break;
                case 3:
                    drawIsoscelesTriangle(5);
                    break;
                case 4:
                    System.out.println("Exit");
                    break;
            }
        }while (choice != 4);
    }

    static void drawRectanle(int length, int width) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void drawTriangleTopLeft(int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                if (i + j < height) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void drawTriangleTopRight(int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                if (j - i >= 0) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void drawTriangleBottonLeft(int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                if (i >= j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void drawTriangleBottonRight(int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                if (i + j >= height - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void drawIsoscelesTriangle(int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < 2 * height - 1; j++) {
                if (j >= height - i - 1 && j <= height - 1 + i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

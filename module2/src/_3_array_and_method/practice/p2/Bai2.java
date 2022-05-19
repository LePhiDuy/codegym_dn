package _3_array_and_method.practice.p2;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name student you want search: ");
        String student = sc.nextLine();
        boolean check = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(student)) {
                System.out.println("Position of the students in the list " + student + " is: " + (i + 1));
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Not found" + student + " in the list.");
        }
    }
}

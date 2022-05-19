package furama_resort.views;

import java.util.Scanner;

public class HomeView {
    public static void displayMainMenu() {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("------Welcome to Furama Resort------");
            System.out.println("1. Employee Managemnet");
            System.out.println("2. Customer Managemnet");
            System.out.println("3. Facility Managemnet");
            System.out.println("4. Booking Managemnet");
            System.out.println("5. Promotion Managemnet");
            System.out.println("6. Exit");
            System.out.print("Nhập vào lựa chọn của bạn: ");
            choice = sc.nextInt();
        } while (choice <= 0 || choice > 6);
        switch (choice) {
            case 1:
                EmployeeView.employeeManage();
                break;
            case 2:
                CustomerView.customerManage();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                System.exit(0);
                break;
        }
        displayMainMenu();
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}

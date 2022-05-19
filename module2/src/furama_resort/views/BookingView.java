package furama_resort.views;

import java.util.Scanner;

public class BookingView {
    public static void bookingManage() {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new contracts ");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");
            System.out.print("Nhập vào lựa chọn của bạn: ");
            choice = sc.nextInt();
        } while (choice <= 0 || choice > 6);
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                HomeView.displayMainMenu();
                break;
        }
    }
}

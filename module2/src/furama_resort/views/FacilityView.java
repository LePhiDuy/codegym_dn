package furama_resort.views;

import java.util.Scanner;

public class FacilityView {
    public static void facilityManage() {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");
            System.out.print("Nhập vào lựa chọn của bạn: ");
            choice = sc.nextInt();
        } while (choice <= 0 || choice > 4);
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                HomeView.displayMainMenu();
                break;
        }
    }
}

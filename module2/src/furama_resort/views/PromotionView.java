package furama_resort.views;

import java.util.Scanner;

public class PromotionView {
    public static void promotionManage() {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Display list customers use service");
            System.out.println("2. Display list customers get voucher");
            System.out.println("3. Return main menu");
            System.out.print("Nhập vào lựa chọn của bạn: ");
            choice = sc.nextInt();
        } while (choice <= 0 || choice > 3);
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                HomeView.displayMainMenu();
                break;
        }
    }
}

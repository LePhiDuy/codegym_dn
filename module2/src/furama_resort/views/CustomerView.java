package furama_resort.views;

import furama_resort.controllers.CustomerController;
import furama_resort.models.Customer;
import furama_resort.models.Employee;

import java.util.Scanner;

public class CustomerView {
    private static CustomerController customerController = new CustomerController();
    public static void customerManage() {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customers");
            System.out.println("3. Edit customers");
            System.out.println("4. Return main menu");
            System.out.print("Nhập vào lựa chọn của bạn: ");
            choice = sc.nextInt();
        } while (choice <= 0 || choice > 4);
        switch (choice) {
            case 1:
                customerController.getAll().forEach(System.out::println);
                break;
            case 2:
                customerController.save(input());
                System.out.println("Thêm thành công");
                break;
            case 3:
                customerController.getAll().forEach(System.out::println);
                System.out.print("Nhập Id của customer cần: ");
                int id = sc.nextInt();
                Customer customer= input();
                customer.setID(id);
                customerController.save(customer);
                System.out.println("Chỉnh sửa thành công");
                break;
            case 4:
                HomeView.displayMainMenu();
                break;
        }
    }
    private static Customer input() {

        return new Customer(0, "ABC06", "20/11/2002", true, "191973678",
                "duyphi2011@gmail.com", "Hue","Diamond" , "Da Nang");
    }
}

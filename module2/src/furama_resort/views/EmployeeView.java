package furama_resort.views;

import furama_resort.controllers.EmployeeController;
import furama_resort.models.Employee;
import furama_resort.services.Impl.EmployeeServiceImpl;

import java.util.Date;
import java.util.Scanner;

public class EmployeeView {
    private static EmployeeController employeeController = new EmployeeController();
    public static void employeeManage() {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Return main menu");
            System.out.print("Nhập vào lựa chọn của bạn: ");
            choice = sc.nextInt();
        } while (choice <= 0 || choice > 4);
        switch (choice) {
            case 1:
                employeeController.getAll().forEach(System.out::println);
                break;
            case 2:
                employeeController.save(input());
                System.out.println("Thêm thành cong");
                break;
            case 3:
                employeeController.save(input());
                System.out.println("Chỉnh sửa thành công");
                break;
            case 4:
                HomeView.displayMainMenu();
                break;
        }
    }
    private static Employee input() {

        return new Employee(0, "ABC06", "20/11/2002", true, "191973678",
                "duyphi2011@gmail.com", "Hue","Cao Dang" , "A", 1200);
    }
}

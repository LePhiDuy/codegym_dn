package demo_toan.view;

import demo_toan.exception.NotFoundBankAccountException;
import demo_toan.model.AccountBanking;
import demo_toan.model.AccountPayment;
import demo_toan.model.AccountSaving;
import demo_toan.service.AccountBankingService;
import demo_toan.validation.Validation;
import product_demo.model.AuthenticProduct;

import java.util.List;
import java.util.Scanner;

public class HomeView {
    public static void main(String[] args) {
        displayMain();
    }

    private static Scanner scanner = new Scanner(System.in);
    private static AccountBankingService accountBankingService = new AccountBankingService();

    public static void displayMain() {
        while (true) {
            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG----");
            System.out.println("Chọn chức năng theo số (để tiếp tục): ");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách các tài khoản ngân hàng");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Thoát");

            int choice = inputChoice(5);
            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    List<AccountBanking> accountBankingList = accountBankingService.findAll();
                    display(accountBankingList);
                    break;
                case 4:
                    searchByName();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }

        }
    }

    public static int inputChoice(int end) {
        int choice = 0;
        String temp;
        boolean isNumber = false;
        do {
            System.out.print("Input choice from 1 to " + end + ": ");
            temp = scanner.nextLine();
            if (Validation.validChoice(temp)) {
                choice = Integer.parseInt(temp);
                if (choice >= 1 && choice <= end) {
                    isNumber = true;
                } else {
                    System.out.println("Choice have from 1 to " + end + ". Please input again");
                }

            } else {
                System.out.println("Choice number regex '\\d{1}'. Input again");
            }
        } while (!isNumber);
        return choice;
    }

    public static void create() {
        System.out.println("Choice type account");
        System.out.println("1. Account Saving");
        System.out.println("2. Account Payment");
        int choice = inputChoice(2);
        String accountCode = inputWithoutEmpty("account code");
        String nameAccount = inputWithoutEmpty("account name");
        String dateCreate = inputWithoutEmpty("date create account");
        AccountBanking accountBanking;
        if (choice == 1) {
            double moneySaving = Double.parseDouble(inputWithoutEmpty("amount money saving"));
            String dateSaving = inputWithoutEmpty("date saving");
            double rate = Double.parseDouble(inputWithoutEmpty("rate"));
            int period = Integer.parseInt(inputWithoutEmpty("period"));
            accountBanking = new AccountSaving(0, accountCode, nameAccount, dateCreate, moneySaving, dateSaving, rate, period);
        } else {
            String numberCard = inputWithoutEmpty("card number");
            double moneyInCard = Double.parseDouble(inputWithoutEmpty("money in card"));
            accountBanking = new AccountPayment(0, accountCode, nameAccount, dateCreate, numberCard, moneyInCard);
        }
        accountBankingService.create(accountBanking);
        System.out.println("Create successfully!");

    }

    public static void delete() {
        System.out.print("Input account code to delete: ");
        String accountCode = scanner.nextLine();
        String answer;
        boolean isExists;
        do {
            System.out.print("Do you want to delete account banking with account code = " + accountCode + " (Y/N): ");
            answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
                System.out.println("Please enter only Y or N");
            }
        } while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N"));
        if (answer.equalsIgnoreCase("Y")){
            do {
                try {
                    accountBankingService.delete(accountCode);
                    isExists = true;
                    System.out.println("Delete successfully");
                    display(accountBankingService.accountBankingList);
                } catch (NotFoundBankAccountException e) {
                    System.out.println(e.getMessage() + "Please input again");
                    accountCode = scanner.nextLine();
                    isExists = false;
                }
            } while (!isExists);
        } else {
            displayMain();
        }

    }

    public static void display(List<AccountBanking> accountBankingList) {
        for (AccountBanking accountBank : accountBankingList) {
            if (accountBank instanceof AccountSaving) {
                AccountSaving accountSaving = (AccountSaving) accountBank;
                System.out.printf("Account saving: id = %d, account code = %s, name = %s, date create =%s, money save =%f, date saving = %s, rate = %f, period = %d\n"
                        , accountSaving.getId(), accountSaving.getAccount(), accountSaving.getName(), accountSaving.getDateCreate(), accountSaving.getMoneySave(),
                        accountSaving.getDateSaving(), accountSaving.getRate(), accountSaving.getPeriod());
            } else {
                AccountPayment accountPayment = (AccountPayment) accountBank;
                System.out.printf("Account payment: id = %d, account code = %s, name = %s, date create =%s, number card = %s, money in card = %f\n"
                        , accountPayment.getId(), accountPayment.getAccount(), accountPayment.getName(), accountPayment.getDateCreate(), accountPayment.getNumberCard(),
                        accountPayment.getMoneyInCard());
            }
        }

    }

    public static void searchByName() {
        String name = inputWithoutEmpty("name to search");
        display(accountBankingService.searchByName(name));
    }

    public static String inputWithoutEmpty(String fieldName) {
        String result = "";
        System.out.print("Input " + fieldName + ": ");
        do {
            result = scanner.nextLine();
            if (result.isEmpty()) {
                System.out.println(fieldName + " cannot empty. Please input again");
            }
        } while (result.isEmpty());
        return result;
    }

}

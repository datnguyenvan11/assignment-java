package assignment.main;

import assignment.controller.EmployeesController;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        EmployeesController employeesController=new EmployeesController();
        while (true) {
            System.out.println("-------------Menu----------------");
            System.out.println("1. Tạo tài khoản.");
            System.out.println("2. Đăng nhập .");
            System.out.println("3. Thoát chương trình.");
            System.out.println("---------------------------------");
            System.out.println("Nhập lựa chọn của bạn: ");
            Scanner scanner=new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("---Tạo tài khoản---");
                    employeesController.create();
                    break;
                case 2:
                    System.out.println("---Đăng nhập---");
                    employeesController.login();
                    break;

                case 3:
                    System.out.println("Thoát");
                    break;
                default:
                    System.out.println("Lựa chọn sai, vui lòng nhập số trong khoảng từ 1 đến 3.");
                    break;
            }
            if (choice == 3) {
                System.out.println("Hẹn gặp lại.");
                break;
            }
        }
    }
}

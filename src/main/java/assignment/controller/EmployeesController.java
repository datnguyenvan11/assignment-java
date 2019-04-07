package assignment.controller;

import assignment.entity.Employees;
import assignment.model.EmployeesModel;

import java.util.Scanner;

public class EmployeesController {
    private Scanner scanner = new Scanner(System.in);

    private EmployeesModel employeesModel = new EmployeesModel();
    private Employees employees = new Employees();

    public void create() {
        while (true) {
            System.out.println("Nhập tên nhân viên : ");
            String name = scanner.nextLine();
            System.out.println("Nhập địa chỉ nhân viên : ");
            String address = scanner.nextLine();
            System.out.println("Nhập email nhân viên : ");
            String email = scanner.nextLine();
            System.out.println("Nhập tài khoản : ");
            String account = scanner.nextLine();
            System.out.println("Nhập mật khẩu : ");
            String password = scanner.nextLine();
            System.out.println("Nhập ngày tạo : ");
            String createAt = scanner.nextLine();
            System.out.println("Nhập ngày cập nhật : ");
            String updateAt = scanner.nextLine();
            System.out.println("Nhập trạng thái: ");
            int status = scanner.nextInt();
            scanner.nextLine();
            if (employeesModel.checkExistAccount(account)) {
                System.err.println("Tài khoản đã tồn tại!. Vui lòng tạo lại tài khoản");
            } else {
                Employees employees = new Employees(name, address, email, account, password, createAt, updateAt, status);
                employeesModel.registe(employees);
                System.out.println("Tạo tài khoản  thành công");
                break;
            }

        }
    }

    public void login() {
        while (true) {
            System.out.println("Tên đăng nhập:");
            String account = scanner.nextLine();
            System.out.println("Mật khẩu: ");
            String password = scanner.nextLine();

            if (employeesModel.login(account, password) == null) {
                System.out.println("Tên tài khoản hoặc mật khẩu không đúng! Vui lòng đăng nhập lại ");

            } else {
                employees = employeesModel.login(account, password);
                System.out.println("-----thông tin tài khoản----");
                System.out.printf("%10s | %15s | %15s | %15s | %15s | %15s | %15s | %15s |\n", "Tên", "Địa chỉ", "Email", "Tên tài khoản", "Mật khẩu", "Ngày tạo", "Ngày update", "Status");
                System.out.printf("%10s | %15s | %15s | %15s | %15s | %15s | %15s | %15s |\n", employees.getName(), employees.getAddress(), employees.getEmail(), employees.getAccount(), employees.getPassword(), employees.getCreateAt(), employees.getUpdateAt(), employees.getStatus());
                break;
            }

        }
    }
}
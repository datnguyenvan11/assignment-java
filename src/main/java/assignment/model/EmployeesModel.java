package assignment.model;

import assignment.entity.Employees;

import java.sql.*;

public class EmployeesModel {
    private static Connection connection;


    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/human_resource?user=root&password=");
        }
    }

    public boolean registe(Employees employee) {
        try {
            initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into employees (name, address, email, account, password, creatAt, updateAt , status) values (?, ?, ?, ?, ?, ?,?, ?)");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getAddress());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getAccount());
            preparedStatement.setString(5, employee.getPassword());
            preparedStatement.setString(6, employee.getCreateAt());
            preparedStatement.setString(7, employee.getUpdateAt());
            preparedStatement.setInt(8, employee.getStatus());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(" Tạo tài khoản không thành công! vui lòng thử lại   " + e.getMessage());
        }
        return false;
    }

    public boolean checkExistAccount(String account) {

        try {
            initConnection();
            String SQL = "SELECT * FROM employees WHERE account = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, account);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Employees login(String account, String password) {
        try {
            initConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM employees WHERE account = ? and password=?");
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString(1);
                String address = resultSet.getString(2);
                String email = resultSet.getString(3);
                String acc = resultSet.getString(4);
                String pass = resultSet.getString(5);
                String createAt = resultSet.getString(6);
                String updateAt = resultSet.getString(7);
                int status = resultSet.getInt(8);
                Employees employees = new Employees(name, address, email, acc, pass, createAt, updateAt, status);
                return employees;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}

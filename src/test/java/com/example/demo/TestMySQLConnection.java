package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestMySQLConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/shopdevgo"; // Thay đổi nếu cần
        String user = "root";
        String password = "root123456";

        try {
            // Tải MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Kết nối đến database
            Connection connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("✅ Kết nối MySQL thành công!");
                connection.close(); // Đóng kết nối sau khi kiểm tra xong
            }
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Không tìm thấy MySQL Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Kết nối MySQL thất bại!");
            e.printStackTrace();
        }
    }
}

package com.shop.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelperClass {
    String url = "jdbc:mysql://localhost:3306/productmanagement_jdbc";
    String username = "root";
    String password = "root";
    Connection connection=null;

    public Connection makeConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           connection= DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

}
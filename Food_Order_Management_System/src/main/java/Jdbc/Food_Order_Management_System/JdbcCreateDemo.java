package Jdbc.Food_Order_Management_System;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class JdbcCreateDemo {
  public static void main(String[] args) {
     String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
     String username = "User";
     String password = "sankar8610";
     try {
       Class.forName("oracle.jdbc.OracleDriver");
       Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
       Statement statement = connection.createStatement();
       String sql = "CREATE TABLE Student (" +
       "Id NUMBER(10) NOT NULL, " +
       "Name VARCHAR2(45) NOT NULL, " +
       "Course VARCHAR2(45) NOT NULL, " +
       "Email VARCHAR2(45) NOT NULL, " +
       "PRIMARY KEY (Id))";
       statement.executeUpdate(sql);
       System.out.println("Created table in the given database...");
       
       statement.close(); // Close the statement
       connection.close();
       
       } 
       catch (ClassNotFoundException e) {
       e.printStackTrace();
       } 
       catch (SQLException e) {
       e.printStackTrace();
       }
    }
}

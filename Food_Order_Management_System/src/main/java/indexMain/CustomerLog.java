package indexMain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import MenuManagement.MenuView;

public class CustomerLog {
    private Connection connection; 

    public CustomerLog () {
       
        connectDB();
    }

    public static void customerlog() {
        System.out.println("-------------------------------------");
        System.out.println("\t Welcome Customer");
        System.out.println("-------------------------------------");
        CustomerLog cl=new CustomerLog();
        cl.log();
    }

    public void connectDB() {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "FOMS";
        String password = "FOMS123";

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void log() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the username: ");
        String name = scan.next();
        System.out.print("Enter the password: ");
        String password = scan.next();
        logMain(name,password);
    }
    public void logMain(String name, String password) {

        if (canUserLogin(name, password)) {
            System.out.println("Login successful!");
            MenuView mv=new MenuView();
            mv.foodMenu();
        } else {
            System.out.println("Login failed. Invalid username or password.");
            log();
        }
    }

    public boolean canUserLogin(String userid, String password) {
        boolean isValidUser = false;

        try {
            String sql = "SELECT * FROM Customerdetails WHERE name = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, userid);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            isValidUser = resultSet.next();

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isValidUser;
    }
    
}
 


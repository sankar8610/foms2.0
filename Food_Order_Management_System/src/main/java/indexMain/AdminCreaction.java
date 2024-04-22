package indexMain;
import userDefinePackages.*;
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import userDefinePackages.*;
public class AdminCreaction {
    public static void adminCreaction() throws Exception {
    	DBOperactions objID = new DBOperactions();
        Scanner scan = new Scanner(System.in);
        objID.ConnectDB();
        System.out.println("---------------------------------------------------");
        System.out.println("\t Enter your details");
        System.out.println("---------------------------------------------------");
        System.out.print("Enter your ID: ");
        int admin_id = scan.nextInt();
        System.out.print("Enter your Name: ");
        String name = scan.next();
        System.out.print("Enter Email: ");
        String email = scan.next();
        System.out.print("Enter your phonenumber: ");
        String phone_number = scan.next();
        System.out.print("Enter address: ");
        String address = scan.next();
        System.out.print("enter your password :");
        String password = scan.next();
        

        String sql = "INSERT INTO Admindetails(admin_id, name, email, phone_number, address, password) VALUES (?, ?, ?, ?, ?, ?)";
        Object[] params = { admin_id, name, email, phone_number, address, password  };

        int rowsInserted = objID.InsertDB(sql, params);
        if (rowsInserted > 0) 
            System.out.println("-------------------------------------------------------");
            System.out.println("\tUser was inserted successfully!");
            System.out.println("-------------------------------------------------------");
        try {
            objID.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        AdminMain ad=new AdminMain();
        ad.adminLog();
        scan.close();
    }
}

	
	



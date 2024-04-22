package indexMain;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class CustomerCreaction {
 
    	    
    	    public void customerCreaction() throws Exception  {
    	    	DBOperactions objIDC = new DBOperactions();
    	        Scanner scan = new Scanner(System.in);
    	        objIDC.ConnectDB();
    	        System.out.println("---------------------------------------------------");
    	        System.out.println("\t Enter your details");
    	        System.out.println("---------------------------------------------------");
    	        System.out.print("Enter your ID: ");
    	        int customer_id = scan.nextInt();
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
    	        

    	        String sqlcus = "INSERT INTO Customerdetails( customer_id, name, email, phone_number, address, password) VALUES (?, ?, ?, ?, ?, ?)";
    	        Object[] params = { customer_id, name, email, phone_number, address, password};

    	        int rowsInserted = objIDC.InsertDB(sqlcus, params);
    	        if (rowsInserted > 0) 
    	            System.out.println("---------------------------------------------------");
    	            System.out.println("\tUser was inserted successfully!");
    	        try {
    	            objIDC.connection.close();
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	        CustomerMain CM=new CustomerMain();
	            CM.customerMain();
	            scan.close();
    	    } 
       }


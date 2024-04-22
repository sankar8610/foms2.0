package orderIndexMain;
import paymentIndex.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import indexMain.DBOperactions;
import resturantMain.RestaurantIndexMain;

public class OrderMain {
	
	public void menuDetails()
	{   System.out.println("-------------------------------------------------------");
		Scanner scan=new Scanner(System.in);
		System.out.println("enter order ID :");
		String order_id=scan.next();
		System.out.println("enter customer Id :");
		int customer_id=scan.nextInt();
		System.out.println("enter restaurant_id :");
		String restaurant_id=scan.next();
		System.out.println("enter menu_id");
		int menu_id=scan.nextInt();
		PaymentMain pm=new PaymentMain();
		String payment_method=pm.paymentInfo();
		System.out.println("enter total_amount");
		int total_amount=scan.nextInt();
		String sql = "INSERT INTO orderdetails(order_id, customer_id, restaurant_id, menu_id, payment_method, total_amount) VALUES ( ?, ?, ?, ?, ?, ?)";
        Object[] param = { order_id, customer_id, restaurant_id, menu_id, payment_method, total_amount };
        DBOperactions DB=new DBOperactions();
        DB.ConnectDB();
        int rowsInserted = DB.InsertDB(sql, param);
   
        if (rowsInserted > 0) { 
            System.out.println("-------------------------------------------------------");
            System.out.println("\t order successful!");
            System.out.println("-------------------------------------------------------");
          
        }
        else
        {   System.out.println("-------------------------------------------------------");
        	System.out.println(" order unsuccessful");
        	System.out.println("-------------------------------------------------------");
        }
        scan.close();
	}
	public void orderView() throws ParseException {
		DBOperactions obj=new DBOperactions();
		obj.ConnectDB();
		 String sql = "SELECT * FROM orderdetails";
		 
		 try {
		 ResultSet resultSet = obj.ReadAllDB(sql);
		 obj.printResultSet(resultSet);
		 resultSet.close();
		 } catch (SQLException e) {
		 e.printStackTrace();
		 } 
		 RestaurantIndexMain RM=new RestaurantIndexMain();
         RM.resturantDetails();
		}
	

}

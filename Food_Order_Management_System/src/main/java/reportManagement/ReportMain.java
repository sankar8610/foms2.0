package reportManagement;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import indexMain.DBOperactions;
import resturantMain.RestaurantIndexMain;

public class ReportMain {
	public void adminView()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("------------------------------------");
		System.out.println("\t Report ");
		System.out.println("------------------------------------");
		System.out.println(" 1. admin report");
		System.out.println(" 2. restaurent report");
		System.out.println(" 3. menu report");
		System.out.println(" 4. order report");
		System.out.println(" 5. customer report");
		System.out.println(" 6. back");
		System.out.println("------------------------------------");
		System.out.print("enter your wish :");
		int num=scan.nextInt();
		System.out.println("------------------------------------");
        view(num);
		
	}
	public void view(int num)
	{
		switch(num)
		{
		case 1:
			admin();
			break;
		case 2:
			restaurent();
			break;
		case 3:
			menu();
			break;
		case 4:
			order();
		case 5:
			customer();
		case 6:
			RestaurantIndexMain rm=new RestaurantIndexMain();
			rm.resturantDetails();
		default :
			System.out.println("invalid entry ");
		}
	}
	public void admin()
	{
		DBOperactions obj=new DBOperactions();
		obj.ConnectDB();
		 String sql = "SELECT * FROM Admindetails";
		 
		 try {
		 ResultSet resultSet = obj.ReadAllDB(sql);
		 obj.printResultSet(resultSet);
		 resultSet.close();
		 } catch (SQLException e) {
		 e.printStackTrace();
		 } 
		 System.out.println("---------------------------------");
		 adminView();
	}
	public void restaurent()
	{
		DBOperactions obj=new DBOperactions();
		obj.ConnectDB();
		 String sql = "SELECT * FROM restaurantinfo";
		 
		 try {
		 ResultSet resultSet = obj.ReadAllDB(sql);
		 obj.printResultSet(resultSet);
		 resultSet.close();
		 } catch (SQLException e) {
		 e.printStackTrace();
		 } 
		 System.out.println("---------------------------------");
		 adminView();
		
	}
	public void menu()
	{
		DBOperactions obj=new DBOperactions();
		obj.ConnectDB();
		 String sql = "SELECT * FROM menuDetails";
		 
		 try {
		 ResultSet resultSet = obj.ReadAllDB(sql);
		 obj.printResultSet(resultSet);
		 resultSet.close();
		 } catch (SQLException e) {
		 e.printStackTrace();
		 } 
		 System.out.println("---------------------------------");
		 adminView();
		 
	}
	public void order()
	{
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
		 System.out.println("---------------------------------");
		 adminView();
		
	}
	public void customer()
	{
		DBOperactions obj=new DBOperactions();
		obj.ConnectDB();
		 String sql = "SELECT * FROM Customerdetails";
		 
		 try {
		 ResultSet resultSet = obj.ReadAllDB(sql);
		 obj.printResultSet(resultSet);
		 resultSet.close();
		 } catch (SQLException e) {
		 e.printStackTrace();
		 } 
		 System.out.println("---------------------------------");
		 adminView();
		
	}
}

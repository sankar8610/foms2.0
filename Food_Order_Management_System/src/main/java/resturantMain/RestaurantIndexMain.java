package resturantMain;
import reportManagement.*;
import orderIndexMain.*;
import indexMain.*;
import orderIndexMain.*;
import java.text.ParseException;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import MenuManagement.MenuMainIndex;

public class RestaurantIndexMain {
	 public void resturantDetails() 
	   {
		   Scanner scan=new Scanner(System.in);
		   System.out.println("--------------------------------");
		   System.out.println("\t Food Order Details");
		   System.out.println("--------------------------------");
	       System.out.println(" 1. Restaurant Informaction");
	       System.out.println(" 2. Restaurant Details");
	       System.out.println(" 3. menu Details");
	       System.out.println(" 4. order Details");
	       System.out.println(" 5. Report");
	       System.out.println(" 6. delete adminDetails");
	       System.out.println(" 7. delete customerDetails");
	       System.out.println(" 8. Exit");
		   System.out.println("--------------------------------");
		   System.out.print("enter your wish :");
	       int number=scan.nextInt();
	       //ResturantInformaction RIM=new ResturantInformaction();
	       //RIM.adminWish(number);
	       try {
			adminWish(number);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   public void adminWish(int num) throws Exception 
	   {
		   int number=num;
	   
		   switch (number) {
	       case 1:
	    	   ResturantInformaction RI=new ResturantInformaction();
	    	   RI.restaurantCreaction();
	       case 2:
	    	   ResturantInformaction RIF=new ResturantInformaction();
	    	   try {
				RIF.restaurantDetailsMain();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       case 3:
	    	   MenuMainIndex mm=new MenuMainIndex();
	    	   mm.menuMain();
	       case 4:
	    	   OrderMain od=new OrderMain();
	    	   od.orderView();
	       case 5:
	    	   ReportMain rm=new ReportMain();
	    	   rm.adminView();
	       case 6:
	    	   ResturantInformaction RIm=new ResturantInformaction();
	    	   RIm.admin();
	       case 7:
	    	   ResturantInformaction RIc=new ResturantInformaction();
	    	   RIc.customer();
	       case 8:
	    	   AdminMain aum=new AdminMain();
	    	   aum.adminLog();
	       default:
	       {
				System.out.println("Invalid entry!....");
				System.out.println("---------------------------------------------------");
				resturantDetails();
				
	       }
	       }
	   }
	    
	   
}
class ResturantInformaction
{
	private Statement connect;
	public void restaurantCreaction()
	   {   Scanner scan=new Scanner(System.in);
		   System.out.println("-------------------------------------------");
		   System.out.println("\t Restaurent Informactions");
		   System.out.println("-------------------------------------------");
		   System.out.println(" 1. add restauramt");
		   System.out.println(" 2. delete resturant");
		   System.out.println(" 3. back");
		   System.out.println("-------------------------------------------");
		   System.out.print("enter your wish :");
		   int num=scan.nextInt();
		   choiceAdmin(num);
		   ResturantInformaction RI=new ResturantInformaction();
		   add();
	   }
	public void choiceAdmin(int num)
	{
		switch (num)
		{
		case 1:
			ResturantInformaction RI=new ResturantInformaction();
			   add();
			break;
		case 2:
			ResturantInformaction RIM=new ResturantInformaction();
			try {
				RIM.deletRestaurant();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		case 3:
			AdminMain ad=new AdminMain();
			try {
				ad.adminLog();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		default:
			System.out.println("invalid choice");
			restaurantCreaction();
		      
		}
	}
	public void add()
	{
	    
		Scanner scan=new Scanner(System.in);
		System.out.print("enter restaurent ID :");
		String restaurant_id=scan.next();
		System.out.print("enter the name :");
		String name=scan.next();
		System.out.print("enter the address :");
		scan.nextLine();
		String address=scan.next();
		System.out.print("enter contact number");
		int phone_number=scan.nextInt();
		String sql = "INSERT INTO restaurantinfo(restaurant_id, name, address, phone_number) VALUES (?, ?, ?, ?)";
        Object[] param = { restaurant_id, name, address, phone_number };
        DBOperactions DB=new DBOperactions();
        DB.ConnectDB();
        int rowsInserted = DB.InsertDB(sql, param);
   
        if (rowsInserted > 0) { 
            System.out.println("---------------------------------------------------");
            System.out.println("\t inserted successfully!");
            RestaurantIndexMain RM=new RestaurantIndexMain();
            RM.resturantDetails();
        }
        else
        {
        	System.out.println("inserted unsuccessfully");
        }
            	
        scan.close();
	}
 
	
	public void restaurantDetailsMain() throws ParseException {
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
		 RestaurantIndexMain RM=new RestaurantIndexMain();
         RM.resturantDetails();
		}
	public void deletRestaurant()throws ParseException
	{
		Scanner scan=new Scanner(System.in);
		  DBOperactions obj=new DBOperactions();
			obj.ConnectDB();
			 
			 System.out.print("Enter Name: ");
			 String name = scan.next();
			 
			 String sql = "DELETE FROM restaurantinfo WHERE name=?"; 
			 Object[] params = { name };
			 obj.DeleteDB(sql, params);
			 
			 scan.close();
			}
	public void admin()throws ParseException
	{
		Scanner scan=new Scanner(System.in);
		  DBOperactions obj=new DBOperactions();
			obj.ConnectDB();
			 
			 System.out.print("Enter Name: ");
			 String name = scan.next();
			 
			 String sql = "DELETE FROM Admindetails WHERE name=?"; 
			 Object[] params = { name };
			 obj.DeleteDB(sql, params);
			 RestaurantIndexMain rm=new RestaurantIndexMain();
			 rm.resturantDetails();
			 scan.close();
			}
	public void customer()throws ParseException
	{
		Scanner scan=new Scanner(System.in);
		  DBOperactions obj=new DBOperactions();
			obj.ConnectDB();
			 
			 System.out.print("Enter Name: ");
			 String name = scan.next();
			 
			 String sql = "DELETE FROM Customerdetails WHERE name=?"; 
			 Object[] params = { name };
			 obj.DeleteDB(sql, params);
			 RestaurantIndexMain rme=new RestaurantIndexMain();
			 rme.resturantDetails();
			 scan.close();
			}

	}



	



































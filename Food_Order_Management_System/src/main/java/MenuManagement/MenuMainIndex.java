package MenuManagement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.text.ParseException;
import indexMain.*;
import resturantMain.RestaurantIndexMain;

import java.util.*;
public class MenuMainIndex{
	Scanner scan=new Scanner(System.in);
    public void menuMain()
    {
    	System.out.println("---------------------------------");
    	System.out.println("\t Food menu Details ");
    	
    	menuDetailsuse();
    }
    public void menuDetailsuse()
    {    
        System.out.println("---------------------------------");
    	System.out.println(" 1. menu informactions  ");
    	System.out.println(" 2. view menu ");
    	System.out.println(" 3. back ");
    	System.out.println("---------------------------------");
    	System.out.print(" enter your wish : ");
    	int num=scan.nextInt();
    	adminwish(num);
    	scan.close();
    }
    public void adminwish(int num)
    {    
    	int number=num;
    	switch(number) {
    	case 1:
    		MenuInfo();
    		break;
    	
    	case 2:
    		viewMenu();
    	    break;
    		
    	
    	case 3:
    		RestaurantIndexMain RM=new RestaurantIndexMain();
    		RM.resturantDetails();
    		break;
    	default :
    		System.out.println("invalid entry");
    		menuDetailsuse();	
    	    
    	}
    		
    }
    public void MenuInfo()
    {    
    	System.out.println("---------------------------------");
    	System.out.println("\t Choice Your Wish");
    	System.out.println("---------------------------------");
    	System.out.println("1. add menu");
    	System.out.println("2. delete menu");
    	System.out.println("3. back");
    	System.out.println("---------------------------------");
    	System.out.print("enter your wish :");
    	int number=scan.nextInt();
    	info(number);
    	scan.close();
    	
    }
    public void info(int num)
    {
    	switch(num)
    	{
    	case 1:
    		try {
				addMenu();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		break;
    	case 2:
    		deletemenu();
    		break;
    	case 3:
    		menuDetailsuse();
    		break;
    	default :
    		System.out.println("invalid entry");
   
    		return;
    	}
    }
    
    
   		
    public void addMenu() throws ParseException {
    	System.out.println("---------------------------------");
    	System.out.println("\t menu Details");
    	System.out.println("---------------------------------");
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
		 menuAdd();
		}
    
    public void menuAdd()
    {   System.out.println("---------------------------------");
    	System.out.println("\t Add menu");
    	System.out.println("---------------------------------");
   
		System.out.println("enter the menu Id :");
		int menu_id=scan.nextInt();
		System.out.println("enter the name :");
		String name=scan.next();
		System.out.println("enter the price :");
		int price=scan.nextInt();
		System.out.println("enter the description");
		String description=scan.next();
		System.out.println("enter the restaurant Id");
		String restaurant_id=scan.next();
		String sql = "INSERT INTO menuDetails(menu_id, name, price, description, restaurant_id) VALUES (?, ?, ?, ?, ?)";
        Object[] param = { menu_id, name, price, description, restaurant_id };
        DBOperactions DB=new DBOperactions();
        DB.ConnectDB();
        int rowsInserted = DB.InsertDB(sql, param);
   
        if (rowsInserted > 0) { 
            System.out.println("---------------------------------------------------");
            System.out.println("\t inserted successfully!");
            System.out.println("-------------------------------------------------------");
            MenuInfo();
        }
        else
        {
        	System.out.println("inserted unsuccessfully");
        }
        scan.close();
    }
    public void viewMenu()
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
    		 menuMain();
    		}
    public void deletemenu() //throws ParseException
	{
	
		  DBOperactions obj=new DBOperactions();
			obj.ConnectDB();
			 
			 System.out.print("Enter Id: ");
			 String menu_id = scan.next();
			 
			 String sql = "DELETE FROM menuDetails WHERE menu_id=?"; 
			 Object[] params = { menu_id };
			 obj.DeleteDB(sql, params);
			 menuDetailsuse();
			 scan.close();
			}
    }


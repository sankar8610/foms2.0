package MenuManagement;
import orderIndexMain.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import indexMain.*;
public class MenuView {
	public void foodMenu()
    {
    	System.out.println("---------------------------------");
    	System.out.println("\t Food Menu");
    	System.out.println("---------------------------------");
    	food();
    }
	public void food()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println(" 1. view menu");
		System.out.println(" 2. order menu");
		System.out.println(" 3. back");
    	System.out.println("---------------------------------");
		System.out.print("enter your wish :");
		int num=scan.nextInt();
    	System.out.println("---------------------------------");

		customerChoice(num);
		scan.close();
	}
	public void customerChoice(int num)
	{
	    switch(num)
	    {
	    case 1:
	    	viewMenu();
	    	break;
	    case 2:
	    	OrderMain om=new OrderMain();
	    	om.menuDetails();
	    case 3:
	    	CustomerMain cm=new CustomerMain();
	    	try {
				cm.customerLog();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    default :
	    	System.out.println("-------------------------------------------------------");
	    	System.out.println("invalid entry");
	    }
	    
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
		 System.out.println("---------------------------------");
		 food();
	}
	 
	}




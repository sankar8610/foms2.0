package indexMain;
import java.util.*;
import MenuManagement.*;
public class AdminMain extends Exception  {

	public  void adminLog() throws Exception {
		Scanner scan=new Scanner(System.in);
		System.out.println("------------------------------------------");
		System.out.println("\t Welcome Admin ");
		System.out.println("------------------------------------------");
        System.out.println(" 1. Admin Login");
        System.out.println(" 2. Create Account");
        System.out.println(" 3. Go Back");
        System.out.println("------------------------------------------");
        System.out.print("enter the choice :");
        int number=scan.nextInt();
        switch(number) 
        {
        case 1:
        	AdminUseMain admin=new AdminUseMain();
            admin.adminWork();
            break;
        case 2:
        	AdminCreaction adminc=new AdminCreaction();
            AdminCreaction.adminCreaction();
            break;
        case 3:
        	System.out.println("------------------------------------------");
        	IndexUseMain mm=new IndexUseMain();
        	mm.mainEntry();
        default:
        {
			System.out.println("Invalid entry!....");
			adminLog();
        }
        
        }
        scan.close();
	}
	

}

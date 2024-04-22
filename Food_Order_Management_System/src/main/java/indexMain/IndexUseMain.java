package indexMain;

import java.util.*;

@SuppressWarnings("serial")
public class IndexUseMain extends Exception {

	public static void main(String arg[]) throws Exception {
                
        System.out.println("---------------------------------------------------");
        System.out.println("\t FOOD ORDER MANAGMENT SYSTEM");
        System.out.println("---------------------------------------------------");
        mainEntry();
    }
    public static void mainEntry() throws Exception
    {
    	Scanner scan = new Scanner(System.in);
        System.out.println(" 1. Admin ");
        System.out.println(" 2. Customer ");
        System.out.println(" 3. Exit ");
        System.out.println("---------------------------------------------------");
        System.out.print("Enter your role : ");

        int number = scan.nextInt();
        try {
			logMethod(number);
		} catch (IndexUseMain e) {
			e.printStackTrace();
		}
        scan.close();
    }

    public static void logMethod(int num) throws Exception {
        switch (num) {
            case 1:
            	AdminMain admin=new AdminMain();
                admin.adminLog();
                break;
            case 2:
            	CustomerMain customer=new CustomerMain();
                customer.customerLog();
                break;
            case 3:
            	System.out.println("Thank you!....");
                System.exit(0); 
            default:
            {
				System.out.println("Invalid entry!....");
				System.out.println("---------------------------------------------------");
				mainEntry();
            }
            
        }
    }
    
}

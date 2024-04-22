package indexMain;
import java.util.*;
public class CustomerMain {

	public void customerLog() throws Exception {
		System.out.println("-------------------------------------------");
		System.out.println("\t Welcome Customer");
		System.out.println("-------------------------------------------");
		customerMain();
	}
	public void customerMain() throws Exception
	{   
		Scanner scan=new Scanner(System.in);
		System.out.println(" 1. Cutomer Login");
		System.out.println(" 2. Account Creaction");
		System.out.println(" 3. Exit");
		System.out.println("-------------------------------------------");
        System.out.print("Enter your choice : ");
        int number=scan.nextInt();
        customerWish(number);
	}
	public void customerWish(int num) throws Exception
	{
		int number=num;
		switch(num) 
        {
        case 1:
        	CustomerLog.customerlog();
            break;
        case 2:
        	CustomerCreaction cus1=new CustomerCreaction();
        	cus1.customerCreaction();
            break;
        case 3:
        	IndexUseMain.mainEntry();
        default:
        {
			System.out.println("Invalid entry!....");
			customerMain();
        }
        
        }
	}

	

}

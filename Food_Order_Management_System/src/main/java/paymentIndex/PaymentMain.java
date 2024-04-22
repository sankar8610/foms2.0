package paymentIndex;
import java.util.*;

public class PaymentMain {

    public String paymentInfo() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter payment method (1 - gpay, 2 - credit card, 3 - cash on delivery): ");

        int choice;
        try {
            choice = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number between 1 and 3.");
            
            scan.nextLine();
            return null; 
        }

        String paymentMethod;
        switch (choice) {
            case 1:
                paymentMethod = "gpay";
                break;
            case 2:
                paymentMethod = "credit card";
                break;
            case 3:
                paymentMethod = "cash on delivery";
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
                paymentMethod = null; 
        }

        return paymentMethod;
    }

     
}

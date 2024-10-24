import java.util.*;
public class FashionShop {

    private static Scanner input = new Scanner(System.in);

    public static void homePage() {
   
        ConsoleWriter.printHomePage();

        int choice = ConsoleWriter.getIntegerInput();
        
        switch (choice) { 
            case 1:
                //laceOrder();
                
                break;
            case 2:
                //searchCustomer();    

                break;
            case 3:
                //searchOrder();

                break;
            case 4:
                //viewReports();
                
                break;
            case 5:
                //setOrderStatus();

                break;
            case 6:
                //deleteOrder();
                
                break;
            
            default:
                return;
   
        }

        homePage();
    
    }

    public static void main(String args[]) {
        homePage();

        ConsoleWriter.clearConsole();

        System.out.println("Goodbye!");
    }

   
    
}
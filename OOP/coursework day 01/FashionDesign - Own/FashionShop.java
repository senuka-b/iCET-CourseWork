import java.util.*;
public class FashionShop {

    private static Scanner input = new Scanner(System.in);

    public static void homePage() {
        clearConsole();
   
        
        int choice = input.nextInt();
        
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

        clearConsole();

        System.out.println("Goodbye!");
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
                if (os.contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
        } catch (final Exception e) {
                e.printStackTrace();
                // Handle any exceptions.
        }
    }
    
}
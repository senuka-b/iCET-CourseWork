public class FashionShop {

    private static void deleteOrder() {

        ConsoleWriter.printDeleteOrderPage();

    }

    private static void setOrderStatus() {

        ConsoleWriter.printSetOrderStatusPage();

    }

    private static void viewReports() {

        ConsoleWriter.printViewReportPage();

    }

    private static void searchOrder() {

        ConsoleWriter.printSearchOrderPage();

    }

    private static void searchCustomer() {
        
        ConsoleWriter.printSearchCustomerPage();
    }

    private static void placeOrder() {

        ConsoleWriter.printPlaceOrderPage();


    }

    private static void homePage() {
   
        ConsoleWriter.printHomePage();

        int choice = ConsoleWriter.getIntegerInput();
        
        switch (choice) { 
            case 1:
                placeOrder();
                
                break;
            case 2:
                searchCustomer();    

                break;
            case 3:
                searchOrder();

                break;
            case 4:
                viewReports();
                
                break;
            case 5:
                setOrderStatus();

                break;
            case 6:
                deleteOrder();
                
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
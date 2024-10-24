public class FashionShop {
    private static int orderCount = 0;
    private static Customer[] customers = new Customer[0];

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

        String phoneNumber = Customer.validatePhoneNumber();

        if (!phoneNumber.equals("invalid")) {

        }


    }

    private static void placeOrder() {

        ConsoleWriter.printPlaceOrderPage();

        Order order = new Order(orderCount+1);

        System.out.println("\tOrder ID : " + order.createOrderString());

        String phoneNumber = Customer.validatePhoneNumber();

        if (phoneNumber.equals("none")) return;

        order.validateTSize();
        System.out.println();

        order.validateQty();

        System.out.println("\tAmount : " + order.calculateAmount());

        boolean choice = ConsoleWriter.yesNoChoice("Do you want to place this order? (y/n) : ");

        if (choice) {
            orderCount++;

            customers = Customer.placeOrder(customers, order, phoneNumber);

            System.out.println("\n\n\t\tOrder placed!");

        }

        choice = ConsoleWriter.yesNoChoice("Do you want to place another order? (y/n) : ");

        if (choice) {
            placeOrder();
        }


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
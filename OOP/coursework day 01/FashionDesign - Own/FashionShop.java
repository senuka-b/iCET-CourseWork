import java.util.Arrays;

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

        System.out.print("\tEnter Order ID : ");
        int orderNumber = Order.validateOrderID(ConsoleWriter.getStringInput(), customers); 

        if (!(orderNumber == -1)) {

            System.out.println("\n");

            Order order = Order.getOrderByNumber(orderNumber, customers);

            System.out.println("\tPhone Number    : " + Customer.getCustomerByOrder(order, customers).getCustomerID());
            System.out.println("\tSize\t\t: " + order.getTSize());
            System.out.println("\tQty\t\t: " + order.getQuantity());
            System.out.println("\tAmount\t\t: " + order.calculateAmount());
            System.out.println("\tStatus\t\t: " + order.getStatuString());



        } else {
            // No order found / invalid ID
            System.out.println("\n\t\tInvalid ID ! \n");
        }

        boolean choice = ConsoleWriter.yesNoChoice("Do you want to search another order? (y/n) : ");
        
        if (choice) {
            searchOrder();
        }

    }

    private static void searchCustomer() {
        
        ConsoleWriter.printSearchCustomerPage();

        String phoneNumber = Customer.validatePhoneNumber();

        Table searchCustomerTable = Table.createSearchCustomerTable(customers, phoneNumber);

        if (!phoneNumber.equals("none")) {

            if (!searchCustomerTable.getIsEmpty()) {

                searchCustomerTable.print();

            } else { 
                // No customer
                System.out.println("\n\n\t\tInvalid input ! \n");
                
            }
                        
        } 

        boolean choice = ConsoleWriter.yesNoChoice("Do you want to search another customer report?  (y/n) : ");

        if (choice) {
            searchCustomer();
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

            // Would return an array with a new customer if the customer is new, or 
            // update the existing customer.
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
        // --- Testing ----
        customers = Customer.placeOrder(customers, new Order(++orderCount, "xs", 10), "0705532339");
        customers = Customer.placeOrder(customers, new Order(++orderCount, "xs", 10), "0705532339");
        customers = Customer.placeOrder(customers, new Order(++orderCount, "m", 20), "0705532339");
        customers = Customer.placeOrder(customers, new Order(++orderCount, "l", 40), "0705532339");

        customers = Customer.placeOrder(customers, new Order(++orderCount, "xxl", 100), "0111111111");
        customers = Customer.placeOrder(customers, new Order(++orderCount, "m", 5), "0111111111");

        customers = Customer.placeOrder(customers, new Order(++orderCount, "s", 30), "0222222222");
        customers = Customer.placeOrder(customers, new Order(++orderCount, "xs", 50), "0222222222");
        


        homePage();

        ConsoleWriter.clearConsole();

        System.out.println("Goodbye!");
    }

   
    
}
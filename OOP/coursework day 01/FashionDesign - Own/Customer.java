class Customer {
    private String customerID;
    private Order[] orders;

    Customer(String customerID) {
        this.customerID = customerID;
    }
    
    public static Customer[] placeOrder(Customer[] customers, Order order, String customerID) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].customerID == customerID) {
                customers[i].orders = extendOrders(customers[i].orders, order);
            }   return customers;
        }

        Customer new_customer = new Customer(customerID);

        Customer[] temp = new Customer[customers.length + 1];

        for (int i = 0; i < customers.length; i++) {
            temp[i] = customers[i];

        }
   
        temp[temp.length-1] = new_customer;

        return temp;
        
    }

    public static Order[] extendOrders(Order[] array, Order final_value) {
        Order[] temp_o = new Order[array.length+1];

        for (int i = 0; i < array.length; i++) {
            temp_o[i] = array[i];

        }

        temp_o[temp_o.length-1] = final_value;

        return temp_o;
    }


    public static String validatePhoneNumber() {

        System.out.print("\tEnter Customer Phone Number : ");
        String phoneNumber = ConsoleWriter.getStringInput();
        
        if (phoneNumber.length() == 10 && phoneNumber.charAt(0) == '0' ) {
           
            return phoneNumber;
        }

        System.out.println("\n\tInvalid phone number! Try again.");

        boolean choice = ConsoleWriter.yesNoChoice("Do you want to enter phone number again (y/n) : ");

        if (choice) {

            System.out.print("\033[6A");
            System.out.print("\033[0J");

            return validatePhoneNumber();

        } 

        return "none";

    }
}

import java.util.Arrays;

class Customer {
    private String customerID;
    private Order[] orders = new Order[0];

    Customer(String customerID) {
        this.customerID = customerID;
    }

    public static boolean isValidCustomerID(String text) {
        if (text.toLowerCase().charAt(0) == '0' && text.length() == 10) {
            return true;
        }

        return false;
    }

    public static Customer getCustomerByOrder(Order order, Customer[] customers) {
        for (Customer customer : customers) {
            for (Order currentOrder : customer.orders) {
                if (currentOrder.getOrderNumber() == order.getOrderNumber()) {
                    return customer;
                }
            }
        }

        return new Customer("invalid");
    }

    public String getCustomerID() {
        return this.customerID;
    }

    public Order[] getOrders() {
        return orders;
    }

    public static boolean isExists(Customer[] customers, String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.customerID.equals(phoneNumber)) {
                return true;
            }
        }

        return false;
    }
    
    public static int[] getQuantityData(Customer[] customers, String customerID) {
        int[] data = new int[6];

        for (int i = 0; i < customers.length; i++) {

            if(customers[i].customerID.equals(customerID)) {
                for (int j = 0; j < data.length; j++) {
                    for (Order order : customers[i].orders) {
                        data[j] += order.getQuantity(j);
                    }
                }
            }
        }


        return data;
    }

    public static Customer[] placeOrder(Customer[] customers, Order order, String customerID) {

        for (int i = 0; i < customers.length; i++) {
            if (customers[i].customerID.equals(customerID)) { // Old customer
                
                customers[i].orders = extendOrders(customers[i].orders, order);

                return customers;
            }
        }

        Customer new_customer = new Customer(customerID);
        new_customer.orders = extendOrders(new_customer.orders, order);

        return extendCustomers(customers, new_customer);
        
    }

    private static Customer[] extendCustomers(Customer[] customers, Customer new_customer) {
        Customer[] temp = new Customer[customers.length + 1];

        for (int i = 0; i < customers.length; i++) {
            temp[i] = customers[i];

        }
   
        temp[temp.length-1] = new_customer;

        return temp;
    }

    private static Order[] extendOrders(Order[] array, Order final_value) {
        Order[] temp_o = new Order[array.length+1];

        for (int i = 0; i < array.length; i++) {
            temp_o[i] = array[i];

        }

        temp_o[temp_o.length-1] = final_value;

        return temp_o;
    }


   
}



class Customer {
    private String customerID;
    private Order[] orders = new Order[0];

    Customer(String customerID) {
        this.customerID = customerID;
    }

    Customer(String customerID, Order[] orders) {
        this.customerID = customerID;
        this.orders = orders;
    }

    public String toString() {
        String returnString = this.customerID + ":";

        if (this.orders.length == 0) return null;

        int i = 0;
        for (Order order : this.orders) {
            returnString += order.toString() + (i != this.orders.length-1 ? "_" : "");
            i++;
        }
        return returnString;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
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

    public static String[][] getSearchCustomerRows(Customer[] customers, String phoneNumber) {
        int[] quantityData = Customer.getQuantityData(customers, phoneNumber);

        String[][] customerReportRows = new String[6][3];

        for (int i = 0; i < customerReportRows.length; i++) {
            for (int j = 0; j < customerReportRows[i].length; j++) {
                String value = "";
                switch (j) {
                    case 0:
                        value = Order.getSizeArray()[i].toUpperCase();
                        break;
                
                    case 1:
                        value = String.format("%d", quantityData[i]);
                        break;

                    case 2:
                        value = String.format("%.2f", Order.calculateAmount(Order.getSizeArray()[i], quantityData[i]));
                        break;
                }

                customerReportRows[i][j] = value;
            }
        }

        return customerReportRows;

        

    }

    public static double getCustomerTotalAmount(Customer[] customers, String phoneNumber) {
        int[] quantityData = Customer.getQuantityData(customers, phoneNumber);

        double totalAmount = 0;
        for (int i = 0; i < quantityData.length; i++) {
            totalAmount += Order.calculateAmount(Order.getSizeArray()[i], quantityData[i]);
        }

        return totalAmount;
    }

    public static void sort(String[][] data, int sort_index) {

        for(int i = data.length-1; i>0; i--){
			for(int j=0; j<i; j++){

                double amount_1 = Double.parseDouble(data[j][sort_index]);
                double amount_2 = Double.parseDouble(data[j+1][sort_index]);

				if(amount_1 < amount_2){

					String[] temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}	
				
			}
		}
    }

    private static String[][] getAllCustomerRows(Customer[] customers, boolean sort) {// No Customers

        String[][] bestInCustomersRows = new String[customers.length][3];

        for (int i = 0; i < customers.length; i++) {
            Customer currentCustomer = customers[i];

            int[] quantityData = Customer.getQuantityData(customers, currentCustomer.getCustomerID());

            double totalAmount = 0;
            int totalQuantities = 0;

            for (int j = 0; j < quantityData.length; j++) {
                totalQuantities += quantityData[j];
                totalAmount += Order.calculateAmount(Order.getSizeArray()[j], quantityData[j]);
            }

            bestInCustomersRows[i][0] = currentCustomer.getCustomerID();
            bestInCustomersRows[i][1] = String.format("%d", totalQuantities);
            bestInCustomersRows[i][2] = String.format("%.2f", totalAmount);
        }


        if(sort) sort(bestInCustomersRows, 2); // Sort in decending order with 'amount' value


        return bestInCustomersRows;

    }

    public static String[][] getBestInCustomersRows(Customer[] customers) {
        return getAllCustomerRows(customers, true);
    }

    public static String[][] getViewCustomerRows(Customer[] customers) {
        return getAllCustomerRows(customers, false);
    }

    public static String[][] getAllCustomerReportRows(Customer[] customers) {
        String[][] allCustomerReportRows = new String[customers.length][8];

        for (int i = 0; i < customers.length; i++) {
            Customer currentCustomer = customers[i];

            allCustomerReportRows[i][0] = currentCustomer.getCustomerID();

            int[] quantityData = Customer.getQuantityData(customers, currentCustomer.getCustomerID());
            double totalAmount = 0;

            for (int j = 0; j < quantityData.length; j++) {
                allCustomerReportRows[i][j+1] = String.format("%d", quantityData[j]);
                totalAmount += Order.calculateAmount(Order.getSizeArray()[j], quantityData[j]);
            }

            allCustomerReportRows[i][7] = String.format("%.2f", totalAmount);
        }

        return allCustomerReportRows;
        
    }
    


   
}

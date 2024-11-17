import java.io.*;
import java.util.Arrays;

class CustomerController {

    // FILE WRITING / READING
    
    private static final String CUSTOMER_FILE = "data/customers.txt";
    
    private static String[] extendArray(String[] array, String value) {
        String[] temp = new String[array.length+1];

        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }

        temp[temp.length-1] = value;
        return temp;
    }

    public static boolean dumpToFile(Customer[] customers) {
        try {
            FileWriter writer = new FileWriter(CUSTOMER_FILE);

            for (int i = 0; i < customers.length; i++) {
                Customer currentCustomer = customers[i];

                if (currentCustomer.toString() != null) {
                    writer.write(currentCustomer.toString());
                    
                    writer.write("\n");
                }
                
            }

            writer.flush();
            writer.close();

            return true;

        } catch (IOException e) {
            return false;
        }
    }

    public static String[] readCustomerStrings() {

        try {
            BufferedReader reader;

            reader = new BufferedReader(new FileReader(CUSTOMER_FILE));
            
            String[] lineArray = new String[0];
            String line = reader.readLine();
            
            while (line != null) {
                if (line.isBlank() || line.isEmpty()) {
                    // End of file. This would not work if there's empty lines between the fields.
                    break;
                }

                System.out.println(line);
                lineArray = extendArray(lineArray, line);
                line = reader.readLine(); 
            }

            reader.close();
            return lineArray.length != 0 ? lineArray : null;

        } catch (IOException e) {
            System.out.println("error 1");
            return null;
        }
        
    }

    private static List parseToCustomerObjects() {
        String[] customerStrings = readCustomerStrings();

        List customerList = new List();

        if (customerStrings == null) {
            return customerList;
        }
                
        for (int j=0; j < customerStrings.length; j++) {
            String[] customerStringsArray = customerStrings[j].split(":"); // [custoemrID, order1_order2_...]

            System.out.println("customerStringsArray " + Arrays.toString(customerStringsArray));

            String customerID = customerStringsArray[0];
            String ordersString = customerStringsArray[1]; // order1_order2_order_3...

            System.out.println("customerID: "+customerID);

            String[] orderStringValues = ordersString.split("_");

            Order[] orderArray = new Order[orderStringValues.length];

            for (int i = 0; i < orderStringValues.length; i++) {

                String[] currentOrderValues = orderStringValues[i].split(",");

                orderArray[i] = new Order(
                    getOrderNumberByID(currentOrderValues[0]),
                    currentOrderValues[1],
                    Integer.parseInt(currentOrderValues[2]),
                    Integer.parseInt(currentOrderValues[3]));

            }

            customerList.add(new Customer(customerID, orderArray));
            
        }

        return customerList;
    }

    private static List getCustomers() {

        return parseToCustomerObjects();
    }

    // ORDER PLACEMENT / UPDATE / DELETE

    private static Order[] extendOrders(Order[] array, Order final_value) {
        Order[] temp_o = new Order[array.length+1];

        for (int i = 0; i < array.length; i++) {
            temp_o[i] = array[i];

        }

        temp_o[temp_o.length-1] = final_value;

        return temp_o;
    }

    public static boolean placeOrder(String customerID, String tSize, int qty) {

        Customer currentCustomer = new Customer(customerID);

        Order newOrder = new Order(getLastOrder() != null ? getLastOrder().getOrderNumber()+1 : 1, tSize, qty);

        List customerList = getCustomers();

        if (customerList.isExists(currentCustomer)) {
            int index = customerList.search(currentCustomer);
            Customer oldCustomer = customerList.get(index);

            currentCustomer.setOrders(extendOrders(oldCustomer.getOrders(), newOrder));

            customerList.set(index, currentCustomer);

            return dumpToFile(customerList.toArray());
        }

        currentCustomer.setOrders(extendOrders(currentCustomer.getOrders(), newOrder));
        customerList.add(currentCustomer);

        return dumpToFile(customerList.toArray());
        
    }

    public static boolean updateOrderStatus(Order order) {
        List customerList = getCustomers();
        int index = customerList.search(getCustomerByOrder(order));
        Customer customer = customerList.get(index);

        Order[] orders = customer.getOrders();

        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getOrderNumber() == order.getOrderNumber()) {
                orders[i] = order;

                return dumpToFile(customerList.toArray());
            }
        }

        return false;

    }

    public static boolean deleteOrder(Order order) {

        List customerList = getCustomers();
        Customer customer = customerList.get(customerList.search(getCustomerByOrder(order)));

        Order[] orders = customer.getOrders();

        for (int j = 0; j < orders.length; j++) {
            if (order.getOrderNumber() == orders[j].getOrderNumber()) {
                
                Order[] temp = new Order[orders.length-1];
                
                for (int k = 0; k < j; k++) {
                    temp[k] = orders[k];
                }

                for (int k = j; k < temp.length; k++) {
                    temp[k] = orders[k+1];
                }

                customer.setOrders(temp);

                return dumpToFile(customerList.toArray());

            }
        }
        

        return false;
    }

    // ORDER DATA

    public static Order getLastOrder() {
        Customer[] customerArray = getCustomers().toArray();

        if (customerArray.length == 0) return null;

        Order lastOrder = customerArray[0].getOrders()[0];
        for (Customer customer : customerArray) {
            for (Order order : customer.getOrders()) {
                if (order.getOrderNumber() >= lastOrder.getOrderNumber()) {
                    lastOrder = order;
                }
            }
        }

        return lastOrder;
    }

    public static int[] getQuantityData(String customerID) {
        Customer[] customers = getCustomers().toArray();
        
        int[] data = new int[6];

        for (int i = 0; i < customers.length; i++) {

            if(customers[i].getCustomerID().equals(customerID)) {
                for (int j = 0; j < data.length; j++) {
                    for (Order order : customers[i].getOrders()) {
                        data[j] += order.getQuantity(j);
                    }
                }
            }
        }


        return data;
    }

    public static Order getOrderByID(String orderID) {
        Customer[] customers = getCustomers().toArray();

        int orderNumber = Integer.parseInt(orderID.substring(4));

        for (Customer customer : customers) {
            for (Order order : customer.getOrders()) {
                if (order.getOrderNumber() == orderNumber) {
                    return order;
                }
            }
        }

        return null;
    }

    // ORDER UTILITIES

    public static int getOrderNumberByID(String orderID) {
        return Integer.parseInt(orderID.substring(4));
    }

    public static boolean isExistsOrder(String orderID) {

        Customer[] customers = getCustomers().toArray();

        int parsed_id = Integer.parseInt(orderID.substring(4));

        for (Customer customer : customers) {
            for (Order order : customer.getOrders()) {
                if (order.getOrderNumber() == parsed_id) {
                    return true;
                }
            }
        }

        return false;
    }

    public static double calculateAmount(String tSize, int qty) {
        return new Order(0, tSize, qty).calculateAmount();
    }

    public static String createOrderString(int orderNumber) {

        return String.format("ODR#%06d", orderNumber);
    }

    

    // ORDER VALIDATION

    public static boolean isValidOrderID(String orderID) {
        if ((orderID.length() == 10) && 
            (orderID
            .substring(0, 4)
            .toLowerCase()
            .equals("odr#"))

            ) {
                return true;
                
        } else {
            return false;
        }
    }
    
    public static boolean isValidQty(String qty) {

        return Integer.parseInt(qty) > 0;
    }

    public static boolean isValidSize(String tSize) {

        switch (tSize.toLowerCase()) {
            case "xs":
            case "s":
            case "m":
            case "l":
            case "xl":
            case "xxl":
                return true;
        
            default:
                return false;      
        }
    }

    // ORDER ROW DATA

    private static String[][] getQuantityRows(int sort_index) {
        Customer[] customers = getCustomers().toArray();


        String[][] data = new String[6][3];

        // [[total_qty, sum], ...]
        double[][] values = new double[6][2];

        for (int i = 0; i < customers.length; i++) {


            int[] quantity_data = getQuantityData(customers[i].getCustomerID());

            for (int j = 0; j < quantity_data.length; j++) {
                    values[j][0] += quantity_data[j];
                    values[j][1] += calculateAmount(Order.getSizeArray()[j], quantity_data[j]);
            }
            

        }

        
        for (int i = 0; i < values.length; i++) {
            data[i][0] = Order.getSizeArray()[i];
            data[i][1] = String.format("%.0f", values[i][0]);
            data[i][2] = String.format("%.2f", values[i][1]);
        }

        sort(data, sort_index);

        return data;
    }

    public static String[][] getOrdersCategorizedByQTYRows() {
        return getQuantityRows( 1);
    }

    public static String[][] getOrdersCategorizedByAmountRows() {
        return getQuantityRows(2);
    }

    private static String[][] getOrderData(int sort_index) {

        Customer[] customers = getCustomers().toArray();

        // [[orderId, phone, size, qty, amount, status], ...]
       String[][] data = new String[0][6];

       for (int i = 0; i < customers.length; i++) {
            Order[] currentOrders = customers[i].getOrders();

            for (int j = 0; j < currentOrders.length; j++) {
                
                Order order = currentOrders[j];

                String[][] temp = new String[data.length+1][6];

                for (int k = 0; k < data.length; k++) {
                    temp[k] = data[k];
                }

                data = temp;

                data[data.length - 1][0] = Integer.toString(order.getOrderNumber());
                data[data.length - 1][1] = getCustomerByOrder(order).getCustomerID();
                data[data.length - 1][2] = order.getTSize();
                data[data.length - 1][3] = String.format("%d", order.getQuantity());
                data[data.length - 1][4] = String.format("%.2f",order.calculateAmount());
                data[data.length - 1][5] = order.getStatuString();        
               

            }
       }


        sort(data, sort_index);

        for (int i = 0; i < data.length; i++) {
            data[i][0] = createOrderString(Integer.parseInt(data[i][0]));
              
        }

        return data;
    }

    public static String[][] getAllOrderRows() {
        return getOrderData(0); // sorted by order number
    }

    public static String[][] getOrderByAmountRows() {
        return getOrderData(4);
    }



    // CUSTOMER DATA

    public static Customer getCustomerByOrder(Order order) {
        Customer[] customers = getCustomers().toArray();

        for (Customer customer : customers) {
            for (Order currentOrder : customer.getOrders()) {
                if (currentOrder.getOrderNumber() == order.getOrderNumber()) {
                    return customer;
                }
            }
        }

        return null;
    }

    public static double getCustomerTotalAmount(String phoneNumber) {
        int[] quantityData = getQuantityData(phoneNumber);

        double totalAmount = 0;
        for (int i = 0; i < quantityData.length; i++) {
            totalAmount += calculateAmount(Order.getSizeArray()[i], quantityData[i]);
        }

        return totalAmount;
    }

    // CUSTOMER UTILITIES

    public static boolean isExistsCustomer(String phoneNumber) {

        return getCustomers().isExists(new Customer(phoneNumber));
    }
    

    // CUSTOMER VALIDATION

    public static boolean isValidCustomerID(String text) {
        if (text.toLowerCase().charAt(0) == '0' && text.length() == 10) {
            for (int i = 0; i < text.length(); i++) {
                if (!Character.isDigit(text.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }


    // CUSTOMER ROW DATA

    public static String[][] getSearchCustomerRows(String phoneNumber) {
        int[] quantityData = getQuantityData(phoneNumber);

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
                        value = String.format("%.2f", calculateAmount(Order.getSizeArray()[i], quantityData[i]));
                        break;
                }

                customerReportRows[i][j] = value;
            }
        }

        return customerReportRows;

    }

    public static String[][] getAllCustomerRows(boolean sort) {// No Customers

        Customer[] customers = getCustomers().toArray();

        String[][] bestInCustomersRows = new String[customers.length][3];

        for (int i = 0; i < customers.length; i++) {
            Customer currentCustomer = customers[i];

            int[] quantityData = getQuantityData(currentCustomer.getCustomerID());

            double totalAmount = 0;
            int totalQuantities = 0;

            for (int j = 0; j < quantityData.length; j++) {
                totalQuantities += quantityData[j];
                totalAmount += calculateAmount(Order.getSizeArray()[j], quantityData[j]);
            }

            bestInCustomersRows[i][0] = currentCustomer.getCustomerID();
            bestInCustomersRows[i][1] = String.format("%d", totalQuantities);
            bestInCustomersRows[i][2] = String.format("%.2f", totalAmount);
        }


        if(sort) sort(bestInCustomersRows, 2); // Sort in decending order with 'amount' value

        return bestInCustomersRows;

    }


    public static String[][] getBestInCustomersRows() {
        return getAllCustomerRows(true);
    }

    public static String[][] getViewCustomerRows() {
        return getAllCustomerRows(false);
    }
  
    public static String[][] getAllCustomerReportRows() {
        Customer[] customers = getCustomers().toArray();

        String[][] allCustomerReportRows = new String[customers.length][8];

        for (int i = 0; i < customers.length; i++) {
            Customer currentCustomer = customers[i];

            allCustomerReportRows[i][0] = currentCustomer.getCustomerID();

            int[] quantityData = getQuantityData(currentCustomer.getCustomerID());
            double totalAmount = 0;

            for (int j = 0; j < quantityData.length; j++) {
                allCustomerReportRows[i][j+1] = String.format("%d", quantityData[j]);
                totalAmount += calculateAmount(Order.getSizeArray()[j], quantityData[j]);
            }

            allCustomerReportRows[i][7] = String.format("%.2f", totalAmount);
        }

        return allCustomerReportRows;
        
    }

    // OTHER

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



}
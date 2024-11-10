import java.util.Arrays;

class CustomerCollection {
    private static Customer[] customerArray = new Customer[0];


    CustomerCollection() {
        // --- TESTING ---


        // customerArray = Customer.placeOrder(customerArray, new Order(++orderCount, "xs", 10), "0705532339"); // 6000
        // customerArray = Customer.placeOrder(customerArray, new Order(++orderCount, "xs", 10), "0705532339"); // 6000
        // customerArray = Customer.placeOrder(customerArray, new Order(++orderCount, "m", 20), "0705532339"); // 18000
        // customerArray = Customer.placeOrder(customerArray, new Order(++orderCount, "l", 40), "0705532339"); // 40000 -> 70000

        // customerArray = Customer.placeOrder(customerArray, new Order(++orderCount, "xxl", 100), "0111111111"); // 120000
        // customerArray = Customer.placeOrder(customerArray, new Order(++orderCount, "m", 5), "0111111111"); // 4500 -> 124500

        // customerArray = Customer.placeOrder(customerArray, new Order(++orderCount, "s", 30), "0222222222"); // 24000
        // customerArray = Customer.placeOrder(customerArray, new Order(++orderCount, "xs", 50), "0222222222"); // 30000 -> 54000
        

    }

    public Customer[] getCustomers() {
        return customerArray;
    }

    public static Order getLastOrder() {
        customerArray = parseToCustomerObjects();

        Order[] lastCustomerOrders = customerArray[customerArray.length-1].getOrders();

        return lastCustomerOrders[lastCustomerOrders.length-1];
    }

    private static Customer[] parseToCustomerObjects() {
        String[] customerStrings = FileManager.getCustomers();

        Customer[] customersArray = new Customer[customerStrings.length];
        if (customerStrings == null) {
            return new Customer[0];
        } else {
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
                        Order.getOrderNumberByID(currentOrderValues[0]),
                        currentOrderValues[1],
                        Integer.parseInt(currentOrderValues[2]),
                        Integer.parseInt(currentOrderValues[3]));

                }

                customersArray[j] = new Customer(customerID, orderArray);
                
            }
        }

        return customersArray;
    }

    public static boolean placeOrder(String customerID, String tSize, int qty) {


        Order newOrder = new Order(getLastOrder().getOrderNumber()+1, tSize, qty);

        customerArray = Customer.placeOrder(customerArray, newOrder, customerID);

        return FileManager.dumpToFile(customerArray);
        
    }

    public String[][] getSearchCustomerRows(String customerID) {
        return Customer.getSearchCustomerRows(customerArray, customerID);
    }

    public double getCustomerTotalAmount(String customerID) {
        return Customer.getCustomerTotalAmount(customerArray, customerID);
    }

    public Customer getCustomerIDByOrder(Order order) {
        return Customer.getCustomerByOrder(order, customerArray);
    }

    public Order getOrderByID(String input) {
        return Order.getOrderByID(input, customerArray);
    }

    public String[][] getBestInCustomersRows() {
        return Customer.getBestInCustomersRows(customerArray);
    }

    public String[][] getViewCustomersRows() {
        return Customer.getViewCustomerRows(customerArray);
    }

    public String[][] getAllCustomerReportRows() {
        return Customer.getAllCustomerReportRows(customerArray);
    }

    public String[][] getOrdersCategorizedByQTYRows() {
        return Order.getOrdersCategorizedByQTYRows(customerArray);
    }

    public String[][] getOrdersCategorizedByAmountRows() {
        return Order.getOrdersCategorizedByAmountRows(customerArray);
    }

    public String[][] getAllOrderRows() {
        return Order.getAllOrderRows(customerArray);
    }

    public String[][] getOrderByAmountRows() {
        return Order.getOrderByAmountRows(customerArray);
    }

    public boolean deleteOrder(Order order) {
        return Order.deleteOrder(customerArray, order);
    }

}

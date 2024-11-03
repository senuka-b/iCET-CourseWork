class CustomerCollection {
    private Customer[] customerArray = new Customer[0];

    private int orderCount = 0;

    CustomerCollection() {
        // --- TESTING ---


        customerArray = Customer.placeOrder(customerArray, new Order(++orderCount, "xs", 10), "0705532339"); // 6000
        customerArray = Customer.placeOrder(customerArray, new Order(++orderCount, "xs", 10), "0705532339"); // 6000
        customerArray = Customer.placeOrder(customerArray, new Order(++orderCount, "m", 20), "0705532339"); // 18000
        customerArray = Customer.placeOrder(customerArray, new Order(++orderCount, "l", 40), "0705532339"); // 40000 -> 70000

        customerArray = Customer.placeOrder(customerArray, new Order(++orderCount, "xxl", 100), "0111111111"); // 120000
        customerArray = Customer.placeOrder(customerArray, new Order(++orderCount, "m", 5), "0111111111"); // 4500 -> 124500

        customerArray = Customer.placeOrder(customerArray, new Order(++orderCount, "s", 30), "0222222222"); // 24000
        customerArray = Customer.placeOrder(customerArray, new Order(++orderCount, "xs", 50), "0222222222"); // 30000 -> 54000
        

    }

    public Customer[] getCustomers() {
        return customerArray;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public boolean placeOrder(String customerID, String tSize, int qty) {
        Order newOrder = new Order(++orderCount, tSize, qty);

        customerArray = Customer.placeOrder(customerArray, newOrder, customerID);
        return true;
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

}

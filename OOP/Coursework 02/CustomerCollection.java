class CustomerCollection {
    private Customer[] customerArray = new Customer[0];

    private int orderCount = 0;

    public int getOrderCount() {
        return orderCount;
    }

    public boolean placeOrder(String customerID, String tSize, int qty) {
        Order newOrder = new Order(++orderCount, tSize, qty);

        customerArray = Customer.placeOrder(customerArray, newOrder, customerID);
        return true;
    }


}

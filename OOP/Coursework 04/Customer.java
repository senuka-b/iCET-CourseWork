

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
   
    public String getCustomerID() {
        return this.customerID;
    }

    public Order[] getOrders() {
        return orders;
    }

   
}

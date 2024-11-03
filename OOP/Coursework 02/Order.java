class Order {

    private static String[] sizes = {"xs", "s", "m", "l", "xl", "xxl"};

    private static final int processing = 0;
    private static final int delievering = 1;
    private static final int delievered = 2;

    private int orderNumber;

    private String tSize;
    private int qty;

    private int status; // processing by default

    Order(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    Order(int orderNumber, String tSize, int qty) {
        this.orderNumber = orderNumber;
        this.tSize = tSize;
        this.qty = qty;

        this.status = processing;

    }

    public String getStatuString() {
        switch (status) {
            case processing:
                return "processing";

            case delievering: 
                return "delievering";

            case delievered:
                return "delievered";

            default:
                return "";
        }
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public String getTSize() {
        return this.tSize;
    }

    public static Order getOrderByID(String orderID, Customer[] customers) {
        int orderNumber = Integer.parseInt(orderID.substring(4));

        for (Customer customer : customers) {
            for (Order order : customer.getOrders()) {
                if (order.orderNumber == orderNumber) {
                    return order;
                }
            }
        }

        return new Order(-1);
    }


    public static boolean isExists(Customer[] customers, String orderID) {

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

    

    public int getQuantity() {
        return qty;
    }

    public int getQuantity(int tSizeIndex) {
        if (sizes[tSizeIndex].equals(this.tSize)) {
            return qty;
        }

        return 0;
    }

    public static String[] getSizeArray() {
        return sizes;
    }

    public static double calculateAmount(String tSize, int qty) {
        return new Order(0, tSize, qty).calculateAmount();
    }

    public double calculateAmount() {

        double unit_price = 0;

        switch (tSize.toLowerCase()) {
            case "xs":
                unit_price = 600;
                break;

            case "s":
                unit_price = 800;
                break;

            case "m":
                unit_price = 900;
                break;

            case "l":
                unit_price = 1000;
                break;

            case "xl":
                unit_price = 1100;
                break;

            case "xxl":
                unit_price = 1200;
                break;
            
        }
        
        return unit_price * qty;
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

    public String createOrderString() {
        
        return String.format("ODR#%06d", orderNumber);
    }

    public static String createOrderString(String orderNumber) {

        return String.format("ODR#%06d", Integer.parseInt(orderNumber));
    }

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

    private static String[][] getQuantityRows(Customer[] customers, int sort_index) {
        String[][] data = new String[6][3];

        // [[total_qty, sum], ...]
        double[][] values = new double[6][2];

        for (int i = 0; i < customers.length; i++) {


            int[] quantity_data = Customer.getQuantityData(customers, customers[i].getCustomerID());

            for (int j = 0; j < quantity_data.length; j++) {
                    values[j][0] += quantity_data[j];
                    values[j][1] += calculateAmount(sizes[j], quantity_data[j]);
            }
            

        }

        
        for (int i = 0; i < values.length; i++) {
            data[i][0] = sizes[i];
            data[i][1] = String.format("%.0f", values[i][0]);
            data[i][2] = String.format("%.2f", values[i][1]);
        }

        Customer.sort(data, sort_index);

        return data;
    }

    public static String[][] getOrdersCategorizedByQTYRows(Customer[] customers) {
        return getQuantityRows(customers, 1);

    }

    public static String[][] getOrdersCategorizedByAmountRows(Customer[] customers) {
        return getQuantityRows(customers, 2);
    }

    private static String[][] getOrderData(Customer[] customers, int sort_index) {

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
                data[data.length - 1][1] = Customer.getCustomerByOrder(order, customers).getCustomerID();
                data[data.length - 1][2] = order.getTSize();
                data[data.length - 1][3] = String.format("%d", order.getQuantity());
                data[data.length - 1][4] = String.format("%.2f",order.calculateAmount());
                data[data.length - 1][5] = order.getStatuString();        
               

            }
       }


        Customer.sort(data, sort_index);

        for (int i = 0; i < data.length; i++) {
            data[i][0] = Order.createOrderString(data[i][0]);
              
        }

        return data;
    }

    public static String[][] getAllOrderRows(Customer[] customers) {
        return getOrderData(customers, 0); // sorted by order number
    }

    public static String[][] getOrderByAmountRows(Customer[] customers) {
        return getOrderData(customers, 4);
    }

    


}

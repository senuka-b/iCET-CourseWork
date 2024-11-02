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


}

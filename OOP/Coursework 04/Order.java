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

    Order(int orderNumber, String tSize, int qty, int status) {
        this.orderNumber = orderNumber;
        this.tSize = tSize;
        this.qty = qty;

        this.status = status;

    }

    public String toString() {
        return String.format("%s,%s,%d,%d",createOrderString(), this.tSize, this.qty, this.status);
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String createOrderString() {
        
        return String.format("ODR#%06d", orderNumber);
    }

}

class Order {

    private static String[] sizes = {"xs", "s", "m", "l", "xl", "xxl"};

    private static final int processing = 0;
    private static final int delievering = 1;
    private static final int delievered = 2;

    private int orderNumber;

    private String tSize;
    private int qty;

    private int status;

    Order(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    Order(int orderNumber, String tSize, int qty) {
        this.orderNumber = orderNumber;
        this.tSize = tSize;
        this.qty = qty;

        this.status = processing;

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


    public void validateQty() {

        System.out.print("\tEnter Quantity : ");
        int quantity = ConsoleWriter.getIntegerInput();

        if (quantity > 0) {

            System.out.println();

            this.qty = quantity;
            return;
        }

        
        System.out.print("\033[0A");
        System.out.print("\033[0J");

        validateQty();
    }

    public void validateTSize() {

        System.out.print("\tEnter T-Shirt Size (XS/S/M/L/XL/XXL) : ");
        String tSize = ConsoleWriter.getStringInput();

        switch (tSize.toLowerCase()) {
            case "xs":
            case "s":
            case "m":
            case "l":
            case "xl":
            case "xxl":
                break;
        
            default:
                
                System.out.print("\033[0A");
                System.out.print("\033[0J");

                validateTSize();
            
        }

        this.tSize = tSize.toLowerCase();

    }

    public String createOrderString() {
        
        int length = getOrderNumberLength();

        String orderString = "";
        while (orderString.length() != 5 - length) {
            orderString += "0";
        }

        orderString += Integer.toString(orderNumber);

        return "ODR#"+orderString;
    }

    private int getOrderNumberLength() {
       
        int num = orderNumber;
        int length = 0;

        do {
            length++;
        } while ((num/=10) != 0);

        return length;

    }

}

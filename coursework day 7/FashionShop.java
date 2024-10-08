import java.util.Arrays;
import java.util.Scanner;

public class FashionShop {

    public static int order_count = 0;

    public static int[] orders = new int[0];
    public static String[] customers = new String[0];
    public static String[] tsizes = new String[0];
    public static int[] qty = new int[0];
    public static int[] statuses = new int[0];

    public static final int processing = 0;
    public static final int delievering = 1;
    public static final int delievered = 2;

    public static Scanner input = new Scanner(System.in);

    public static boolean yesNoChoice(String text) {

        System.out.print("\n\n\t" + text);
        char choice = input.next().toLowerCase().charAt(0);

        return choice == 'y' ? true : false;

    }

    public static int getIntegerLength(int num) {
       
        int length = 0;
        
        do {
            length++;
        } while ((num/=10) != 0);


        return length;

        
    }

    public static String validatePhoneNumber(boolean searchCustomer) {


        System.out.print("\n\n\tEnter Customer Phone Number : ");
        String phoneNumber = input.next();
        
        if (phoneNumber.length() == 10 && phoneNumber.charAt(0) == '0' ) {
           
            return phoneNumber;
        }

        return "invalid";
    }

    public static String validatePhoneNumber() {


        System.out.print("\tEnter Customer Phone Number : ");
        String phoneNumber = input.next();
        
        if (phoneNumber.length() == 10 && phoneNumber.charAt(0) == '0' ) {
           
            return phoneNumber;
        }

        System.out.println("\n\tInvalid phone number! Try again.");

        boolean choice = yesNoChoice("Do you want to enter phone number again (y/n) : ");


        if (choice) {

            System.out.print("\033[6A");
            System.out.print("\033[0J");

            return validatePhoneNumber();

        } 

        return "none";


    }

    public static String validateTSize() {

        System.out.print("\tEnter T-Shirt Size (XS/S/M/L/XL/XXL) : ");
        String tSize = input.next();

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

                return validateTSize();
            
        }

        return tSize.toLowerCase();

    }

    public static int validateQty() {

        System.out.print("\tEnter Quantity : ");
        int quantity = input.nextInt();

        if (quantity > 0) return quantity;

        
        System.out.print("\033[0A");
        System.out.print("\033[0J");

        return validateQty();
    }

    public static double calculateAmount(String tSize, int quantity) {

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
        
        return unit_price * quantity;
    }

    public static String createOrderString(int orderID) {
        
        int length = getIntegerLength(orderID);

        String orderString = "";
        while (orderString.length() != 5 - length) {
            orderString += "0";
        }

        orderString += Integer.toString(orderID);

        return "ODR#"+orderString;
    }

    public static int[] extendArray(int[] array, int final_value) {
        int[] temp_o = new int[array.length+1];


        for (int i = 0; i < array.length; i++) {
            temp_o[i] = array[i];

        }

   
        temp_o[temp_o.length-1] = final_value;

        return temp_o;
    }

    public static String[] extendArray(String[] array, String final_value) {
        String[] temp_s = new String[array.length+1];

        for (int i = 0; i < array.length; i++) {
            temp_s[i] = array[i];
        }

        temp_s[temp_s.length - 1] = final_value;

        return temp_s;
    }


    public static void createOrder(String tSize, int quantity) {
        
        // orders
        orders = extendArray(orders, order_count);

        // Tsizes
        tsizes = extendArray(tsizes, tSize);

        // qty
        qty = extendArray(qty, quantity);

        // status
        statuses = extendArray(statuses, processing);

    }   

   public static void createCustomer(String phoneNumber) {
        
        customers = extendArray(customers, phoneNumber);

   }

    public static void placeOrder() {
 
        clearConsole();

        String place_order_string = "\r\n" +
            "      _____  _      " +
            "             ____   " +
            "       _            " +
            "\r\n" +
            "     |  __ \\| |    " +
            "             / __ \\" +
            "        | |         " +
            "  \r\n" +
            "     | |__) | | __ _" +
            "  ___ ___  | |  | |_" +
            " __ __| | ___ _ __  " +
            "\r\n" +
            "     |  ___/| |/ _` " +
            "|/ __/ _ \\ | |  | |" +
            " \'__/ _` |/ _ \\ \'" +
            "__| \r\n" +
            "     | |    | | (_| " +
            "| (_|  __/ | |__| | " +
            "| | (_| |  __/ |    " +
            "\r\n" +
            "     |_|    |_|\\__," +
            "_|\\___\\___|  \\___" +
            "_/|_|  \\__,_|\\___|" +
            "_|    \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "\r\n" +
            "                    " +
            "                    " +
            "                    " +
            "\r\n";
        System.out.println(place_order_string);
        System.out.println("     _____________________________________________________\n\n");

        System.out.println("\tOrder ID : " + createOrderString(orders.length+1));

        System.out.println();

        String phoneNumber = validatePhoneNumber();

        System.out.println();
        
        if (phoneNumber == "none") return;

        String tSize = validateTSize();

        System.out.println();

        int qty = validateQty();

        System.out.println();

        System.out.println("\tAmount : " + calculateAmount(tSize, qty));

        boolean choice = yesNoChoice("Do you want to place this order? (y/n)");

        if (choice) {
            
            order_count++;

            createOrder(tSize, qty);

            createCustomer(phoneNumber);

            System.out.println("\n\n\t\tOrder placed!");
        }

        choice = yesNoChoice("Do you want to place another order? (y/n)");

        if (choice) {
            placeOrder();
        }

    }

    public static int searchIndex(String[] array, String value) {
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (value.equals(array[i])) return i;
        }

        return index;
    }

    public static int searchIndex(int[] array, int value) {
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) return i;
        }

        return index;
    }

    public static int[] getCustomerReportData(String phone_number) {

        String[] sizes = {"xs", "s", "m", "l", "xl", "xxl"};
        int[] data = new int[6];

        for (int i = 0; i < customers.length; i++) {
            
            if (phone_number.equals(customers[i])) {
                int index = searchIndex(sizes, tsizes[i]);

                data[index] += qty[i];
                
            }

        }

        return data;

    }

    public static void printCustomerReport(int[] data) {
        String[] sizes = {"XS", "S", "M", "L", "XL", "XXL"};

        // System.out.printf("%s","\t\t+----------+---------+---------------+");
		// System.out.printf("%s","\n\t\t|   Size   |  QTY    |    Amount     |");
		// System.out.printf("%s","\n\t\t+----------+---------+---------------+");	

        // double total = 0;
        // for (int i = 0; i < data.length; i++){
		// 	System.out.printf("%s%3s%s%3s%s%8s%s","\n\t\t|    ",sizes[i],"   |  ",data[i],"    |    ",calculateAmount(sizes[i], data[i]),"   | ");
        //     total += calculateAmount(sizes[i], data[i]);
        // }


        String[][] customerReport = new String[8][3];

        customerReport[0] = new String[]{"Sizes", "QTY", "Amount"};

        double total = 0;
        for (int i = 1; i < customerReport.length-1; i++) {
            for (int j = 0; j < customerReport[i].length; j++) {
                String value = "";
                switch (j) {
                    case 0:
                        value = sizes[i-1];
                        break;
                
                    case 1:
                        value = String.format("%d", data[i-1]);
                        break;

                    case 2:
                        value = String.format("%.2f", calculateAmount(sizes[i-1], data[i-1]));
                        total += calculateAmount(sizes[i-1], data[i-1]);
                        break;
                }

                customerReport[i][j] = value;
            }
        }

        customerReport[customerReport.length-1] = new String[]{"Total Amount", String.format("%.2f", total)};

        printTable(customerReport, true);


         
    }

    public static void printTable(String[][] rows, boolean lastRowLong) {

        // Find maximum length string in each column -> Make space according to that

        int[] max_length_array = new int[rows[0].length+1];
        
        for (int i = 0; i < rows[0].length; i++) {
			int max_length = 0;

            for (int j = 0; j < rows.length; j++) {

                if (lastRowLong == true && i == rows[0].length-1 && j == rows.length-1) { // Final column final row final element
                    int last_row_length = rows[j].length;
                    max_length = rows[j][last_row_length-1].length();
                    break;
                }


                if (rows[j][i].length() > max_length) {
					max_length = rows[j][i].length();

				}
            }

			max_length_array[i] = max_length+4;
        }


		// Header line
		
        for (int i = 0; i < max_length_array.length; i++) {

            if (i == 0) System.out.print("\t\t");

            System.out.print("+");

			for (int j = 0; j < max_length_array[i]; j++) {
				System.out.print("-");
			}

        }

		System.out.println();

		// Header values

		for (int i = 0; i < rows[0].length; i++) {
            if (i == 0) System.out.print("\t\t");
		
			if (rows[0][i].length()+4 == max_length_array[i]) {
				System.out.print("|  "+rows[0][i] + "  ");

			} else {
				System.out.print("| "+rows[0][i]);

				for (int j = 0; j < max_length_array[i]-(rows[0][i].length()+1); j++) {
					System.out.print(" ");
				}

			}

			
		}

		System.out.println("|");

		// Header end line

		for (int i = 0; i < max_length_array.length; i++) {
            if (i == 0) System.out.print("\t\t");

            System.out.print("+");

			for (int j = 0; j < max_length_array[i]; j++) {
				System.out.print("-");
			}

        }

		System.out.println();

		// Data

		for (int i = 1; i < rows.length; i++) {
            System.out.print("\t\t");

            if (lastRowLong == true && i == rows.length-1) { // Skip last row
                break;
            }

			for (int j = 0; j < rows[i].length; j++) {
				System.out.print("| " + rows[i][j]);

				for (int k = 0; k < max_length_array[j] - (rows[i][j].length() + 1); k++) {
					System.out.print(" ");
				}

			}
			System.out.println("|");
		}

		// Data end line

		for (int i = 0; i < max_length_array.length; i++) {
            System.out.print("+");

			for (int j = 0; j < max_length_array[i]; j++) {
				System.out.print("-");
			}

        }


        System.out.println();

        
        if (lastRowLong) {

            // Last row values

            int space = 0;
            int index = 0;



            for (int i = 0; i < max_length_array.length-2; i++) {
                space += max_length_array[i];
                index = i;
            }

            int space_copy = space; // For last row end line

            int remaining_space = 0;
            for (int i = index+1; i < max_length_array.length; i++) {
                remaining_space += max_length_array[i];
            }

            System.out.print("\t\t");

            for (int i = 0; i < rows[rows.length-1].length; i++) {
                System.out.print("|  " + rows[rows.length-1][i]);

                for (int j = 0; j < space - (rows[rows.length-1][i].length()+1)  ; j++) {
                    System.out.print(" ");
                }

                space = remaining_space-1;
            }

            System.out.println("|");

            // Last row end line
            space = space_copy;

            System.out.print("\t\t");
            for (int i = 0; i < rows[rows.length-1].length+1; i++) {
                System.out.print("+");

                for (int j = 0; j < space+1; j++) {
                    if (i == rows[rows.length-1].length) break;

                    System.out.print("-");
                }

              
                space = remaining_space - 1;
          
            }


        }

        System.out.println();
		
    }

    public static void searchCustomer() {
        clearConsole();

        String search_customer_string = "\r\n" +
            "       _____        " +
            "             _      " +
            "  _____          _  " +
            "                    " +
            "      \r\n" +
            "      / ____|       " +
            "            | |     " +
            " / ____|        | | " +
            "                    " +
            "      \r\n" +
            "     | (___   ___  _" +
            "_ _ _ __ ___| |__   " +
            "| |    _   _ ___| |_" +
            " ___  _ __ ___   ___" +
            " _ __ \r\n" +
            "      \\___ \\ / _ " +
            "\\/ _` | \'__/ __| " +
            "\'_ \\  | |   | | | " +
            "/ __| __/ _ \\| \'_ " +
            "` _ \\ / _ \\ \'__|" +
            "\r\n" +
            "      ____) |  __/ (" +
            "_| | | | (__| | | | " +
            "| |___| |_| \\__ \\ " +
            "|| (_) | | | | | |  " +
            "__/ |   \r\n" +
            "     |_____/ \\___|" +
            "\\__,_|_|  \\___|_| " +
            "|_|  \\_____\\__,_|_" +
            "__/\\__\\___/|_| |_|" +
            " |_|\\___|_|   \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "      \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "      \r\n";
            
		System.out.println(search_customer_string);

		System.out.println("    _____________________________________________________________________\n");

        String phone_number = validatePhoneNumber(true); // searchCustomer phone validation method

        System.out.println();

        if (phone_number != "invalid") {

            int[] customer_quantity_data = getCustomerReportData(phone_number);

            int count = 0;
            for (int i = 0; i < customer_quantity_data.length; i++) {
                if (customer_quantity_data[i] == 0) {
                    count++;
                }
            }

            if (count != customer_quantity_data.length) {
                printCustomerReport(customer_quantity_data);
            } else {
                
                // No customer
                System.out.println("\n\n\tInvalid input ! \n");

            }


        } else {
            System.out.println("\n\n\tInvalid input ! \n");
        }

        boolean choice = yesNoChoice("Do you want to search another customer report?  (y/n) : ");

        if (choice) {
            searchCustomer();
        }


    }
 
    public static boolean isExists(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                return true;
            }
        }

        return false;
    }

    public static int validateOrderID(String orderIDString) {

        if (orderIDString.length() == 9) {
            if (!(orderIDString.charAt(0) == 'o' &&
                orderIDString.charAt(1) == 'd' &&
                orderIDString.charAt(2) == 'r' &&
                orderIDString.charAt(3) == '#')) {

                return -1;
            }
        } else {
            return -1;
        }

        String num_string = "";
        for (int i = 0; i < orderIDString.length(); i++) {
            if (orderIDString.charAt(i) == '#') {

                for (int j = i+1; j < orderIDString.length(); j++) {

                    num_string += Character.toString(orderIDString.charAt(j));

                }

                break;
            }   
        }

        int parsed_id = Integer.parseInt(num_string);
        if (isExists(orders, parsed_id)) {
            return parsed_id;
        }

        return -1;

    }

    public static String getStatus(int num) {
        String value = "";

        switch (num) {
            case 0:
                value = "processing";
                break;
        
            case 1:
                value = "delievering";

                break;

            case 2:
                value = "delievered";

                break;

            default:
                break;
        }

        return value;
    }

    public static void displayOrder(int orderID) {
        System.out.println("\n");

        String phoneNumber, size;
        phoneNumber = size = "";
        int quantity, status;
        double amount;
        amount = quantity = status = 0;


        for (int i = 0; i < orders.length; i++) {
            if (orderID == orders[i]) {
                phoneNumber = customers[i];
                size = tsizes[i];
                status = statuses[i];
                quantity = qty[i];
                amount = calculateAmount(tsizes[i], quantity);

                break;
            }
        }

        System.out.println("\tPhone Number    : " + phoneNumber);
        System.out.println("\tSize\t\t: " + size);
        System.out.println("\tQty\t\t: " + quantity);
        System.out.println("\tAmount\t\t: " + amount);
        System.out.println("\tStatus\t\t: " + getStatus(status));


    }

    public static void searchOrder() {
        clearConsole();

        String search_order_string = "\r\n" +
            "       _____        " +
            "             _      " +
            "  ____          _   " +
            "        \r\n" +
            "      / ____|       " +
            "            | |     " +
            " / __ \\        | | " +
            "         \r\n" +
            "     | (___   ___  _" +
            "_ _ _ __ ___| |__   " +
            "| |  | |_ __ __| | _" +
            "__ _ __ \r\n" +
            "      \\___ \\ / _ " +
            "\\/ _` | \'__/ __| " +
            "\'_ \\  | |  | | \'_" +
            "_/ _` |/ _ \\ \'__|" +
            "\r\n" +
            "      ____) |  __/ (" +
            "_| | | | (__| | | | " +
            "| |__| | | | (_| |  " +
            "__/ |   \r\n" +
            "     |_____/ \\___|" +
            "\\__,_|_|  \\___|_| " +
            "|_|  \\____/|_|  \\_" +
            "_,_|\\___|_|   \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "        \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "        \r\n";

        System.out.print(search_order_string);

        System.out.print("   _________________________________________________________________\n\n");


        System.out.print("\tEnter Order ID : ");
        int orderID = validateOrderID(input.next().toLowerCase());

        if (orderID == -1) {
            System.out.println("\n\t Invalid ID ! \n");
        } else {
            displayOrder(orderID);
        }

        boolean choice = yesNoChoice("Do you want to search another order? (y/n) : ");
        
        if (choice) {
            searchOrder();
        }
    }

    public static int[] shrinkArray(int[] array, int value) {
        int index = searchIndex(array, value);

        int[] temp = new int[array.length-1];

        for (int i = 0; i < index; i++) {
            temp[i] = array[i];
        }

        for (int i = index; i < temp.length; i++) {
            temp[i] = array[i+1];
        }


        return temp;

    }

    public static String[] shrinkArray(String[] array, String value) {
        int index = searchIndex(array, value);

        String[] temp = new String[array.length-1];

        for (int i = 0; i < index; i++) {
            temp[i] = array[i];
        }

        for (int i = index; i < temp.length; i++) {
            temp[i] = array[i+1];
        }


        return temp;

    }

    public static void deleteOrderData(int orderID) {
        int index = searchIndex(orders, orderID);

        orders = shrinkArray(orders, orderID);

        customers = shrinkArray(customers, customers[index]);

        tsizes = shrinkArray(tsizes, tsizes[index]);

        qty = shrinkArray(qty, qty[index]);

        statuses = shrinkArray(statuses, statuses[index]);


    }

    public static void deleteOrder() {
        clearConsole();

        						
        String delete_order_string = "\r\n" +
            "   _____       _    " +
            "  _          ____   " +
            "       _           " +
            "\r\n" +
            "  |  __ \\     | |  " +
            "  | |        / __ \\" +
            "        | |         " +
            " \r\n" +
            "  | |  | | ___| | __" +
            "_| |_ ___  | |  | |_" +
            " __ __| | ___ _ __ " +
            "\r\n" +
            "  | |  | |/ _ \\ |/ " +
            "_ \\ __/ _ \\ | |  |" +
            " | \'__/ _` |/ _ \\ " +
            "\'__|\r\n" +
            "  | |__| |  __/ |  _" +
            "_/ ||  __/ | |__| | " +
            "| | (_| |  __/ |   " +
            "\r\n" +
            "  |_____/ \\___|_|\\" +
            "___|\\__\\___|  \\__" +
            "__/|_|  \\__,_|\\___" +
            "|_|   \r\n" +
            "                    " +
            "                    " +
            "                   " +
            "\r\n" +
            "                    " +
            "                    " +
            "                   " +
            "\r\n";
                                    

        System.out.print(delete_order_string);

        System.out.print("   _________________________________________________________________\n\n");


        System.out.print("\tEnter Order ID : ");
        int orderID = validateOrderID(input.next().toLowerCase());

        if (orderID == -1) {
            System.out.println("\n\t Invalid ID ! \n");
        } else {
            displayOrder(orderID);

            boolean choice = yesNoChoice("Do you want to delete this order? (y/n) : ");

            if (choice) {
                deleteOrderData(orderID);

                System.out.println("\n\t\tOrder Deleted !\n");
            }
        }

        

        boolean choice = yesNoChoice("Do you want to delete another order? (y/n) : ");
        
        if (choice) {
            deleteOrder();
        }
    }    

    public static void viewCustomerReports() {

    }

    public static void viewReports() {
        clearConsole();

        String view_reports_string = "\r\n" +
            "             _____  " +
            "                    " +
            " _       \r\n" +
            "            |  __ \\" +
            "                    " +
            " | |      \r\n" +
            "            | |__) |" +
            "___ _ __   ___  _ __" +
            "| |_ ___ \r\n" +
            "            |  _  //" +
            " _ \\ \'_ \\ / _ \\|" +
            " \'__| __/ __|\r\n" +
            "            | | \\ " +
            "\\  __/ |_) | (_) | " +
            "|  | |_\\__ \\\r\n" +
            "            |_|  \\_" +
            "\\___| .__/ \\___/|_" +
            "|   \\__|___/\r\n" +
            "                    " +
            "   | |              " +
            "         \r\n" +
            "                    " +
            "   |_|              " +
            "         \r";


        System.out.println(view_reports_string);

        System.out.println("\t    _______________________________________\n");

        System.out.println("\t\t[1] Customer Reports\n");
        System.out.println("\t\t[2] Item Reports\n");
        System.out.println("\t\t[3] Orders Reports\n");

        System.out.print("\tEnter option : ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                viewCustomerReports();
                break;

            case 2:
                break;

            case 3:
                break;
        
            default:
                return;
        }


        viewReports();

    }

    public static void homePage() {
        clearConsole();

        
        String fashion_shop_text = "\r\n" +
            "             /$$$$$$" +
            "$$                 /" +
            "$$       /$$        " +
            "                    " +
            "/$$$$$$  /$$        " +
            "                  \r" +
            "\n" +
            "            | $$____" +
            "_/                | " +
            "$$      |__/        " +
            "                   /" +
            "$$__  $$| $$        " +
            "                  \r" +
            "\n" +
            "            | $$    " +
            "/$$$$$$   /$$$$$$$| " +
            "$$$$$$$  /$$  /$$$$$" +
            "$  /$$$$$$$       | " +
            "$$  \\__/| $$$$$$$  " +
            " /$$$$$$   /$$$$$$ " +
            "\r\n" +
            "            | $$$$$|" +
            "____  $$ /$$_____/| " +
            "$$__  $$| $$ /$$__  " +
            "$$| $$__  $$      | " +
            " $$$$$$ | $$__  $$ /" +
            "$$__  $$ /$$__  $$\r" +
            "\n" +
            "            | $$__/ " +
            "/$$$$$$$|  $$$$$$ | " +
            "$$  \\ $$| $$| $$  " +
            "\\ $$| $$  \\ $$    " +
            "   \\____  $$| $$  " +
            "\\ $$| $$  \\ $$| $$" +
            "  \\ $$\r\n" +
            "            | $$   /" +
            "$$__  $$ \\____  $$|" +
            " $$  | $$| $$| $$  |" +
            " $$| $$  | $$       " +
            "/$$  \\ $$| $$  | $$" +
            "| $$  | $$| $$  | $$" +
            "\r\n" +
            "            | $$  | " +
            " $$$$$$$ /$$$$$$$/| " +
            "$$  | $$| $$|  $$$$$" +
            "$/| $$  | $$      | " +
            " $$$$$$/| $$  | $$| " +
            " $$$$$$/| $$$$$$$/\r" +
            "\n" +
            "            |__/   " +
            "\\_______/|_______/ " +
            "|__/  |__/|__/ \\___" +
            "___/ |__/  |__/     " +
            "  \\______/ |__/  |_" +
            "_/ \\______/ | $$___" +
            "_/ \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "        | $$      \r" +
            "\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "        | $$      \r" +
            "\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "        |__/      \r" +
            "\n";

    

        System.out.println(fashion_shop_text);
             
        System.out.println("\t    __________________________________________________________________________________________________________");
        
        System.out.println("\n\t\t[1] Place Order                                         [2] Search Customer\n");
        System.out.println("\t\t[3] Search Order                                        [4] View Reports\n");
        System.out.println("\t\t[5] Set Order Status                                    [6] Delete Order\n");
        
        System.out.print("\n\t\tInput Option : ");
        int choice = input.nextInt();
        
        switch (choice) {
            case 1:
                placeOrder();
                
                break;
            case 2:
                searchCustomer();    

                break;
            case 3:
                searchOrder();

                break;
            case 4:
                viewReports();
                
                break;
            case 5:
                
                break;
            case 6:
                deleteOrder();
                break;
            
            default:
                return;
   
        }

    homePage();
    
    }

    public static void main(String args[]) {

        homePage();

        clearConsole();

        System.out.println("Goodbye!");

    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
                if (os.contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
        } catch (final Exception e) {
                e.printStackTrace();
                // Handle any exceptions.
        }
    }
}

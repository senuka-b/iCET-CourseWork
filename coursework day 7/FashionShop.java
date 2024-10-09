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

    public static String[] sizes = {"XS", "S", "M", "L", "XL", "XXL"};

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

    public static String[][] extendArray(String[][] array, int sub_length) {
        String[][] temp_i = new String[array.length+1][sub_length];

        for (int i = 0; i < array.length; i++) {
            temp_i[i] = array[i];
        }

        return temp_i;
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
            if (value.toLowerCase().equals(array[i].toLowerCase())) return i;
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

    public static int[] getQuantityData(String phone_number) {

        
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

            // -------------------

            for (int j = 0; j < rows[i].length; j++) {
				System.out.print("| ");

				for (int k = 0; k < max_length_array[j]-1; k++) {
					System.out.print(" ");
				}


			}

            System.out.println("|");

            // --------------------
            System.out.print("\t\t");


			for (int j = 0; j < rows[i].length; j++) {
				System.out.print("| " + rows[i][j]);

				for (int k = 0; k < max_length_array[j] - (rows[i][j].length() + 1); k++) {
					System.out.print(" ");
				}

			}
			System.out.println("|");
		}

		// Data end line

        if (lastRowLong == false) {
            System.out.print("\t\t");

        }

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

            int[] customer_quantity_data = getQuantityData(phone_number);

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

    public static boolean isExists(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (value.equals(array[i])) {
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

    public static int getSum(int[] data) {
        int total = 0;
        for (int i = 0; i < data.length; i++) {
            total += data[i];
        }

        return total;
    }

    public static double getTotalAmount(int[] quantity_data) {
        double total = 0;
        for (int i = 0; i < quantity_data.length; i++) {
            total += calculateAmount(sizes[i], quantity_data[i]);
        }

        return total;
    }

    public static String[][] getCustomerData() {
        
        String[] temp_customer = new String[0];

        // [[phone, quantity_sum, total_amount], ...]
        String[][] data = new String[1][3];

        data[0] = new String[]{"Customer ID", "All QTY", "Amount"};

        int index = 1;
        for (int i = 0; i < customers.length; i++) {
            if (isExists(temp_customer, customers[i]) == false) {
                temp_customer = extendArray(temp_customer, customers[i]);

                int[] quantity_data = getQuantityData(customers[i]);

                data  = extendArray(data, 3);

                data[index][0] = customers[i];
                data[index][1] = String.format("%d", getSum(quantity_data));
                data[index][2] = String.format("%.2f", getTotalAmount(quantity_data) );
                
                index++;
            }
        }

        return data;
    }

    public static void sort(String[][] data, int sort_index) {

        for(int i = data.length-1; i>0; i--){
			for(int j=1; j<i; j++){

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

    public static boolean displayBestInCustomers() {
        clearConsole();

        String best_in_customers = "\r\n" +
            "             ____   " +
            "         _     _____" +
            "          _____     " +
            "     _              " +
            "                  \r" +
            "\n" +
            "            |  _ \\ " +
            "         | |   |_   " +
            "_|        / ____|   " +
            "     | |            " +
            "                   " +
            "\r\n" +
            "            | |_) | " +
            "___  ___| |_    | | " +
            " _ __   | |    _   _" +
            " ___| |_ ___  _ __ _" +
            "__   ___ _ __ ___ \r" +
            "\n" +
            "            |  _ < /" +
            " _ \\/ __| __|   | |" +
            " | \'_ \\  | |   | |" +
            " | / __| __/ _ \\| " +
            "\'_ ` _ \\ / _ \\ \'" +
            "__/ __|\r\n" +
            "            | |_) | " +
            " __/\\__ \\ |_   _| " +
            "|_| | | | | |___| |_" +
            "| \\__ \\ || (_) | |" +
            " | | | |  __/ |  \\_" +
            "_ \\\r\n" +
            "            |____/ " +
            "\\___||___/\\__| |__" +
            "___|_| |_|  \\_____" +
            "\\__,_|___/\\__\\___" +
            "/|_| |_| |_|\\___|_|" +
            "  |___/\r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "                  \r" +
            "\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "                  \r";

        System.out.println(best_in_customers);

        System.out.println("\t    ______________________________________________________________________________________\n");

        String[][] best_customer_data = getCustomerData();

        sort(best_customer_data, 2);

        printTable(best_customer_data, false);

        System.out.print("\tTo access the Main Menu, please enter 0 : ");
        int choice = input.nextInt();

        if (choice == 0) return true;

        System.out.print("\033[0A");
        System.out.print("\033[0J");

        return displayBestInCustomers();


    }

    public static boolean displayCustomers() {
        clearConsole();

        String view_customers_string = "\r\n" +
            "            __      " +
            "___                 " +
            " _____          _   " +
            "                    " +
            "         \r\n" +
            "            \\ \\   " +
            " / (_)              " +
            "  / ____|        | |" +
            "                    " +
            "           \r\n" +
            "             \\ \\  " +
            "/ / _  _____      __" +
            " | |    _   _ ___| |" +
            "_ ___  _ __ ___   __" +
            "_ _ __ ___ \r\n" +
            "              \\ \\/" +
            " / | |/ _ \\ \\ /\\ " +
            "/ / | |   | | | / __" +
            "| __/ _ \\| \'_ ` _ " +
            "\\ / _ \\ \'__/ __|" +
            "\r\n" +
            "               \\  /" +
            "  | |  __/\\ V  V / " +
            " | |___| |_| \\__ \\" +
            " || (_) | | | | | | " +
            " __/ |  \\__ \\\r\n" +
            "                \\/ " +
            "  |_|\\___| \\_/\\_/" +
            "    \\_____\\__,_|__" +
            "_/\\__\\___/|_| |_| " +
            "|_|\\___|_|  |___/\r" +
            "\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "         \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "         \r";

        System.out.println(view_customers_string);

        System.out.println("\t    _____________________________________________________________________________\n");

        String[][] customer_data = getCustomerData();

        printTable(customer_data, false);

        System.out.print("\tTo access the Main Menu, please enter 0 : ");
        int choice = input.nextInt();

        if (choice == 0) return true;

        System.out.print("\033[0A");
        System.out.print("\033[0J");

        return displayCustomers();
        


    }

    public static String[][] getAllCustomerReportData() {

        // [[phone_num, xs, s, ..., total], ...]
        String[][] data = new String[1][8];

        data[0][0] = "Phone Number";

        for (int i = 0; i < sizes.length; i++) {
            data[0][i+1] = sizes[i];
        }

        data[0][7] = "Total";

        String[] temp_customer = new String[0];

        int index = 1;
        for (int i = 0; i < customers.length; i++) {
            if (isExists(temp_customer, customers[i]) == false) {
                temp_customer = extendArray(temp_customer, customers[i]);

                data = extendArray(data, 8);

                data[index][0] = customers[i];

                int[] quantity_data = getQuantityData(customers[i]);
                for (int j = 0; j < quantity_data.length; j++) {
                    data[index][j+1] = String.format("%d",quantity_data[j]);
                }

                data[index][7] = String.format("%.2f", getTotalAmount(quantity_data));

                index++;
            }
        }


        return data;

    }

    public static boolean allCustomerReport() {
        clearConsole();

        String all_customer_report_string = "\r\n" +
            "                    " +
            "  _ _    _____      " +
            "    _               " +
            "               _____" +
            "                    " +
            "   _   \r\n" +
            "                /\\ " +
            "  | | |  / ____|    " +
            "    | |             " +
            "               |  __" +
            " \\                 " +
            "    | |  \r\n" +
            "               /  \\" +
            "  | | | | |    _   _" +
            " ___| |_ ___  _ __ _" +
            "__   ___ _ __  | |__" +
            ") |___ _ __   ___  _" +
            " __| |_ \r\n" +
            "              / /\\ " +
            "\\ | | | | |   | | |" +
            " / __| __/ _ \\| \'_" +
            " ` _ \\ / _ \\ \'__|" +
            " |  _  // _ \\ \'_ " +
            "\\ / _ \\| \'__| __|" +
            "\r\n" +
            "             / ____ " +
            "\\| | | | |___| |_| " +
            "\\__ \\ || (_) | | |" +
            " | | |  __/ |    | |" +
            " \\ \\  __/ |_) | (_" +
            ") | |  | |_ \r\n" +
            "            /_/    " +
            "\\_\\_|_|  \\_____\\" +
            "__,_|___/\\__\\___/|" +
            "_| |_| |_|\\___|_|  " +
            "  |_|  \\_\\___| .__" +
            "/ \\___/|_|   \\__|" +
            "\r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "     | |            " +
            "       \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "     |_|            " +
            "       \r";

        System.out.println(all_customer_report_string);

        System.out.println("\t    _______________________________________________________________________________________________\n");


        String[][] all_customer_report_data = getAllCustomerReportData();

        printTable(all_customer_report_data, false);

        System.out.print("\tTo access the Main Menu, please enter 0 : ");
        int choice = input.nextInt();

        if (choice == 0) return true;

        System.out.print("\033[0A");
        System.out.print("\033[0J");

        return allCustomerReport();
    }

    public static boolean viewCustomerReports() {
        clearConsole();

        String view_customer_reports_string = "\r\n" +
            "              _____ " +
            "         _          " +
            "                    " +
            "_____               " +
            "        _       \r\n" +
            "             / ____|" +
            "        | |         " +
            "                   |" +
            "  __ \\             " +
            "        | |      \r" +
            "\n" +
            "            | |    _" +
            "   _ ___| |_ ___  _ " +
            "__ ___   ___ _ __  |" +
            " |__) |___ _ __   __" +
            "_  _ __| |_ ___ \r\n" +
            "            | |   | " +
            "| | / __| __/ _ \\| " +
            "\'_ ` _ \\ / _ \\ \'" +
            "__| |  _  // _ \\ \'" +
            "_ \\ / _ \\| \'__| _" +
            "_/ __|\r\n" +
            "            | |___| " +
            "|_| \\__ \\ || (_) |" +
            " | | | | |  __/ |   " +
            " | | \\ \\  __/ |_) " +
            "| (_) | |  | |_\\__ " +
            "\\\r\n" +
            "             \\_____" +
            "\\__,_|___/\\__\\___" +
            "/|_| |_| |_|\\___|_|" +
            "    |_|  \\_\\___| ." +
            "__/ \\___/|_|   \\__" +
            "|___/\r\n" +
            "                    " +
            "                    " +
            "                    " +
            "          | |       " +
            "                \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "          |_|       " +
            "                \r";

            System.out.println(view_customer_reports_string);
            
            System.out.println("\t    ____________________________________________________________________________________\n");

            System.out.println("\t\t[1] Best in Customers\n");
            System.out.println("\t\t[2] View Customers\n");
            System.out.println("\t\t[3] All Customer Report\n");

            System.out.print("\tEnter option : ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    return displayBestInCustomers();
                
                case 2:
                    return displayCustomers();

                case 3:
                    return allCustomerReport();
                    
            
                default:
                    System.out.print("\n\t\tInvalid Input !\n");

                    boolean yn = yesNoChoice("Do you want to enter an option again? (y/n) : ");

                    if (yn == false) {
                        return yn;
                    }
            }

            return viewCustomerReports();
        }   

    public static String[][] getSortedByData(String type) {
        String[][] data = new String[7][3];


        data[0] = new String[]{"Size", "QTY", "Total Amount"};

        // [[total_qty, sum], ...]
        double[][] values = new double[6][2];

        String[] temp_customer = new String[0];
        for (int i = 0; i < customers.length; i++) {
            if (isExists(temp_customer, customers[i]) == false) {
                temp_customer = extendArray(temp_customer, customers[i]);

                int[] quantity_data = getQuantityData(customers[i]);

                for (int j = 0; j < quantity_data.length; j++) {
                     values[j][0] += quantity_data[j];
                     values[j][1] += calculateAmount(sizes[j], quantity_data[j]);
                }
            }

        }

        
        for (int i = 0; i < values.length; i++) {
            data[i+1][0] = sizes[i];
            data[i+1][1] = String.format("%.0f", values[i][0]);
            data[i+1][2] = String.format("%.2f", values[i][1]);
        }

        sort(data, type == "qty" ? 1 : 2);

        return data;
    }


    public static boolean viewItemReportByAmount() {
        clearConsole();

        String sorted_by_amount_string = "\r\n" +
            "              _____ " +
            "           _        " +
            "   _   ____         " +
            "                    " +
            "                  _ " +
            "  \r\n" +
            "             / ____|" +
            "          | |       " +
            "  | | |  _ \\       " +
            "     /\\            " +
            "                   |" +
            " |  \r\n" +
            "            | (___  " +
            " ___  _ __| |_ ___  " +
            "__| | | |_) |_   _  " +
            "   /  \\   _ __ ___ " +
            "  ___  _   _ _ __ | " +
            "|_ \r\n" +
            "             \\___ " +
            "\\ / _ \\| \'__| __/" +
            " _ \\/ _` | |  _ <| " +
            "| | |   / /\\ \\ | " +
            "\'_ ` _ \\ / _ \\| |" +
            " | | \'_ \\| __|\r\n" +
            "             ____) |" +
            " (_) | |  | ||  __/ " +
            "(_| | | |_) | |_| | " +
            " / ____ \\| | | | | " +
            "| (_) | |_| | | | | " +
            "|_ \r\n" +
            "            |_____/ " +
            "\\___/|_|   \\__\\__" +
            "_|\\__,_| |____/ \\_" +
            "_, | /_/    \\_\\_| " +
            "|_| |_|\\___/ \\__,_" +
            "|_| |_|\\__|\r\n" +
            "                    " +
            "                    " +
            "              __/ | " +
            "                    " +
            "                    " +
            "  \r\n" +
            "                    " +
            "                    " +
            "             |___/  " +
            "                    " +
            "                    " +
            "  \r\n";

        System.out.println(sorted_by_amount_string);

        System.out.println("\t    ________________________________________________________________________\n");

        String[][] sorted_by_amount_data = getSortedByData("amount");

        printTable(sorted_by_amount_data, false);;


        System.out.print("\tTo access the Main Menu, please enter 0 : ");
        int choice = input.nextInt();

        if (choice == 0) return true;

        System.out.print("\033[0A");
        System.out.print("\033[0J");

        return viewItemReportByAmount();
    }

    public static boolean viewItemReportByQTY() {
        clearConsole();

        String sorted_by_qty_string = "\r\n" +
            "              _____ " +
            "           _        " +
            "   _   ____         " +
            "  ____ _________    " +
            " __\r\n" +
            "             / ____|" +
            "          | |       " +
            "  | | |  _ \\       " +
            "  / __ \\__   __\\ " +
            "\\   / /\r\n" +
            "            | (___  " +
            " ___  _ __| |_ ___  " +
            "__| | | |_) |_   _  " +
            "| |  | | | |   \\ \\" +
            "_/ / \r\n" +
            "             \\___ " +
            "\\ / _ \\| \'__| __/" +
            " _ \\/ _` | |  _ <| " +
            "| | | | |  | | | |  " +
            "  \\   /  \r\n" +
            "             ____) |" +
            " (_) | |  | ||  __/ " +
            "(_| | | |_) | |_| | " +
            "| |__| | | |     | |" +
            "   \r\n" +
            "            |_____/ " +
            "\\___/|_|   \\__\\__" +
            "_|\\__,_| |____/ \\_" +
            "_, |  \\___\\_\\ |_|" +
            "     |_|   \r\n" +
            "                    " +
            "                    " +
            "              __/ | " +
            "                    " +
            "   \r\n" +
            "                    " +
            "                    " +
            "             |___/  " +
            "                    " +
            "   \r";

        System.out.println(sorted_by_qty_string);

        System.out.println("\t    ________________________________________________________________________\n");

        String[][] sorted_by_qty_data = getSortedByData("qty");

        printTable(sorted_by_qty_data, false);;


        System.out.print("\tTo access the Main Menu, please enter 0 : ");
        int choice = input.nextInt();

        if (choice == 0) return true;

        System.out.print("\033[0A");
        System.out.print("\033[0J");

        return viewItemReportByQTY();
    }

    public static boolean viewItemReports() {
        clearConsole();

        String item_reports_string = "\r\n" +
            "             _____ _" +
            "                   _" +
            "____                " +
            "       _       \r\n" +
            "            |_   _| " +
            "|                 | " +
            " __ \\              " +
            "       | |      \r\n" +
            "              | | | " +
            "|_ ___ _ __ ___   | " +
            "|__) |___ _ __   ___" +
            "  _ __| |_ ___ \r\n" +
            "              | | | " +
            "__/ _ \\ \'_ ` _ \\ " +
            " |  _  // _ \\ \'_ " +
            "\\ / _ \\| \'__| __/" +
            " __|\r\n" +
            "             _| |_| " +
            "||  __/ | | | | | | " +
            "| \\ \\  __/ |_) | (" +
            "_) | |  | |_\\__ \\" +
            "\r\n" +
            "            |_____|" +
            "\\__\\___|_| |_| |_|" +
            " |_|  \\_\\___| .__/" +
            " \\___/|_|   \\__|__" +
            "_/\r\n" +
            "                    " +
            "                    " +
            "         | |        " +
            "               \r\n" +
            "                    " +
            "                    " +
            "         |_|        " +
            "               \r";

        System.out.println(item_reports_string);

        System.out.println("\t    _________________________________________________________________\n");

        System.out.println("\t\t[1] Best Selling Categories Sorted by QTY\n");
        System.out.println("\t\t[2] Best Selling Categories Sorted by Amount\n");

        System.out.print("\tEnter option : ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                return viewItemReportByQTY();

            case 2:
                return viewItemReportByAmount();

            default:
                System.out.print("\n\t\tInvalid Input !\n");

                boolean yn = yesNoChoice("Do you want to enter an option again? (y/n) : ");

                if (yn == false) {
                    return yn;
                }
        }

        return viewItemReports();
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
                 if (viewCustomerReports()) return;
                break;

            case 2:
                if (viewItemReports()) return;
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

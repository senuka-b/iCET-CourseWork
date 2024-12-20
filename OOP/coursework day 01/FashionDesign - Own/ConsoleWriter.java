import java.util.*;


class ConsoleWriter {

    private static Scanner input = new Scanner(System.in);

    private static String fashionShopText =  "\r\n" +
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
        
    private static String placeOrderString = "\r\n" +
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

    private static String searchCustomerString = "\r\n" +
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

    private static String searchOrderString = "\r\n" +
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

    private static String viewReportsString = "\r\n" +
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

    private static String orderStatusString = "\r\n" +
        "              ____  " +
        "        _           " +
        "   _____ _        _ " +
        "            \r\n" +
        "             / __ \\" +
        "        | |         " +
        "   / ____| |      | " +
        "|            \r\n" +
        "            | |  | |" +
        "_ __ __| | ___ _ __ " +
        " | (___ | |_ __ _| |" +
        "_ _   _ ___ \r\n" +
        "            | |  | |" +
        " \'__/ _` |/ _ \\ \'" +
        "__|  \\___ \\| __/ _" +
        "` | __| | | / __|\r" +
        "\n" +
        "            | |__| |" +
        " | | (_| |  __/ |   " +
        "  ____) | || (_| | |" +
        "_| |_| \\__ \\\r\n" +
        "             \\____/" +
        "|_|  \\__,_|\\___|_|" +
        "    |_____/ \\__\\__" +
        ",_|\\__|\\__,_|___/" +
        "\r\n" +
        "                    " +
        "                    " +
        "                    " +
        "            \r\n" +
        "                    " +
        "                    " +
        "                    " +
        "            \r";

        
    private static String deleteOrderString = "\r\n" +
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

    private String viewCustomerReportString = "\r\n" +
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

    private static String bestInCustomersString = "\r\n" +
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

    private static String viewCustomersString = "\r\n" +
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

    private static String allCustomerReportString = "\r\n" +
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

    public static void printAllCustomerReport() {
        clearConsole();

        System.out.println(allCustomerReportString);

        System.out.println("\t    _______________________________________________________________________________________________\n");


    }

    public static void printHomePage() {
        clearConsole();

        System.out.println(fashionShopText);
             
        System.out.println("\t    __________________________________________________________________________________________________________");

        System.out.println("\n\t\t[1] Place Order                                         [2] Search Customer\n");
        System.out.println("\t\t[3] Search Order                                        [4] View Reports\n");
        System.out.println("\t\t[5] Set Order Status                                    [6] Delete Order\n");
        
        System.out.print("\n\t\tInput Option : ");
    }

    public static void printPlaceOrderPage() {
        clearConsole();
        
        System.out.println(placeOrderString);

        System.out.println("     _____________________________________________________\n\n");

    }

    public static void printSearchCustomerPage() {
        clearConsole();

		System.out.println(searchCustomerString);

		System.out.println("    _____________________________________________________________________\n");

    }

    public static void printSearchOrderPage() {
        clearConsole();

        System.out.print(searchOrderString);

        System.out.print("   _________________________________________________________________\n\n");

    }

    public static void printViewCustomers() {
        clearConsole();

        System.out.println(viewCustomersString);

        System.out.println("\t    _____________________________________________________________________________\n");

    }

    public static void printBestInCustomers() {
        clearConsole();

        System.out.println(bestInCustomersString);

        System.out.println("\t    ______________________________________________________________________________________\n");

    }

    public static void printViewCustomerReportPage() {
        clearConsole();

        System.out.println(viewReportsString);
        
        System.out.println("\t    ____________________________________________________________________________________\n");

        System.out.println("\t\t[1] Best in Customers\n");
        System.out.println("\t\t[2] View Customers\n");
        System.out.println("\t\t[3] All Customer Report\n");

    }

    public static void printViewReportPage() {
        clearConsole();

        System.out.println(viewReportsString);
        
        System.out.println("\t    _______________________________________\n");

        System.out.println("\t\t[1] Customer Reports\n");
        System.out.println("\t\t[2] Item Reports\n");
        System.out.println("\t\t[3] Orders Reports\n");

        System.out.println("\t    _______________________________________\n");


    }

    public static void printSetOrderStatusPage() {
        clearConsole();

        System.out.println(orderStatusString);

        System.out.println("\t    ____________________________________________________________\n");

    }

    public static void printDeleteOrderPage() {
        clearConsole();

        System.out.print(deleteOrderString);

        System.out.print("   _________________________________________________________________\n\n");


    }

    public static int getIntegerInput() {
        return input.nextInt();

    }

    public static String getStringInput() {
        return input.next();
    }

    public static boolean yesNoChoice(String text) {

        System.out.print("\n\n\t" + text);
        char choice = getStringInput().toLowerCase().charAt(0);

        return choice == 'y' ? true : false;

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

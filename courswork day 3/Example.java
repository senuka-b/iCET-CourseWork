import java.util.*;
class Example {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\t\t\t");

        String smart_fashion_text = "\r\n" +
            "                    " +
            "_____               " +
            "       _     ______ " +
            "       _     _      " +
            "       \r\n" +
            "                   /" +
            " ____|              " +
            "      | |   |  ____|" +
            "      | |   (_)     " +
            "       \r\n" +
            "                  | " +
            "(___  _ __ ___   __ " +
            "_ _ __| |_  | |__ __" +
            " _ ___| |__  _  ___ " +
            " _ __  \r\n" +
            "                   " +
            "\\___ \\| \'_ ` _ \\" +
            " / _` | \'__| __| | " +
            " __/ _` / __| \'_ \\" +
            "| |/ _ \\| \'_ \\ \r" +
            "\n" +
            "                   _" +
            "___) | | | | | | (_|" +
            " | |  | |_  | | | (_" +
            "| \\__ \\ | | | | (_" +
            ") | | | |\r\n" +
            "                  |_" +
            "____/|_| |_| |_|\\__" +
            ",_|_|   \\__| |_|  " +
            "\\__,_|___/_| |_|_|" +
            "\\___/|_| |_|\r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "       \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "       \r\n";
                
        System.out.println(smart_fashion_text);

        System.out.print("\t\t  Date : ");
        String date = input.next();

        System.out.print("\n\n\t\t  Customer Name : ");
        String customer_name = input.next();

        System.out.println("\n\t\t  _______________________________________________________________________");

            String t_shirt_text = "\r\n" +
                "                    " +
                "                    " +
                " _______     _____ _" +
                "     _      _       " +
                "\r\n" +
                "                    " +
                "                    " +
                "|__   __|   / ____| " +
                "|   (_)    | |      " +
                "\r\n" +
                "                    " +
                "                    " +
                "   | |_____| (___ | " +
                "|__  _ _ __| |_ ___ " +
                "\r\n" +
                "                    " +
                "                    " +
                "   | |______\\___ \\" +
                "| \'_ \\| | \'__| __" +
                "/ __|\r\n" +
                "                    " +
                "                    " +
                "   | |      ____) | " +
                "| | | | |  | |_\\__ " +
                "\\\r\n" +
                "                    " +
                "                    " +
                "   |_|     |_____/|_" +
                "| |_|_|_|   \\__|___" +
                "/\r\n" +
                "                    " +
                "                    " +
                "                    " +
                "                    " +
                "\r\n" +
                "                    " +
                "                    " +
                "                    " +
                "                    " +
                "\r\n";
                
        System.out.println(t_shirt_text);

        System.out.print("\t\t  Number of T-Shirts : ");
        int no_tshirts = input.nextInt();  

        System.out.print("\n\n\t\t  Unit price of T-Shirt : ");
        double  unit_price_tshirt = input.nextDouble();

        System.out.print("\n\n\t\t  Discount Rate (%) : ");
        double discount_rate_tshirt = input.nextDouble();

        double subtotal_tshirt = unit_price_tshirt * no_tshirts;
        double amount_tshirt = subtotal_tshirt - (subtotal_tshirt * discount_rate_tshirt / 100);

        System.out.println("\n\n\t\t  +--------------------------+---------+---------------------+-------------+");
        System.out.println("\t\t  |        Description       |   QTY   |     Unit Price      |    Amount   |");
        System.out.println("\t\t  +--------------------------+---------+---------------------+-------------+");


        System.out.println("\t\t  | T-Shirt                  |    " + no_tshirts + "    |        " + unit_price_tshirt + "        |     " + amount_tshirt  +"  |");

        System.out.println("\t\t  +--------------------------+---------+---------------------+-------------+");

        String trousers_text = "\r\n" +
            "                    " +
            "                 ___" +
            "____                " +
            "                \r\n" +
            "                    " +
            "                |__ " +
            "  __|               " +
            "                \r\n" +
            "                    " +
            "                   |" +
            " |_ __ ___  _   _ __" +
            "_  ___ _ __ ___ \r\n" +
            "                    " +
            "                   |" +
            " | \'__/ _ \\| | | /" +
            " __|/ _ \\ \'__/ __|" +
            "\r\n" +
            "                    " +
            "                   |" +
            " | | | (_) | |_| \\_" +
            "_ \\  __/ |  \\__ \\" +
            "\r\n" +
            "                    " +
            "                   |" +
            "_|_|  \\___/ \\__,_|" +
            "___/\\___|_|  |___/" +
            "\r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                \r\n";


        System.out.println("\n\t\t  __________________________________________________________________________\n\n");


        System.out.println(trousers_text);


        System.out.print("\t\t  Number of Trousers : ");
        int no_trousers = input.nextInt();  


        System.out.print("\n\n\t\t  Unit price of Trouser : ");
        double  unit_price_trouser = input.nextDouble();

        System.out.print("\n\n\t\t  Discount Rate (%) : ");
        double discount_rate_trouser = input.nextDouble();

        double subtotal_trouser = no_trousers * unit_price_trouser;
        double amount_trouser = subtotal_trouser - (subtotal_trouser * discount_rate_trouser / 100);


        System.out.println("\n\n\t\t  +--------------------------+---------+---------------------+-------------+");
        System.out.println("\t\t  |        Description       |   QTY   |     Unit Price      |    Amount   |");
        System.out.println("\t\t  +--------------------------+---------+---------------------+-------------+");


        System.out.println("\t\t  | Trousers                 |    " + no_trousers + "    |          " + unit_price_trouser + "     |    " + amount_trouser  +"   |");

        System.out.println("\t\t  +--------------------------+---------+---------------------+-------------+");

        System.out.println("\n\t\t  __________________________________________________________________________\n\n");


        String shirts_text = "\r\n" +
            "                    " +
            "                  __" +
            "___ _     _      _  " +
            "     \r\n" +
            "                    " +
            "                 / _" +
            "___| |   (_)    | | " +
            "     \r\n" +
            "                    " +
            "                | (_" +
            "__ | |__  _ _ __| |_" +
            " ___ \r\n" +
            "                    " +
            "                 \\_" +
            "__ \\| \'_ \\| | \'_" +
            "_| __/ __|\r\n" +
            "                    " +
            "                 ___" +
            "_) | | | | | |  | |_" +
            "\\__ \\\r\n" +
            "                    " +
            "                |___" +
            "__/|_| |_|_|_|   \\_" +
            "_|___/\r\n" +
            "                    " +
            "                    " +
            "                    " +
            "     \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "     \r\n";

        System.out.println(shirts_text);

        
        System.out.print("\t\t  Number of Shirts : ");
        int no_shirts = input.nextInt();  

        System.out.print("\n\n\t\t  Unit price of Shirt : ");
        double  unit_price_shirt = input.nextDouble();

        System.out.print("\n\n\t\t  Discount Rate (%) : ");
        double discount_rate_shirt = input.nextDouble();

        double subtotal_shirt = no_shirts * unit_price_shirt;
        double amount_shirt = subtotal_shirt - (subtotal_shirt * discount_rate_shirt / 100);

        System.out.println("\n\n\t\t  +--------------------------+---------+---------------------+-------------+");
        System.out.println("\t\t  |        Description       |   QTY   |     Unit Price      |    Amount   |");
        System.out.println("\t\t  +--------------------------+---------+---------------------+-------------+");


        System.out.println("\t\t  | Shirts                   |    " + no_shirts + "    |       " + unit_price_shirt + "        |    " + amount_shirt  +"   |");

        System.out.println("\t\t  +--------------------------+---------+---------------------+-------------+");

        System.out.println("\n\t\t  __________________________________________________________________________\n\n");


        String shorts_text = "\r\n" +
            "                    " +
            "                  __" +
            "___ _               " +
            " _       \r\n" +
            "                    " +
            "                 / _" +
            "___| |              " +
            "| |      \r\n" +
            "                    " +
            "                | (_" +
            "__ | |__   ___  _ __" +
            "| |_ ___ \r\n" +
            "                    " +
            "                 \\_" +
            "__ \\| \'_ \\ / _ \\" +
            "| \'__| __/ __|\r\n" +
            "                    " +
            "                 ___" +
            "_) | | | | (_) | |  " +
            "| |_\\__ \\\r\n" +
            "                    " +
            "                |___" +
            "__/|_| |_|\\___/|_| " +
            "  \\__|___/\r\n" +
            "                    " +
            "                    " +
            "                    " +
            "         \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "         \r\n";


        System.out.println(shorts_text);

          
        System.out.print("\t\t  Number of Shorts : ");
        int no_shorts = input.nextInt();  

        System.out.print("\n\n\t\t  Unit price of Short : ");
        double  unit_price_short = input.nextDouble();

        System.out.print("\n\n\t\t  Discount Rate (%) : ");
        double discount_rate_short = input.nextDouble();

        double subtotal_short = no_shorts * unit_price_short;
        double amount_short = subtotal_short - (subtotal_short * discount_rate_short / 100);

        System.out.println("\n\n\t\t  +--------------------------+---------+---------------------+-------------+");
        System.out.println("\t\t  |        Description       |   QTY   |     Unit Price      |    Amount   |");
        System.out.println("\t\t  +--------------------------+---------+---------------------+-------------+");


        System.out.println("\t\t  | Shorts                   |    " + no_shorts + "    |       " + unit_price_short + "         |    " + amount_short +"   |");

        System.out.println("\t\t  +--------------------------+---------+---------------------+-------------+");

        System.out.println("\n\t\t  __________________________________________________________________________\n\n");


        System.out.println("\n\n\t\t  +-------------------------------------------------------------------------------+");

        String bill_summary_text = "\r\n" +
            "                    " +
            "        ____  _ _ _ " +
            "   _____            " +
            "                    " +
            "            \r\n" +
            "                    " +
            "       |  _ \\(_) | " +
            "|  / ____|          " +
            "                    " +
            "             \r\n" +
            "                    " +
            "       | |_) |_| | |" +
            " | (___  _   _ _ __ " +
            "___  _ __ ___   __ _" +
            " _ __ _   _ \r\n" +
            "                    " +
            "       |  _ <| | | |" +
            "  \\___ \\| | | | \'" +
            "_ ` _ \\| \'_ ` _ \\" +
            " / _` | \'__| | | |" +
            "\r\n" +
            "                    " +
            "       | |_) | | | |" +
            "  ____) | |_| | | | " +
            "| | | | | | | | (_| " +
            "| |  | |_| |\r\n" +
            "                    " +
            "       |____/|_|_|_|" +
            " |_____/ \\__,_|_| |" +
            "_| |_|_| |_| |_|\\__" +
            ",_|_|   \\__, |\r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "       __/ |\r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "      |___/ \r\n";

        System.out.println(bill_summary_text);

        double total_amount = amount_tshirt + amount_trouser + amount_shirt + amount_short;


        System.out.println("\n\t\t    Customer : " + "Haridnu" + "\t\t\t\t\t\tDate : " + "1990-02-23\n\n");

        System.out.println("\t\t  +---------------------+------------+--------------------+-----------------------+");
        System.out.println("\t\t  | Description         |     QTY    |     Unit Price     |          Amount       |");
        System.out.println("\t\t  +---------------------+------------+--------------------+-----------------------+");

        System.out.println("\t\t  |                     |            |                    |                       |");

        System.out.println("\t\t  | T-Shirt             |    " + no_tshirts + "       |        " + unit_price_tshirt + "       |     " + amount_tshirt  +"\t\t  |");
        System.out.println("\t\t  |                     |            |                    |                       |");

        System.out.println("\t\t  | Trouser             |    " + no_trousers + "       |        " + unit_price_trouser + "      |     " + amount_trouser +"\t\t  |");
        System.out.println("\t\t  |                     |            |                    |                       |");

        System.out.println("\t\t  | Shirt               |    " + no_shirts + "       |        " + unit_price_shirt + "      |     " + amount_shirt +"\t\t  |");
        System.out.println("\t\t  |                     |            |                    |                       |");

        System.out.println("\t\t  | Short               |    " + no_shorts + "       |        " + unit_price_short + "       |     " + amount_short +"\t\t  |");
        System.out.println("\t\t  |                     |            |                    |                       |");

        System.out.println("\t\t  +---------------------+------------+--------------------+-----------------------+");

        System.out.println("\t\t  | Total                                                 |     " + total_amount + "            |");

        System.out.println("\t\t  +-------------------------------------------------------+-----------------------+");

        

    }
}
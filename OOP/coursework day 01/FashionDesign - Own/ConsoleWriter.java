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

    public static void printHomePage() {
        clearConsole();

        System.out.println(fashionShopText);
             
        System.out.println("\t    __________________________________________________________________________________________________________");

        System.out.println("\n\t\t[1] Place Order                                         [2] Search Customer\n");
        System.out.println("\t\t[3] Search Order                                        [4] View Reports\n");
        System.out.println("\t\t[5] Set Order Status                                    [6] Delete Order\n");
        
        System.out.print("\n\t\tInput Option : ");
    }

    public static int getIntegerInput() {
        return input.nextInt();

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

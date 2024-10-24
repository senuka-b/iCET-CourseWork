import java.util.*;
class Example {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\t------------------------------------------------------------------------------------------");
        System.out.println("\t||\t\t                                                               \t\t||");
        System.out.println("\t||\t\t                                                               \t\t||");       
        System.out.println("\t||\t\t                           ~'%@@%'~                            \t\t||");       
        System.out.println("\t||\t\t                         ~@@@@@@@@@@~                          \t\t||");       
        System.out.println("\t||\t\t    '~#@@#'             ~@@@@@@@@@@@@~                         \t\t||");       
        System.out.println("\t||\t\t   '@@@@@@@@            @@@@@@@@@@@@@@%                        \t\t||");       
        System.out.println("\t||\t\t   @@@@@@@@@@           ~@@@@@@@@@@@@@~                        \t\t||");       
        System.out.println("\t||\t\t   '@@@@@@@@'            '@@@@@@@@@@@~                         \t\t||");       
        System.out.println("\t||\t\t    .;#@@#,.               -'%@@%'-                            \t\t||");       
        System.out.println("\t||\t\t  ~#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@                      \t\t||");       
        System.out.println("\t||\t\t *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@        '#@@@       \t\t||");       
        System.out.println("\t||\t\t @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   :'@@@@@@@       \t\t||");       
        System.out.println("\t||\t\t @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@       \t\t||");       
        System.out.println("\t||\t\t @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@       \t\t||");       
        System.out.println("\t||\t\t @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@       \t\t||");       
        System.out.println("\t||\t\t @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@       \t\t||");       
        System.out.println("\t||\t\t  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    :'@@@@@@@       \t\t||");       
        System.out.println("\t||\t\t   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@          '#@@@       \t\t||");       
        System.out.println("\t||\t\t     *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@                        \t\t||");       
        System.out.println("\t||\t\t               ,#@@@@++@@@@%                                   \t\t||");       
        System.out.println("\t||\t\t              -@@@@%     %@@@~                                 \t\t||");       
        System.out.println("\t||\t\t              ~%%~         ~%%~                                \t\t||");       
        System.out.println("\t||\t\t                                                               \t\t||");       
        System.out.println("\t||\t\t      ___  ____________   _____________  _________  ______     \t\t||");       
        System.out.println("\t||\t\t     / _ \\/__  __/  __/  / ___/__  __/ \\/ / ___/  \\/  / - | \t\t||");       
        System.out.println("\t||\t\t    / ' _/  / / _\\  \\   / /____ / /_/    / __// /\\_/ / _  | \t\t||");   
        System.out.println("\t||\t\t   /_/|_|  /_/ /____/   \\____/_____/_/\\_/____/_/  /_/_/ \\_| \t\t||");       
        System.out.println("\t||\t\t                                                               \t\t||");       
        System.out.println("\t||\t\t                                                               \t\t||");       
        System.out.println("\t||\t\t                                                               \t\t||");       
        System.out.println("\t||\t\t                                                               \t\t||");       
        System.out.println("\t||\t\t                                                               \t\t||");       
        System.out.println("\t||\t\t                                                               \t\t||");       
        System.out.println("\t------------------------------------------------------------------------------------------");


        System.out.print("\n\n\tEnter Date: ");
        String date = input.next();

        System.out.print("\n\n\tLocation: ");
        String location = input.next();


        System.out.println("\n\n\t\t\t   _             _      _    _       ____   _         ");
        System.out.println("\t\t\t  /-\\__ ______(_) |____| |__| |___  | ___(_) |_ __  ___                 ");
        System.out.println("\t\t\t / _ \\ v / -' | | / -' |  - \\ / -_) |  _|| | | '  \\(_'<          ");
        System.out.println("\t\t\t/_/ \\_\\_/\\__,_|_|_\\__,_|_'__/_\\___| |_|  |_|_|_|_|_/__/                        ");
        System.out.println("\n\t\t\t\b=========================================================");
        
        System.out.println("\n\n\t\t 1) Movie 1 - Hall 1\t\t\t\t\t 2) Movie 2 - Hall 2 ");
        System.out.println("\n\t\t 3) Movie 3 - Hall 3\t\t\t\t\t 4) Movie 4 - Hall 4");

        System.out.print("\n\n\n\tEnter Movie Number: ");
        int movie_number = input.nextInt();

        System.out.print("\n\n\n");

        System.out.println("\t\t\t\t _______      ");
        System.out.println("\t\t\t\t|__   __|_               ");
        System.out.println("\t\t\t\t   | |  (_)_ __ ___  ____                  ");
        System.out.println("\t\t\t\t   | |  | | '_ ' _ \\/  - \\      ");
        System.out.println("\t\t\t\t   | |  | | | | | | |  __/          ");
        System.out.println("\t\t\t\t   |_|  |_|_| |_| |_|\\___|                                 ");
        System.out.println("\t\t\t=============================================             ");

        System.out.println("\n\n");

        System.out.println("\t\t\t\t\t 1) 9.00 A.M");
        System.out.println("\n\t\t\t\t\t 2) 2.00 P.M");
        System.out.println("\n\t\t\t\t\t 1) 7.00 A.M");

        input.nextLine(); // nextLine automatically takes the previous \n as an input so this is the re to prevent that
        
        System.out.print("\n\n\tEnter Time: ");
        String time = input.nextLine(); // nextLine for spaces

        System.out.println("\n\n");

        System.out.println("\t\t\t _____            _                                   ");
        System.out.println("\t\t\t/  __ \\          | |                                 ");
        System.out.println("\t\t\t| /  \\ _   _ ____| |_ ___  _,__,___   ___ _ __       ");
        System.out.println("\t\t\t| |   | | | | ___| __/ _ \\|  _   _ \\ /  -\\ '__|       ");
        System.out.println("\t\t\t| \\__/\\ |_| \\__  \\ || (_) | | | | | |  __/ |           ");
        System.out.println("\t\t\t\\_____/\\__,_|____/\\__\\___/|_| |_| |_|\\___|_|                       ");
        System.out.println("\n\n\t\t\t================================================");
        
        System.out.print("\n\n\tName: ");
        String name = input.next();

        System.out.print("\n\n\tPhone Number: ");
        int phone_number = input.nextInt();

        System.out.print("\n\n\tChild OR Parent: ");
        String child_or_parent = input.next();

        System.out.print("\n\n\tNumber of Tickets: ");
        int number_of_tickets = input.nextInt();

        int tax_percentage = 80;
        int ticket_price = 90;

        // Calculating tax per ticket
        int tax = (ticket_price * tax_percentage) / 100;

        int taxed_ticket_price = ticket_price + tax;

        System.out.println("\n\n\t--------------------------------------------------------------------------------");
        System.out.println("\t||\t\t                                                              ||");
        System.out.println("\t||\t\t      ___  ____________   _____________  _________  ______    ||");       
        System.out.println("\t||\t\t     / _ \\/__  __/  __/  / ___/__  __/ \\/ / ___/  \\/  / - |\t\b\b||");       
        System.out.println("\t||\t\t    / ' _/  / / _\\  \\   / /____ / /_/    / __// /\\_/ / _  |\t\b\b||");   
        System.out.println("\t||\t\t   /_/|_|  /_/ /____/   \\____/_____/_/\\_/____/_/  /_/_/ \\_|\t\b\b||");       
        System.out.println("\t||\t\t                                                              ||");
        System.out.println("\t||\t\t                                                              ||");
        System.out.println("\t||\t\t                                                              ||");
        System.out.println("\t||\t\t                                                              ||");
        System.out.println("\t||\tDate : " +date+ "\t\t\t\tLocation : "+ location +"\t\b\b||");
        System.out.println("\t||\t\t\t\t\t\t\t\t\t\t\b\b||");
        System.out.println("\t||\t\t\t\t\t\t\t\t\t\t\b\b||");
        
        System.out.println("\t||--------------------------------------------------------------------------- ||");
        System.out.println("\t||\t\t\t\t\t\t\t\t\t\t\b\b||");
        System.out.println("\t||\t\t\t\t\t\t\t\t\t\t\b\b||");
        System.out.println("\t||\t\t\t\t\t\t\t\t\t\t\b\b||");

        System.out.println("\t||\t\t Name\t\t : " + name + "\t\t\t\t\t\b\b||");
        System.out.println("\t||\t\t\t\t\t\t\t\t\t\t\b\b||");
        System.out.println("\t||\t\t Phone Number\t : " + phone_number+ "\t\t\t\t\t\b\b||");
        System.out.println("\t||\t\t\t\t\t\t\t\t\t\t\b\b||");
        System.out.println("\t||\t\t Tickets\t\b  : " + number_of_tickets + "\t\t\t\t\t\t\b\b||");
        System.out.println("\t||\t\t\t\t\t\t\t\t\t\t\b\b||");
        System.out.println("\t||\t\t Type \t\t : " + child_or_parent + "\t\t\t\t\t\b\b||");
        System.out.println("\t||\t\t\t\t\t\t\t\t\t\t\b\b||");
        System.out.println("\t||\t\t Time\t\t : " + time + "\t\t\t\t\t\b\b||");
        System.out.println("\t||\t\t\t\t\t\t\t\t\t\t\b\b||");
        System.out.println("\t||\t\t Hall\t\t : " + movie_number + " Hall\t\t\t\t\t\b\b||");
        System.out.println("\t||\t\t\t\t\t\t\t\t\t\t\b\b||");
        System.out.println("\t||\t\t Tax\t\t : " + tax * number_of_tickets + "\t\t\t\t\t\t\b\b||");
        System.out.println("\t||\t\t\t\t\t\t\t\t\t\t\b\b||");
        System.out.println("\t||\t\t\t\t\t\t\t\t\t\t\b\b||");

        System.out.println("\t||\t\t\t\t\t\t\t\tTotal : " + taxed_ticket_price * number_of_tickets + "\t\b\b||");
        System.out.println("\t||\t\t\t\t\t\t\t\t\t\t\b\b||");
        System.out.println("\t||\t\t\t\t\t\t\t\t\t\t\b\b||");


        System.out.println("\t--------------------------------------------------------------------------------");










    
    }
}
import java.util.*;
public class Example {

    public static double getLeasingAmount (double monthly_installment, double interest_rate, double years) {
        double leasing_amount =(monthly_installment * (1-(1/Math.pow((1+(interest_rate/100/12)), (years * 12))))) / (interest_rate/100/12);
        
        return leasing_amount;
    }

    public static void findLeasingAmount() {
        clearConsole();

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("|                         Find Leasing Amount                            |");   
        System.out.println("--------------------------------------------------------------------------");

        System.out.println("\n");


        double monthly_installment = validateMonthlyInstallmentInput("installment");

        double years = validateMonthlyInstallmentInput("year");

        double interest_rate = validateMonthlyInstallmentInput("rate");

        double leasing_amount = getLeasingAmount(monthly_installment, interest_rate, years);

        System.out.printf("%n  You can get Lease Amount\t: %.0f", leasing_amount);

        Scanner input = new Scanner(System.in);

        System.out.println("\n");
        System.out.print("Do you want to find another Leasing Amount(Y/N): ");

        char choice = input.next().charAt(0);
        if (choice != 'N') {
            findLeasingAmount(); 
        }
    }

    public static void calculateLeasingCategory() {
        clearConsole();

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("|                      Search Leasing Category                           |");   
        System.out.println("--------------------------------------------------------------------------");

        System.out.println("\n");

        Scanner input = new Scanner(System.in);

        System.out.print("Enter lease amount\t: ");
        double lease_amount = input.nextDouble();

        System.out.print("\nEnter annual interest rate\t: ");
        double interest_rate = input.nextDouble();

        System.out.println();

        System.out.printf("Your monthly installment for 3 year leasing plan : %.2f%n", getMonthlyInstallment(lease_amount, interest_rate, 3));
        System.out.printf("Your monthly installment for 4 year leasing plan : %.2f%n", getMonthlyInstallment(lease_amount, interest_rate, 4));
        System.out.printf("Your monthly installment for 5 year leasing plan : %.2f%n", getMonthlyInstallment(lease_amount, interest_rate, 5));



        System.out.println("\n");
        System.out.print("Do you want to calculate another Leasing Category(Y/N): ");

        char choice = input.next().charAt(0);
        if (choice != 'N') {
            calculateLeasingCategory();
        }


    }

    public static double getMonthlyInstallment(double lease_amount, double interest_rate, double years) {

        double monthly_installment = (lease_amount * (interest_rate/100/12)) / (1-(1/Math.pow((1+(interest_rate/100/12)), (years * 12))));

        return monthly_installment;
    }


    public static double validateMonthlyInstallmentInput(String type) {
        Scanner input = new Scanner(System.in);

        double value = 0;
        switch (type) {
            case "amount":

                System.out.print("\n  Enter lease amount\t: ");
                value = input.nextDouble();

                if (value <= 0) {
                    System.out.println("\t\nInvalid leasing amount... Please try again!\n");
                    return validateMonthlyInstallmentInput(type);
                }

                break;

            case "rate":

                System.out.print("\n  Enter annual interest rate\t: ");
                value = input.nextDouble();


                if (value <= 0) {
                    System.out.println("\tInvalid leasing rate... Please try again!");
                    return validateMonthlyInstallmentInput(type);
                }

                break;

            case "year":
        
                System.out.print("\n  Enter number of years\t: ");
                value = input.nextDouble();

                if (value > 5 || value <= 0) {
                    System.out.println("\tInvalid leasing year... Please try again!");
                    return validateMonthlyInstallmentInput(type);
                }

                break;

            case "installment":
                System.out.print("\n  Enter the monthly lease payment you could afford\t: ");
                value = input.nextDouble();

                if (value <= 0) {
                    System.out.println("\tInvalid amount... Please try again!");
                    return validateMonthlyInstallmentInput(type);

                }

                break;
                
                        
        }

        return value;
    }

    public static void calculateMonthlyInstallment() {
        clearConsole();

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("|                  Calculate Leasing Payment (Monthly Installment)       |");   
        System.out.println("--------------------------------------------------------------------------");

        System.out.println("\n");


        double lease_amount = validateMonthlyInstallmentInput("amount");

        double interest_rate = validateMonthlyInstallmentInput("rate");

        double years = validateMonthlyInstallmentInput("year");

        double monthly_installment = getMonthlyInstallment(lease_amount, interest_rate, years);

        System.out.printf("%n  Your monthly installment\t: %.2f", monthly_installment);

        Scanner input = new Scanner(System.in);

        System.out.println("\n");
        System.out.print("Do you want to calculate another monthly installment(Y/N): ");

        char choice = input.next().charAt(0);
        if (choice != 'N') {
            calculateMonthlyInstallment();
        }


    }

    public static void leasingPaymentPage() {
        clearConsole();

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("|                           Leasing Payment                              |");   
        System.out.println("--------------------------------------------------------------------------");

        System.out.println("\n");


        System.out.println("\t[1] Calculate Monthly Installment\n");
        System.out.println("\t[2] Search Leasing Category\n");
        System.out.println("\t[3] Find Leasing Amount\n");
        System.out.println("\t[4] Exit\n");

        Scanner input = new Scanner(System.in);

        System.out.print("Enter an option to continue > ");
        int option = input.nextInt();

        switch (option) {
            case 1:
                calculateMonthlyInstallment();
                break;

            case 2:
                calculateLeasingCategory();
                break;

            case 3:
                findLeasingAmount();
                break;

            case 4:
                return;
        
            default:
                break;
        }

        leasingPaymentPage();
    }

    public static void calculateSCCLTax() {
        clearConsole();

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("|           SOCIAL SECURITY CONTRIBUTION LEVY (SCCL) TAX                  |");   
        System.out.println("--------------------------------------------------------------------------");

        System.out.println("\n");

        Scanner input = new Scanner(System.in);

        System.out.print("  Enter value of Good or Service :  ");
        double value = input.nextDouble();

        if (value > 0) {

            double sales_tax = value * 0.025;
            value += sales_tax;
            double vat = value * 0.15;
    
            double sccl_tax = sales_tax + vat;
            
            System.out.println("  \nYou have to pay SSCL Tax : " + sccl_tax);

        } else {
            System.out.println("\tInvalid input!");
        }

       


        System.out.println("\n");
        System.out.print("Do you want to calculate another SCCL Tax(Y/N): ");

        char choice = input.next().charAt(0);
        if (choice != 'N') {
            calculateSCCLTax();
        }
        

    }

    public static double getIncomeTax (double remaining, double factor) {

        if (factor == 0.36) return remaining * factor;

        if (remaining > 0 && remaining <= 500000) {

            return remaining * factor;
        
        } else {

            return  (500000 * factor) + getIncomeTax(remaining-500000, factor+0.06);
        } 


    }

    public static void calculateIncomeTax() {
        clearConsole();

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("|                             INCOME TAX                                 |");   
        System.out.println("--------------------------------------------------------------------------");

        Scanner input = new Scanner(System.in);

        System.out.print("  Enter your total income per year :  ");
        double income = input.nextDouble();

        if (income > 0) {
            if (income <= 1200000) {
                System.out.println("\tYou don't have to pay Payable Tax");
    
            } else {
                double remaining = income - 1200000;
    
                double income_tax = getIncomeTax(remaining, 0.06);
    
                System.out.printf("%n  You have to pay Income Tax per year: %.0f", income_tax);
    
            }
        } else {
            System.out.println("\tInvalid input!");
        }

       

        System.out.println("\n");
        System.out.print("Do you want to calculate another Income Tax(Y/N): ");

        char choice = input.next().charAt(0);
        if (choice != 'N') {
            calculateIncomeTax();
        }
        

    }

    public static double getPayableTax (double remaining, double factor) {
        

        if (factor == 0.36) return remaining * factor;


        if (remaining > 0 && remaining <= 41667) {

            return remaining * factor;
        
        } else {

            return  (41667 * factor) + getPayableTax(remaining-41667, factor+0.06);
        } 



        
    }

    public static void calculatePayableTax() {
        clearConsole();

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("|                             PAYABLE TAX                                |");   
        System.out.println("--------------------------------------------------------------------------");

        Scanner input = new Scanner(System.in);

        System.out.print("  Enter your employee payment per month :  ");
        double salary = input.nextDouble();

        if (salary > 0) {
                
            if (salary <= 100000) {
                System.out.println("\tYou don't have to pay Payable Tax");

            } else if ( salary > 100000) {
                double remaining = salary - 100000;

                double payable_tax = getPayableTax(remaining, 0.06);

                System.out.printf("%n  You have to pay Payable Tax per month: %.0f", payable_tax);

            }

        } else {
            System.out.println("\tInvalid input!");
        }


        System.out.println("\n");
        System.out.print("Do you want to calculate another Payable Tax(Y/N): ");

        char choice = input.next().charAt(0);
        if (choice != 'N') {
            calculatePayableTax();
        }
        

    }
    

    public static void calculateDividendTax () {
        clearConsole();

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|                                DIVIDEND TAX                                        |");
        System.out.println("--------------------------------------------------------------------------------------");

        System.out.println();

        Scanner input = new Scanner(System.in);

        System.out.print("  Enter your total dividend per year   : ");
        double annual_dividend  = input.nextDouble();
        

        if (annual_dividend > 0) {

            if (annual_dividend < 100000) {
                System.out.println("\tYou don't have to pay dividend tax");

            } else {
                    
                double tax = (annual_dividend - 100000)  * 0.14;
                System.out.printf("  You have to pay dividend tax per year : %.2f%n", tax);
            }
            
        } else {
            System.out.println("\tInvalid input!");
        }
        
        System.out.println("\n");
        System.out.print("Do you want to calculate another Rent Tax(Y/N): ");

        char choice = input.next().charAt(0);
        if (choice != 'N') {
            calculateDividendTax();
        }

    }

    public static void calculateBankInterestTax () {
        clearConsole();

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|                              BANK INTEREST TAX                                     |");
        System.out.println("--------------------------------------------------------------------------------------");

        System.out.println();

        Scanner input = new Scanner(System.in);

        System.out.print("  Enter your bank interest per year\t: ");
        double annual_interest  = input.nextDouble();
        

        if (annual_interest > 0) {

            double tax = (annual_interest) * 0.05;
            System.out.println("  You have to pay Bank Interest per year : " + tax);
            
        } else {
            System.out.println("\tInvalid input!");
        }
        
        System.out.println("\n");
        System.out.print("Do you want to calculate another Rent Tax(Y/N): ");

        char choice = input.next().charAt(0);
        if (choice != 'N') {
            calculateBankInterestTax();
        }

    }

    public static void calculateRentTax() {
        clearConsole();

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|                                  RENT TAX                                          |");
        System.out.println("--------------------------------------------------------------------------------------");
    
        System.out.println();

        Scanner input = new Scanner(System.in);

        System.out.print("  Enter your rent\t: ");
        double rent  = input.nextDouble();
        

        if (rent > 0) {
            if (rent < 100000) {
                System.out.println(" You don't have to pay Rent Tax");
            } else {
                double tax = (rent-100000) * 0.10;
                System.out.println("  You have to pay Rent Tax : " + tax);
            }
        } else {
            System.out.println("\tInvalid input!");
        }
        
        System.out.println("\n");
        System.out.print("Do you want to calculate another Rent Tax(Y/N): ");

        char choice = input.next().charAt(0);
        if (choice != 'N') {
            calculateRentTax();
        }
        
    }



    public static void withholdingTaxPage () {
        clearConsole();

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("|                                  WITHHOLDING TAX                                   |");
        System.out.println("--------------------------------------------------------------------------------------");

        System.out.println("\t[1] Rent Tax\n");
        System.out.println("\t[2] Bank Interest Tax\n");
        System.out.println("\t[3] Dividend Tax\n");
        System.out.println("\t[4] Exit\n");
  
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your option > ");
        int choice = input.nextInt();

      
        switch (choice) {
            case 1:
                calculateRentTax();
                break;
        
            case 2:
                calculateBankInterestTax();
                break;

            case 3:
                calculateDividendTax();
                break;

            case 4:
                return;

            default:
                break;
        }
        

        withholdingTaxPage();


    }

    public static void homePage() {
        clearConsole();

        String icet_art = "\r\n" +
            "                    " +
            "                    " +
            "               _____" +
            "_   ______   _______" +
            "_  ________ \r\n" +
            "                    " +
            "                    " +
            "              |     " +
            " \\ /      \\ |     " +
            "   \\|        \\\r\n" +
            "                    " +
            "                    " +
            "               \\$$$" +
            "$$$|  $$$$$$\\| $$$$" +
            "$$$$ \\$$$$$$$$\r\n" +
            "                    " +
            "                    " +
            "                | $$" +
            "  | $$   \\$$| $$__ " +
            "      | $$   \r\n" +
            "                    " +
            "                    " +
            "                | $$" +
            "  | $$      | $$  \\" +
            "      | $$   \r\n" +
            "                    " +
            "                    " +
            "                | $$" +
            "  | $$   __ | $$$$$ " +
            "     | $$   \r\n" +
            "                    " +
            "                    " +
            "               _| $$" +
            "_ | $$__/  \\| $$___" +
            "__    | $$   \r\n" +
            "                    " +
            "                    " +
            "              |   $$" +
            " \\ \\$$    $$| $$  " +
            "   \\   | $$   \r\n" +
            "                    " +
            "                    " +
            "               \\$$$" +
            "$$$  \\$$$$$$  \\$$$" +
            "$$$$$    \\$$   \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "            \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "            \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "            \r\n";

        System.out.println(icet_art);
        System.out.println("\n");

        String tax_calculator_art = "\r\n" +
            "                    " +
            "          _______   " +
            "         _____      " +
            "_            _      " +
            " _             \r\n" +
            "                    " +
            "         |__   __|  " +
            "        / ____|    |" +
            " |          | |     " +
            "| |            \r\n" +
            "                    " +
            "            | | __ _" +
            "__  __ | |     __ _|" +
            " | ___ _   _| | __ _" +
            "| |_ ___  _ __ \r\n" +
            "                    " +
            "            | |/ _` " +
            "\\ \\/ / | |    / _`" +
            " | |/ __| | | | |/ _" +
            "` | __/ _ \\| \'__|" +
            "\r\n" +
            "                    " +
            "            | | (_| " +
            "|>  <  | |___| (_| |" +
            " | (__| |_| | | (_| " +
            "| || (_) | |   \r\n" +
            "                    " +
            "            |_|\\__," +
            "_/_/\\_\\  \\_____\\" +
            "__,_|_|\\___|\\__,_|" +
            "_|\\__,_|\\__\\___/|" +
            "_|   \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "               \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "               \r\n";

        System.out.println(tax_calculator_art);
        System.out.println("\n");

        System.out.println("============================================================================================================\n");

        System.out.println("\t[1] Withholding Tax\n");
        System.out.println("\t[2] Payable Tax\n");
        System.out.println("\t[3] Income Tax\n");
        System.out.println("\t[4] Social Security Contribution Levy (SSCL) Tax\n");
        System.out.println("\t[5] Leasing Payment\n");
        System.out.println("\t[6] Exit\n");

        Scanner input = new Scanner(System.in);
        System.out.print("  Enter your option > ");

        int choice = input.nextInt();


        switch (choice) {
            case 1:
                withholdingTaxPage();
                break;
        
            case 2:
                calculatePayableTax();
                break;

            
            case 3:
                calculateIncomeTax();
                break;

            case 4:
                calculateSCCLTax();
                break;

            case 5: 
                leasingPaymentPage();
                break;
            
            case 6:
                return;
            
            default:
                break;
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

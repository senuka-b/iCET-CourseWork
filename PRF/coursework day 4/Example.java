import java.util.*;
class Example {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("|                      SALARY INFORMATION SYSTEM                          |");   
        System.out.println("--------------------------------------------------------------------------");


        System.out.println("\n\n\t [1] Calculate Income Tax");
        System.out.println("\t [2] Calculate Annual Bonus");
        System.out.println("\t [3] Calculate Loan Amount" );

        System.out.print("\n\nEnter an option to continue > ");
        int option = input.nextInt();

        System.out.println("\n");

        if (option == 1) {     
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("|                      Calculate Income Tax                               |");   
            System.out.println("--------------------------------------------------------------------------");

            System.out.print("Input Employee name - ");
            String name = input.next();

            System.out.print("Input Employee salary - ");
            double salary = input.nextDouble();

            double income_tax = 0;

            if (salary <= 100000) {

            } else if ( salary > 100000) {
                double remaining = salary - 100000;
                
                System.out.println("INC " + income_tax);
                System.out.println(remaining);


                if (remaining > 0 && remaining <= 41667) {
                    income_tax += remaining * 0.06;
                    remaining = 0;
                } else if (remaining > 41667) {
                    income_tax += 41667 * 0.06;
                    remaining -= 41667;
                }

                
                System.out.println("INC " + income_tax);

                System.out.println(remaining);

                if (remaining > 0 && remaining <= 41667) {
                    income_tax += remaining * 0.12;
                    remaining = 0;
                } else if (remaining > 41667) {
                    income_tax += 41667 * 0.12;
                    remaining -= 41667;
                }
                System.out.println("INC " + income_tax);

                System.out.println(remaining);

                if (remaining > 0 && remaining <= 41667) {
                    income_tax += remaining * 0.18;
                    remaining = 0;

                } else if (remaining > 41667) {
                    income_tax += 41667 * 0.18;
                    remaining -= 41667;
                }
                System.out.println("INC " + income_tax);

                System.out.println(remaining);


                if (remaining > 0 && remaining <= 41667) {
                    income_tax += remaining * 0.24;
                    remaining = 0;
                } else if (remaining > 41667) {
                    income_tax += 41667 * 0.24;
                    remaining -= 41667;
                }
                System.out.println("INC " + income_tax);
                System.out.println(remaining);


                if (remaining > 0 && remaining <= 41667) {
                    income_tax += remaining * 0.30;
                    remaining = 0;
                } else if (remaining > 41667) {
                    income_tax += 41667 * 0.30;
                    remaining -= 41667;
                }
                System.out.println("INC " + income_tax);

                System.out.println(remaining);


                if (remaining > 0) { 
                    income_tax += remaining * 0.36;
                }
                System.out.println("INC " + income_tax);

                System.out.println(remaining);

            }

            System.out.printf("%n%nYou have to pay income tax per month: %.0f", income_tax);
        } else if (option == 2) {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("|                      Calculate Annual Bonus                             |");   
            System.out.println("--------------------------------------------------------------------------");


            System.out.print("Input Employee name - ");
            String name = input.next();

            System.out.print("Input Employee salary - ");
            double salary = input.nextDouble();

            double annual_bonus = 0;

            if (salary < 100000) {
                annual_bonus = 5000;
            } else if (salary >= 100000 && salary <= 199999) {
                annual_bonus = salary * 0.10;
            } else if (salary <= 299999) {
                annual_bonus = salary * 0.15;
            } else if (salary <= 399999) {
                annual_bonus = salary * 0.20;
            } else {
                annual_bonus = salary * 0.35;
            }

            System.out.println("\n\nAnnual bonus     - " + annual_bonus);
        
        } else if (option == 3) {

            System.out.print("Input Employee name - ");
            String name = input.next();

            System.out.print("Input Employee salary - ");
            double salary = input.nextDouble();

            System.out.print("Enter number of year: ");
            int num_year = input.nextInt();


            if (salary< 50000) {
                System.out.println("You can not get a loan because your salary is less than Rs. 50 000");
            } else if (num_year > 5) {
                System.out.println("You can not get a loan because you have more than 5 years");
            } else {
                double r = 0.15;
                double n = num_year * 12;
                double loan_amount = (salary * 0.60) * ((1 - (1 / (Math.pow(1 + ( r / 12), n))))/(r/12));

                // double x = salary * 0.60;
                // double y = Math.pow(1 + ( r / 12), n);

                // double loan_amount = x * ((1 - (1 / y)) / (r/12));

                System.out.println("\n\nYou can get Loan Amount: " + Math.round(loan_amount / 1000) * 1000);
            }

        }

    }
}
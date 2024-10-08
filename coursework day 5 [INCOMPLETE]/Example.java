import java.util.*;
class Example {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        // INCOMPLETE

        String i_calc = "\r\n" +

            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "          \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "          \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "          \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "          \r\n" +
            "                    " +
            "                    " +
            "        $$$$$$\\  $$" +
            "$$$$\\            $$" +
            "\\           \r\n" +
            "                    " +
            "                    " +
            "        \\_$$  _|$$ " +
            " __$$\\           $$" +
            " |          \r\n" +
            "                    " +
            "                    " +
            "          $$ |  $$ /" +
            "  \\__| $$$$$$\\  $$" +
            " | $$$$$$$\\ \r\n" +
            "                    " +
            "                    " +
            "          $$ |  $$ |" +
            "       \\____$$\\ $$" +
            " |$$  _____|\r\n" +
            "                    " +
            "                    " +
            "          $$ |  $$ |" +
            "       $$$$$$$ |$$ |" +
            "$$ /      \r\n" +
            "                    " +
            "                    " +
            "          $$ |  $$ |" +
            "  $$\\ $$  __$$ |$$ " +
            "|$$ |      \r\n" +
            "                    " +
            "                    " +
            "        $$$$$$\\ \\$" +
            "$$$$$  |\\$$$$$$$ |$" +
            "$ |\\$$$$$$$\\ \r\n" +
            "                    " +
            "                    " +
            "        \\______| \\" +
            "______/  \\_______|" +
            "\\__| \\_______|\r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "          \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "          \r\n" +
            "                    " +
            "                    " +
            "                    " +
            "                    " +
            "          \r\n";



        String number_calc = "\r\n" +
            "       _   _        " +
            "         _          " +
            "        _____       " +
            "                   _" +
            "            \r\n" +
            "      | \\ | |      " +
            "         | |        " +
            "        / ____|     " +
            "                   |" +
            " |           \r\n" +
            "      |  \\| |_   _ " +
            "_ __ ___ | |__   ___" +
            " _ __  | |     ___  " +
            "_ ____   _____ _ __|" +
            " |_ ___ _ __ \r\n" +
            "      | . ` | | | | " +
            "\'_ ` _ \\| \'_ \\ /" +
            " _ \\ \'__| | |    /" +
            " _ \\| \'_ \\ \\ / /" +
            " _ \\ \'__| __/ _ \\" +
            " \'__|\r\n" +
            "      | |\\  | |_| |" +
            " | | | | | |_) |  __" +
            "/ |    | |___| (_) |" +
            " | | \\ V /  __/ |  " +
            "| ||  __/ |   \r\n" +
            "      |_| \\_|\\__,_" +
            "|_| |_| |_|_.__/ \\_" +
            "__|_|     \\_____\\_" +
            "__/|_| |_|\\_/ \\___" +
            "|_|   \\__\\___|_|  " +
            " \r\n" +
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

        System.out.println(i_calc);
        System.out.println(number_calc);
        System.out.println("\t\b=================================================================================");


        System.out.println("\n\n");

        System.out.println("\t  [01] Decimal Converter\n");
        System.out.println("\t  [02] Binary Converter\n");
        System.out.println("\t  [03] Octal Converter\n");
        System.out.println("\t  [04] Hexadecimal Converter\n");
        System.out.println("\t  [05] Roman Number Converter\n");

        // TODO: Add validationo
        // TODO: While loop for continous program


        // Decimal to binary

        int decimal = 101;
        
        int i = decimal;
        String binary_result = "";
        while (i > 0 ) {

            binary_result += Integer.toString(i % 2);
            i/=2;
            
        }

        for (int j = binary_result.length()-1; j>=0;j--) {
            System.out.print(binary_result.charAt(j));
        }

        System.out.println();

        // Decimal to octal
        i = decimal;
        String octal_result = "";
        while (i > 0 ) {

            octal_result += Integer.toString(i % 8);
            i/=8;
            
        }

        for (int j = octal_result.length()-1; j>=0;j--) {
            System.out.print(octal_result.charAt(j));
        }


        System.out.println();

        // Decimal to hex
        i = 255;
        String hex_result = "";

        while (i > 0 ) {

            String value = "";
            
            switch (i % 16) {
                case 10:
                    value = "A";
                    break;

                case 11:
                    value = "B";
                    break;
                
                case 12:
                    value = "C";
                    break;

                case 13:
                    value = "D";
                    break;

                case 14:
                    value = "E";
                    break;

                case 15:
                    value = "F";
                    break;
            
                default:
                    value = Integer.toString(i % 16);
                    break;
            }

            hex_result += value;
            i/=16;
            
        }

        for (int j = hex_result.length()-1; j>=0;j--) {
            System.out.print(hex_result.charAt(j));
        }
        
        System.out.println();

        // Binary to Decimal

        int binary = 11011;
        int binary_copy = binary;
        int decimal_result = 0;
        for (int j = 0; j < Integer.toString(binary).length(); j++) {
           
            decimal_result += ((int)Math.pow(2, j)) * (binary_copy % 10);
            
            binary_copy /= 10;
            
        }

        System.out.println(decimal_result);

        System.out.println();

        // Binary to Octal (Groups of 3)

        int octal_copy = binary; // 11011
        int boctal_result = 0;
        String boctal_result_string = "";
        String group = "";
        for (int j = 0, group_sub_index = 0; j < Integer.toString(binary).length(); j++) {
            
            int max_group = Integer.toString(binary).length() / 3;
            if (Integer.toString(binary).length() % 3 != 0 ) {
                max_group++;
            }

            int group_index = 0;
            while(group_index != max_group) {
                
                if (group_sub_index == 3) {

                    String reversed_group = "";
                    for (int l = group.length()-1; l>=0;l--) { // Reversing 
                        reversed_group += group.charAt(l);
                    }

                    // System.out.println("Reversed Group " + reversed_group);

                    int group_int = Integer.parseInt(reversed_group);

                    for (int k = 0; k < 3; k++) {


                        int x=0;
                        switch (k) {
                            case 0:
                                x=1;
                                break;
                            case 1:
                                x=2;
                                break;
                            case 2:
                                x=4;
                                break;
                        }
                        // System.out.println("Pow: " + x + " * " + (group_int % 10));


                        boctal_result += x * (group_int % 10);
                        group_int /= 10;

                        // System.out.println("Boctal result: " + boctal_result);
                    }

                    boctal_result_string += boctal_result;
                    boctal_result = 0;

                    group_sub_index = 0;
                    group = "";

                    // boctal_result += (int)Math.pow(8, j) * Integer.parseInt(group);
                } else {
                    group += (octal_copy % 10);
                    // System.out.println("Index: " + j + " group: " + group + " Octal_copy: " + octal_copy);
                    octal_copy /= 10;

                    group_sub_index++;
                }

                group_index++;
            }
        }

        String boctal_result_string_reversed = "";
        for (int j = boctal_result_string.length()-1; j>=0;j--) {
            boctal_result_string_reversed += boctal_result_string.charAt(j); // TODO: Remove zeeros
        }
        
        boctal_result = Integer.parseInt(boctal_result_string_reversed);

        System.out.println(boctal_result);

        // Binary to hexadecimal
            // Converting to decimal -> hexadecimal

        binary = 11011;
        binary_copy = binary;
        int bd_result = 0;
        for (int j = 0; j < Integer.toString(binary).length(); j++) {
            
            bd_result += ((int)Math.pow(2, j)) * (binary_copy % 10);
            
            binary_copy /= 10;
            
        }

        i = bd_result;
        String bh_result = "";

        while (i > 0 ) {

            String value = "";
            
            switch (i % 16) {
                case 10:
                    value = "A";
                    break;

                case 11:
                    value = "B";
                    break;
                
                case 12:
                    value = "C";
                    break;

                case 13:
                    value = "D";
                    break;

                case 14:
                    value = "E";
                    break;

                case 15:
                    value = "F";
                    break;
            
                default:
                    value = Integer.toString(i % 16);
                    break;
            }

            bh_result += value;
            i/=16;
            
        }

        for (int j = bh_result.length()-1; j>=0;j--) {
            System.out.print(bh_result.charAt(j));
        }


        System.out.println();


        // Octal to decimal

        int octal =2047;
        octal_copy = octal;
        int od_result = 0;
        for (int j = 0; j < Integer.toString(octal).length(); j++) {
           
            od_result += ((int)Math.pow(8, j)) * (octal_copy % 10);
            
            octal_copy /= 10;
            
        }

        System.out.println(od_result);

        System.out.println();

        // Octal to binary
            // octal to decimal -> binary

       

        System.out.println(od_result);

        System.out.println();

        i = od_result;
        String ob_result = "";
        while (i > 0 ) {

            ob_result += Integer.toString(i % 2);
            i/=2;
            
        }

        for (int j = ob_result.length()-1; j>=0;j--) {
            System.out.print(ob_result.charAt(j));
        }

        System.out.println();

        // Octal to hex
            // Octal to decimal -> hex

            i = od_result;
            String ox_result = "";
    
            while (i > 0 ) {
    
                String value = "";
                
                switch (i % 16) {
                    case 10:
                        value = "A";
                        break;
    
                    case 11:
                        value = "B";
                        break;
                    
                    case 12:
                        value = "C";
                        break;
    
                    case 13:
                        value = "D";
                        break;
    
                    case 14:
                        value = "E";
                        break;
    
                    case 15:
                        value = "F";
                        break;
                
                    default:
                        value = Integer.toString(i % 16);
                        break;
                }
    
                ox_result += value;
                i/=16;
                
            }
    
            for (int j = ox_result.length()-1; j>=0;j--) {
                System.out.print(ox_result.charAt(j));
            }
            
            System.out.println();


        // Hex to Decimal
        // TODO: CASE insensitive

        String hex = "B03AF";
        int hd_result = 0;
        for (int j = hex.length()-1, k=0; j >= 0; j--, k++) {

            
            int value = 0;
            switch (hex.charAt(j)) {
                case 'A':
                    value = 10;
                    break;
                case 'B':
                    value = 11;
                    break;
                case 'C':
                    value = 12;
                    break;
                case 'D':
                    value = 13;
                    break;
                case 'E':
                    value = 14;
                    break;
                case 'F':
                    value = 15;
                    break;
            
                default:
                    value = Integer.parseInt(String.valueOf(hex.charAt(j)));
                    break;
            }

            hd_result += ((int)Math.pow(16, k)) * value;
            
                            
        }
    
        System.out.println(hd_result);

        System.out.println();


        // Hex to binary
        
        i = hd_result;
        String hb_result = "";
        while (i > 0 ) {

            hb_result += Integer.toString(i % 2);
            i/=2;
            
        }

        for (int j = hb_result.length()-1; j>=0;j--) {
            System.out.print(hb_result.charAt(j));
        }

        System.out.println();


        // Hex to octal

        i = hd_result;
        String ho_result = "";
        while (i > 0 ) {

            ho_result += Integer.toString(i % 8);
            i/=8;
            
        }

        for (int j = ho_result.length()-1; j>=0;j--) {
            System.out.print(ho_result.charAt(j));
        }


        System.out.println();


        int dr = 78;
        int dr_copy = dr;
        String roman = "";
        while (dr != 0) {
            while (dr / 500 != 0) {
                roman += "D";
                dr -= 500;
            }

            System.out.println("DR: "+dr);

            while (dr / 50 != 0) {
                roman += "L";
                dr -= 50;

            }

            while (dr / 10 != 0) {
                roman += "X";
                dr -= 10;
            System.out.println("DR10: "+dr);

            }

            System.out.println("DR: "+dr);


            while (dr / 5 != 0) {
                roman += "V";
                dr -=5;
            }

            System.out.println("DR: "+dr);


            for (int j=1; j <= dr; j++) {
                if (dr == 4) {
                    roman += "IV";
                    dr-=4;
                } else {
                    roman += "I";
                    dr--;
                }

               
            }
        }

        System.out.println(roman);


    }
}
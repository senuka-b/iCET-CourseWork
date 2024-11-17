import java.io.*;

class FileManager {

    private static final String CUSTOMER_FILE = "data/customers.txt";
    
    private static String[] extendArray(String[] array, String value) {
        String[] temp = new String[array.length+1];

        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }

        temp[temp.length-1] = value;
        return temp;
    }

    public static boolean dumpToFile(Customer[] customers) {
        try {
            FileWriter writer = new FileWriter(CUSTOMER_FILE);

            for (int i = 0; i < customers.length; i++) {
                Customer currentCustomer = customers[i];

                if (currentCustomer.toString() != null) {
                    writer.write(currentCustomer.toString());
                    
                    writer.write("\n");
                }
                
            }

            writer.flush();
            writer.close();

            return true;

        } catch (IOException e) {
            return false;
        }
    }

    public static String[] getCustomers() {

        try {
            BufferedReader reader;

            reader = new BufferedReader(new FileReader(CUSTOMER_FILE));
            
            String[] lineArray = new String[0];
            String line = reader.readLine();
            
            while (line != null) {
                if (line.isBlank() || line.isEmpty()) {
                    // End of file. This would not work if there's empty lines between the fields.
                    break;
                }

                System.out.println(line);
                lineArray = extendArray(lineArray, line);
                line = reader.readLine(); 
            }

            reader.close();
            return lineArray.length != 0 ? lineArray : null;

        } catch (IOException e) {
            System.out.println("error 1");
            return null;
        }


        
    }



}

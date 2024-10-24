class Table {
    private String[][] rows;
    private boolean lastRowLong = false;
    private int[] maxLengthArray;

    private static String[] searchCustomerHeader = new String[]{"Sizes", "QTY", "Amount"};

    Table(String[][] rows, boolean lastRowLong) {
        this.rows = extendRows(rows);
        this.lastRowLong = lastRowLong;

        createMaxLengthArray();
    }

    Table(String[][] rows) {
        this.rows = extendRows(rows);

        createMaxLengthArray();
    }

    private static String[][] extendRows(String[][]rows) {
        String[][] extendedRows = new String[rows.length + 1][rows[0].length];

        for (int i = 1; i < extendedRows.length-1; i++) {
            extendedRows[i] = rows[i];
        }

        return extendedRows;
    }

    private void createMaxLengthArray() {
          // Find maximum length string in each column -> Make space according to that

        maxLengthArray = new int[rows[0].length+1];
    
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

            maxLengthArray[i] = max_length+4;
        }
    }

    private void printHeaderLine() {
        for (int i = 0; i < maxLengthArray.length; i++) {

            if (i == 0) System.out.print("\t\t");

            System.out.print("+");

			for (int j = 0; j < maxLengthArray[i]; j++) {
				System.out.print("-");
			}

        }

		System.out.println();
    }

    private void printHeaderValues() {
        for (int i = 0; i < rows[0].length; i++) {
            if (i == 0) System.out.print("\t\t");
		
			if (rows[0][i].length()+4 == maxLengthArray[i]) {
				System.out.print("|  "+rows[0][i] + "  ");

			} else {
				System.out.print("| "+rows[0][i]);

				for (int j = 0; j < maxLengthArray[i]-(rows[0][i].length()+1); j++) {
					System.out.print(" ");
				}

			}
			
		}

		System.out.println("|");
    }

    private void printData() {
        for (int i = 1; i < rows.length; i++) {
            System.out.print("\t\t");

            if (lastRowLong == true && i == rows.length-1) { // Skip last row
                break;
            }

            // -------------------

            for (int j = 0; j < rows[i].length; j++) {
				System.out.print("| ");

				for (int k = 0; k < maxLengthArray[j]-1; k++) {
					System.out.print(" ");
				}

			}

            System.out.println("|");

            // --------------------
            System.out.print("\t\t");


			for (int j = 0; j < rows[i].length; j++) {
				System.out.print("| " + rows[i][j]);

				for (int k = 0; k < maxLengthArray[j] - (rows[i][j].length() + 1); k++) {
					System.out.print(" ");
				}

			}
			System.out.println("|");
		}
    }

    private void printDataEndLine() {
        if (lastRowLong == false) {
            System.out.print("\t\t");

        }

		for (int i = 0; i < maxLengthArray.length; i++) {
            System.out.print("+");

			for (int j = 0; j < maxLengthArray[i]; j++) {
				System.out.print("-");
			}

        }


        System.out.println();
    }

    private void printLastRow() {
        // Last row values

        int space = 0;
        int index = 0;



        for (int i = 0; i < maxLengthArray.length-2; i++) {
            space += maxLengthArray[i];
            index = i;
        }

        int space_copy = space; // For last row end line

        int remaining_space = 0;
        for (int i = index+1; i < maxLengthArray.length; i++) {
            remaining_space += maxLengthArray[i];
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

        System.out.println();

    }

    private void printTable() {
        printHeaderLine();

        printHeaderValues();

        printHeaderLine();

        printData();

        printDataEndLine();

        if (lastRowLong) {
            printLastRow();
        }
    }

 

    
}



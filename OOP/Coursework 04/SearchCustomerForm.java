import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

import javax.swing.table.*;

class SearchCustomerForm extends JFrame{

    private JButton buttonBack;
    private JButton buttonSearch;

    private JLabel labelCustomer;
    private JTextField textFieldCustomerID;

    private JTable tableCustomer;
    private DefaultTableModel dtm;

    private JLabel labelTotal;
    private JLabel labelTotalValue;


    SearchCustomerForm(HomeForm homeForm) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 500);
        //setMinimumSize(new Dimension(getSize().width + 50, getSize().height + 30)); 
        setLocationRelativeTo(null);

        setTitle("Search Customer");

        buttonBack = new JButton("Back");
        buttonBack.setOpaque(true);
        buttonBack.setBackground(Color.RED);
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setFont(new Font(null, Font.BOLD, 20));

        JPanel buttonBackPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonBackPanel.add(buttonBack);

        JPanel mainPanel = new JPanel(new BorderLayout());
        
        JPanel subTopPanel = new JPanel(new GridLayout(1,3));

        labelCustomer = new JLabel("Enter Customer ID : ");
        labelCustomer.setFont(new Font(null, Font.BOLD, 16));
        labelCustomer.setHorizontalAlignment(JLabel.CENTER);

        textFieldCustomerID = new JTextField();

        buttonSearch = new JButton("Search");
        buttonSearch.setOpaque(true);
        buttonSearch.setBackground(Color.decode("#00cccb"));
        buttonSearch.setForeground(Color.WHITE);
        buttonSearch.setFont(new Font(null, Font.BOLD,14));

        JPanel buttonSearchPanel = new JPanel(new BorderLayout());
        buttonSearchPanel.setBorder(new EmptyBorder(0,40,0,40));
        buttonSearchPanel.add(buttonSearch);

        subTopPanel.add(labelCustomer);
        subTopPanel.add(textFieldCustomerID);
        subTopPanel.add(buttonSearchPanel);

        JPanel subCenterPanel = new JPanel(new BorderLayout());
        subCenterPanel.setBorder(new EmptyBorder(35,100,0,100));

        Object[] headers = new Object[]{"Size", "Qty", "Amount"};
        dtm = new DefaultTableModel(headers, 0);


        tableCustomer = new JTable(dtm);
        tableCustomer.setFont(new Font(null, Font.PLAIN, 13));
        DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer();
        tableCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        tableCustomer.getColumn("Size").setCellRenderer(tableCellRenderer);
        tableCustomer.getColumn("Qty").setCellRenderer(tableCellRenderer);
        tableCustomer.getColumn("Amount").setCellRenderer(tableCellRenderer);

        JScrollPane tablePane = new JScrollPane(tableCustomer);

        JPanel subBottomPanel = new JPanel(new GridLayout(1,2));
        subBottomPanel.setBorder(new EmptyBorder(20,30,20,30));

        labelTotal = new JLabel("Total : ");
        labelTotal.setFont(new Font(null, Font.BOLD, 15));

        labelTotalValue = new JLabel("");
        labelTotalValue.setFont(new Font(null, Font.BOLD, 15));
        labelTotalValue.setHorizontalAlignment(JLabel.RIGHT);

        subBottomPanel.add(labelTotal);
        subBottomPanel.add(labelTotalValue);

        subCenterPanel.add("Center", tablePane);
        subCenterPanel.add("South",subBottomPanel);

        mainPanel.add("North", subTopPanel);
        mainPanel.add("Center", subCenterPanel);

        add("North", buttonBackPanel);
        add("Center", mainPanel);


        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                homeForm.setVisible(true);
                dispose();
            }
        });

        buttonSearch.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent evt) {
                String input = textFieldCustomerID.getText();

                if (CustomerController.isValidCustomerID(input) && CustomerController.isExistsCustomer(input)) {

                    String[][] searchCustomerRows = CustomerController.getSearchCustomerRows(input);

                    int rowHeight = subCenterPanel.getHeight() / searchCustomerRows.length - 20;
                    tableCustomer.setRowHeight(rowHeight);

                    dtm.setRowCount(0);
                    for (String[] row : searchCustomerRows) {
                        dtm.addRow(row);
                    }

                    labelTotalValue.setText(String.format("%.2f", CustomerController.getCustomerTotalAmount(input)));


                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Customer ID", "Error", JOptionPane.ERROR_MESSAGE);
                }
           }
        });

        
    }

}

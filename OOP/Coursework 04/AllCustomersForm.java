import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.border.EmptyBorder;
import javax.swing.table.*;;

class AllCustomersForm extends JFrame {
    
    private JButton buttonBack;

    private DefaultTableModel dtm;
    private JTable table; 

    AllCustomersForm(ReportForm reportForm) {
         
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        //setMinimumSize(new Dimension(getSize().width + 50, getSize().height + 30)); 
        setLocationRelativeTo(null);

        setTitle("All Customers");

        buttonBack = new JButton("Back");
        buttonBack.setOpaque(true);
        buttonBack.setBackground(Color.RED);
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setFont(new Font(null, Font.BOLD, 20));

        JPanel buttonBackPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonBackPanel.add(buttonBack);

        Object[] headers = new Object[8];
        headers[0] = "Customer ID";
        headers[7] = "Amount";

        for (int i = 1; i < headers.length-1; i++) {
            headers[i] = Order.getSizeArray()[i-1].toUpperCase();
        }

        dtm = new DefaultTableModel(headers, 0);
        table = new JTable(dtm);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(new EmptyBorder(20,40,60,40));
        tablePanel.add(scrollPane);

        add("North", buttonBackPanel);
        add("Center", tablePanel);

        String[][] allCustomerReportRows = CustomerController.getAllCustomerReportRows();

        table.setRowHeight(40);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        for (Object column : headers) {
            table.getColumn(column).setCellRenderer(cellRenderer);    
        }

        for (String[] row : allCustomerReportRows) {
            dtm.addRow(row);
        }

        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                reportForm.setVisible(true);
                dispose();
            }    
        
        });
    }
}
